package ch.bildspur.ads.syntaxtree

import ch.bildspur.ads.syntaxtree.types.ElementType
import java.util.*

class SyntaxTreeParser {
    val intentRegex = Regex("^(\\s)+")

    val commentRegex = Regex("^\\s*#(.*)\$")
    val assignmentRegex = Regex("^\\s*(\\w+)\\.(\\w+)\\s*=\\s*\"([\\w\\s]*)\"")
    val actionRegex = Regex("^(\\s*)(\\w+)\\.(\\w+)\\(\"?([\\w\\s]*)\"?\\)")

    data class ElementDetectionResult(val type : ElementType, val result : MatchResult?)

    fun parse(lines : List<String>) : SyntaxTree
    {
        val tree = SyntaxTree()
        lines.forEach { parseLine(it, tree) }
        return tree
    }

    private fun parseLine(line : String, tree: SyntaxTree)
    {
        // detect type
        val parsedLine = detectElementType(line)
        if(parsedLine.result == null)
            return

        // detect intent and merge if possible
        val intent = intentRegex.findAll(line).map { it.value.length }.sum()
        /*
        if(tree.currentIntent != intent)
            tree.merge()
        */

        // parse elements
        val values = parsedLine.result.groupValues
        when(parsedLine.type)
        {
            ElementType.COMMENT -> tree.add(CommentElement(values[1]))
            ElementType.ACTION -> TODO()
            ElementType.ASSIGNMENT -> tree.add(AssignmentElement(values[1], values[2], values[3]))
            ElementType.BRANCH -> TODO()
            ElementType.NONE -> {}
        }
    }

    private fun detectElementType(line : String) : ElementDetectionResult
    {
        lateinit var result : Sequence<MatchResult>

        // comment
        if({result = commentRegex.findAll(line); result}().count() > 0)
        {
            return ElementDetectionResult(ElementType.COMMENT, result.first())
        }

        // assignment
        if({result = assignmentRegex.findAll(line); result}().count() > 0)
        {
            return ElementDetectionResult(ElementType.ASSIGNMENT, result.first())
        }

        return ElementDetectionResult(ElementType.NONE, null)
    }
}