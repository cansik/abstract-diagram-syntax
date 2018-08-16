package ch.bildspur.ads.syntaxtree

import ch.bildspur.ads.syntaxtree.types.BranchType

open class BranchElement(val type : BranchType,
                         val elements : MutableList<SyntaxElement> = mutableListOf()) : SyntaxElement() {
}