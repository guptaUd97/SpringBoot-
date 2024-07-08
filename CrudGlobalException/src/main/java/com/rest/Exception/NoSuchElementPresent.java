package com.rest.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoSuchElementPresent extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    private int errorCode;
    private String errorMessage;
    private boolean status = true;
}