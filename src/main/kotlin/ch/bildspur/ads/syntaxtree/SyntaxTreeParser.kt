package ch.bildspur.ads.syntaxtree

class SyntaxTreeParser {
    val commentRegex = Regex("^#(\\s*)(.*)\$")
    val assignmentRegex = Regex("^(\\s*)(\\w+)\\.(\\w+)\\s*=\\s*\"([\\w\\s]*)\"")
    val methodRegex = Regex("^(\\s*)(\\w+)\\.(\\w+)\\(\"([\\w\\s]*)\"\\)")

    fun parse(lines : List<String>) : SyntaxTree
    {
        val tree = SyntaxTree()
        lines.forEach { parseLine(it, tree) }
        return tree
    }

    private fun parseLine(line : String, tree: SyntaxTree)
    {

    }
}