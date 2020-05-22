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
            <p>青大旅行><span>项目简介</span></p>
        </div>
        <div>
            <h1 style="text-align: center;font-size: x-large;color: darkblue">项目愿景</h1>
            <br>
            <div style="padding-bottom: 15px;padding-left: 20px;padding-right: 20px;padding-top: 20px;border:2px solid darkblue;">
                <p class="lead" style="color: darkblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过现代信息化手段,建设我们独特的旅游项目储备和重大旅游项目建设的动态的新闻跟踪
                    系统,对各项目进行系统化的旅游管理与跟进.基于互联网掌握全面的旅游产业项目信息, 并通
                    过信息化工具的智能化统计分析功能辅助项目信息,并通过信息化工具的智能化统计分析功能辅
                    助项目决策,从而达到整合和争取各类旅游建设资金,建设一批有重大影响和强大支撑的大型旅游
                    项目,以项目建设促进旅游大发展,促进旅游产业大省建设.</p>
                <p class="lead" style="color: darkblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    运用计算机创建一个网络互动平台.让更多的游客登进入到我们制作的旅游板块和旅游团队
                    中.通过页面的景点展示,景点简介,度假村简介,动态新闻.让阅览者第一时间获得第一手的旅游
                    信息,和某些景点的动态新闻.让阅览者更好的选择到适合自己的旅游团队,通过旅游团队的活动
                    时间,让自己能更好的安排自己的业余时间,让人们更能积极的参加我们的旅游团.
                </p>
                <img src="images/qingda.png" width="100%">
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
