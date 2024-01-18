package com.preschool.preschoolhome.notice;

import com.preschool.preschoolhome.common.Const;
import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.notice.model.NoticeInsDto;
import com.preschool.preschoolhome.notice.model.NoticeUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper mapper;
    //알림장 등록
    ResVo insNotice(NoticeInsDto dto){
        if(dto.getIlevel()<2){
            return new ResVo(Const.FAIL);
        }
        mapper.insNotice(dto);
        mapper.insNiticePics(dto);
        return new ResVo(Const.SUCCESS);
    }

    ResVo updNotice(NoticeUpdDto dto){


        return null;
    }
}
