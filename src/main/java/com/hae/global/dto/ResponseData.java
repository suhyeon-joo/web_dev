package com.hae.global.dto;

import lombok.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResponseData <T> {
    private Header header;
    private T body;
    public ResponseData(final @NonNull Header header) {this.header=header;}
}
