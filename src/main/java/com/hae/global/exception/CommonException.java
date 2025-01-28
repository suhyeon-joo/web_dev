package com.hae.global.exception;

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
public class CommonException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2607982687853635669L;

    private HttpStatus status;
    private Integer code;
    private String message;

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Throwable e) {
        super(e);
    }

    public CommonException(String message, Throwable e) {
        super(message, e);
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        //setStatus(status);
    }


}
