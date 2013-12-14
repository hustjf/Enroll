<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
  <head>
    <title>选课登陆</title>
      <script type="text/javascript">
          function checkingIsNull(){
              var username = document.getElementById("un").value;
              var password = document.getElementById("pw").value;
              if(username.trim().length == 0||password.trim().length == 0){
              alert("用户名密码不能为空！");
              }
              else {
                  document.login.submit();
              }
          }
      </script>
  </head>
  <body>
<form name="login" method="post" action="/login.do">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="un"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="pw"/></td>
        </tr>
    </table>
    <center><input type="submit" value="登陆" onclick="checkingIsNull();return false"/></center>
</form>
  </body>
</html>
