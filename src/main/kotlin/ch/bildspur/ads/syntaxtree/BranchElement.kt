package ch.bildspur.ads.syntaxtree

import ch.bildspur.ads.syntaxtree.types.BranchType

open class BranchElement(val type : BranchType,
                         val negated : Boolean = false,
                         val action: ActionElement = ActionElement(),
                         val elements : MutableList<SyntaxElement> = mutableListOf()) : SyntaxElement() {

    override fun toString(): String {
        return "BranchElement(type=$type, negated=$negated, action=$action, elements=$elements)"
    }
}