<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 13-10-11
  Time: 上午1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="JavaBean.CourseInfo" %>
<%@ page import="JavaBean.UserInfo" %>
<%@taglib prefix="s" uri="WEB-INF/tld/taglib.tld" %>
<html>
<head>
    <title>课程表</title>
    <script type="text/javascript">
        function checkingDelete(){
            var select = document.getElementsByName("checkdelete");
            var sum = 0;
            for(var i=0;i<select.length;i++){
                if(select[i].checked==true){
                    sum++;
                    break;
                }
            }
            if(sum==0){
                alert("请选择要删除的课程")
            }else{
                document.delete.submit();
            }
        }
    </script>
</head>
<body>
<%--<jsp:useBean id="courseinfo" scope="request" class="JavaBean.CourseInfo"/>--%>
<%--<jsp:useBean id="userinfo" scope="session" class="JavaBean.UserInfo"/>--%>
<%
    UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
    CourseInfo courseinfo = (CourseInfo) request.getAttribute("courseinfo");
    pageContext.setAttribute("userinfo",userinfo);
%>
<form name="delete" method="post" action="/operate.do">
    <s:setcolor color="GREEN">
    ${userinfo.username}的课表<br/>
    </s:setcolor>
    <table cellpadding='0' cellspacing='0' align='center' border='1' bordercolor='blue' width='80%'>
        <tr>
            <td></td><td>课程编号</td><td>课程名</td>
        </tr>
        <%
            for (int i=0;i<courseinfo.getCoursename().size();i++){
        %>
        <tr>
            <td><input type="checkbox" name="checkdelete" id="check" value="<%=courseinfo.getCoursename().get(i)%>"/></td>
            <td><%=courseinfo.getCoursenumber().get(i)%></td>
            <td><%=courseinfo.getCoursename().get(i)%></td>
        </tr>
        <%
            }
        %>
    </table>
    <center><input type="button" value="添加课程" onclick="location.href='addcourse.jsp'"/><input type="submit" value="删除所选课程" onclick="checkingDelete();return false"/></center>
</form>
</body>
</html>