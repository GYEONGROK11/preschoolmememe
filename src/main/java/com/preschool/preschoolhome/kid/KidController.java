package com.preschool.preschoolhome.kid;

import com.preschool.preschoolhome.common.ResVo;
import com.preschool.preschoolhome.kid.model.KidInsDto;
import com.preschool.preschoolhome.kid.model.KidInsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
