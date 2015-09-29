package org.fiveguns.dao.impl;

import com.github.pagehelper.PageHelper;
import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.StaffDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */

@Component
public class StaffDaoImpl extends BasedaoA<StaffDto> {
    /**
     * 通过主键获取实体
     *
     * @param id
     * @return
     */
    @Override
    public StaffDto selectByPrimaryKey(Integer id) {
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
    public int insert(StaffDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.StaffDtoMapper.insert", record);
    }

    /**
     * 插入记录，必须指定非空的字段，但是其他字段可选
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(StaffDto record) {
        return sessionTemplate.insert("org.fiveguns.mapper.StaffDtoMapper.insertSelective", record);
    }

    /**
     * 更新实体类，不需要指定所有的键
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(StaffDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.StaffDtoMapper.updateByPrimaryKeySelective", record);
    }

    /**
     * 通过主键来更新实体类
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(StaffDto record) {
        return sessionTemplate.update("org.fiveguns.mapper.StaffDtoMapper.updateByPrimaryKey", record);
    }

    /**
     * 通过所有的实体
     *
     * @return 所有实体的回合
     */
    public List<StaffDto> selectAll() {
        return sessionTemplate.selectList("org.fiveguns.mapper.StaffDtoMapper.selectAll");
    }

    /**
     * 获得所有的实体类，加入分页支持
     *
     * @param page      想要获取的页码
     * @param rowCounts 一页的数量
     * @return
     */
    @Override
    public List<StaffDto> selectAllByPage(int page, int rowCounts) {
        PageHelper.startPage(page, rowCounts);
        return sessionTemplate.selectList("org.fiveguns.mapper.StaffDtoMapper.selectAllByPage");
    }
}
