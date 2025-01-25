package com.hae.global.enums;

import com.hae.global.dto.Header;
import lombok.Getter;

@Getter
public enum HeaderCode {
    OK(0),
    REQUEST_FORMAT_ERROR(1),
    REQUEST_NOT_FOUND_DATA(2),
    TIMEOUT(3),
    SERVER_ERROR(4),
    REDIRECT(5),
    OTHERS(6);

    private final int code;
    HeaderCode(int code){this.code = code;}
}
