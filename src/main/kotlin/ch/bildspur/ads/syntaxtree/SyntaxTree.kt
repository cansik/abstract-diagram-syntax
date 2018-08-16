package ch.bildspur.ads.syntaxtree

import ch.bildspur.ads.syntaxtree.types.BranchType
import java.util.*

class SyntaxTree(val defaultIntent: Int = 4) : BranchElement(BranchType.ROOT) {

    private var branches = Stack<BranchElement>()

    init {
        branches.push(this)
    }

    val currentBranch: BranchElement
        get() = branches.peek()

    val currentIntent: Int
        get() = (branches.size - 1) * defaultIntent

    fun add(element: SyntaxElement) {
        currentBranch.elements.add(element)
    }

    fun branch(element: BranchElement) {
        currentBranch.elements.add(element)
        branches.push(element)
    }

    fun merge() {
        branches.pop()
    }
}