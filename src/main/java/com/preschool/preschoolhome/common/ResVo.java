package com.preschool.preschoolhome.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor //기본생성자
@Schema(title = "결과")
public class ResVo {
    @Schema(title = "결과")
    private int result;
}
