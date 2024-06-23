package com.effectivemobile.csvgen.service;


import com.effectivemobile.csvgen.dto.Report;
import com.effectivemobile.csvgen.utils.CsvUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CsvService {

    CsvUtils csvUtils;

    public void makeReport(String filePath, List<Report> list) throws IOException {
        csvUtils.writeDataLineByLine(filePath, list);
    }
}
