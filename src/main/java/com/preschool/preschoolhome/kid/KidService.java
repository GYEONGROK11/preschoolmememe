package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.Const;
import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.*;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
import com.preschool.preschoolhome.kid.model.sel.KidGrowth;
import com.preschool.preschoolhome.kid.model.sel.KidParent;
import com.preschool.preschoolhome.kid.model.sel.KidProfileVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KidService {
    private final KidMapper mapper;

    public KidProfileVo kidProfile(int ikid, int irank){
        KidProfileVo vo = new KidProfileVo();
        if (irank < 2) {
            vo.setResult(Const.FAIL);
            return vo;
        }
        vo = mapper.kidProfile(ikid);
        vo.setResult(Const.SUCCESS);
        List<KidParent> parents = mapper.kidParent(ikid);
        List<KidGrowth> growths= mapper.kidGrowth(ikid);
        vo.setGrowths(growths);
        vo.setParents(parents);
        return vo;

    }

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

    public ResVo kidInsDetail(List<KidDetailInsDto> list) {
        for (KidDetailInsDto dto : list ) {
            if (dto.getHeight() < 1 || dto.getWeight() < 1 || dto.getIrank() < 2 ||
                (dto.getActivity() == 0 && dto.getCreativity() == 0 && dto.getPolite() == 0) ||
                (dto.getActivity() == 1 && dto.getCreativity() == 1 && dto.getPolite() == 0) ||
                (dto.getActivity() == 0 && dto.getCreativity() == 1 && dto.getPolite() == 1) ||
                (dto.getActivity() == 1 && dto.getCreativity() == 0 && dto.getPolite() == 1)) {
                return new ResVo(Const.FAIL);
            }
        }
        for (KidDetailInsDto dto : list ){
            int month = Integer.parseInt(dto.getGrowthDate().substring(5,7));

            switch (month/3){
                case 0 :
                    dto.setQuarterly(1);
                    break;
                case 1 :
                    dto.setQuarterly(2);
                case 2 :
                    dto.setQuarterly(3);
                case 3 :
                    dto.setQuarterly(3);
            }

            mapper.kidGrowthInsDetail(dto);

            mapper.kidBodyInsDetail(dto);

        }
        return new ResVo(Const.SUCCESS);
    }
    ResVo kidUpdDetail(List<KidDetailUpdDto> list){
        for (KidDetailUpdDto dto : list ) {
            if (dto.getHeight() < 1 || dto.getWeight() < 1 || dto.getIrank() < 2 ||
                (dto.getActivity() == 0 && dto.getCreativity() == 0 && dto.getPolite() == 0) ||
                (dto.getActivity() == 1 && dto.getCreativity() == 1 && dto.getPolite() == 0) ||
                (dto.getActivity() == 0 && dto.getCreativity() == 1 && dto.getPolite() == 1) ||
                (dto.getActivity() == 1 && dto.getCreativity() == 0 && dto.getPolite() == 1)) {
                return new ResVo(Const.FAIL);
            }
        }
        for (KidDetailUpdDto dto : list ) {
            mapper.kidGrowthUpdDetail(dto);
            mapper.kidBodyUpdDetail(dto);
        }
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

    public ResVo kidUpdProfile(KidUpdDto dto) {
        if (dto.getKidNm() == null || dto.getBirth() == null ||
            dto.getAddress() == null || !(dto.getGender() == 0 || dto.getGender() == 1) ||
            dto.getProfile() == null || dto.getIrank() < 2) {
            ResVo vo1 = new ResVo(Const.FAIL);
            return vo1;
        }
        mapper.kidUpdProfile(dto);
        return new ResVo(Const.SUCCESS);
    }
}
