package ch.bildspur.ads.syntaxtree

import ch.bildspur.ads.syntaxtree.types.BranchType
import java.util.*

class SyntaxTree : BranchElement(BranchType.ROOT)
{

    private var branches = Stack<BranchElement>()

    init {
        branches.push(this)
    }

    val currentBranch : BranchElement
        get() = branches.peek()

    val currentIntent : Int
        get() = branches.size - 1

    fun add(element : SyntaxElement)
    {
        currentBranch.elements.add(element)
    }

    fun branch(element: BranchElement)
    {
        currentBranch.elements.add(element)
        branches.push(element)
    }

    fun merge()
    {
        branches.pop()
    }
}