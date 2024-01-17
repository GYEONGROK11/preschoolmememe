package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.*;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
import com.preschool.preschoolhome.kid.model.sel.KidProfileVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kid")
public class KidController {
    private final KidService service;

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

    @GetMapping("/detail/edit/{ikid}")
    public KidDetailEditVo getKidDetailEdit(@PathVariable int ikid, int irank){
        return service.kidDetailEdit(ikid,irank);
    }

    @PutMapping
    public ResVo putKidProfile(@RequestPart MultipartFile pic, @RequestPart  KidUpdDto dto){
        return service.kidUpdProfile(pic, dto);
    }

}
