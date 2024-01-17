package com.preschool.preschoolhome.kid.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Schema(title = "원아 코드 출력")
public class KidInsVo {
    @Schema(title = "결과")
    private int result;
    @Schema(title = "코드")
    private String code;
}
