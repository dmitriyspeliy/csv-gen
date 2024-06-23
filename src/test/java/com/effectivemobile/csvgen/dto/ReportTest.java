package com.effectivemobile.csvgen.dto;

import lombok.Getter;

@Getter
public class ReportTest extends Report {
    public ReportTest(String name, String type) {
        super(name, type);
    }
}
