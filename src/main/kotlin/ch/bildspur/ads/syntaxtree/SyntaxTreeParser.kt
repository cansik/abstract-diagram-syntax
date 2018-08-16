package ch.bildspur.ads.syntaxtree

import ch.bildspur.ads.syntaxtree.types.BranchType
import ch.bildspur.ads.syntaxtree.types.ElementType

class SyntaxTreeParser {
    private val defaultIntent = 4

    private val textMatchRegex = "[\\w\\s,\\.\\-\\^'¨\\\$=\\/\\\\&%\\*\\+§;:_£!`\\?#°<>]*"

    private val intentRegex = Regex("^(\\s)+")

    private val commentRegex = Regex("^\\s*#(.*)\$")
    private val assignmentRegex = Regex("^\\s*(\\w+)\\.(\\w+)\\s*=\\s*\"($textMatchRegex)\"")
    private val actionRegex = Regex("^\\s*(\\w+)\\.(\\w+)\\(\"?($textMatchRegex)\"?\\)")
    private val branchRegex = Regex("^\\s*(if|while|do while|else)+\\s*(!?)(?:(\\w+)\\.(\\w+)\\(\"?($textMatchRegex)\"?\\))?:")

    data class ElementDetectionResult(val type: ElementType, val result: MatchResult?)

    fun parse(lines: List<String>, autoDetectIntent : Boolean = false): SyntaxTree {
        // auto detect intent
        val intent = if(autoDetectIntent)
            lines.map { intentRegex.findAll(it).map { it.value.length }.sum() }.toSet().sortedBy { it }[1]
        else
            defaultIntent

        // parse tree
        val tree = SyntaxTree(intent)
        lines.forEach { parseLine(it, tree) }
        return tree
    }

    private fun parseLine(line: String, tree: SyntaxTree) {
        // detect type
        val parsedLine = detectElementType(line)
        if (parsedLine.result == null)
            return

        // detect intent and merge if possible
        val intent = intentRegex.findAll(line).map { it.value.length }.sum()
        while (parsedLine.type != ElementType.COMMENT && tree.currentIntent != intent)
            tree.merge()

        // parse elements
        val values = parsedLine.result.groupValues
        when (parsedLine.type) {
            ElementType.COMMENT -> tree.add(CommentElement(values[1]))
            ElementType.ACTION -> tree.add(ActionElement(values[1], values[2], values[3]))
            ElementType.ASSIGNMENT -> tree.add(AssignmentElement(values[1], values[2], values[3]))
            ElementType.BRANCH -> tree.branch(BranchElement(BranchType.byTag(values[1])!!, values[2] == "!", ActionElement(values[3], values[4], values[5])))
        }
    }

    private fun detectElementType(line: String): ElementDetectionResult {
        lateinit var result: Sequence<MatchResult>

        // comment
        if ({ result = commentRegex.findAll(line); result }().count() > 0) {
            return ElementDetectionResult(ElementType.COMMENT, result.first())
        }

        // assignment
        if ({ result = assignmentRegex.findAll(line); result }().count() > 0) {
            return ElementDetectionResult(ElementType.ASSIGNMENT, result.first())
        }

        // action
        if ({ result = actionRegex.findAll(line); result }().count() > 0) {
            return ElementDetectionResult(ElementType.ACTION, result.first())
        }

        // branch
        if ({ result = branchRegex.findAll(line); result }().count() > 0) {
            return ElementDetectionResult(ElementType.BRANCH, result.first())
        }

        return ElementDetectionResult(ElementType.COMMENT, null)
    }
}