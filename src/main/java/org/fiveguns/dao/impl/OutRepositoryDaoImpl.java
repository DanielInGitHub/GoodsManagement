package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.poo.OutRepositoryDto;
import org.fiveguns.vo.OutRepositoryVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */

@Component
public class OutRepositoryDaoImpl extends BasedaoA<OutRepositoryDto> {
    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public OutRepositoryDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.OutRepositoryDtoMapper.selectByPrimaryKey", id);
    }

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.OutRepositoryDtoMapper.deleteByPrimaryKey", id);
    }
    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(OutRepositoryDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.OutRepositoryDtoMapper.insert", record);
    }
    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(OutRepositoryDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.OutRepositoryDtoMapper.insertSelective", record);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(OutRepositoryDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.OutRepositoryDtoMapper.updateByPrimaryKeySelective", record);
    }
    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(OutRepositoryDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.OutRepositoryDtoMapper.updateByPrimaryKey", record);
    }

    /**
     * 显示所有的出库信息
     * @return List of OutRepository
     */
    public List<OutRepositoryVO> selectAll() {
        return sessionTemplate.selectList("org.fiveguns.mapper.OutRepositoryDtoMapper.selectAll");
    }
}
