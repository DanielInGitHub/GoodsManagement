package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.DepartmentDaoImpl;
import org.fiveguns.po.DepartmentDto;
import org.fiveguns.service.BaseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by admin on 2015/9/20.
 */
public class DepartmentServiceImpl implements BaseServiceI<DepartmentDto> {

    @Autowired
    @Qualifier("deptDao")
    private DepartmentDaoImpl deptdao;

    public void addEntity(DepartmentDto DepartmentDto) {
        deptdao.insert(DepartmentDto);
    }

    public void modifyEntity(DepartmentDto DepartmentDto) {
        deptdao.updateByPrimaryKeySelective(DepartmentDto);
    }

    public DepartmentDto loadEntity(int id) {
        return null;
    }

    public DepartmentDto getEntity(int id) {
        return deptdao.selectByPrimaryKey(id);
    }

    public List<DepartmentDto> getAllEntities() {
        return null;
    }

    public void deleteEntity(DepartmentDto DepartmentDto) {
        deptdao.deleteByPrimaryKey(DepartmentDto.getId());
    }
}

