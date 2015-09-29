package org.fiveguns.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.fiveguns.service.impl.StorageServiceImpl;
//import org.fiveguns.service.impl.PoiUtils.InRepositoryUtils;
//import org.fiveguns.vo.StorageGood;
//import org.fiveguns.vo.StorageSQL;
//import org.fiveguns.vo.StorageShow;
import org.fiveguns.vo.StorageGood;
import org.fiveguns.vo.StorageSQL;
import org.fiveguns.vo.StorageShow;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * Created by never on 2015/9/24.
 */

@Action("storage")
@ParentPackage("struts-default")
@Namespace("/")
@Results(
        {
                @Result(name = "getAll", location = "/WEB-INF/fragments/InrepositoryManager.jsp"),
                @Result(name = "showmessage", location = "/WEB-INF/fragments/InrepositoryMessage.jsp"),
        })
public class StorageAction extends ActionSupport {

    @Autowired
    private StorageServiceImpl storageServiceImpl;

    private File file;
    private String inrepositoryid;
    private String intime;
    private String suppliers;

    private List<StorageGood> listGoods;
    private StorageShow storageShow;
    private List<StorageShow> list;
    private int countpage;


//    @Autowired
//    private InRepositoryUtils inRepositoryUtils;

    public String getAll() {
        list = storageServiceImpl.selectByGroup();
        countpage = storageServiceImpl.selectcountpage();
        System.out.println(countpage);
        System.out.println("拿到所有信息的方法");
        return "getAll";
    }

    /**
     * 条件查询
     */
    public String selectbysearch() {
        StorageSQL sql = new StorageSQL();
        if(intime != null && intime.equals("")==false){
            String s = intime;
            sql.setIntime(s);
            System.out.println(intime+"+++++++++++++++++++++++++++++++++");
        }

        if(suppliers != null && suppliers.equals("")==false){
            String ss = suppliers;
            sql.setSuppliers(ss);
            System.out.println(suppliers+"+++++++++++++++++++++++++++++++++");
        }

        if(inrepositoryid != null && inrepositoryid.equals("")==false){
            String sss = inrepositoryid;
            sql.setInrepositoryid(sss);
            System.out.println(inrepositoryid+"+++++++++++++++++++++++++++++++++");
        }
//        StorageSQL sql = new StorageSQL();
//        sql.setIntime("2015-09-19");
//        sql.setSuppliers("傻逼");
        list = storageServiceImpl.selectbysearch(sql);
        System.out.println(sql.getIntime());
        System.out.println(list.size());
        return "getAll";
    }

    /**
     *    查询对应的入库信息
     * @return
     */
    public String selectInrepositoryGoods(){
        System.out.println(inrepositoryid);
        listGoods = storageServiceImpl.selectallingood(inrepositoryid);
        storageShow = storageServiceImpl.selectmesInprositoryId(inrepositoryid);
        System.out.println(listGoods.size());
        return "showmessage";
    }

    /**
     *    通过Excel对订单进行入库
     * @return
     */
//    public String addInrepository(){
//        System.out.println("开始进行入库");
//        String filename = file.getPath();
//        System.out.println(filename);
//        String inid = inRepositoryUtils.addPoiUtils(filename);
//        System.out.println("添加入库成功"+inid);
//        this.setInrepositoryid(inid);
//        return this.selectInrepositoryGoods();
//    }

}
