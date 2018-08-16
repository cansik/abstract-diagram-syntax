package ch.bildspur.ads.psi;

import ch.bildspur.ads.AdsLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AdsElementType extends IElementType {
    public AdsElementType(@NotNull @NonNls String debugName) {
        super(debugName, AdsLanguage.INSTANCE);
    }
}