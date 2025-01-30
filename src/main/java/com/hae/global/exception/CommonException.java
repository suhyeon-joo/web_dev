package com.hae.global.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * 커스텀 예외 클래스 (전역적으로 사용)
 * CommonException은 RuntimeException을 확장하고, HttpStatus, code, message 등을 포함하여 예외 정보를 관리합니다.
 * 다양한 생성자를 제공하여, Throwable을 래핑하거나 HttpStatus를 포함할 수 있도록 설계됨.
 */
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
        this.message = message;
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
        this.code = status.value();
    }

    public CommonException(String message, HttpStatus status, int code) {
        super(message);
        this.message = message;
        this.status = status;
        this.code = code;
    }

}
