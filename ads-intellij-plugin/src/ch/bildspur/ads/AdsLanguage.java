package ch.bildspur.ads;

import com.intellij.lang.Language;

public class AdsLanguage extends Language {
    public static final AdsLanguage INSTANCE = new AdsLanguage();

    private AdsLanguage() {
        super("AbstractDiagramSyntax");
    }
}