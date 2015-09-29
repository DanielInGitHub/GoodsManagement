package org.fiveguns.controller;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.fiveguns.service.impl.CommodityServiceImpl;
import org.fiveguns.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 2015/9/26.
 */
@Action("Warehouse")
@ParentPackage("struts-default")
@Namespace("/")
@Results(
        {
                @Result(name = "Warehouse", location = "/Warehouse.jsp"),
        })
public class WarehouseAction extends ActionSupport {

    public CommodityServiceImpl getGoodsService() {
        return commodityService;
    }

    public void setGoodsService(CommodityServiceImpl commodityService) {
        this.commodityService = commodityService;
    }

    @Autowired
    private CommodityServiceImpl commodityService;
    private List<Warehouse> list;

    public List<Warehouse> getList() {
        return list;
    }

    public void setList(List<Warehouse> list) {
        this.list = list;
    }

    public String warehouse() {
        list = commodityService.getWarehouseInventory1();
        // just for debug
        for (Warehouse wh : list) {
            System.out.println(wh);
        }

        return "Warehouse";

    }
}

