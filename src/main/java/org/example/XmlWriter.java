package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class XmlWriter extends AbstractWriter {
    XmlWriter() { super("xml"); }

    @Override
    void writeToFile(FileOutputStream fos, Structure structure) throws IOException, JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Structure.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(structure, writer);
        fos.write(writer.toString().getBytes(StandardCharsets.UTF_8));
    }
}
