package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.CommodityDaoImpl;
import org.fiveguns.po.CommodityDto;
import org.fiveguns.service.BaseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */
@Service
public class CommodityServiceImpl implements BaseServiceI<CommodityDto> {

    @Autowired
    @Qualifier("commodityDaoImpl")
    private CommodityDaoImpl commodityDaoImpl;

    /**
     * 添加实体
     *
     * @param CommodityDto 实体对象
     */
    public void addEntity(CommodityDto CommodityDto) {
        commodityDaoImpl.insert(CommodityDto);
    }

    /**
     * 删除指定ID的商品
     */
    public void deleteEntity(int id) {
        commodityDaoImpl.deleteByPrimaryKey(id);
    }

    /**
     * 修改实体
     *
     * @param CommodityDto 实体对象(不需指定所有的键)
     */
    public void modifyEntity(CommodityDto CommodityDto) {
        commodityDaoImpl.updateByPrimaryKey(CommodityDto);
    }

    /**
     * 通过ID获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public CommodityDto getEntity(int id) {
        return commodityDaoImpl.selectByPrimaryKey(id);
    }

//    /**
//     * 通过货品名称来查询
//     *
//     * @param name 需要查询的货品名称
//     * @return goods
//     * 同意货品名称的集合
//     */
//    public List<CommodityDto> getEntitiesByname(String name) {
//        return commodityDaoImpl.selectByName(name);
//    }

    /**
     * 查看商品种类
     *
     * @return goods
     * 已经分类的Goods集合
     */
//    public List<CommodityVo> getEntitieskind() {
//        return commodityDaoImpl.getEntitieskind();
//    }


//    /**
//     * 获取库房盘存显示信息
//     *
//     * @return
//     */
//    public List<Warehouse> getWarehouseInventory() {
//        return commodityDaoImpl.getWarehouseInventory();
//    }

}
