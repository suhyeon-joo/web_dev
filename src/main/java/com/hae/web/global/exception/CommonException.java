package com.hae.web.global.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CommonException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 2607982687853635669L;

    private HttpStatus status;
    private Integer code;
    private String message;

    public CommonException(String s, Exception e) {

    }

    public CommonException(String s) {

    }

}
