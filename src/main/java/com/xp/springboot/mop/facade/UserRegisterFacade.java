package com.xp.springboot.mop.facade;



import org.springframework.web.bind.annotation.PostMapping;

import com.xp.springboot.mop.common.Result;

public interface UserRegisterFacade {
    @PostMapping(value = "/mopFacade/get/getUserCount")
    Result<Integer> getUserCount();
    //  Result<ResourceConfigDTO<List<StoreyDTO>>> getStoreyById(@RequestParam("id") String id);
    //    Result<Boolean> saveResourcePriority(@RequestBody PrioritySortDto prioritySortDto);
}
