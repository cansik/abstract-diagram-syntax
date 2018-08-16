package ch.bildspur.ads.psi;

import ch.bildspur.ads.AdsLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AdsTokeType extends IElementType {
    public AdsTokeType(@NotNull @NonNls String debugName) {
        super(debugName, AdsLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "AdsTokenType." + super.toString();
    }
}