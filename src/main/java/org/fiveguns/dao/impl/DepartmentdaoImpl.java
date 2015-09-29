package org.fiveguns.dao.impl;

import com.github.pagehelper.PageHelper;
import org.fiveguns.dao.BasedaoA;
import org.fiveguns.po.DepartmentDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/9/20.
 */
@Component
public class DepartmentDaoImpl extends BasedaoA<DepartmentDto> {

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

    /**
     * 获得所有的实体类，加入分页支持
     *
     * @param page      想要获取的页码
     * @param rowCounts 一页的数量
     * @return
     */
    @Override
    public List<DepartmentDto> selectAllByPage(int page, int rowCounts) {
        PageHelper.startPage(page, rowCounts);
        return sessionTemplate.selectList("org.fiveguns.mapper.CommodityDtoMapper.selectAllByPage");
    }
}
