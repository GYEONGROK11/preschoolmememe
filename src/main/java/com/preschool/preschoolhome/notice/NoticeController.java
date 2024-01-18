package com.preschool.preschoolhome.notice;

import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.notice.model.NoticeInsDto;
import com.preschool.preschoolhome.notice.model.NoticeUpdDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    private final NoticeService service;

    @Operation(summary = "알림장 등록", description = "알림장 등록")
    @PostMapping
    public ResVo postInsNotice(@RequestBody NoticeInsDto dto){
        return service.insNotice(dto);
    }

    @Operation(summary = "알림장 수정", description = "알림장 수정")
    @PutMapping
    public ResVo putUpdNotice(@RequestBody NoticeUpdDto dto){
        return service.updNotice(dto);
    }
}
