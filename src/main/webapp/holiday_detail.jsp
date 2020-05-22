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
            <p>青大旅行><span>度假主题</span></p>
        </div>
        <div>
            <div class="left">
                <table class="table table-bordered" style="width: 50%;margin: auto">
                    <tr>
                        <th>度假主题:</th>
                        <td style="vertical-align: middle">${holiday.l_Theme}</td>
                    </tr>
                    <tr>
                        <th>目的地:</th>
                        <td style="vertical-align: middle">${holiday.l_Destination}</td>
                    </tr>
                    <tr>
                        <th>常规价:</th>
                        <td style="vertical-align: middle">${holiday.l_RetailPrice}元</td>
                    </tr>
                    <tr>
                        <th>儿童价:</th>
                        <td style="vertical-align: middle">${holiday.l_ChildPrice}元</td>
                    </tr>
                    <tr>
                        <th>学生价:</th>
                        <td style="vertical-align: middle">${holiday.l_StudentPrice}元</td>
                    </tr>
                    <tr>
                        <th>出发时间:</th>
                        <td style="vertical-align: middle">${holiday.l_Data}</td>
                    </tr>
                    <tr>
                        <th>出行方式:</th>
                        <td style="vertical-align: middle">${holiday.l_Traffic}</td>
                    </tr>
                    <tr>
                        <th>旅游时长:</th>
                        <td style="vertical-align: middle">${holiday.l_TravelDays}天</td>
                    </tr>
                    <tr>
                        <th>行程说明:</th>
                        <td>${holiday.l_Explain}</td>
                    </tr>
                    <tr>
                        <td style="text-align: center" colspan="2">
                            <button type="button" class="btn btn-default"><a
                                    href="participation?method=join&l_Theme=${holiday.l_ID}&u_Name=${user.u_Name}">我要参加</a>
                            </button>
                            <a class="btn" id="favorite" onclick="addFavorite('${holiday.l_ID}','${user.u_ID}')"
                               title="${flag}"><i
                                    class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>
                        </td>

                    </tr>
                </table>
                <br>
            </div>
        </div>
    </div>
</div>

<!--引入头部-->
<%--<div id="footer"></div>--%>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<!--导入布局js，共享header和footer-->
<%--<script type="text/javascript" src="js/include.js"></script>--%>

<script>
    if ($("#favorite").attr("title") === '1') {
        //不可点击
        $(".collect a").prop("disabled", true);//置灰
        $("#favorite").text("取消收藏");
    } else {
        $(".collect a").addClass("already");
    }
    var addFavorite = function (l_id, u_id) {
        if ($("#favorite").attr("title") === '1') {
            $.post("participation?method=canFavorite", {"l_id": l_id, "u_id": u_id}, function (res) {
                alert(res)
                if (res === 'success') {
                    alert(111)
                    $(".collect a").addClass("already");
                } else {
                    alert('取消失败')
                }
            })
        } else {
            $.post("participation?method=addFavorite", {"l_id": l_id, "u_id": u_id}, function (res) {
                if (res === 'success') {
                    $(".collect a").prop("disabled", true);//置灰
                    $("#favorite").text("取消收藏");
                } else {
                    alert('收藏失败')
                }
            })

        }
    }
</script>
</body>
</html>
