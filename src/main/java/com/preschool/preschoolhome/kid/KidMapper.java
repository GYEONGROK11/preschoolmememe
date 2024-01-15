package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.kid.model.KidDetailInsDto;
import com.preschool.preschoolhome.kid.model.KidDetailUpdDto;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
import com.preschool.preschoolhome.kid.model.KidInsDto;
import com.preschool.preschoolhome.kid.model.KidUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KidMapper {
    //원아등록
    int kidSignup(KidInsDto dto);
    int selIkid(KidInsDto dto);
    //원아 발달사항 등록
    int kidGrowthInsDetail(KidDetailInsDto dto);
    int kidBodyInsDetail(KidDetailInsDto dto);
    //원아 발달사항 수정
    int kidGrowthUpdDetail(KidDetailUpdDto dto);
    int kidBodyUpdDetail(KidDetailUpdDto dto);
    //원아정보 수정
    int kidProfile(KidUpdDto dto);
    //원아 수정 시 기존 정보 출력
    KidDetailEditVo kidDetailEdit(int ikid);


}
