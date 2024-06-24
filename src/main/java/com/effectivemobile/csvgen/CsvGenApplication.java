package com.effectivemobile.csvgen;

import com.effectivemobile.csvgen.annotation.ExcludeColumn;
import com.effectivemobile.csvgen.dto.Report;
import com.effectivemobile.csvgen.service.CsvService;
import com.effectivemobile.csvgen.utils.CsvUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CsvGenApplication {

    static CsvService csvService;

    public static void main(String[] args) throws IOException {
        CsvUtils csvUtils = new CsvUtils();
        csvService = new CsvService(csvUtils);
        csvService.makeReport("src/main/resources/report/test1.csv", List.of(new Report("Test", "Test1"), new Report("Test", "Test1")));
        SpringApplication.run(CsvGenApplication.class, args);
    }

}
