package com.preschool.preschoolhome.kid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "원아 발달사항 수정")
public class KidDetailUpdDto {
    @Schema(title = "원아 pk")
    private int ikid;
    @Schema(title = "등급 pk")
    private int irank;
    @Schema(title = "키")
    private int height;
    @Schema(title = "체중")
    private int weight;
    @Schema(title = "예의바른")
    private int polite;
    @Schema(title = "활발한")
    private int activity;
    @Schema(title = "창의적인")
    private int creativity;
    @Schema(title = "입력일")
    private String growthDate;
    @Schema(title = "발달사항 메모")
    private String growthMemo;
    @Schema(title = "측정일")
    private String bodyDate;
    @JsonIgnore
    private int bodyQuarterly;
    @JsonIgnore
    private int growthQuarterly;
}
