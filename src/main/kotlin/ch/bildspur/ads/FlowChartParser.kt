package ch.bildspur.ads

import ch.bildspur.ads.syntaxtree.SyntaxTreeParser

class FlowChartParser {

    val syntaxTreeParser = SyntaxTreeParser()

    fun parse(lines : List<String>) {
        // create syntax tree
        val tree = syntaxTreeParser.parse(lines)
        println(tree)
    }
}