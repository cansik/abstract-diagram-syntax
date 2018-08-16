package ch.bildspur.ads;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class AdsFileType extends LanguageFileType {
    public static final AdsFileType INSTANCE = new AdsFileType();

    private AdsFileType() {
        super(AdsLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ADS file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Abstract Diagram Syntax file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ads";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AdsIcons.FILE;
    }
}
