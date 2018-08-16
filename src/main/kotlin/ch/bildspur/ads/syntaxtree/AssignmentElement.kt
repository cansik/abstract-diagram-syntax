package ch.bildspur.ads.syntaxtree

class AssignmentElement(val target : String,
                        val name : String,
                        val value : String) : SyntaxElement() {

    override fun toString(): String {
        return "AssignmentElement(target='$target', name='$name', value='$value')"
    }
}