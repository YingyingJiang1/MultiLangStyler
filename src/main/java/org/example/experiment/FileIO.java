package org.example.experiment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static List<ExpUnit> read(String filePath) {
        List<ExpUnit> expUnitList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 每行是一个JSON对象，反序列化成Data对象
                ExpUnit expUnit = objectMapper.readValue(line, ExpUnit.class);
                expUnitList.add(expUnit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expUnitList;
    }

    public static void write(String filePath, List<ExpUnit> expUnitList) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ExpUnit expUnit : expUnitList) {
                // 将Data对象序列化为JSON字符串
                String json = objectMapper.writeValueAsString(expUnit);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
