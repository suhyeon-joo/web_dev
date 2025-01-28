package com.hae.global.enums;

import lombok.Getter;
//        2xx: 성공 (예: 200 OK, 201 Created, 202 updated, 203 )
//        4xx: 클라이언트 오류 (예: 400 Bad Request, 401 Unauthorized)
//        5xx: 서버 오류 (예: 500 Internal Server Error)
//        100 ~ 199: 정보 코드 (잘 사용되지 않음).
//        200 ~ 299: 성공 코드.
//        300 ~ 399: 리다이렉션 (거의 사용되지 않음).
//        400 ~ 499: 클라이언트 오류.
//        500 ~ 599: 서버 오류.
//        700 ~ 799: 클라이언트-서버 간 커스텀 오류.
//        800 ~ 899: 파싱 또는 데이터 오류.
//        900 ~ 999: 비즈니스 로직 오류.

@Getter
public enum HeaderCodeMsg {
    // Authentication Messages
    AUTH_USER_NOTFOUND(204, "존재하지 않는 유저입니다."),
    AUTH_TOKEN_INVALID(401, "토큰이 유효하지 않습니다"),
    AUTH_PASSWORD_NOT_MATCH(204, "패스워드가 틀렸습니다."),
    AUTH_PASSWORD_NOT_FIT(204, "패스워드가 조건에 맞는 형식이 아닙니다."),
    AUTH_TOKEN_UPDATE_SUCCESS(202, "Token updated successfully"),
    AUTH_SUCCESS(1, "인증에 성공하였습니다"),
    AUTH_UNAUTHORIZED(401, "권한이 없습니다"),

    // General Success and Error Messages
    SUCCESS(1, "Successfully processed.."),
    ERR_RSP_NOT_FOUND(2, "Data not found.."),
    ERR_RSP_NOT_EQUAL(3, "The comparison value is different.."),
    ERR_RSP_INPUT_ERROR(4, "The input value is not appropriate.."),
    ERR_RSP_FORMAT_ERROR(5, "The data is malformed or exceeds the specified size.."),
    ERR_RSP_DATA_DUPLICATE(6, "This supplier biz number is already registered."),
    ERR_RSP_NOT_NULL(7, "No required input value.."),
    ERR_RSP_OTHER_ERROR(9, "An error occurred while processing the data.."),
    ERR_RSP_NOT_USE(8, "Access restricted data.."),
    ERR_RSP_UNAUTHORIZED(401, "There is no user authentication information.."),
    ERR_NOT_FOUND_URL(404, "No response was found for the requested REST API URL. Please check url, method, body, etc."),

    // Client Error Messages
    ERR_CLIENT_NULL_OBJECT(705, "You can not perform the operation by receiving data that has no value.."),
    ERR_ALREADY_REGI_COMPANY(201, "This company is already registered"),
    ERR_ALREADY_REGI_USER(202, "This user is already registered"),
    ERR_ALREADY_REGI_ROLE(203, "This role is already registered"),
    ERR_CLIENT_NO_AUTH(204, "This user does not have auth"),
    ERR_CLIENT_ACCOUNT_LOCK(205, "This user account was locked"),

    // Server Error
    ERR_SERVER_DB_QUERY_NOT_WORK(501, "Server database query failed.");

    private final int code;
    private final String msg;

    HeaderCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
