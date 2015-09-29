package org.fiveguns.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.fiveguns.service.impl.DeliveryServiceImpl;
import org.fiveguns.vo.OutRepositoryVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by johnny on 15-9-26.
 */
@Action("OutRepository")
@ParentPackage("struts-default")
@Namespace("/")
@Results(
        {
                @Result(name = "getAll", location = "/OutRepositoryManager.jsp"),
                @Result(name = "showMessage", location = "/OutRepositoryMessage.jsp"),
                @Result(name = "error", location = "/error.jsp"),
        })
public class OutRepositoryAction extends ActionSupport {
    @Autowired
    private DeliveryServiceImpl outRepositoryService;
    private List<OutRepositoryVO> list;
    private OutRepositoryVO outRepositoryVO;


    public String getAll() {
        list = outRepositoryService.getAllOutRepositoryVO();
        // just for debug
        for (OutRepositoryVO vo : list) {
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

    public List<OutRepositoryVO> getList() {
        return list;
    }

    public void setList(List<OutRepositoryVO> list) {
        this.list = list;
    }

    public OutRepositoryVO getOutRepositoryVO() {
        return outRepositoryVO;
    }

    public void setOutRepositoryVO(OutRepositoryVO outRepositoryVO) {
        this.outRepositoryVO = outRepositoryVO;
    }

}