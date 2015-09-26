package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.GoodsDto;
import org.fiveguns.vo.GoodsVo;
import org.fiveguns.vo.Warehouse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */
@Component
public class GoodsDaoImpl extends BasedaoA<GoodsDto> {
    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.GoodsDtoMapper.deleteByPrimaryKey", id);
    }
    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(GoodsDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.GoodsDtoMapper.insert", record);
    }
    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(GoodsDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.GoodsDtoMapper.insertSelective", record);
    }
    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public GoodsDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.GoodsDtoMapper.selectByPrimaryKey", id);
    }
    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(GoodsDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.GoodsDtoMapper.updateByPrimaryKeySelective", record);
    }
    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(GoodsDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.GoodsDtoMapper.updateByPrimaryKey", record);
    }
    /**
     * 通过货品名称来查询
     *
     * @param name
     *              需要查询的货品名称
     * @return goods
     *              同意货品名称的集合
     */
    public  List<GoodsDto> selectByName(String name) {
        List<GoodsDto> goods =  sessionTemplate.selectList("org.fiveguns.mapper.GoodsDtoMapper.selectByName", "衬衫");
        return goods;
    }
    /**
     * 通过货品名称来查询
     *
     * @return goods
     *              已经分类的Goods集合
     */
    public List<GoodsVo> getEntitieskind() {
        List<GoodsVo> goods =  sessionTemplate.selectList("org.fiveguns.mapper.GoodsDtoMapper.selectGroupByName");
        return goods;
    }

    /**
     * 获取库房盘存信息
     * @return 所有库房盘存信息
     */
    public List<Warehouse> getWarehouseInventory() {
        return sessionTemplate.selectList("org.fiveguns.mapper.GoodsDtoMapper.WarehouseInventory");
    }

}
