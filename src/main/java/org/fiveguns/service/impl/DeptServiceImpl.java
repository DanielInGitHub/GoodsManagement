package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.DepartmentdaoImpl;
import org.fiveguns.poo.DeptDto;
import org.fiveguns.service.BaseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by admin on 2015/9/20.
 */
public class DeptServiceImpl implements BaseServiceI<DeptDto> {

    @Autowired
    @Qualifier("deptDao")
    private DepartmentdaoImpl deptdao;

    public void addEntity(DeptDto deptDto) {
        deptdao.insert(deptDto);
    }

    public void modifyEntity(DeptDto deptDto) {
        deptdao.updateByPrimaryKeySelective(deptDto);
    }

    public DeptDto loadEntity(int id) {
        return null;
    }

    public DeptDto getEntity(int id) {
        return deptdao.selectByPrimaryKey(id);
    }

    public List<DeptDto> getAllEntities() {
        return null;
    }

    public void deleteEntity(DeptDto deptDto) {
        deptdao.deleteByPrimaryKey(deptDto.getId());
    }
}

