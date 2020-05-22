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
            <p>青大旅行><span>新闻动态</span></p>
        </div>
        <div>
            <div class="left">
                <table class="table table-hover;table table-striped" >
                    <%--遍历数据--%>
                    <c:forEach items="${pb.data}" var="news">
                        <tr>
                            <td style="color: darkblue"><a href="news?method=findnewsById&n_ID=${news.n_ID}">${news.n_MainTitle}</a></td>
                            <td style="color: darkblue"><a href="news?method=findnewsById&n_ID=${news.n_ID}">${news.n_Datetime}</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="page_num_inf">
                    <i></i> 共
                    <span>${pb.totalPage}</span>页<span>${pb.totalCount}</span>条
                </div>
                <div class="pageNum">
                    <ul>
                        <li><a href="news?pageNumber=1&method=findAllNews">首页</a></li>
                        <c:if test="${pb.pageNumber>1}">
                            <li class="threeword"><a href="news?method=findAllNews&pageNumber=${pb.pageNumber-1}">上一页</a></li>
                        </c:if>
                        <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
                            <c:if test="${pb.pageNumber==i}">
                                <li style="background-color: yellow;"><a href="news?method=findAllNews&pageNumber=${i}">${i}</a></li>
                            </c:if>
                            <c:if test="${pb.pageNumber!=i}">
                                <li><a href="news?method=findAllNews&pageNumber=${i}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pb.pageNumber<pb.totalPage}">
                            <li class="threeword"><a href="news?method=findAllNews&pageNumber=${pb.pageNumber+1}">下一页</a></li>
                        </c:if>
                        <li class="threeword"><a href="news?method=findAllNews&pageNumber=${pb.totalPage}">末页</a></li>
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
