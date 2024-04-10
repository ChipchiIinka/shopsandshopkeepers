package ru.edu.penzgtu.lab.shopsandshopkeepers.exception;

import lombok.Getter;

@Getter
public class LabWorkException extends RuntimeException{
    private final ErrorType type;

    public LabWorkException(ErrorType type, String massage){
        super(massage);
        this.type = type;
    }

    public LabWorkException(ErrorType type, String massage, Throwable throwable){
        super(massage, throwable);
        this.type = type;
    }

    public LabWorkException(ErrorType type, Throwable throwable){
        super(throwable);
        this.type = type;
    }
}
