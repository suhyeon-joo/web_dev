package com.hae.global.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Header {
    private Integer code;
    private String codeName;
    private String message;
    private int messageCd;
}
