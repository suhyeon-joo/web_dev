package com.hae.global.controller;

import com.hae.global.exception.CommonException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;


import com.hae.global.conf.BaseConstant;
import com.hae.global.dto.ResultMessage;
import com.hae.global.thread.GlobalMapThreadLocal;
import com.hae.global.util.StringUtil;
import com.hae.global.dto.NetHeader;

/**
 * 모든 컨트롤러가 상속하는 BaseController에서 공통적인 요청 처리 로직을 정의.
 * setResultMessage() 메서드를 사용하여 Model에 결과 메시지를 추가하는 방식으로 예외 메시지 처리를 지원.
 */
@Data
public class BaseController {

    private Log logger = LogFactory.getLog(getClass());
    private String[] baseUrls;
    private String[] sortedBaseUrls;
    @Autowired
    private ApplicationContext applicationContext;

    public BaseController() {
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);
//		System.out.println(">>>>>>>>requestMapping.value() =="+requestMapping.value());
        if (requestMapping == null || requestMapping.value().length == 0) {
            throw new CommonException("RequestMapping이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        if (requestMapping.value().length > 0) {
            this.baseUrls = requestMapping.value();
            bubbleSortByLength();
        }
    }

    private void bubbleSortByLength() {
        sortedBaseUrls = new String[baseUrls.length];
        for (int i = 0; i < baseUrls.length; i++)
            sortedBaseUrls[i] = baseUrls[i];

        if (sortedBaseUrls.length < 2)
            return;

        if (getLog().isDebugEnabled())
            getLog().debug("Before sort : " + ToStringBuilder.reflectionToString(sortedBaseUrls, ToStringStyle.DEFAULT_STYLE));

        boolean change = false;
        String temp;
        int length;
        length = sortedBaseUrls.length;
        for (int i = 0; i < length - 1; i++) {
            change = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (sortedBaseUrls[j].length() < sortedBaseUrls[j + 1].length()) {
                    temp = sortedBaseUrls[j];
                    sortedBaseUrls[j] = sortedBaseUrls[j + 1];
                    sortedBaseUrls[j + 1] = temp;
                    change = true;
                }
            }
            if (change == false)
                break;
        }

        if (getLog().isDebugEnabled())
            getLog().debug("After sort : " + ToStringBuilder.reflectionToString(sortedBaseUrls, ToStringStyle.DEFAULT_STYLE));
    }

    private static String extractMessage(String source, boolean oraKeyVisible) {
        int appendIndex = 0;
        if (oraKeyVisible == false)
            appendIndex = 11;
        if (source.indexOf("Exception") > 0)
            return source.subSequence(source.indexOf("Exception") + "Exception".length() + 2 + appendIndex, source.length()).toString();
        else
            return source;
    }

    protected Log getLog() {
        return logger;
    }

    protected ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    protected String getMessage(String messageKey) {
        return getApplicationContext().getMessage(
                String.format("%s.%s", getHighPackage(getClass().getPackage()),
                        messageKey), null, Locale.getDefault());
    }

    protected String getMessage(String messageKey, Locale locale,
                                Object... params) {
        return getApplicationContext().getMessage(
                String.format("%s.%s", getHighPackage(getClass().getPackage()),
                        messageKey), params, locale);
    }

    protected String getMessage(String messageKey, Locale locale) {
        return getApplicationContext().getMessage(
                String.format("%s.%s", getHighPackage(getClass().getPackage()),
                        messageKey), null, locale);
    }

    protected String getBaseUrl() {
        if (baseUrls.length > 1) {
            String requestUri = (String) GlobalMapThreadLocal
                    .get(BaseConstant.THREAD_LOCAL_REQUEST_URI_KEY);
            if (requestUri == null) {
                if (getLog().isDebugEnabled())
                    getLog().debug(
                            "RequestUri is null, return baseUrl : "
                                    + baseUrls[0]);
                return baseUrls[0];
            }

            for (String baseUrl : sortedBaseUrls) {
                if (requestUri.startsWith(baseUrl)) {
                    if (getLog().isDebugEnabled())
                        getLog().debug("baseUrl selected : " + baseUrl);
                    return baseUrl;
                }
            }
        }

        if (getLog().isDebugEnabled())
            getLog().debug("baseUrl count 1, return baseUrl : " + baseUrls[0]);
        return baseUrls[0];
    }

    protected String getBaseUrl(int index) throws Exception {
        if (baseUrls.length <= index)
            throw new IllegalArgumentException("BaseUrls count is : " + baseUrls.length
                    + ", current index : " + index);

        return baseUrls[index];
    }

    public void setResultMessage(ResultMessage resultMessage, Model model)
            throws Exception {
        model.addAttribute("resultMessage", resultMessage);
    }

    public void setResultMessage(String status, String messageCode, Model model) {
        setResultMessage(status, messageCode, null, Locale.getDefault(), model);
    }

    public void setResultMessage(String status, String messageCode,
                                 Object[] messageArgs, Model model) {
        setResultMessage(status, messageCode, messageArgs, Locale.getDefault(),
                model);
    }

    public void setResultMessage(String status, String messageCode,
                                 Object[] messageArgs, Locale locale, Model model) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setStatus(status);
        resultMessage.setMessage(applicationContext.getMessage(messageCode,
                messageArgs, locale));
        logger.debug(resultMessage);
        if (model == null)
            if(logger.isDebugEnabled()) {
                logger.debug("Model is null : " + model);
            }
            else {
                if (model.asMap() == null) {
                    if(logger.isDebugEnabled()) {
                        logger.debug("Model.asMap() is null : " + model.asMap());
                    }
                    model.asMap().clear();
                } else {
                    if(logger.isDebugEnabled()) {
                        logger.debug("Model.asMap() is not null : " + model.asMap());
                    }
                }

                model.addAttribute("resultMessage", resultMessage);
            }
    }

    public void setRequestNodataResultMessage(Model model) {
        setSuccessResultMessage(model,
                "com.raycloud.base.message.ajax.status.request.nodata",
                "com.raycloud.base.message.ajax.status.request.nodata",
                "com.raycloud.base.message.ajax.message.request.nodata",
                "com.raycloud.base.message.ajax.message.request.nodata");
    }

    public void setNodataResultMessage(Model model) {
        setSuccessResultMessage(model, "com.raycloud.base.message.ajax.status.nodata",
                "com.raycloud.base.message.ajax.status.nodata",
                "com.raycloud.base.message.ajax.message.nodata",
                "com.raycloud.base.message.ajax.message.nodata");
    }

    private void setSuccessResultMessage(Model model, String status,
                                         String statusDefault, String message, String messageDefault) {
        model.addAttribute(
                StringUtil.uncapitalize(ResultMessage.class.getSimpleName()),
                getResultMessage(status, statusDefault, message, messageDefault));
    }

    private ResultMessage getResultMessage(String status, String statusDefault,
                                           String message, String messageDefault) {
        return getResultMessage(status, statusDefault, message, messageDefault,
                null, null);
    }

    private ResultMessage getResultMessage(String status, String statusDefault,
                                           String message, String messageDefault, String errorMessage,
                                           String errorMessageDefault) {
        if (errorMessage == null) {
            return new ResultMessage(getApplicationContext().getMessage("Error Message is Null", null,
                    Locale.getDefault()), getApplicationContext().getMessage("Error Message is Null", null,
                    Locale.getDefault()));
        } else {
            return null;
        }
    }

    private String getHighPackage(Package pack) {
        return pack.getName().substring(0, pack.getName().lastIndexOf("."));
    }

    /**
     * hys : 공통으로 사용하는 메소드는 상속하여 하위 컨트롤러에서 사용하기 위해 부모클래스에 해당 메소드를 작성함.
     * RestApi 사용함에 있어 Header정보를 얻기 위해 사용하는 메소드
     * @param request
     * @param methodName
     * @return
     */
    protected NetHeader getHeader(HttpServletRequest request, String methodName){
        NetHeader result = new NetHeader();
        if (request.getHeader("userToken") != null)
            result.userToken = request.getHeader("userToken");
        else
            result.userToken = null;

        if (request.getHeader("fcmToken") != null)
            result.fcmToken = request.getHeader("fcmToken");
        else
            result.fcmToken = null;

        if (request.getHeader("timezone") != null)
            result.timezone = request.getHeader("timezone");
        else
            result.timezone = "Asia/Seoul";

        if (request.getHeader("appVersion") != null)
            result.appVersion = request.getHeader("appVersion");
        else
            result.appVersion = null;

        if (request.getHeader("osKind") != null)
            result.osKind = request.getHeader("osKind");
        else
            result.osKind = null;

        if (request.getHeader("osVersion") != null)
            result.osVersion = request.getHeader("osVersion");
        else
            result.osVersion = null;

        if (request.getHeader("deviceModelName") != null)
            result.deviceModelName = request.getHeader("deviceModelName");
        else
            result.deviceModelName = null;


        if (request.getHeader("appTag") != null)
            result.appTag = request.getHeader("appTag");
        else
            result.appTag = null;

        if (request.getHeader("hashKey") != null)
            result.hashKey = request.getHeader("hashKey");
        else
            result.hashKey = null;

        return result;
    }
}
