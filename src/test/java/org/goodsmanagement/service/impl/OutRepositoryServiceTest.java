package org.goodsmanagement.service.impl;

import org.fiveguns.service.impl.DeliveryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by johnny on 15-9-23.
 */
public class OutRepositoryServiceTest {
    private ApplicationContext applicationContext;
    private DeliveryServiceImpl outRepositoryService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        outRepositoryService = (DeliveryServiceImpl) applicationContext.getBean("deliveryServiceImpl");
    }

    @Test
    public void getGoodsById() {
//        OutRepositoryDto vo = outRepositoryService.getEntity(1);
//        System.out.println(vo);
    }

    @Test
    public void getAllInfo() {
//        List<DeliveryVo> vo = outRepositoryService.getAllOutRepositoryVO();
//        System.out.println(vo);
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

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
}
