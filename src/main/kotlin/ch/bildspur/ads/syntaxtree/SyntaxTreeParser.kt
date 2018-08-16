package ch.bildspur.ads.syntaxtree

import ch.bildspur.ads.syntaxtree.types.ElementType
import java.util.*

class SyntaxTreeParser {
    val intentRegex = Regex("^(\\s)+")

    val commentRegex = Regex("^\\s*#(.*)\$")
    val assignmentRegex = Regex("^\\s*(\\w+)\\.(\\w+)\\s*=\\s*\"([\\w\\s]*)\"")
    val methodRegex = Regex("^\\s*(\\w+)\\.(\\w+)\\(\"([\\w\\s]*)\"\\)")

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
        if(tree.currentIntent != intent)
            tree.merge()

        // parse elements
        when(parsedLine.type)
        {
            ElementType.COMMENT -> {
                val comment = CommentElement(parsedLine.result.groupValues[0])
                tree.add(comment)
            }
            ElementType.ACTION -> TODO()
            ElementType.ASSIGNMENT -> TODO()
            ElementType.BRANCH -> TODO()
            ElementType.NONE -> {}
        }
    }

    private fun detectElementType(line : String) : ElementDetectionResult
    {
        lateinit var result : Sequence<MatchResult>
        if({result = commentRegex.findAll(line); result}().count() > 0)
        {
            return ElementDetectionResult(ElementType.COMMENT, result.first())
        }

        return ElementDetectionResult(ElementType.NONE, null)
    }
}