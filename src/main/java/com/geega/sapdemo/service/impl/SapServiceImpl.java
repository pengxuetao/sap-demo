package com.geega.sapdemo.service.impl;

import com.geega.sapdemo.service.SapService;
import com.geega.sapdemo.service.dto.CgrktkReq;
import com.geega.sapdemo.service.dto.CgrktkResp;
import com.geega.sapjco3.utils.SapJcoUtils;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoTable;
import org.springframework.beans.factory.annotation.Autowired;

public class SapServiceImpl implements SapService {

    @Autowired
    private JCoDestination jCoDestination;

    /**
     * 采购入库退库
     *
     * @param req 请求参数
     * @return CgrktkResp
     */
    @Override
    public CgrktkResp cgrktk(CgrktkReq req) {
        CgrktkResp cgrktkResp = null;
        try {
            JCoRepository jCoRepository = jCoDestination.getRepository();
            JCoFunction jCoFunction = jCoRepository.getFunction("ZFUN_SAPWMS_CGRKTK");

            // 请求参数
            SapJcoUtils.transferImportParameterList(jCoFunction, req);

            // 调用RFC
            jCoFunction.execute(jCoDestination);

            // 响应参数
//            String result = jCoFunction.getExportParameterList().getString("GSXX");

            // 表结构
            JCoTable table = jCoFunction.getTableParameterList().getTable("CGRKTK");
            for (int i = 0; i < table.getNumRows(); i++) {
                table.setRow(i);
                String bukrs = table.getString("BUKRS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cgrktkResp;
    }
}