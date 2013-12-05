<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 13-10-10
  Time: 下午10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
    <script type="text/javascript">
        function checkingNumber(){
            var addnum = document.getElementById("addnum").value;
            var addcourse = document.getElementById("addcourse").value;
            if(addnum.trim().length==0 ||addcourse.trim().length==0){
                alert("课程编号与课程名称不能为空")
            }else {
                if(!IsNum(addnum)){
                alert("课程编号请输入数字")
                }else{
                    document.add.submit();
                }
            }
        }
        function IsNum(num){
            var reNum=/^\d*$/;
            return(reNum.test(num));
        }
    </script>
</head>
<body>
<form name="add" method="post" action="/operate.do">
<table align="center">
    <tr>
        <td>课程编号：</td>
        <td><input type="text" name="addnum" id="addnum"/></td>
    </tr>
    <tr>
        <td>课程名称：</td>
        <td><input type="text" name="addcourse" id="addcourse"/></td>
    </tr>
</table>
<center><input type="submit" value="确认添加" onclick="checkingNumber();return false"/><input type="button" value="返回课表" onclick="location.href='operate.do'"/></center>
</form>
</body>
</html>