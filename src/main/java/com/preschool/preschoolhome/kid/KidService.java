package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.Const;
import com.preschool.preschoolhome.common.MyFileUtils;
import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.*;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
import com.preschool.preschoolhome.kid.model.sel.KidGrowth;
import com.preschool.preschoolhome.kid.model.sel.KidParent;
import com.preschool.preschoolhome.kid.model.sel.KidProfileVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KidService {
    private final KidMapper mapper;
    private final MyFileUtils myFileUtils;

    public KidProfileVo kidProfile(int year, int ikid, int irank) {
        KidProfileVo vo = new KidProfileVo();
        if (irank < 2) {
            vo.setResult(Const.FAIL);
            return vo;
        }
        vo = mapper.kidProfile(ikid);
        vo.setResult(Const.SUCCESS);
        List<KidParent> parents = mapper.kidParent(ikid);
        List<KidGrowth> growths = mapper.kidGrowth(ikid, year);
        vo.setGrowths(growths);
        vo.setParents(parents);
        return vo;

    }

    public KidInsVo kidSignup(MultipartFile pic, KidInsDto dto) {
        if (dto.getKidNm() == null || dto.getBirth() == null ||
                dto.getAddress() == null || !(dto.getGender() == 0 || dto.getGender() == 1) ||
                pic == null || dto.getIrank() < 2) {
            KidInsVo vo1 = new KidInsVo();
            vo1.setResult(Const.FAIL);
            return vo1;
        }

        String path = "/kid/profile";
        String savedPicFileNm = myFileUtils.transferTo(pic, path);
        dto.setProfile(savedPicFileNm);
        mapper.kidSignup(dto);
        int ikid = mapper.selIkid(dto);
        KidInsVo vo2 = new KidInsVo();
        vo2.setCode(dto.getCode());
        vo2.setResult(ikid);
        return vo2;
    }

    public ResVo kidInsDetail(List<KidDetailInsDto> list) {
        for (KidDetailInsDto dto : list) {
            if (dto.getHeight() < 1 || dto.getWeight() < 1 || dto.getIrank() < 2 ||
                    (dto.getActivity() == 0 && dto.getCreativity() == 0 && dto.getPolite() == 0) ||
                    (dto.getActivity() == 1 && dto.getCreativity() == 1 && dto.getPolite() == 0) ||
                    (dto.getActivity() == 0 && dto.getCreativity() == 1 && dto.getPolite() == 1) ||
                    (dto.getActivity() == 1 && dto.getCreativity() == 0 && dto.getPolite() == 1)) {
                return new ResVo(Const.FAIL);
            }
        }

        for (KidDetailInsDto dto : list) {
            int growthmonth = Integer.parseInt(dto.getGrowthDate().substring(5, 7));
            int bodymonth = Integer.parseInt(dto.getBodyDate().substring(5, 7));
            switch (growthmonth / 3) {
                case 0: dto.setGrowthQuarterly(4); break;
                case 1: dto.setGrowthQuarterly(1); break;
                case 2: dto.setGrowthQuarterly(2); break;
                case 3: dto.setGrowthQuarterly(3); break;
                case 4: dto.setGrowthQuarterly(4); break;
            }
            switch (bodymonth / 3) {
                case 0: dto.setBodyQuarterly(4); break;
                case 1: dto.setBodyQuarterly(1); break;
                case 2: dto.setBodyQuarterly(2); break;
                case 3: dto.setBodyQuarterly(3); break;
                case 4: dto.setBodyQuarterly(4); break;
            }
                //같은 분기가 들어오지 않는 작업 필요
                mapper.kidGrowthInsDetail(dto);

                mapper.kidBodyInsDetail(dto);

            }
            return new ResVo(Const.SUCCESS);
        }


    ResVo kidUpdDetail(List<KidDetailUpdDto> list) {
        for (KidDetailUpdDto dto : list) {
            if (dto.getHeight() < 1 || dto.getWeight() < 1 || dto.getIrank() < 2 ||
                    (dto.getActivity() == 0 && dto.getCreativity() == 0 && dto.getPolite() == 0) ||
                    (dto.getActivity() == 1 && dto.getCreativity() == 1 && dto.getPolite() == 0) ||
                    (dto.getActivity() == 0 && dto.getCreativity() == 1 && dto.getPolite() == 1) ||
                    (dto.getActivity() == 1 && dto.getCreativity() == 0 && dto.getPolite() == 1)) {
                return new ResVo(Const.FAIL);
            }
        }
        for (KidDetailUpdDto dto : list) {
            int growthmonth = Integer.parseInt(dto.getGrowthDate().substring(5, 7));
            int bodymonth = Integer.parseInt(dto.getBodyDate().substring(5, 7));
            switch (growthmonth / 3) {
                case 0: dto.setGrowthQuarterly(4); break;
                case 1: dto.setGrowthQuarterly(1); break;
                case 2: dto.setGrowthQuarterly(2); break;
                case 3: dto.setGrowthQuarterly(3); break;
                case 4: dto.setGrowthQuarterly(4); break;
            }
            switch (bodymonth / 3) {
                case 0: dto.setBodyQuarterly(4); break;
                case 1: dto.setBodyQuarterly(1); break;
                case 2: dto.setBodyQuarterly(2); break;
                case 3: dto.setBodyQuarterly(3); break;
                case 4: dto.setBodyQuarterly(4); break;
            }
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

    public ResVo kidUpdProfile(MultipartFile pic, KidUpdDto dto) {
        if (dto.getKidNm() == null || dto.getBirth() == null ||
                dto.getAddress() == null || !(dto.getGender() == 0 || dto.getGender() == 1) ||
                pic == null || dto.getIrank() < 2) {
            ResVo vo1 = new ResVo(Const.FAIL);
            return vo1;
        }
        String path = "/kid/"+dto.getIkid();
        myFileUtils.delFolderTrigger(path);
        String savedPicFileNm = myFileUtils.transferTo(pic, path);
        dto.setProfile(savedPicFileNm);
        mapper.kidUpdProfile(dto);
        return new ResVo(Const.SUCCESS);
    }

    public ResVo allGraduateKid(int irank){
        if (irank < 3) {
            return new ResVo(Const.FAIL);
        }
        LocalDate now = LocalDate.now();
        int nowYear = now.getYear();//현재년도
        int year1 = nowYear - Const.GRADUATE_YEAR;
        mapper.allGraduateKid(year1);
        return new ResVo(Const.SUCCESS);
    }

}
