<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/22
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/register.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- 头部 end -->
<div>
    <div class="left">
        <table class="table table-bordered" style="width: 50%;margin: auto">
            <tr>
                <th>订单id</th>
                <td style="vertical-align: middle">${order.p_id}</td>
            </tr>
            <tr>
                <th>用户名:</th>
                <td style="vertical-align: middle">${order.p_nameid}</td>
            </tr>
            <tr>
                <th>度假主题:</th>
                <td style="vertical-align: middle">${order.l_Theme}</td>
            </tr>
            <tr>
                <th>目的地:</th>
                <td style="vertical-align: middle">${order.l_Destination}</td>
            </tr>

            <tr>
                <th>出发时间:</th>
                <td style="vertical-align: middle">${order.l_Data}</td>
            </tr>
            <tr>
                <th>出行方式:</th>
                <td style="vertical-align: middle">${order.l_Traffic}</td>
            </tr>
            <tr>
                <th>旅游时长:</th>
                <td style="vertical-align: middle">${order.l_TravelDays}天</td>
            </tr>
            <tr>
                <th>行程说明:</th>
                <td>${order.l_Explain}</td>
            </tr>
            <tr>
                <th>订单价格:</th>
                <td style="vertical-align: middle">${order.l_price}元</td>
            </tr>
            <tr>
                <td style="text-align: center">
                    <c:if test="${order.flag == 0}">
                        <button type="button" class="btn btn-default"><a
                                href="participation?method=pay&price=${order.l_price}&p_ID=${order.p_id}">付款</a>
                        </button>
                        <button type="button" class="btn btn-default"><a
                                href="participation?method=canceParticipation&p_ID=${order.p_id}">取消订单</a>
                        </button>
                    </c:if>

                </td>
            </tr>

        </table>
    </div>
</div>

</div>
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>
<!--导入布局js，共享header和footer-->

</body>
</html>
