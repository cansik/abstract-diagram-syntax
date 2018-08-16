package ch.bildspur.ads.syntaxtree

class ActionElement(val target : String,
                    val method : String,
                    val argument : String) : SyntaxElement() {

    override fun toString(): String {
        return "ActionElement(target='$target', method='$method', argument='$argument')"
    }
}