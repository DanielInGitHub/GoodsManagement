package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.CommodityDaoImpl;
import org.fiveguns.po.CommodityDto;
import org.fiveguns.service.BaseServiceI;
import org.fiveguns.vo.CommodityVo;
import org.fiveguns.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /*************************************************************/
    /*---------------------手动添加的方法--------------------------*/
    /*************************************************************/

    /**
     * 通过货品名称来查询
     *
     * @param name 需要查询的货品名称
     * @return goods
     * 同意货品名称的集合
     */
    public List<CommodityDto> getEntitiesByname(String name) {
        return commodityDaoImpl.selectByName(name);
    }

    /**
     * 分页获取所有的物品信息
     *
     * @param page
     * @param counts
     * @return
     */
    public List<CommodityDto> getAllCommoditiesByPage(int page, int counts) {
        return commodityDaoImpl.getAllCommoditiesByPage(page, counts);
    }

    public int getCounts() {
        return commodityDaoImpl.getCounts();
    }
//    /**
//     * 查看商品种类
//     *
//     * @return goods
//     * 已经分类的Goods集合
//     */
//    public List<CommodityVo> getEntitiesByType() {
//        return commodityDaoImpl.getEntitiesByType();
//    }


    /**
     * 获取库房盘存显示信息
     *
     * @return
     */
    public List<Warehouse> getWarehouseInventory() {
        return commodityDaoImpl.getWarehouseInventory();
    }

    public List<Warehouse> getWarehouseInventory1() {
        return commodityDaoImpl.getWarehouseInventory1();
    }
}
