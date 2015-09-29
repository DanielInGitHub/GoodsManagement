//package org.fiveguns.dao.impl;
//
//import com.github.pagehelper.PageHelper;
//import org.fiveguns.dao.BasedaoA;
//import org.fiveguns.po.StorageDto;
//import org.fiveguns.vo.StorageGood;
//import org.fiveguns.vo.StorageShow;
//import org.fiveguns.vo.StorageSQL;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * Created by lifei on 2015/9/20.
// */
//@Component
//public class StorageDaoImpl extends BasedaoA<StorageDto> {
//    private int pagesize = 3;
//
//    public int getPagesize() {
//        return pagesize;
//    }
//
//    public void setPagesize(int pagesize) {
//        this.pagesize = pagesize;
//    }
//
//    /**
//     * 通过主键获取实体
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public StorageDto selectByPrimaryKey(Integer id) {
//        return sessionTemplate.selectOne("org.fiveguns.mapper.StorageDtoMapper.selectByPrimaryKey", id);
//    }
//
//    /**
//     * 通过主键删除
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public int deleteByPrimaryKey(Integer id) {
//        return sessionTemplate.delete("org.fiveguns.mapper.StorageDtoMapper.deleteByPrimaryKey", id);
//    }
//
//    /**
//     * 插入记录，必须指定所有的字段
//     *
//     * @param record
//     * @return
//     */
//    @Override
//    public int insert(StorageDto record) {
//        return sessionTemplate.insert("org.fiveguns.mapper.StorageDtoMapper.insert", record);
//    }
//
//    /**
//     * 插入记录，必须指定非空的字段，但是其他字段可选
//     *
//     * @param record
//     * @return
//     */
//    @Override
//    public int insertSelective(StorageDto record) {
//        return sessionTemplate.insert("org.fiveguns.mapper.StorageDtoMapper.insertSelective", record);
//    }
//
//    /**
//     * 更新实体类，不需要指定所有的键
//     *
//     * @param record
//     * @return
//     */
//    @Override
//    public int updateByPrimaryKeySelective(StorageDto record) {
//        return sessionTemplate.update("org.fiveguns.mapper.StorageDtoMapper.updateByPrimaryKeySelective", record);
//    }
//
//    /**
//     * 通过主键来更新实体类
//     *
//     * @param record
//     * @return
//     */
//    @Override
//    public int updateByPrimaryKey(StorageDto record) {
//        return sessionTemplate.update("org.fiveguns.mapper.StorageDtoMapper.updateByPrimaryKey", record);
//    }
//
//
//    /**
//     * 获取入库的表中所有的信息
//     *
//     * @return
//     */
//    public List<StorageShow> selectByGroup() {
//        return sessionTemplate.selectList("org.fiveguns.mapper.StorageDtoMapper.selectByGroup");
//    }
//
//    /**
//     * 条件查询
//     *
//     * @param sql Inrepositorysql类型的对象，保存需要查询的信息
//     * @return
//     */
//    public List<StorageShow> selectsearch(StorageSQL sql) {
//        System.out.println(sql.getIntime() + "=======");
//        System.out.println(sql.getSuppliers() + "=======");
//        System.out.println(sql.getInrepositoryid() + "=======");
//        List<StorageShow> list = sessionTemplate.selectList("org.fiveguns.mapper.StorageDtoMapper.selectsql", sql);
//        System.out.println("Dao层中执行了方法" + list.size());
//        return sessionTemplate.selectList("org.fiveguns.mapper.StorageDtoMapper.selectsql", sql);
//    }
//
//    /**
//     * 查询入库单下所有入库的物品
//     *
//     * @return
//     */
//    public List<StorageGood> selectallingood(String inrepositoryid) {
//        return sessionTemplate.selectList("org.fiveguns.mapper.StorageDtoMapper.selectingood", inrepositoryid);
//    }
//
//    /**
//     * 查询一张入库单的基本信息
//     *
//     * @return
//     */
//    public StorageShow selectmesInprositoryId(String inprositoryId) {
//        return sessionTemplate.selectOne("org.fiveguns.mapper.StorageDtoMapper.selectmesInprositoryId", inprositoryId);
//    }
//
//    /**
//     * 分页查询
//     *
//     * @return
//     */
//    public List<StorageShow> selectbypage(int page) {
//        return sessionTemplate.selectList("org.fiveguns.mapper.StorageDtoMapper.selectbypage", page * pagesize);
//    }
//
//    /**
//     * 统计有多少条入库单记录
//     *
//     * @return
//     */
//    public int selectCounts() {
//        return sessionTemplate.selectOne("org.fiveguns.mapper.StorageDtoMapper.selectCounts");
//    }
//
//    /**
//     * 获得所有的实体类，加入分页支持
//     *
//     * @param page      想要获取的页码
//     * @param rowCounts 一页的数量
//     * @return
//     */
//    @Override
//    public List<StorageDto> selectAllByPage(int page, int rowCounts) {
//        PageHelper.startPage(page, rowCounts);
//        return sessionTemplate.selectList("org.fiveguns.mapper.CommodityDtoMapper.selectAllByPage");
//    }
//}
