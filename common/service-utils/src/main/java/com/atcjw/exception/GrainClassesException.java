package com.atcjw.exception;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrainClassesException extends RuntimeException{
    private Integer code;
    private String message;
}
