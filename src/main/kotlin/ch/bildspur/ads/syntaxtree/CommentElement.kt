package ch.bildspur.ads.syntaxtree

class CommentElement(val value : String) : SyntaxElement() {
    override fun toString(): String {
        return "CommentElement(value='$value')"
    }
}