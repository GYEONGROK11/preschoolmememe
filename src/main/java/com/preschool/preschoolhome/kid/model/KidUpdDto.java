package com.preschool.preschoolhome.kid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class KidUpdDto {
    private int ikid;
    private String kidNm;
    private int gender;
    private String profile;
    private String birth;
    private String address;
    @JsonIgnore
    private int code;
    private String memo;
    private int irank;

}
