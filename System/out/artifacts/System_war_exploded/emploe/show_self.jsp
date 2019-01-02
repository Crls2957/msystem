<%@ page language="java" import="java.util.*,entity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
    <title>员工详细信息</title>
    <style type="text/css">
        .STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
        .STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; color:blue; font-size: 25px }
        .STYLE3 { font-family: "宋体"; font-size: 16px;color: green}
    </style>
    <script>
        function showReq(){
            window.location.href="/System_war_exploded/ShowNewsTable";
        }
    </script>
</head>
<body bgcolor="#6CA6CD">
<center>
    <table width="900" border="0" style="border: solid gray 1pt solid;">
        <%
            Emploe emploe=(Emploe) request.getSession().getAttribute("emploe");
        %>
        <tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
        <tr>
            <td height="29" bgcolor="#6C7B8B" align="right" width="58%">
                <span class="STYLE2">详细信息</span>
            </td>
            <td height="29" bgcolor="#6C7B8B" align="right">
                <input type="button" value="查看留言消息" class="STYLE3" onclick="showReq()"/>
                <span class="STYLE1">当前用户：<%=emploe.getEname()%></span>
                <input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
            </td>
        </tr>
        <tr>
            <td height="254" align="center" colspan="2"><br><br>
                <table width="70%" height="100%" border="0" style="background-image: url(../images/formbj2.jpg)">
                    <tr>
                        <td width="20%" align="right">
                            员工编号：
                        </td>
                        <td width="25%" align="center">
                            <%=emploe.getEid()%>
                        </td>
                        <td width="55%" rowspan="8" align="center" >
                            <a href="showImage.jsp">更改图像</a><br>
                            <img src="<%=emploe.getEphoto()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" align="right">
                            姓名：
                        </td>
                        <td width="25%" align="center">
                            <%=emploe.getEname()%>
                        </td>
                    </tr>
                    <tr height="10%">
                        <td width="20%" align="right">
                            薪资待遇：
                        </td>
                        <td width="25%" align="center">
                            <%=emploe.getEsalary()%>
                        </td>
                    </tr>
                    <tr height="10%">
                        <td align="right">
                            性别：
                        </td>
                        <td align="center">
                            <%=emploe.getEsex()%>
                        </td>
                    </tr>
                    <tr height="10%">
                        <td align="right">
                            生日：
                        </td>
                        <td align="center">
                            <%=emploe.getEbir()%>
                        </td>
                    </tr>
                    <tr height="10%" >
                        <td align="right">
                            婚否：
                        </td>
                        <td align="center">
                            <%=emploe.getEmarry()%>
                        </td>
                    </tr>
                    <tr height="10%">
                        <td  align="right">
                            学历：
                        </td>
                        <td align="center">
                            <%=emploe.getEedu()%>
                        </td>
                    </tr>
                    <tr height="10%" >
                        <td align="right">
                            部门编号：
                        </td>
                        <td align="center">
                            <%=emploe.getDid()%>
                        </td>
                    </tr>
                    <tr height="10%" >
                        <td align="right">
                            职位编号：
                        </td>
                        <td align="center">
                            <%=emploe.getPid()%>
                        </td>
                    </tr>
                    <tr height="10%" >
                        <td align="right">
                            电话号码：
                        </td>
                        <td align="center">
                            <%=emploe.getEphone()%>
                        </td>
                    </tr>
                    <tr height="10%" >
                        <td align="right">
                            家庭地址：
                        </td>
                        <td align="center">
                            <%=emploe.getEaddr()%>
                        </td>
                    </tr>
                    <tr height="10%" >
                        <td></td>
                        <td align="center" >
                            <a href="/System_war_exploded/LoadDate?eid=<%=emploe.getEid()%>">更改资料</a>
                        </td>
                        <td align="left">
                            <a href="/System_war_exploded/emploe/password_update.jsp">更改密码</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="76" colspan="2">
                <br><br><br>
                <%@ include file="../tail.jsp"%>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
