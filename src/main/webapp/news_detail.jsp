<%--
  Created by IntelliJ IDEA.
  User: hzb
  Date: 2018/12/22
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>青大旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<!--引入头部-->

<jsp:include page="header.jsp"></jsp:include>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <p>青大旅行><span>新闻详情</span></p>
        </div>
        <div>
                <h1 style="text-align: center;font-size: x-large;color: darkblue">${news.n_MainTitle}</h1>
            <div style="text-align: right">
                <small style="text-align: right;color: dodgerblue;text-decoration-line: underline">${news.n_Datetime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.n_Author}</small>
            </div>
            <br>
            <div style="padding-bottom: 15px;padding-left: 20px;padding-right: 20px;padding-top: 20px;border:2px solid darkblue;">
                <p class="lead" style="color: darkblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.n_Content}</p>
            </div>
        </div>
    </div>
</div>

<!--引入头部-->
<%--<div id="footer"></div>--%>
<jsp:include page="footer.jsp"></jsp:include>
<!--导入布局js，共享header和footer-->
<%--<script type="text/javascript" src="js/include.js"></script>--%>
</body>
</html>
