package com.hae.global.exception;

import com.hae.global.dto.ResponseData;
import com.hae.global.dto.Header;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 글로벌 예외 처리 핸들러
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 커스텀 예외 (`CommonException`) 처리
     */
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ResponseData<?>> handleCommonException(CommonException e) {
        ResponseData<?> response = new ResponseData<>(
                Header.builder()
                        .code(e.getCode() != null ? e.getCode() : HttpStatus.BAD_REQUEST.value())
                        .message(e.getMessage())
                        .codeName(e.getStatus() != null ? e.getStatus().name() : HttpStatus.BAD_REQUEST.name())
                        .build()
        );

        return ResponseEntity.status(e.getStatus() != null ? e.getStatus() : HttpStatus.BAD_REQUEST)
                .body(response);
    }

    /**
     * 모든 `RuntimeException` 처리
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseData<?>> handleRuntimeException(RuntimeException e) {
        ResponseData<?> response = new ResponseData<>(
                Header.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message("서버 내부 오류 발생")
                        .codeName(HttpStatus.INTERNAL_SERVER_ERROR.name())
                        .build()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    /**
     * 예외를 포괄적으로 처리
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseData<?>> handleException(Exception e) {
        ResponseData<?> response = new ResponseData<>(
                Header.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message("알 수 없는 오류 발생")
                        .codeName(HttpStatus.INTERNAL_SERVER_ERROR.name())
                        .build()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
