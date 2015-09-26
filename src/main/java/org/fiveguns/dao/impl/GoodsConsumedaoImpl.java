package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.GoodsConsumeDto;
import org.fiveguns.vo.GetGoodsVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by johnny on 2015/9/23.
 */
@Component
public class GoodsConsumedaoImpl extends BasedaoA<GoodsConsumeDto> {
    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        
        return sessionTemplate.delete("org.fiveguns.mapper.GoodsConsumeDtoMapper.deleteByPrimaryKey", id);
    }
    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(GoodsConsumeDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.GoodsConsumeDtoMapper.insert", record);
    }
    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(GoodsConsumeDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.GoodsConsumeDtoMapper.insertSelective", record);
    }
    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public GoodsConsumeDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.GoodsConsumeDtoMapper.getGoodsById", id);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(GoodsConsumeDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.GoodsConsumeDtoMapper.updateByPrimaryKeySelective", record);
    }
    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(GoodsConsumeDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.GoodsConsumeDtoMapper.updateByPrimaryKey", record);
    }



    /**
     * 通过id获取页面显示信息
     * @param id 传入的id
     * @return VO用于显示
     */
    public GetGoodsVO getGoodsById(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.GoodsConsumeDtoMapper.getGoodsById", id);
    }

    public List<GetGoodsVO> allGetGoodsInfo() {
        return sessionTemplate.selectList("org.fiveguns.mapper.GoodsConsumeDtoMapper.allGetGoodsInfo");
    }
}
