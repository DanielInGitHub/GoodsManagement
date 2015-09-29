package org.fiveguns.controller;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.fiveguns.po.CommodityDto;
import org.fiveguns.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by never on 2015/9/29.
 */
@Action("CommodityManage")
@ParentPackage("struts-default")
@Namespace("/")
@Results(
        {
                @Result(name = "success", location = "/WEB-INF/views/showCommodities.jsp"),
        })
public class CommodityManageAction {

    @Autowired
    private CommodityServiceImpl commodityService;

    private final static int NUM_PER_PAGE = 5;

    public String getAllCommoditiesByPage() {

        HttpServletRequest request = ServletActionContext.getRequest();
        int page = 1;
        String tmp = request.getParameter("page");
        if (tmp == null || "".equals(tmp))
            page = 1;
        else page = Integer.parseInt(tmp);
//        System.out.println(page);
        int counts = commodityService.getCounts();
        int total_page = counts / NUM_PER_PAGE;
        if (total_page == 0)
            total_page = 1;
        if (total_page < page || page <= 0)
            page = 1;

        List<CommodityDto> commodityDtos = commodityService.getAllCommoditiesByPage(page, 5);
        request.setAttribute("list", commodityDtos);
        request.setAttribute("total_page", total_page);
        request.setAttribute("page", page);

        return "success";
    }

//    private class CurrentPage<T> {
//        private int current;
//        private List<T> list;
//        private int total_page;
//    }
}
