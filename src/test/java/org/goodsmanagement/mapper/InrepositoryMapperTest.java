//package org.goodsmanagement.mapper;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.fiveguns.dao.impl.StorageDaoImpl;
//import org.fiveguns.service.impl.StorageServiceImpl;
//import org.fiveguns.vo.StorageSQL;
//import org.fiveguns.vo.StorageShow;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
///**
// * Created by lifei on 2015/9/23.
// */
//public class InrepositoryMapperTest {
//    private SqlSessionFactory sqlSessionFactory;
//    private SqlSession sqlSession;
//    private ApplicationContext applicationContext;
//    @Autowired
//    @Qualifier("storageDaoImpl")
//    private StorageDaoImpl storageDaoImpl;
//
//    @Autowired
//    @Qualifier("storageServiceImpl")
//    private StorageServiceImpl storageServiceImpl;
//
//    @Before
//    public void setUp() throws Exception {
//        applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
//        storageDaoImpl = (StorageDaoImpl) applicationContext.getBean("storageDaoImpl");
//        sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
//        sqlSession = sqlSessionFactory.openSession();
//        storageServiceImpl = (StorageServiceImpl) applicationContext.getBean("storageServiceImpl");
//    }
//
//    @Test
//    public void testDeleteByPrimaryKey() throws Exception {
//
//    }
//
//    @Test
//    public void testInsert() throws Exception {
//        //测试条件查询
//        StorageSQL sql = new StorageSQL();
//        sql.setIntime("2015-09-19");
////        sql.setSuppliers("傻逼");
////        sql.setInrepositoryid("K13141");
//        int a= sqlSession.selectOne("org.fiveguns.mapper.InRepositoryDtoMapper.selectcountpage");
//        System.out.println(a);
////       List<StorageShow> list= sqlSession.selectList("org.fiveguns.mapper.InRepositoryDtoMapper.selectsql", sql);
////        System.out.println(list.size());
////        List<StorageShow> list1 = storagedaoImpl.selectsearch(sql);
////        System.out.println("通过Dao接口进行查询"+list1.size());
//        int page=1;
//        List<StorageShow> list1= sqlSession.selectList("org.fiveguns.mapper.InRepositoryDtoMapper.selectbypage",page*3);
//        System.out.println(list1.size());
//
//
//        System.out.println("共"+ storageServiceImpl.selectcountpage()+"页");
//    }
//
//}
