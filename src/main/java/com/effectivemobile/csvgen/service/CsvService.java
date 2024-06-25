package com.effectivemobile.csvgen.service;


import com.effectivemobile.csvgen.utils.CsvUtils;
import com.effectivemobile.csvgen.utils.exception.ErrorInWriteCsvFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final CsvUtils csvUtils;

    public <T> void makeReport(String filePath, List<T> list) throws ErrorInWriteCsvFile {
        csvUtils.writeDataLineByLine(filePath, list);
    }
}
