package com.geega.sapdemo.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采购入库退库DTO
 * @author pxt
 * @date 2024-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CgrktkDTO {

    /**
     * 采购订单行号 必输
     */
    private String ebelp;

    /**
     * 物料编号 必输
     */
    private String matnr;

    /**
     * 数量 必输
     */
    private String menge;

    /**
     * 计量单位 选填(不填,系统默认基本单位）
     */
    private String meins;

    /**
     * 工厂 必输
     */
    private String werks;

    /**
     * 入库的库存地点 必输
     */
    private String lgort;

    /**
     * 参考凭证会计年度 当为退货采购订单冲销必输
     */
    private String lfbja;

    /**
     * 参考凭证的凭证号 当为退货采购订单冲销必输
     */
    private String lfbnr;

}