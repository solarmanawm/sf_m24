package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class XmlWriter {
    private final Structure structure;

    XmlWriter(Structure structure) {
        this.structure = structure;
    }

    void write() {
        String fileExtension = ".xml";
        String filePath = "";
        File file = new File(filePath + "req" + fileExtension);
        StringWriter writer = null;

        String directory = "xmlReqs";
        File directoryFile = new File(directory);

        if (!(directoryFile.exists() && directoryFile.isDirectory())) {
            directoryFile.mkdir();
        }

        try (FileOutputStream fos = new FileOutputStream(directory + "/" + file)) {
            writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(Structure.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(structure, writer);
            fos.write(writer.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException | JAXBException e) {
            System.out.println(e);
//            log.error("Невозможно записать в файл " + filePath);
            System.exit(1);
        }
    }
}
