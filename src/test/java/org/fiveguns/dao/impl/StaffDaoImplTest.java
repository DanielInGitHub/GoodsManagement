package org.fiveguns.dao.impl;

import org.fiveguns.po.StaffDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by never on 2015/9/29.
 */
public class StaffDaoImplTest {

    private ApplicationContext applicationContext;
    private StaffDaoImpl staffDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        staffDao = (StaffDaoImpl) applicationContext.getBean("staffDaoImpl");
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        StaffDto staffDto = staffDao.selectByPrimaryKey(1);
        System.out.println(staffDto);
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {
        staffDao.deleteByPrimaryKey(1);
    }

    @Test
    public void testInsert() throws Exception {
        StaffDto staffDto = new StaffDto();
        staffDto.setName("Test");
        staffDto.setDeptid(1);
        staffDto.setGender("男");
        staffDao.insert(staffDto);
    }

    @Test
    public void testInsertSelective() throws Exception {
        StaffDto staffDto = new StaffDto();
        staffDto.setName("Test");
        staffDto.setDeptid(1);
        staffDto.setGender("男");
        staffDao.insertSelective(staffDto);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        StaffDto staffDto = new StaffDto();
        staffDto.setId(5);
        staffDto.setName("Test");
        staffDto.setDeptid(1);
        staffDto.setGender("女");
        staffDao.updateByPrimaryKeySelective(staffDto);
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {
        StaffDto staffDto = new StaffDto();
        staffDto.setId(5);
        staffDto.setName("Test");
        staffDto.setDeptid(1);
        staffDto.setGender("女");
        staffDao.updateByPrimaryKey(staffDto);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<StaffDto> staffDtos = staffDao.selectAll();
        System.out.println(Arrays.toString(staffDtos.toArray()));
    }

    @Test
    public void testSelectAllByPage() throws Exception {
        List<StaffDto> staffDtos = staffDao.selectAllByPage(1, 2);
        System.out.println(Arrays.toString(staffDtos.toArray()));
    }
}