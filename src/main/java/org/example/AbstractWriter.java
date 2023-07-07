package org.example;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class AbstractWriter {
    private final String fileExtension;
    AbstractWriter(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    abstract void writeToFile(FileOutputStream fos, Structure structure) throws IOException, JAXBException;

    void write(Structure structure) {
        String fileExtension = "." + this.fileExtension;
        File file = new File("req" + fileExtension);

        String directory = this.fileExtension + "Reqs";
        File directoryFile = new File(directory);

        if (!(directoryFile.exists() && directoryFile.isDirectory())) {
            directoryFile.mkdir();
        }

        try (FileOutputStream fos = new FileOutputStream(directory + "/" + file)) {
            writeToFile(fos, structure);
        } catch (IOException | JAXBException e) {
            System.exit(1);
        }
    }
}
