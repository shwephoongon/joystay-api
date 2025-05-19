package com.shwephoo.joystay_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponseDto<T> {
    private String status;
    private T data;
}
