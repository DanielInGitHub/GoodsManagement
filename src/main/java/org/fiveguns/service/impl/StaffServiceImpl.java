package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.StaffDaoImpl;
import org.fiveguns.po.StaffDto;
import org.fiveguns.service.BaseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */
@Service
public class StaffServiceImpl implements BaseServiceI<StaffDto> {

    @Autowired
    @Qualifier("staffDaoImpl")
    private StaffDaoImpl staffDao;

    /**
     * 添加实体
     *
     * @param staffDto 实体对象
     */
    public void addEntity(StaffDto staffDto) {
        staffDao.insert(staffDto);
    }

    /**
     * 修改实体
     *
     * @param staffDto 实体对象(不需指定所有的键)
     */
    public void modifyEntity(StaffDto staffDto) {
        staffDao.updateByPrimaryKey(staffDto);
    }

    /**
     * 通过ID获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public StaffDto getEntity(int id) {
        return staffDao.selectByPrimaryKey(id);
    }

    /**
     * 删除指定ID的商品
     */
    public void deleteEntity(int id) {
        staffDao.deleteByPrimaryKey(id);
    }

}
