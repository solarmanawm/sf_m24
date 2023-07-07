package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonWriter extends AbstractWriter {
    JsonWriter() {
        super("json");
    }

    @Override
    void writeToFile(FileOutputStream fos, Structure structure) throws IOException {
        StringWriter writer = new StringWriter();
        writer.write(JsonUtil.getInstance().serialize(structure));
        fos.write(writer.toString().getBytes(StandardCharsets.UTF_8));
    }
}
