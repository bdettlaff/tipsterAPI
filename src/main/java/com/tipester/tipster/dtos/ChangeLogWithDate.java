package com.tipester.tipster.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeLogWithDate {
    private String title;
    private String date;
    private String content;
}
