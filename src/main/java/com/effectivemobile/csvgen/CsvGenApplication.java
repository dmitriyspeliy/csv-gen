package com.effectivemobile.csvgen;

import com.effectivemobile.csvgen.dto.Report;
import com.effectivemobile.csvgen.service.CsvService;
import com.effectivemobile.csvgen.utils.CsvUtils;
import com.effectivemobile.csvgen.utils.exception.ErrorInWriteCsvFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CsvGenApplication {

    private static CsvService csvService;

    public static void main(String[] args) throws ErrorInWriteCsvFile {
        CsvUtils csvUtils = new CsvUtils();
        csvService = new CsvService(csvUtils);
        csvService.makeReport("src/main/resources/report/test1.csv", List.of(new Report("Test", "Test1"), new Report("Test", "Test1")));
        SpringApplication.run(CsvGenApplication.class, args);
    }

}
