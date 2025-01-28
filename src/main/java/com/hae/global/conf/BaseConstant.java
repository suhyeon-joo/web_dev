package com.hae.global.conf;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;

public class BaseConstant {

    @Value("${domain.tostringstyle}")
    private static String toStringStyle;
    @Value("${domain.field.limit.byte.size}")
    private static String DOMAINS_TOSTRING_LIMIT_COUNT;
    @Value("${domain.tostring.limit.count.aop}")
    private static String DOMAINS_FIELD_LIMIT_BYTE_SIZE;


    /* Keyboard Symbols */
    /** <b>키보드 특수문자</b> : 왼쪽 중괄호 */
    public static final String OPEN_BRACE = "{";
    /** <b>키보드 특수문자</b> : 오른쪽 중괄호 */
    public static final String CLOSE_BRACE = "}";
    /** <b>키보드 특수문자</b> : 왼쪽 대괄호 */
    public static final String OPEN_BRAKET = "[";
    /** <b>키보드 특수문자</b> : 오른쪽 대괄호 */
    public static final String CLOSE_BRAKET = "]";
    /** <b>키보드 특수문자</b> : 왼쪽 소괄호 */
    public static final String OPEN_PARENTHESIS = "(";
    /** <b>키보드 특수문자</b> : 오른쪽 소괄호 */
    public static final String CLOSE_PARENTHESIS = ")";
    /** <b>키보드 특수문자</b> : 왼쪽 부등호 */
    public static final String LESS_THEN = "<";
    /** <b>키보드 특수문자</b> : 오른쪽 부등호 */
    public static final String GREATER_THEN = ">";
    /** <b>키보드 특수문자</b> : 공백 */
    public static final String BLANK = " ";
    /** <b>키보드 특수문자</b> : 들여쓰기(탭) */
    public static final String INDENT = "\t";
    /** <b>키보드 특수문자</b> : 별표 */
    public static final String ASTERISK = "*";
//	/** <b>키보드 특수문자</b> : 위 화살표 */
//	public static final String UP_ARROW = "↑";
//	/** <b>키보드 특수문자</b> : 아래 화살표 */
//	public static final String DOWN_ARROW = "↓";
//	/** <b>키보드 특수문자</b> : 오른쪽 화살표 */
//	public static final String RIGHT_ARROW = "→";
//	/** <b>키보드 특수문자</b> : 왼쪽 화살표 */
//	public static final String LEFT_ARROW = "←";
    /** <b>키보드 특수문자</b> : Ampersand */
    public static final String AMPERSAND = "&";
    /** <b>키보드 특수문자</b> : Double Ampersand */
    public static final String DOUBLE_AMPERSAND = "&&";

    private static enum TO_STRING_STYLE {
        DEFAULT_STYLE, MULTI_LINE_STYLE, NO_FIELD_NAMES_STYLE, SHORT_PREFIX_STYLE, SIMPLE_STYLE
    };

    public static final ToStringStyle UNIPAYROLL_AGENT_TOSTRING_STYLE;

    public static final String THREAD_LOCAL_USERINFO_KEY = "LIFETIP_USER_INFO";
    public static final String THREAD_LOCAL_REQUEST_URI_KEY = "THREAD_LOCAL_REQUEST_URI";

    public static final String SESSION_ATTRIBUTE_NAME = "LIFETIP_SESSION_ATTR";
    public static final String SESSION_HTTPREQUEST_NAME = "LIFETIP_REQUEST";
    public static final String SESSION_HTTPSESSION_NAME = "LIFETIP_SESSION";

    static {
        if (TO_STRING_STYLE.MULTI_LINE_STYLE.toString().equals(toStringStyle)) UNIPAYROLL_AGENT_TOSTRING_STYLE = ToStringStyle.MULTI_LINE_STYLE;
        else if (TO_STRING_STYLE.NO_FIELD_NAMES_STYLE.toString().equals(
                toStringStyle)) UNIPAYROLL_AGENT_TOSTRING_STYLE = ToStringStyle.NO_FIELD_NAMES_STYLE;
        else if (TO_STRING_STYLE.SHORT_PREFIX_STYLE.toString().equals(
                toStringStyle)) UNIPAYROLL_AGENT_TOSTRING_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
        else if (TO_STRING_STYLE.SIMPLE_STYLE.toString().equals(toStringStyle))
            UNIPAYROLL_AGENT_TOSTRING_STYLE = ToStringStyle.SIMPLE_STYLE;
        else
            UNIPAYROLL_AGENT_TOSTRING_STYLE = ToStringStyle.DEFAULT_STYLE;


    }
}
