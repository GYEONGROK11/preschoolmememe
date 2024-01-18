package com.preschool.preschoolhome.notice;

import com.preschool.preschoolhome.notice.model.NoticeInsDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface NoticeMapper {
    //알림장 등록
    int insNotice(NoticeInsDto dto);
    int insNiticePics(NoticeInsDto dto);
}
