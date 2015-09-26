package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.DepartmentDto;
import org.springframework.stereotype.Component;

/**
 * Created by never on 2015/9/20.
 */
@Component
public class DepartmentdaoImpl extends BasedaoA<DepartmentDto> {

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.DepartmentDtoMapper.deleteByPrimaryKey", id);
    }

    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(DepartmentDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.DepartmentDtoMapper.insert", record);
    }

    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(DepartmentDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.DepartmentDtoMapper.insertSelective", record);
    }

    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public DepartmentDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.DepartmentDtoMapper.selectByPrimaryKey", id);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(DepartmentDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.DepartmentDtoMapper.updateByPrimaryKeySelective", record);
    }

    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(DepartmentDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.DepartmentDtoMapper.updateByPrimaryKey", record);
    }

}
