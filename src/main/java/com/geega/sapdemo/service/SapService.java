package com.geega.sapdemo.service;

import com.geega.sapdemo.service.dto.CgrktkReq;
import com.geega.sapdemo.service.dto.CgrktkResp;

/**
 * SAP系统Service
 * @author pxt
 * @date 2024/8/28
 */
public interface SapService {

    /**
     * 采购入库退库
     * @param req 请求参数
     * @return CgrktkResp
     */
    CgrktkResp cgrktk(CgrktkReq req);

}