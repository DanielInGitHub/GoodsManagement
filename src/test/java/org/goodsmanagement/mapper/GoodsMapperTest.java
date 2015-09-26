package org.goodsmanagement.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fiveguns.dao.impl.StoragedaoImpl;
import org.fiveguns.service.impl.InRepositoryServiceImpl;
import org.fiveguns.vo.InrepositoryGood;
import org.fiveguns.vo.Inrepositorysql;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lifei on 2015/9/20.
 */
@Component
public class GoodsMapperTest {
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
        //测试通过名字查询到货品
//        List<GoodsDto> users =  sqlSession.selectList("org.fiveguns.mapper.GoodsDtoMapper.selectByName", "衬衫");
//        System.out.println(users.size());
//        GoodsDto good =  sqlSession.selectOne("org.fiveguns.mapper.GoodsDtoMapper.selectByPrimaryKey", 1);
//        good.setGoodnumbers(100);
//        int i = sqlSession.update("org.fiveguns.mapper.GoodsDtoMapper.updateByPrimaryKey",good);
//        InRepositoryDto in = new InRepositoryDto();
//        in.setInrepositoryid("ad1231");
//        in.setSuppliers("傻逼");
//        in.setLinkman("臭傻逼");
//        in.setOperatorid(1);
//        Date indata = null;
//        try {
//            DateFormat f = new SimpleDateFormat("yyyy/MM/dd");
//            indata = new Date(f.parse(val1[4].toString()).getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        in.setIntime(new java.util.Date());
        //将物品信息设置
//        in.setGoodid(1);
//        in.setGoodnumber(20);
//        int i = sqlSession.insert("org.fiveguns.mapper.InRepositoryDtoMapper.insert", in);
//        int i=storagedaoImpl.insert(in);
//        System.out.println(i);
//        String inrepositoryid = "k12312";
//        List<InrepositoryGood> list= sqlSession.selectList("org.fiveguns.mapper.InRepositoryDtoMapper.selectingood",inrepositoryid);
//        System.out.println(list.size());
        Inrepositorysql sql = new Inrepositorysql();
        sql.setIntime("2015-09-22");
//        sql.setSuppliers("傻逼");
//        sql.setInrepositoryid("ad1231");
        List<InrepositoryGood> list= sqlSession.selectList("org.fiveguns.mapper.InRepositoryDtoMapper.selectsql",sql);
        System.out.println(list.size());


        System.out.println("共"+inRepositoryServiceImpl.selectcountpage()+"页");
    }

}
