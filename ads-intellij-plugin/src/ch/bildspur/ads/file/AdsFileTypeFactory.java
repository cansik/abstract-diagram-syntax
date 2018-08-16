package ch.bildspur.ads.file;

import com.intellij.openapi.fileTypes.*;
        import org.jetbrains.annotations.NotNull;

public class AdsFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(AdsFileType.INSTANCE);
    }
}