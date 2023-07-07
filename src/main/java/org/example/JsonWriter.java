package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonWriter extends AbstractWriter {
    private static final Logger log = LogManager.getLogger(JsonWriter.class);
    JsonWriter() {
        super("json");
    }

    @Override
    void writeToFile(FileOutputStream fos, Structure structure) throws IOException {
        StringWriter writer = new StringWriter();
        writer.write(JsonUtil.getInstance().serialize(structure));
        fos.write(writer.toString().getBytes(StandardCharsets.UTF_8));
        log.error("Данные зхаписаны в  " + this.fileExtension + " файл запроса.");
    }
}
