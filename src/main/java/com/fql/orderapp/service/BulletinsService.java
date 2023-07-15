package com.fql.orderapp.service;

import com.fql.orderapp.common.result.SimpleResult;
import com.fql.orderapp.controller.bulletins.request.BulletinsRequest;
import com.fql.orderapp.controller.bulletins.response.BulletinsDTO;

public interface BulletinsService {

    SimpleResult<BulletinsDTO> getBulletinsDTO(BulletinsRequest accessInfoRequest);
}
