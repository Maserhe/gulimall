package com.jpg6.gulimall.ware.feign;

import com.jpg6.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("gulimall-member")
public interface MemberFeignService {

    /**
     * 根据id获取用户地址信息
     * @param id
     * @return
     */
    @RequestMapping("/member/memberreceiveaddress/info/{id}")
    R info(@PathVariable("id") Long id);

}
