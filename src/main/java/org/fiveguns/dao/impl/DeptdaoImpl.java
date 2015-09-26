package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.DeptDto;
import org.springframework.stereotype.Component;

/**
 * Created by never on 2015/9/20.
 */
@Component
public class DeptdaoImpl extends BasedaoA<DeptDto> {

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.DeptDtoMapper.deleteByPrimaryKey", id);
    }

    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(DeptDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.DeptDtoMapper.insert", record);
    }

    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(DeptDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.DeptDtoMapper.insertSelective", record);
    }

    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public DeptDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.DeptDtoMapper.selectByPrimaryKey", id);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(DeptDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.DeptDtoMapper.updateByPrimaryKeySelective", record);
    }

    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(DeptDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.DeptDtoMapper.updateByPrimaryKey", record);
    }

}
