package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.Const;
import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.*;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
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

    public ResVo kidInsDetail(KidDetailInsDto dto) {
        if (dto.getHeight() < 1 || dto.getWeight() < 1 || dto.getIrank() < 2 ||
            (dto.getActivity() == 0 && dto.getCreativity() == 0 && dto.getPolite() == 0) ||
            (dto.getActivity() == 1 && dto.getCreativity() == 1 && dto.getPolite() == 0) ||
            (dto.getActivity() == 0 && dto.getCreativity() == 1 && dto.getPolite() == 1) ||
            (dto.getActivity() == 1 && dto.getCreativity() == 0 && dto.getPolite() == 1)) {
            return new ResVo(Const.FAIL);
        }
        mapper.kidGrowthInsDetail(dto);
        mapper.kidBodyInsDetail(dto);
        return new ResVo(Const.SUCCESS);
    }
    ResVo kidUpdDetail(KidDetailUpdDto dto){
        if (dto.getHeight() < 1 || dto.getWeight() < 1 || dto.getIrank() < 2 ||
                (dto.getActivity() == 0 && dto.getCreativity() == 0 && dto.getPolite() == 0) ||
                (dto.getActivity() == 1 && dto.getCreativity() == 1 && dto.getPolite() == 0) ||
                (dto.getActivity() == 0 && dto.getCreativity() == 1 && dto.getPolite() == 1) ||
                (dto.getActivity() == 1 && dto.getCreativity() == 0 && dto.getPolite() == 1)) {
            return new ResVo(Const.FAIL);
        }
        mapper.kidGrowthUpdDetail(dto);
        mapper.kidBodyUpdDetail(dto);
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
