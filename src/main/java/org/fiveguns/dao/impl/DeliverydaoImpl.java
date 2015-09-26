package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.DeliveryDto;
import org.fiveguns.vo.OutRepositoryVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */

@Component
public class DeliverydaoImpl extends BasedaoA<DeliveryDto> {
    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public DeliveryDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.DeliveryDtoMapper.selectByPrimaryKey", id);
    }

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.DeliveryDtoMapper.deleteByPrimaryKey", id);
    }
    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(DeliveryDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.DeliveryDtoMapper.insert", record);
    }
    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(DeliveryDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.DeliveryDtoMapper.insertSelective", record);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(DeliveryDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.DeliveryDtoMapper.updateByPrimaryKeySelective", record);
    }
    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(DeliveryDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.DeliveryDtoMapper.updateByPrimaryKey", record);
    }

    /**
     * 显示所有的出库信息
     * @return List of OutRepository
     */
    public List<OutRepositoryVO> selectAll() {
        return sessionTemplate.selectList("org.fiveguns.mapper.DeliveryDtoMapper.selectAll");
    }
}
