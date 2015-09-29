package org.fiveguns.dao.impl;

import org.fiveguns.po.CommodityDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by never on 2015/9/29.
 */
public class CommodityDaoImplTest {

    private ApplicationContext applicationContext;
    private CommodityDaoImpl commodityDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        commodityDao = (CommodityDaoImpl) applicationContext.getBean("commodityDaoImpl");
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {
        commodityDao.deleteByPrimaryKey(1);
    }

    @Test
    public void testInsert() throws Exception {
        CommodityDto commodityDto = new CommodityDto();
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
    public void testSelectAllByPage() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

    @Test
    public void testSelectByName() throws Exception {

    }

    @Test
    public void testGetEntitieskind() throws Exception {

    }

    @Test
    public void testGetWarehouseInventory() throws Exception {

    }
}