package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.KidInsDto;
import com.preschool.preschoolhome.kid.model.KidInsVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KidMapper {

    int kidSignup(KidInsDto dto);
    int selIkid(KidInsDto dto);
}
