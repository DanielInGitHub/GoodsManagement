package org.fiveguns.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

import org.fiveguns.po.CommodityDto;
import org.fiveguns.service.impl.CommodityServiceImpl;
import org.fiveguns.vo.CommodityVo;
import org.fiveguns.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/9/25.
 */

@Action("GoodsManager")
@ParentPackage("struts-default")
@Namespace("/")
@Results(
        {

                @Result(name = "success", location = "/goodsManager.jsp"),
                @Result(name = "showGood", location = "/goodsManager.jsp"),
                @Result(name = "showAll", location = "/showGoodsInformation.jsp"),
                @Result(name = "addGood", location = "/addGood.jsp")
        })
public class GoodsManagerAction extends ActionSupport implements ServletRequestAware {

    @Autowired
    private CommodityServiceImpl goodsServiceImpl;
    private String goodName;
    private List<CommodityDto> listGood;
    private List<CommodityVo> list = new ArrayList<CommodityVo>();
    private List<Warehouse> listNumber;
    private HttpServletRequest request;
    private CommodityVo commodityVo;

    public CommodityVo getCommodityVo() {
        return commodityVo;
    }

    public void setCommodityVo(CommodityVo commodityVo) {
        this.commodityVo = commodityVo;
    }

    public List<CommodityDto> getListGood() {
        return listGood;
    }

    public void setListGood(List<CommodityDto> listGood) {
        this.listGood = listGood;
    }

    public List<Warehouse> getListNumber() {
        return listNumber;
    }

    public void setListNumber(List<Warehouse> listNumber) {
        this.listNumber = listNumber;
    }

    public List<CommodityVo> getList() {
        return list;
    }

    public void setList(List<CommodityVo> list) {
        this.list = list;
    }

    public CommodityServiceImpl getCommodityServiceImpl() {
        return goodsServiceImpl;
    }

    public void setCommodityServiceImpl(CommodityServiceImpl goodsServiceImpl) {
        this.goodsServiceImpl = goodsServiceImpl;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    //显示�?有物品信�?
    public String getAll() {
        list = goodsServiceImpl.getEntitieskind();
        System.out.println("物品的种类大小：" + list.size());
        return SUCCESS;
    }

    //根据物品名称查询
    public String selectByName() {
        System.out.println("物品名称�?" + goodName);
        listGood = goodsServiceImpl.getEntitiesByname(goodName);
        CommodityVo commodityVo = new CommodityVo();
        commodityVo.setName(listGood.get(0).getName());
        commodityVo.setUit(listGood.get(0).getUnit());
        list.add(commodityVo);
        return "showGood";
    }

    //显示�?有物品详细信�?
    public String showAll() throws Exception {
//        listNumber = goodsServiceImpl.getWarehouseInventory(goodName);
        listGood = goodsServiceImpl.getEntitiesByname(goodName);
        return "showAll";
    }

    //根据物品名称删除物品
    public String deleteGoods() throws Exception {
        System.out.println("删除的物品名称：" + goodName);
        listGood = goodsServiceImpl.getEntitiesByname(goodName);
        goodsServiceImpl.deleteEntity(listGood.get(0).getId());
        getAll();
        return "showGood";
    }

    //增加物品
    public String addGood() {
        System.out.println("增加物品信息:" + commodityVo);
        CommodityDto commodityDto = new CommodityDto();
        commodityDto.setName(commodityVo.getName());
        commodityDto.setUnit(commodityVo.getUit());
//        commodityDto.setNumber(commodityVo.getGoodnumbers());
//        commodityDto.setType(commodityVo.get());
        System.out.println("增加物品信息:" + commodityDto);
        goodsServiceImpl.addEntity(commodityDto);
        return "addGood";
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
