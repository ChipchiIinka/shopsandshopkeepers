package ru.edu.penzgtu.lab.shopsandshopkeepers.exception.baseresponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String code;

    private String title;

    private String text;
}
