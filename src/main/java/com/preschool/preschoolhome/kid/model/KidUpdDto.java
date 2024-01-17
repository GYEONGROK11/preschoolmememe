package com.preschool.preschoolhome.kid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class KidUpdDto {
    private int ikid;
    private String kidNm;
    private int iclass;
    private int gender;
    @JsonIgnore
    private String profile;
    private String birth;
    private String address;
    private String memo;
    private int irank;
    private String emerNm;
    private String emerNb;
}
