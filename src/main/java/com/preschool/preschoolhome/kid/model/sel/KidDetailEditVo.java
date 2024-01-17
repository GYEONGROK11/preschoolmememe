package com.preschool.preschoolhome.kid.model.sel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class KidDetailEditVo {
    @JsonIgnore
    private int result;
    private String kidNm;
    private int iclass;
    private int gender;
    private String profile;
    private String birth;
    private String address;
    private String memo;
    private String emerNm;
    private String emerNb;

}
