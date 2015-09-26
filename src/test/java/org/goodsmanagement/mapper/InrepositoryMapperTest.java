package org.goodsmanagement.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fiveguns.dao.impl.StoragedaoImpl;
import org.fiveguns.service.impl.InRepositoryServiceImpl;
import org.fiveguns.vo.InrepositoryShow;
import org.fiveguns.vo.Inrepositorysql;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lifei on 2015/9/23.
 */
public class InrepositoryMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private ApplicationContext applicationContext;
    @Autowired
    @Qualifier("storagedaoImpl")
    private StoragedaoImpl storagedaoImpl;

    @Autowired
    @Qualifier("inRepositoryServiceImpl")
    private InRepositoryServiceImpl inRepositoryServiceImpl;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        storagedaoImpl = (StoragedaoImpl) applicationContext.getBean("storagedaoImpl");
        sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        sqlSession = sqlSessionFactory.openSession();
        inRepositoryServiceImpl = (InRepositoryServiceImpl) applicationContext.getBean("inRepositoryServiceImpl");
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        //测试条件查询
        Inrepositorysql sql = new Inrepositorysql();
        sql.setIntime("2015-09-19");
//        sql.setSuppliers("傻逼");
//        sql.setInrepositoryid("K13141");
        int a= sqlSession.selectOne("org.fiveguns.mapper.InRepositoryDtoMapper.selectcountpage");
        System.out.println(a);
//       List<InrepositoryShow> list= sqlSession.selectList("org.fiveguns.mapper.InRepositoryDtoMapper.selectsql", sql);
//        System.out.println(list.size());
//        List<InrepositoryShow> list1 = storagedaoImpl.selectsearch(sql);
//        System.out.println("通过Dao接口进行查询"+list1.size());
        int page=1;
        List<InrepositoryShow> list1= sqlSession.selectList("org.fiveguns.mapper.InRepositoryDtoMapper.selectbypage",page*3);
        System.out.println(list1.size());


        System.out.println("共"+inRepositoryServiceImpl.selectcountpage()+"页");
    }

}
