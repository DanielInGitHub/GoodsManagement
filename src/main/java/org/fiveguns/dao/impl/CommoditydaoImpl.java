package org.fiveguns.dao.impl;

import com.github.pagehelper.PageHelper;
import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.CommodityDto;
import org.fiveguns.vo.GoodsVo;
import org.fiveguns.vo.Warehouse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */
@Component
public class CommodityDaoImpl extends BasedaoA<CommodityDto> {
    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.CommodityDtoMapper.deleteByPrimaryKey", id);
    }

    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(CommodityDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.CommodityDtoMapper.insert", record);
    }

    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(CommodityDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.CommodityDtoMapper.insertSelective", record);
    }

    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public CommodityDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.CommodityDtoMapper.selectByPrimaryKey", id);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(CommodityDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.CommodityDtoMapper.updateByPrimaryKeySelective", record);
    }

    /**
     * 获得所有的实体类，加入分页支持
     *
     * @param page      想要获取的页码
     * @param rowCounts 一页的数量
     * @return
     */
    @Override
    public List<CommodityDto> selectAllByPage(int page, int rowCounts) {
        PageHelper.startPage(page, rowCounts);
        return sessionTemplate.selectList("org.fiveguns.mapper.CommodityDtoMapper.selectAllByPage");
    }

    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(CommodityDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.CommodityDtoMapper.updateByPrimaryKey", record);
    }

    /**
     * 通过货品名称来查询
     *
     * @param name 需要查询的货品名称
     * @return goods
     * 同意货品名称的集合
     */
    public List<CommodityDto> selectByName(String name) {
//        List<CommodityDto> goods = sessionTemplate.selectList("org.fiveguns.mapper.CommodityDtoMapper.selectByName", "衬衫");
        return sessionTemplate.selectList("org.fiveguns.mapper.CommodityDtoMapper.selectByName", name);
    }

    /**
     * 通过货品名称来查询
     *
     * @return goods
     * 已经分类的Goods集合
     */
    public List<GoodsVo> getEntitieskind() {
        List<GoodsVo> goods = sessionTemplate.selectList("org.fiveguns.mapper.CommodityDtoMapper.selectGroupByName");
        return goods;
    }

    /**
     * 获取库房盘存信息
     *
     * @return 所有库房盘存信息
     */
    public List<Warehouse> getWarehouseInventory() {
        return sessionTemplate.selectList("org.fiveguns.mapper.CommodityDtoMapper.WarehouseInventory");
    }

}
