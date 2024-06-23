package com.effectivemobile.csvgen.utils;

import com.effectivemobile.csvgen.annotation.ExcludeColumn;
import com.effectivemobile.csvgen.dto.Report;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CsvUtils {

    /**
     * Write info from {@link Report} list to file.csv
     */
    public void writeDataLineByLine(String filePath, List<? extends Report> list) throws IOException {
        if (list.size() == 0 || filePath == null)
            throw new IllegalArgumentException("FilePath is null or list is null");

        File file = new File(filePath);
        FileWriter outFile = new FileWriter(file);

        try (CSVWriter writer = new CSVWriter(outFile)) {
            // adding header to csv
            Report report = list.get(0);
            Set<String> columnsExcludeName = new HashSet<>();
            if (report.getClass().isAnnotationPresent(ExcludeColumn.class)) {
                columnsExcludeName = Arrays.stream(report.getClass().getAnnotation(ExcludeColumn.class).nameOfColumns())
                        .collect(Collectors.toSet());
            }
            Field[] fields = report.getClass().getDeclaredFields();
            ArrayList<String> arrayList = new ArrayList<>();

            //set header
            for (Field field : fields) {
                if (!columnsExcludeName.contains(field.getName())) {
                    arrayList.add(field.getName().toUpperCase());
                }
            }

            writer.writeNext(arrayList.toArray(new String[0]));

            //set value cell
            for (Report item : list) {
                ArrayList<String> arr = new ArrayList<>();
                for (int j = 0; j < item.getClass().getDeclaredFields().length; j++) {
                    String nameOfColumn = item.getClass().getDeclaredFields()[j].getName().toLowerCase();
                    if (!columnsExcludeName.contains(nameOfColumn)) {
                        Field f = item.getClass().getDeclaredField(nameOfColumn);
                        f.setAccessible(true);
                        String value = (String) f.get(item);
                        arr.add(value);
                    }
                }
                writer.writeNext(arr.toArray(new String[0]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
