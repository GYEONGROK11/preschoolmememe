package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.Const;
import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.KidDetailInsDto;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
import com.preschool.preschoolhome.kid.model.KidInsDto;
import com.preschool.preschoolhome.kid.model.KidInsVo;
import com.preschool.preschoolhome.kid.model.KidUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class KidService {
    private final KidMapper mapper;

    public KidInsVo kidSignup(KidInsDto dto) {

        if (dto.getKidNm() == null || dto.getBirth() == null ||
                dto.getAddress() == null || !(dto.getGender() == 0 || dto.getGender() == 1) ||
                dto.getProfile() == null || dto.getIrank() < 2) {
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

    public ResVo kidDetail(KidDetailInsDto dto){
        if (dto.getHeight() == 0 || dto.getWeight() == 0 ||
                dto.getGrowthMemo() ==null || dto.getIrank() < 2) {
            return new ResVo(Const.FAIL);
        }
        mapper.kidDetail(dto);
        return new ResVo(Const.SUCCESS);
    }

    public KidDetailEditVo kidDetailEdit(int ikid, int irank) {
        KidDetailEditVo vo = new KidDetailEditVo();
        if (irank < 2) {
            vo.setResult(Const.FAIL);
            return vo;
        }
        vo = mapper.kidDetailEdit(ikid);
        vo.setResult(Const.SUCCESS);
        return vo;
    }

    public ResVo kidProfile(KidUpdDto dto) {
        if (dto.getKidNm() == null || dto.getBirth() == null ||
                dto.getAddress() == null || !(dto.getGender() == 0 || dto.getGender() == 1) ||
                dto.getProfile() == null || dto.getIrank() < 2) {
            ResVo vo1 = new ResVo(Const.FAIL);
            return vo1;
        }
        mapper.kidProfile(dto);
        return new ResVo(Const.SUCCESS);
    }
}
