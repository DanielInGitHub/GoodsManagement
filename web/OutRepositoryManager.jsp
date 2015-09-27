<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Johnny
  Date: 2015/9/26
  Time: 11:28
--%>
<html>
<head>
    <title>出库管理</title>
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
        <jsp:include page="fragments/contentTop.jsp"/>
        <div class="ctop"><a href="#">首页</a> &gt; <a href="#">入库出库管理</a> &gt; <a href="#">出库管理</a>
        </div>
        <form id="formresume" enctype="multipart/form-data" method="post">

            <div class="tum">
                <div class="contlist">
                    <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
                        <td><input type="file" name="file" value="选择出库清单文件" class="s_file_button"></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="submit" name="submit" id="button3" value="添加出库" class="s_btn"
                                   onclick="javascript:this.form.action='/OutRepository!addOutRepository'"/></td>
                        <%--显示表头标题--%>
                        <tr style="color:#000; font-size:14px; padding:10px 0;">
                            <s:iterator var="column"
                                        value="@org.goodsManagement.ResourceString.Resource@OutRepositoryHead"
                                        id="headname">
                                <td align="center" bgcolor="#fff8f8"><s:property value='headname'/></td>
                            </s:iterator>
                        </tr>
                        <%--显示表内容--%>
                        <s:iterator value="list" var="column">
                            <tr style="color:#000; font-size:14px; padding:10px 0;">
                                <td align="center" bgcolor="#fff8f8">${outrepositoryid}</td>
                                <td align="center" bgcolor="#fff8f8">${outtime}</td>
                                <td align="center" bgcolor="#fff8f8">${goodname}</td>
                                <td align="center" bgcolor="#fff8f8">${goodtype}</td>
                                <td align="center" bgcolor="#fff8f8">${deptname}</td>
                                <td align="center" bgcolor="#fff8f8">${username}</td>
                                <td align="center" bgcolor="#fff8f8"><a
                                        href="/OutRepository!selectOutRepositoryById?outrepositoryid=${outrepositoryid}">查看详细信息</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>