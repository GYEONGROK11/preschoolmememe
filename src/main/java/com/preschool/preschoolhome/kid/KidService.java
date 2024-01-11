package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.Const;
import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.KidInsDto;
import com.preschool.preschoolhome.kid.model.KidInsVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class KidService {
    private final KidMapper mapper;

    public KidInsVo kidSignup(KidInsDto dto){

        if(dto.getKidNm() == null || dto.getBirth() == null ||
                dto.getAddress() == null || !(dto.getGender() == 0 ||dto.getGender() == 1) ||
                dto.getProfile() == null ||dto.getIrank()<2){
            KidInsVo vo1 = new KidInsVo();
            vo1.setResult(Const.FAIL);
            return vo1;
        }
        mapper.kidSignup(dto);
        int ikid = mapper.selIkid(dto);
        KidInsVo vo2 = new KidInsVo();
        vo2.setCode(dto.getCode());
        vo2.setResult(ikid);
        return vo2;
    }
}
