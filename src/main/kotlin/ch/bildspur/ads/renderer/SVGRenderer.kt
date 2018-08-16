package ch.bildspur.ads.renderer

import ch.bildspur.ads.syntaxtree.SyntaxTree
import org.jfree.graphics2d.svg.SVGGraphics2D

class SVGRenderer : AdsRenderer {
    override fun render(syntaxTree: SyntaxTree) {
        val graphics = SVGGraphics2D(300, 300)
    }
}