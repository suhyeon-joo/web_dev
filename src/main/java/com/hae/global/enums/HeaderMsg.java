package com.hae.global.enums;

import lombok.Getter;

@Getter
public enum HeaderMsg {
    AUTH_USER_NOTFOUND("존재하지 않는 유저입니다."),
    AUTH_TOKEN_INVAILD("토큰이 유효하지 않습니다"),
    AUTH_PASSWORD_NOT_MATCH("패스워드가 틀렸습니다."),
    AUTH_PASSWORD_NOT_FIT("패스워드가 조건에 맞는 형식이 아닙니다."),
    AUTH_SUCCESS("인증에 성공하였습니다"),
    AUTH_UNAUTHORIZED("권한이 없습니다"),
    ILS_DEPT_LIST_FOUND("부서 리스트를 불러왔습니다.");

    private final String msg;

    HeaderMsg(String msg){this.msg = msg;}
}
