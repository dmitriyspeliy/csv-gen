package com.effectivemobile.csvgen.dto;

import com.effectivemobile.csvgen.annotation.ExcludeColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Report {
    private String name;
    private String type;
}
