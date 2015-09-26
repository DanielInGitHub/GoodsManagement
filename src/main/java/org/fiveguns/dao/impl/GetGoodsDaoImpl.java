package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.GetGoodsDto;
import org.fiveguns.vo.GetGoodsVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by johnny on 2015/9/23.
 */
@Component
public class GetGoodsDaoImpl extends BasedaoA<GetGoodsDto> {
    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.GetGoodsDtoMapper.deleteByPrimaryKey", id);
    }
    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(GetGoodsDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.GetGoodsDtoMapper.insert", record);
    }
    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(GetGoodsDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.GetGoodsDtoMapper.insertSelective", record);
    }
    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public GetGoodsDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.GetGoodsDtoMapper.getGoodsById", id);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(GetGoodsDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.GetGoodsDtoMapper.updateByPrimaryKeySelective", record);
    }
    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(GetGoodsDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.GetGoodsDtoMapper.updateByPrimaryKey", record);
    }



    /**
     * 通过id获取页面显示信息
     * @param id 传入的id
     * @return VO用于显示
     */
    public GetGoodsVO getGoodsById(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.GetGoodsDtoMapper.getGoodsById", id);
    }

    public List<GetGoodsVO> allGetGoodsInfo() {
        return sessionTemplate.selectList("org.fiveguns.mapper.GetGoodsDtoMapper.allGetGoodsInfo");
    }
}
