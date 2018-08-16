package ch.bildspur.ads.syntaxtree.types

enum class BranchType(val tag : String) {
    ROOT("root"),
    IF("if"),
    ELSE("else"),
    DO_WHILE("do while"),
    WHILE("while")
}
