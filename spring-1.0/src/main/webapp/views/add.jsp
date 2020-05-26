<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%

String path = "";
%>
<html>
<head>
    <title>zhouliqiong</title>
</head>
<body>
<form method="post" action="/addUser">
    <p><span>姓名：</span><input type="text" name="username"/></p>
    <p><span>密码：</span><input type="password" name="password"/></p>
    <p><span>生日：</span><input type="text" name="birthday"/></p>
    <p><span>性别：</span><input type="radio" name="gender" value="1"/>男<input type="radio" name="gender" value="2"/>女</p>
    <p><input type="submit" value="提交"/></p>
</form>

</body>
<script>


</script>
</html>
