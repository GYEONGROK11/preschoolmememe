package com.preschool.preschoolhome.kid.model.sel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class KidProfileVo {
    private String kidNm;
    private int iclass;
    private int gender;
    private String profile;
    private String birth;
    private String address;
    List<KidGrowth> growths;
    List<KidParent> parents;
    @JsonIgnore
    private String code;
    private String memo;
    private String emernm;
    private String emernb;

}
