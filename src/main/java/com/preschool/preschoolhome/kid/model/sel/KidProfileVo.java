package com.preschool.preschoolhome.kid.model.sel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class KidProfileVo {
    @JsonIgnore
    private int result;
    private String kidNm;
    private int iclass;
    private int gender;
    private String profile;
    private String birth;
    private String address;
    List<KidGrowth> growths = new ArrayList<>();
    List<KidParent> parents = new ArrayList<>();
    @JsonIgnore
    private String code;
    private String memo;
    private String emerNm;
    private String emerNb;

}
