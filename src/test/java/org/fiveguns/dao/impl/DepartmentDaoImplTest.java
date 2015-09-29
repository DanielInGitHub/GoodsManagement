package org.fiveguns.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by never on 2015/9/29.
 */
public class DepartmentDaoImplTest {

    private ApplicationContext applicationContext;
    private DepartmentDaoImpl departmentDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        departmentDao = (DepartmentDaoImpl) applicationContext.getBean("departmentDaoImpl");
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {
        departmentDao.deleteByPrimaryKey(1);
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

    @Test
    public void testSelectAllByPage() throws Exception {

    }
}