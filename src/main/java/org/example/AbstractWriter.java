package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public abstract class AbstractWriter {
    private static final Logger log = LogManager.getLogger(AbstractWriter.class);
    protected final String fileExtension;
    AbstractWriter(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    abstract void writeToFile(FileOutputStream fos, Structure structure) throws IOException, JAXBException;

    void write(Structure structure) {
        String fileExtension = "." + this.fileExtension;
        Date date = new Date();
        File file = new File("req_" + date.getTime() + fileExtension);

        String directory = this.fileExtension + "Reqs";
        File directoryFile = new File(directory);

        if (!(directoryFile.exists() && directoryFile.isDirectory())) {
            directoryFile.mkdir();
        }

        String path = directory + "/" + file;
        try (FileOutputStream fos = new FileOutputStream(path)) {
            writeToFile(fos, structure);
        } catch (IOException | JAXBException e) {
            log.error("Невозможно записать в файл " + path);
            System.exit(1);
        }
    }
}
