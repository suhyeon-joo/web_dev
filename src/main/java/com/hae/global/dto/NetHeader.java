package com.hae.global.dto;

public class NetHeader {

    /// <summary>
    /// 모든 환경에서 전송 대상이 되는 값.
    /// 사용자 인증시 서버에서 전달한 토큰 값.
    /// </summary>
    public String userToken ;
    /// <summary>
    /// 모바일 환경만 해당 되는 값.
    /// 푸쉬 메세지 토큰 값으로 모바일 환경이 아닌 경우 null 값 전송.
    /// </summary>
    public String fcmToken ;
    /// <summary>
    /// 선택 값으로 전달 가능할 경우만 전달.
    /// java DateTime의 TimeZone 값으로 현재는 고정.
    /// 고정값 Asia/Seoul
    /// </summary>
    public String timezone ;
    /// <summary>
    /// 선택 값으로 전달 가능할 경우만 전달.
    /// application version으로 모바일 앱의 경우 앱 버전을 전송.
    /// 그외는 자체 개발 버전을 전송.
    /// </summary>
    public String appVersion;
    /// <summary>
    /// 선택 값으로 전달 가능할 경우만 전달.
    /// android, ios, windows 등 실행 os 전달.
    /// </summary>
    public String osKind ;
    /// <summary>
    /// 선택 값으로 전달 가능할 경우만 전달.
    /// oskind의 버전
    /// </summary>
    public String osVersion ;
    /// <summary>
    /// 모바일 환경만 해당 되는 값.
    /// 사용 단말기의 모델명을 전달한다.
    /// </summary>
    public String deviceModelName ;


    /// <summary>
    /// 모바일 변조 확인을 위한 hashKey
    /// </summary>
    public String hashKey ;

    public String appTag;


    public Boolean hasUserToken()
    {
        return ((userToken != null) && !userToken.isEmpty()) ;
    }

    public Boolean hasFcmToken()
    {
        return ((fcmToken != null) && !fcmToken.isEmpty());
    }

}
