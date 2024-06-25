package com.effectivemobile.csvgen.dto;

import com.effectivemobile.csvgen.annotation.ExcludeColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ExcludeColumn(nameOfColumns = {"type", "name"})
public class ReportTestWithAllExcludeColumn {
    private String name;
    private String type;
}
