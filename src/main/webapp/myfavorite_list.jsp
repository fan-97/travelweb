<%--
  Created by IntelliJ IDEA.
  User: hzb
  Date: 2018/12/22
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <p>青大旅行><span>我的参加</span></p>
        </div>
        <div>
            <div class="left">
                <c:if test="${list.size ==0}">
                    <h4>您还没有任何订单，请去参团吧！</h4>
                </c:if>
                <c:if test="${list.size != 0}">
                    <c:forEach items="${list}" var="order">
                        <table class="table table-bordered">
                            <tr>
                                <th>订单id</th>
                                <th>用户名</th>
                                <th>订单价格</th>
                                <th>订单状态</th>
                                <th>操作</th>
                            </tr>
                            <tr>
                                <td style="vertical-align: middle">${order.p_id}</td>
                                <td style="vertical-align: middle">${order.p_nameid}</td>
                                <td style="vertical-align: middle">${order.price}元</td>
                                <td style="vertical-align: middle">
                                    <c:if test="${order.flag == 1}">
                                        <font color="green">已支付</font>
                                    </c:if>
                                    <c:if test="${order.flag == 0}">
                                        <font color="red">未支付</font>
                                    </c:if>
                                </td>
                                <td style="vertical-align: middle">
                                    <button type="button" class="btn btn-default">
                                        <a href="participation?method=participationDetail&p_id=${order.p_id}">订单详情</a>
                                    </button>
                                </td>
                            </tr>
                        </table>
                        <br>
                    </c:forEach>
                </c:if>
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
