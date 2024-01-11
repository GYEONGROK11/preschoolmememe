package com.preschool.preschoolhome.kid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class KidInsDto {
    @JsonIgnore
    private int ikid;
    private String kidNm;
    private int iclass;
    private int gender;
    private String profile;
    private String birth;
    private String address;
    private String code;
    private String memo;
    private int irank;
    private String emernm;
    private String emernb;

}
