package com.effectivemobile.csvgen.dto;

import com.effectivemobile.csvgen.annotation.ExcludeColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@ExcludeColumn(nameOfColumns = {"type"})
public class ReportTestWithExcludeCountry extends Report{
    public ReportTestWithExcludeCountry(String name, String type) {
        super(name, type);
    }
}
