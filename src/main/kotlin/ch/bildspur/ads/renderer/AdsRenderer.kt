package ch.bildspur.ads.renderer

import ch.bildspur.ads.syntaxtree.SyntaxTree

interface AdsRenderer {
    fun render(syntaxTree: SyntaxTree)
}