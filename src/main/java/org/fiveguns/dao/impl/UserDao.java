package org.fiveguns.dao.impl;

import org.fiveguns.dao.BasedaoA;
import org.fiveguns.poo.UserDto;
import org.springframework.stereotype.Component;

/**
 * Created by lifei on 2015/9/20.
 */
@Component
public class UserDao extends BasedaoA<UserDto> {
    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public UserDto selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne("org.fiveguns.mapper.StaffDtoMapper.selectByPrimaryKey", id);
    }

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete("org.fiveguns.mapper.StaffDtoMapper.deleteByPrimaryKey", id);
    }

    /**
     * 插入记录，必须指定所有的字段
     *
     * @param record
     * @return
     */
    @Override
    public int insert(UserDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.StaffDtoMapper.insert", record);
    }

    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(UserDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.StaffDtoMapper.insertSelective", record);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(UserDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.StaffDtoMapper.updateByPrimaryKeySelective", record);
    }

    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(UserDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.StaffDtoMapper.updateByPrimaryKey", record);
    }
}
