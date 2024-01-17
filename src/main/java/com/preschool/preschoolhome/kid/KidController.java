package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.*;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
import com.preschool.preschoolhome.kid.model.sel.KidProfileVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kid")
@Tag(name = "원아", description = "원아 등록 및 수정")
public class KidController {
    private final KidService service;

    @Operation(summary = "원아 마이페이지", description = """
                원아 페이지 정보<br>
                리스트 안 result 값이<br>
                -1 : 원아 조회 실패<br>
                1 이상 : 원아 조회 성공""")
    @GetMapping("/{ikid}")
    public KidProfileVo getKidProfile(@PathVariable int ikid, int irank){
        return service.kidProfile(ikid,irank);
    }
    @PostMapping
    public KidInsVo postKidSignup(@RequestPart MultipartFile pic, @RequestPart KidInsDto dto){
        return service.kidSignup(pic, dto);
    }

    @PostMapping("/detail")
    public ResVo postKidInsDetail(@RequestBody List<KidDetailInsDto> dto){
        return service.kidInsDetail(dto);
    }

    @PutMapping("/detail")
    public ResVo putKidUpdDetail(@RequestBody List<KidDetailUpdDto> dto){
        return service.kidUpdDetail(dto);
    }

    //원아 마이페이지 조회
    @GetMapping("/detail/edit/{ikid}")
    public KidDetailEditVo getKidDetailEdit(@PathVariable int ikid, int irank){
        return service.kidDetailEdit(ikid,irank);
    }

    @PutMapping
    public ResVo putKidProfile(@RequestPart MultipartFile pic, @RequestPart  KidUpdDto dto){
        return service.kidUpdProfile(pic, dto);
    }

}
