package com.hae.web.global.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Header {
    private Integer code;
    private String message;
    private String messageCd;
}
