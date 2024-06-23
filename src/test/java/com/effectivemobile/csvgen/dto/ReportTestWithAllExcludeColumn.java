package com.effectivemobile.csvgen.dto;

import com.effectivemobile.csvgen.annotation.ExcludeColumn;
import lombok.Getter;

@Getter
@ExcludeColumn(nameOfColumns = {"type, name"})
public class ReportTestWithAllExcludeColumn extends Report {
    public ReportTestWithAllExcludeColumn(String name, String type) {
        super(name, type);
    }
}
