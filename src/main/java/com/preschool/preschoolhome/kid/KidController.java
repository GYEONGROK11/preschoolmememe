package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.KidInsDto;
import com.preschool.preschoolhome.kid.model.KidInsVo;
import com.preschool.preschoolhome.kid.model.KidUpdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kid")
public class KidController {
    private final KidService service;

    @PostMapping
    public KidInsVo postKidSignup(@RequestBody KidInsDto dto){
        return service.kidSignup(dto);
    }

    @GetMapping("/detail/edit/{ikid}")
    public KidInsDto getKidDetailEdit(@RequestParam int ikid,int irank){
        return service.kidDetailEdit(ikid,irank);
    }


    @PutMapping
    public ResVo putKidProfile(@RequestBody KidUpdDto dto){
        return service.kidProfile(dto);
    }

}
