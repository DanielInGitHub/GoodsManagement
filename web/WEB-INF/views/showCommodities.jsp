<%@ page import="org.fiveguns.resourcestring.ColumnName" %>
<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/9/28
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>人员领用明细管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="综合业务管理系统">
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="cont left">
    <div class="content">
        <jsp:include page="../../fragments/contentTop.jsp"/>
        <div class="ctop"><a href="#">首页</a> &gt; <a href="#">人员领用明细管理</a> &gt; <a href="#">人员领用明细管理</a>
        </div>
        <form id="myform" method="post">
            <div class="tum">
                <div class="contlist">
                    <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
                        <%--显示表头标题--%>
                        <tr style="color:#000; font-size:14px; padding:10px 0;">
                            <c:forEach var="column" items="<%=ColumnName.COMMODITY_HEAD%>">
                                <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
                            </c:forEach>
                        </tr>
                        <%--显示表内容--%>
                        <c:forEach var="dto" items="${list}">
                            <tr style="color:#000; font-size:14px; padding:10px 0;">
                                <td align="center" bgcolor="#fff8f8"><c:out value="${dto.id}"/></td>
                                <td align="center" bgcolor="#fff8f8"><c:out value="${dto.name}"/></td>
                                <td align="center" bgcolor="#fff8f8"><c:out value="${dto.unit}"/></td>
                                <td align="center" bgcolor="#fff8f8"><c:out value="${dto.number}"/></td>
                                <td align="center" bgcolor="#fff8f8"><c:out value="${dto.type}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <td><input type="submit" name="submit" id="up" value="上一页" class="s_btn"
                               onclick="javascript:this.form.action='/CommodityManage!getAllCommoditiesByPage?page=${page-1}'"/>
                    </td>
                    共${total_page}页 当前第${page}页
                    <td><input type="submit" name="submit" id="down" value="下一页" class="s_btn"
                               onclick="javascript:this.form.action='/CommodityManage!getAllCommoditiesByPage?page=${page+1}'"/>
                    </td>
                </div>

            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
