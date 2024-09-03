package com.geega.sapdemo.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 采购入库退库请求参数
 * @author pxt
 * @date 2024-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CgrktkReq {

    /**
     * 采购订单编号 必输
     */
    private String ebeln;

    /**
     * 交货单号 必输
     */
    private String xblnr;

    /**
     * 公司间交货单 非必输；公司间采购订单已有交货单的，需抛送交货单
     */
    private String vbeln;

    /**
     * 过账日期 必输
     */
    private String budat;

    /**
     * 移动类型 必输（101/102）
     */
    private String bwart;

    /**
     * 用户名 必输
     */
    private String usnam;

    /**
     * 移动原因 选填(当退货采购时候（RETPO = 'X',PO信息打上退货标记后），需要输入移动原因)
     */
    private String grund;

    /**
     * 采购入库退库DTO
     */
    private List<CgrktkDTO> cgrktk;

}