package com.hae.global.controller;

import com.hae.global.dto.Header;
import com.hae.global.dto.ResponseData;
import com.hae.global.enums.HeaderCode;
import com.hae.global.enums.HeaderCodeMsg;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 404에러 페이지처리에 사용된다.
 */
@CrossOrigin(origins = "*")
@RestController /* return : return Type 지정 */
@RequestMapping("/error")
public class ErrorController extends BaseController{
    @RequestMapping(value="/404",method=RequestMethod.POST)
    public ResponseEntity<Object> pageNotFoundViewPOST(HttpServletRequest request) throws Exception {
        ResponseData<?> responseData = new ResponseData<Object>(Header.builder()
                .code(HeaderCode.OK.getCode())
                .message(HeaderCodeMsg.ERR_NOT_FOUND_URL.getMsg())
                .messageCd(HeaderCodeMsg.ERR_NOT_FOUND_URL.getCode()).build());


        return ResponseEntity.ok(responseData);
    }
    @RequestMapping(value="/404",method=RequestMethod.GET)
    public ResponseEntity<Object> pageNotFoundViewGET(HttpServletRequest request) throws Exception {
        ResponseData<Object> result = new ResponseData<Object>(Header.builder()
                        .code(HeaderCode.OK.getCode())
                        .message(HeaderCodeMsg.ERR_NOT_FOUND_URL.getMsg())
                        .messageCd(HeaderCodeMsg.ERR_NOT_FOUND_URL.getCode()).build());
        //"요청하신 REST API URL 에 대한 응답을 찾을 수 없습니다.";
        return ResponseEntity.ok(result);
    }
}