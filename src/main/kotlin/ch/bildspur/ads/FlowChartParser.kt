package ch.bildspur.ads

import ch.bildspur.ads.syntaxtree.SyntaxTree

class FlowChartParser {

    fun parse(lines : List<String>)
    {
        // create syntax tree
        val tree = parseSyntaxTree(lines)

    }

    private fun parseSyntaxTree(lines : List<String>) : SyntaxTree
    {
        val tree = SyntaxTree()

        return tree
    }
}