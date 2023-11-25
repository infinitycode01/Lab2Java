package com.infinity;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlSerializationFormat<T> implements SerializationFormat<T> {

    private final XmlMapper xmlMapper;
    private final Class<T> typeParameterClass;

    public XmlSerializationFormat(Class<T> typeParameterClass) {
        this.xmlMapper = new XmlMapper();
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public String serialize(T object) throws IOException {
        return xmlMapper.writeValueAsString(object);
    }

    @Override
    public T deserialize(String data) throws IOException {
        return xmlMapper.readValue(data, typeParameterClass);
    }

    @Override
    public void writeToFile(List<T> objects, String filePath) throws IOException {
        xmlMapper.writeValue(new File(filePath), objects);
    }

    @Override
    public List<T> readFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found: " + filePath);
        }
        // Читання XML як масиву елементів
        return new ArrayList<>(List.of(xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructArrayType(typeParameterClass))));
    }
}
