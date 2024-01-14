package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.KidDetailInsDto;
import com.preschool.preschoolhome.kid.model.sel.KidDetailEditVo;
import com.preschool.preschoolhome.kid.model.KidInsDto;
import com.preschool.preschoolhome.kid.model.KidInsVo;
import com.preschool.preschoolhome.kid.model.KidUpdDto;
import com.preschool.preschoolhome.kid.model.sel.KidProfileVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kid")
public class KidController {
    private final KidService service;

    @GetMapping
    public KidProfileVo getKidProfile(){
        return null;
    }
    @PostMapping
    public KidInsVo postKidSignup(@RequestBody KidInsDto dto){
        return service.kidSignup(dto);
    }

    @PostMapping("/detail")
    public ResVo postKidDetail(@RequestBody KidDetailInsDto dto){
        return service.kidDetail(dto);
    }
    @GetMapping("/detail/edit/{ikid}")
    public KidDetailEditVo getKidDetailEdit(@PathVariable int ikid, int irank){
        return service.kidDetailEdit(ikid,irank);
    }

    @PutMapping
    public ResVo putKidProfile(@RequestBody KidUpdDto dto){
        return service.kidProfile(dto);
    }

}
