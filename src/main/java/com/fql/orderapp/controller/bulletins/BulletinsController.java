package com.fql.orderapp.controller.bulletins;

import com.fql.orderapp.common.base.WebResponse;
import com.fql.orderapp.common.result.SimpleResult;
import com.fql.orderapp.common.utils.ResultUtil;
import com.fql.orderapp.controller.bulletins.request.BulletinsRequest;
import com.fql.orderapp.controller.bulletins.response.BulletinsDTO;
import com.fql.orderapp.service.BulletinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class BulletinsController {

    @Autowired
    private BulletinsService bulletinsService;

    @GetMapping("/notice/last-one")
    public WebResponse<BulletinsDTO> getBulletins() {
        BulletinsRequest request = new BulletinsRequest();
        SimpleResult<BulletinsDTO> result = bulletinsService.getBulletinsDTO(request);
        if (result.isSuccess() && Objects.nonNull(result.getValue())) {
            return ResultUtil.success(result.getValue());
        }
        return ResultUtil.error("500", "get access info failed!");

    }
}
