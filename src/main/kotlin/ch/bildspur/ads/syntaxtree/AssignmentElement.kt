package ch.bildspur.ads.syntaxtree

class AssignmentElement(val target : String,
                        val name : String,
                        val value : String) : SyntaxElement() {
}