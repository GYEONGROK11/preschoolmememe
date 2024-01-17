package com.preschool.preschoolhome.kid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class KidDetailInsDto {
    private int ikid;
    private int irank;
    private int height;
    private int weight;
    private int polite;
    private int activity;
    private int creativity;
    private String growthMemo;
    private String growthDate;
    private String bodyDate;
    @JsonIgnore
    private int bodyQuarterly;
    @JsonIgnore
    private int growthQuarterly;
}
