package org.fiveguns.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.fiveguns.service.impl.DeliveryServiceImpl;
import org.fiveguns.vo.DeliveryVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by johnny on 15-9-26.
 */
@Action("delivery")
@ParentPackage("struts-default")
@Namespace("/")
@Results(
        {
                @Result(name = "getAll", location = "/WEB-INF/fragments/OutRepositoryManager.jsp"),
                @Result(name = "showMessage", location = "/OutRepositoryMessage.jsp"),
                @Result(name = "error", location = "/error.jsp"),
        })
public class DeliveryAction extends ActionSupport {

    @Autowired
    private DeliveryServiceImpl outRepositoryService;
    private List<DeliveryVo> list;
    private DeliveryVo outRepositoryVO;


    public String getAll() {
        list = outRepositoryService.getAllDeliveryVo();
        // just for debug
        for (DeliveryVo vo : list) {
            System.out.println(vo);
        }
        return "getAll";
    }

    public DeliveryServiceImpl getOutRepositoryService() {
        return outRepositoryService;
    }

    public void setOutRepositoryService(DeliveryServiceImpl outRepositoryService) {
        this.outRepositoryService = outRepositoryService;
    }

    public List<DeliveryVo> getList() {
        return list;
    }

    public void setList(List<DeliveryVo> list) {
        this.list = list;
    }

    public DeliveryVo getOutRepositoryVO() {
        return outRepositoryVO;
    }

    public void setOutRepositoryVO(DeliveryVo outRepositoryVO) {
        this.outRepositoryVO = outRepositoryVO;
    }

}
