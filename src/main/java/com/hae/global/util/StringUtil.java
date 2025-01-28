package com.hae.global.util;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

public final class StringUtil {

    private StringUtil() {
    }

    public static String cutStringFromDelimitedString(String resource, String delmiter, int depth) {
        String pResource = resource;
        int pDepth = depth;
        if (depth < 0)
            pDepth = 0;

        for (int i = 0; i < pDepth; i++) {
            pResource = pResource.substring(0, pResource.lastIndexOf(delmiter));
        }

        return pResource;
    }

    /**
     *
     * <pre>
     * StringUtils.defaultString(null)  = ""
     * StringUtils.defaultString("")    = ""
     * StringUtils.defaultString("bat") = "bat"
     * </pre>
     *
     * @param source
     * @return
     */

    public static String defaultString(String source) {
        return defaultString(source);
    }

    public static String defaultString(Object source) {
        if(source != null)
            return defaultString(String.valueOf(source));
        else
            return "";
    }

    /**
     *
     * <pre>
     * StringUtils.defaultString(null, "NULL")  = "NULL"
     * StringUtils.defaultString("", "NULL")    = ""
     * StringUtils.defaultString("bat", "NULL") = "bat"
     * </pre>
     *
     * @param source
     * @param defaultValue
     * @return
     */

    public static String defaultString(String source, String defaultValue) {
        return defaultString(source,
                defaultValue);
    }

    /**
     * 사용자 이름 마스킹 처리
     * @param name
     * @return
     */
    public static String marskingName(String name) {
        String marskingNmae = "";
        String firstName = "";
        String lastName = "";
        int lastNameStartPoint;
        if(name != null && !"".equals(name)) {
            if(name.length() > 1) {
                firstName = name.substring(0,1);
                lastNameStartPoint = name.indexOf(firstName);
                lastName = name.substring(lastNameStartPoint + 1, name.length());
                String markers = "";
                for(int i =0; i < lastName.length(); i++) {
                    markers += "*";
                }
                lastName = lastName.replace(lastName, markers);
                marskingNmae = firstName + lastName;
            }

        }else {
            marskingNmae = "*";
        }
        return marskingNmae;
    }
    public static String defaultString(Object source, String defaultValue) {
        if(source != null)
            return defaultString((String)source, defaultValue);
        else
            return defaultValue;
    }

    /**
     *
     * <pre>
     * String[] str = {"abc", "def", "ghi"};
     * String[] temp = StringUtil.addStringToArray(str, "jkl"};
     * </pre>
     *
     *
     * @param array
     * @param str
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String[] addStringToArray(String[] array, String str) {
        return org.springframework.util.StringUtils
                .addStringToArray(array, str);
    }

    public static <E> String arrayToCommaDelimitedString(E[] array) {
        return arrayToDelimitedString(array, ",");
    }

    public static <E> String arrayToDelimitedString(E[] array, String delim) {
        return org.springframework.util.StringUtils.arrayToDelimitedString(
                array, delim);
    }

    public static <E> String collectionToCommaDelimitedString(
            Collection<E> collection) {
        return org.springframework.util.StringUtils
                .collectionToCommaDelimitedString(collection);
    }

    /**
     *
     * @param collection
     * @param delim
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static <E> String collectionToDelimitedString(
            Collection<E> collection, String delim) {
        return org.springframework.util.StringUtils
                .collectionToDelimitedString(collection, delim);
    }

    /**
     *
     * @param collection
     * @param delim
     * @param prefix
     * @param suffix
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static <E> String collectionToDelimitedString(
            Collection<E> collection, String delim, String prefix, String suffix) {
        return org.springframework.util.StringUtils
                .collectionToDelimitedString(collection, delim, prefix, suffix);
    }

    public static boolean containsWhitespace(String str) {
        return org.springframework.util.StringUtils.containsWhitespace(str);
    }

    public static String[] delimitedListToStringArray(String str, String delim) {
        return org.springframework.util.StringUtils.delimitedListToStringArray(
                str, delim);
    }

    public static String getFilename(String path) {
        return org.springframework.util.StringUtils.getFilename(path);
    }

    public static String getFilenameExtension(String path) {
        return org.springframework.util.StringUtils.getFilenameExtension(path);
    }

    public static String quote(String str) {
        return org.springframework.util.StringUtils.quote(str);
    }

    public static Object quoteIfString(Object obj) {
        return org.springframework.util.StringUtils.quoteIfString(obj);
    }

    public static String doubleQuote(String str) {
        return ((str != null) ? String.format("\"%s\"", str) : null);
    }

    public static Object doubleQuoteIfString(Object obj) {
        return ((obj instanceof String) ? doubleQuote(String.valueOf(obj))
                : obj);
    }

    public static String[] removeDuplicateStrings(String[] array) {
        return org.springframework.util.StringUtils
                .removeDuplicateStrings(array);
    }

    /**
     * @param oldPattern
     * @param newPattern
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String replace(String inString, String oldPattern,
                                 String newPattern) {
        return org.springframework.util.StringUtils.replace(inString,
                oldPattern, newPattern);
    }

    public static String replaceAll(String src, String oldstr, String newstr)
    {
        if (src == null)
            return null;

        StringBuffer dest = new StringBuffer("");
        int  len = oldstr.length();
        int  srclen = src.length();
        int  pos = 0;
        int  oldpos = 0;

        while ((pos = src.indexOf(oldstr, oldpos)) >= 0) {
            dest.append(src.substring(oldpos, pos));
            dest.append(newstr);
            oldpos = pos + len;
        }

        if (oldpos < srclen)
            dest.append(src.substring(oldpos, srclen));

        return dest.toString();
    }

    public static String delete(String inString, String pattern) {
        return org.springframework.util.StringUtils.delete(inString, pattern);
    }

    /**
     *
     * @param array
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String[] sortStringArray(String[] array) {
        return org.springframework.util.StringUtils.sortStringArray(array);
    }

    /**
     *
     * @param toSplit
     * @param delim
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String[] split(String toSplit, String delim) {
        return org.springframework.util.StringUtils.split(toSplit, delim);
    }

    /**
     *
     * @param str
     * @param prefix
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        return org.springframework.util.StringUtils.startsWithIgnoreCase(str,
                prefix);
    }

    /**
     *
     * @param str
     * @param suffix
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static boolean endWithIgnoreCase(String str, String suffix) {
        return org.springframework.util.StringUtils.endsWithIgnoreCase(str,
                suffix);
    }

    /**
     *
     * @param collection
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String[] toStringArray(Collection<String> collection) {
        return org.springframework.util.StringUtils.toStringArray(collection);
    }

    /**
     *
     * @param enumeration
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String[] toStringArray(Enumeration<String> enumeration) {
        return org.springframework.util.StringUtils.toStringArray(enumeration);
    }

    /**
     *
     * @param str
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String trimAllWhitespace(String str) {
        return org.springframework.util.StringUtils.trimAllWhitespace(str);
    }

    /**
     *
     * @param str
     * @param leadingCharacter
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        return org.springframework.util.StringUtils.trimLeadingCharacter(str,
                leadingCharacter);
    }

    /**
     *
     * @param str
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String trimLeadingWhitespace(String str) {
        return org.springframework.util.StringUtils.trimLeadingWhitespace(str);
    }

    /**
     *
     * @param str
     * @param trailingCharacter
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String trimTrailingCharacter(String str,
                                               char trailingCharacter) {
        return org.springframework.util.StringUtils.trimTrailingCharacter(str,
                trailingCharacter);
    }

    /**
     *
     * @param str
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String trimTrailingWhitespace(String str) {
        return org.springframework.util.StringUtils.trimTrailingWhitespace(str);
    }

    /**
     *
     * @param str
     * @return
     * @see org.springframework.util.StringUtils
     */
    public static String trimWhitespace(String str) {
        return org.springframework.util.StringUtils.trimWhitespace(str);
    }

    public static String capitalize(String str) {
        return org.springframework.util.StringUtils.capitalize(str);
    }

    public static String uncapitalize(String str) {
        return org.springframework.util.StringUtils.uncapitalize(str);
    }

    /**
     *
     * @param pattern
     * @param arguments
     * @return
     * @throws IllegalArgumentException
     */
    public static String format(String pattern, Object[] arguments)
            throws IllegalArgumentException {
        return MessageFormat.format(pattern, arguments);
    }

    public static boolean isEmpty(String value) {
        return (value == null || value.trim().length() == 0 || value.equals(""));
    }

    public static String isEmptyToDefault(String value, String defaultMessage) {
        if (isEmpty(value))
            return defaultMessage;
        else
            return value;
    }

    // ////////////////////////////////////////////////////////////////////////////
    // ////////////////////////////////////////////////////////////////////////////
    // ////////////////////////////////////////////////////////////////////////////

    public static String toVariableNameStyle(String value) {
        StringBuilder result = new StringBuilder();
        String firstWord = value.substring(0, 1);
        result.append(firstWord.toLowerCase() + value.substring(1));
        return result.toString();
    }

    public static String toClassNameStyle(String value) {
        StringBuilder result = new StringBuilder();
        String firstWord = value.substring(0, 1);
        result.append(firstWord.toUpperCase() + value.substring(1));
        return result.toString();
    }

    public static String nl2br(String str) {
        String pStr = str;
        pStr = pStr.replaceAll("(\r\n|\r|\n|\n\r)", "<br />");
        return pStr;
    }

    public static String cutBytes(String strSource, int cutByte) {
        // cutByte = 40;
        String pStrSource = strSource;
        if (pStrSource == null)
            return "";
        String strPostfix = "...";
        int postfixSize = 3;
        pStrSource = pStrSource.trim();
        char[] charArray = pStrSource.toCharArray();
        int strIndex = 0;
        int byteLength = 0;
        for (; strIndex < pStrSource.length(); strIndex++) {
            int byteSize = 0;
            if (charArray[strIndex] < 256) {
                byteSize = 1;
            } else {
                byteSize = 3;
            }
            if ((byteLength + byteSize) > cutByte - postfixSize) {
                break;
            }
            byteLength = byteLength += byteSize;
        }
        if (strIndex == pStrSource.length())
            strPostfix = "";
        else {
            if ((byteLength + postfixSize) < cutByte)
                strPostfix = " " + strPostfix;
        }
        return pStrSource.substring(0, strIndex) + strPostfix;
    }

    public static String convertEncoding(String source, String srcEncoding, String targetEncoding) throws UnsupportedEncodingException {
        return new String(source.getBytes(srcEncoding), targetEncoding);
    }

    public static String convertIsoToUtf8(String source) throws UnsupportedEncodingException {
        return convertEncoding(source, "ISO8859-1", "UTF-8");
    }

    public static String removeHtml(String sourceHtml) {
        Pattern scripts = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);
        Pattern style = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
        Pattern tags = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");
//		Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
        Pattern entityRefs = Pattern.compile("&[^;]+;");
        Pattern whitespace = Pattern.compile("\\s\\s+");

        Matcher m;
        String pSourceHtml = sourceHtml;
        m = scripts.matcher(pSourceHtml);
        pSourceHtml = m.replaceAll("");
        m = style.matcher(pSourceHtml);
        pSourceHtml = m.replaceAll("");
        m = tags.matcher(pSourceHtml);
        pSourceHtml = m.replaceAll("");
        m = entityRefs.matcher(pSourceHtml);
        pSourceHtml = m.replaceAll("");
        m = whitespace.matcher(pSourceHtml);
        pSourceHtml = m.replaceAll(" ");

        return pSourceHtml;
    }

    /**
     * (length - str.length) 만큼 앞에 0을 추가한다.
     * @param str
     * @param length
     * @return
     */
    public static String addZero (String str, int length) {
        String temp = "";
        for (int i = str.length(); i < length; i++)
            temp += "0";
        temp += str;
        return temp;
    }


    public static Map<String,Object> stringToMap(String source) {
        Map<String,Object> map = new HashMap<String, Object>();

        ObjectMapper mapper = new ObjectMapper();

        String strSource="";
        try {
            if (source != null) {
                strSource = mapper.writeValueAsString(source);
                //      ArrayList cars1 = mapper.readValue(rData, new TypeReference<ArrayList>(){});
                map = mapper.readValue(strSource, new TypeReference<Map<String, Object>>() {
                });
                return map;
            }
        } catch (Exception e) {
            // TODO: handle exception
            return map;
        }
        return map;

    }
}
