package org.goodsmanagement.dao.impl;

import org.fiveguns.dao.impl.DepartmentdaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by never on 2015/9/20.
 */
public class DepartmentdaoImplTest {

    private ApplicationContext applicationContext;
    private DepartmentdaoImpl deptdao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        deptdao = (DepartmentdaoImpl) applicationContext.getBean("deptdaoImpl");
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
//        DeptDto deptDto = new DeptDto();
//        deptDto.setDeptname("测试");
//        deptdao.insert(deptDto);
//         deptdao.selectByPrimaryKey(1);
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
}