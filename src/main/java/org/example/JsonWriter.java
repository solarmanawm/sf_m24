package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonWriter {
    private final Structure structure;

    JsonWriter(Structure structure) {
        this.structure = structure;
    }

    void write() {
        String fileExtension = ".json";
        String filePath = "";
        File file = new File(filePath + "req" + fileExtension);
        StringWriter writer = null;

        String directory = "jsonReqs";
        File directoryFile = new File(directory);

        if (!(directoryFile.exists() && directoryFile.isDirectory())) {
            directoryFile.mkdir();
        }

        try (FileOutputStream fos = new FileOutputStream(directory + "/" + file)) {
            writer = new StringWriter();
            writer.write(JsonUtil.getInstance().serialize(structure));
            fos.write(writer.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e);
//            log.error("Невозможно записать в файл " + filePath);
            System.exit(1);
        }
    }
}
