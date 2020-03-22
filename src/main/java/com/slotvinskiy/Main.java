package com.slotvinskiy;

//1) Создать проект Maven. В корень проекта положить текстовый файл с содержимым в формате jSon (json.txt)
//Распарсить этот JSON и вывести обьекты через println().

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final String JSON_FILE_NAME = "json.txt";
    public static final String XML_TXT = "xml.txt";

    public static void main(String[] args) {
        Group group = getJsonFrom(JSON_FILE_NAME);
        String xml = getXmlFrom(group);
        System.out.println(xml);
        writeItToFile(xml, XML_TXT);
    }

    private static Group getJsonFrom(String fileName) {
        if (fileName == null) {
            System.out.println("Empty file name.");
        }
        Gson gson = new Gson();
        String json = readJsonFrom(fileName);
        Group group = gson.fromJson(json, Group.class);
        System.out.println(group);
        return group;
    }

    private static String readJsonFrom(String fileName) {
        if (fileName == null) {
            System.out.println("Empty file name.");
        }
        String json = new String();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            json = stream.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static String getXmlFrom(Group group) {
        if (group == null) {
            return null;
        }
        String xml = new String();
        XmlMapper mapper = new XmlMapper();
        try {
            xml = mapper.writeValueAsString(group);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return xml;
    }


    private static void writeItToFile(String xml, String path) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
