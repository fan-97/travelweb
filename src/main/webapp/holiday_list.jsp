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
            <p>青大旅行><span>度假主题</span></p>
        </div>
        <div>
            <div class="left">
                <c:forEach items="${pb.data}" var="holiday">
                    <table class="table table-bordered">
                        <tr>
                            <th>度假主题:</th>
                            <td>${holiday.l_Theme}</td>
                        </tr>
                        <tr>
                            <th>目的地:</th>
                            <td>${holiday.l_Destination}</td>
                        </tr>
                        <tr>
                            <th>出发时间:</th>
                            <td>${holiday.l_Data}</td>
                        </tr>
                        <tr>
                            <th>行程说明:</th>
                            <td>${holiday.l_Explain}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center" colspan="2">
                            <button type="button" class="btn btn-default"><a href="holiday?method=findDetailholiday&l_ID=${holiday.l_ID}">查看详情</a></button>
                            </td>
                        </tr>
                    </table>
                    <br>
                </c:forEach>
                <div class="pageNum">
                    <ul>
                        <li><a href="holiday?pageNumber=1&method=findAllscenery">首页</a></li>
                        <c:if test="${pb.pageNumber>1}">
                            <li class="threeword"><a href="holiday?method=findAllholiday&pageNumber=${pb.pageNumber-1}">上一页</a></li>
                        </c:if>
                        <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
                            <c:if test="${pb.pageNumber==i}">
                                <li style="background-color: yellow;"><a href="holiday?method=findAllholiday&pageNumber=${i}">${i}</a></li>
                            </c:if>
                            <c:if test="${pb.pageNumber!=i}">
                                <li><a href="holiday?method=findAllholiday&pageNumber=${i}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pb.pageNumber<pb.totalPage}">
                            <li class="threeword"><a href="holiday?method=findAllholiday&pageNumber=${pb.pageNumber+1}">下一页</a></li>
                        </c:if>
                        <li class="threeword"><a href="holiday?method=findAllholiday&pageNumber=${pb.totalPage}">末页</a></li>
                    </ul>
                </div>
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
