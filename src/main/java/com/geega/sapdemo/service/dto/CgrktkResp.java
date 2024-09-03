package com.geega.sapdemo.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 采购入库退库响应参数
 * @author pxt
 * @date 2024-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CgrktkResp {

    /**
     * 物料凭证编号
     */
    private String mblnr;

    /**
     * 采购入库退库DTO
     */
    private List<CgrktkDTO> cgrktk;

}