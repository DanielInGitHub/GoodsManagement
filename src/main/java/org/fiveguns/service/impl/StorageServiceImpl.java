package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.StorageDaoImpl;
import org.fiveguns.po.StorageDto;
import org.fiveguns.service.BaseServiceI;
import org.fiveguns.service.impl.PoiUtils.InRepositoryUtils;
import org.fiveguns.vo.InrepositoryGood;
import org.fiveguns.vo.InrepositoryShow;
import org.fiveguns.vo.Inrepositorysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements BaseServiceI<StorageDto> {

    @Autowired
    @Qualifier("storageDaoImpl")
    private StorageDaoImpl storageDaoImpl;

    @Autowired
    @Qualifier("inRepositoryUtils")
    private InRepositoryUtils inRepositoryUtils;

    private int pagecount;

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public void addEntity(StorageDto StorageDto) {
        storageDaoImpl.insert(StorageDto);
    }

    public void modifyEntity(StorageDto StorageDto) {
        storageDaoImpl.updateByPrimaryKey(StorageDto);
    }

    public StorageDto loadEntity(int id) {
        return null;
    }

    public StorageDto getEntity(int id) {
        return storageDaoImpl.selectByPrimaryKey(id);
    }

    public List<StorageDto> getAllEntities() {
        return null;
    }

    public void deleteEntity(StorageDto StorageDto) {
        storageDaoImpl.deleteByPrimaryKey(StorageDto.getId());
    }

    /**
     * 产品入库
     */
    public void addinRepositoryD(String filename) {
        inRepositoryUtils.addPoiUtils(filename);
    }

    /**
     * 查看所有的入库信息
     */
    public List<InrepositoryShow> selectallmes() {
        return storageDaoImpl.selectall();
    }

    /**
     * 条件查询
     */
    public List<InrepositoryShow> selectbysearch(Inrepositorysql sql) {
        System.out.println(sql.getIntime());
        return storageDaoImpl.selectsearch(sql);
    }
    /**
     * 按照入库单号查询所有入库的货物，入库数量，以及详细的入库单信息，在另一个jsp页面显示时调用
     */
    public List<InrepositoryGood> selectallingood(String inrepositoryid){
        return  storageDaoImpl.selectallingood(inrepositoryid);
    }

    /**
     * 查询一张入库单的基本信息
     *
     * @return
     */
    public InrepositoryShow selectmesInprositoryId(String inprositoryId) {
        return  storageDaoImpl.selectmesInprositoryId(inprositoryId);
    }


    /**
     * 统计有多少页
     *
     * @return
     */
    public int selectcountpage() {
        int pagesize = 3;
        int count = storageDaoImpl.selectcount();
        if(count%pagesize!=0){

            pagecount = (count/pagesize)+1;
        }else{
            pagecount = count/pagesize;
        }
        return pagecount;
    }

    /**
     * 根据页码查询记录
     *
     * @return
     */
    public List<InrepositoryShow> selectbypage(int page) {
        return  storageDaoImpl.selectbypage(page);
    }
}
