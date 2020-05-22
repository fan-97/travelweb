<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/getParameter.js"></script>
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<!-- 头部 start -->
<header id="header">
    <div class="top_banner">
        <img src="images/top_banner.jpg" alt="">
    </div>

    <div class="shortcut">
        <c:if test="${empty user}">
            <!-- 未登录状态  -->
            <div class="login_out">
                <a data-toggle="modal" data-target="#loginModel">登录</a>
                <a  data-toggle="modal" data-target="#myModal">注册</a>
            </div>
        </c:if>
       <c:if test="${not empty user}">
           <!-- 登录状态  -->
           <div class="login">
               <span>欢迎回来，${user.u_Name}</span>
               <a href="participation?method=findparticipationByName&username=${user.u_Name}" class="collection">我的参加</a>
               <a href="user?method=logout">退出</a>
           </div>
     </c:if>

        <script>

        </script>
    </div>
    <div class="header_wrap">
        <div class="topbar">
            <div class="logo">
                <a href="/"><img src="images/logo.jpg" alt=""></a>
            </div>
            <div class="search">
                <input name="" type="text" placeholder="请输入景点名称" class="search_input" id="rnameId" value="${rname}" autocomplete="off">
                <a href="javascript:void(0);" onclick="searchFun()" class="search-button">搜索</a>
            </div>
            <script>
                function searchFun() {
                    //给"搜索"按钮绑定单击事件,在单击事件中获取输入框的值,并向服务器发送分页查询的请求.
                    var rname = $("#rnameId").val();
                    location.href = "scenery?method=findsceneryByName&rname="+rname+"&pageNumber=1";
                }
            </script>
            <div class="hottel">
                <div class="hot_pic">
                    <img src="images/hot_tel.jpg" alt="">
                </div>
                <div class="hot_tel">
                    <p class="hot_time">客服热线(9:00-6:00)</p>
                    <p class="hot_num">400-618-9090</p>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- 头部 end -->
<!-- 首页导航 -->
<div class="navitem">
    <ul class="nav" id="categoryUI">
        <li class="nav-active"><a href="index.jsp">首页</a></li>
        <li><a href="introduce.jsp">项目简介</a></li>
        <li><a href="news?method=findAllNews&pageNumber=1">新闻动态</a></li>
        <li><a href="scenery?method=findAllscenery&pageNumber=1">景点展示</a></li>
        <li><a href="holiday?method=findAllholiday&pageNumber=1">度假主题</a></li>
        <li><a href="participation?method=findparticipationByName&username=${user.u_Name}">我的参加</a></li>
        <li><a href="contact.jsp">联系我们</a></li>
        <li><a href="user?method=getuserinfo">我的信息</a></li>
    </ul>
</div>



<!-- 注册 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form id="registerForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">用户注册</h4>

                </div>
                <div class="modal-body">

                        <%--隐藏域提交数据--%>
                        <input type="hidden" name="method" value="register">
                        <div class="form-group">
                            <label for="useraname">用户名</label>
                            <input type="text" class="form-control" name="u_Name" id="useraname" placeholder="请输入用户名">
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="text" class="form-control" name="u_Password" id="password" placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            <label for="coun">国籍</label>
                            <input type="text" class="form-control" name="u_Location_coun" id="coun" placeholder="请输入国籍">
                        </div>
                        <div class="form-group">
                            <label for="prov">省份</label>
                            <input type="text" class="form-control" name="u_Location_prov" id="prov" placeholder="请输入省份">
                        </div>
                        <div class="form-group">
                            <label for="city">城市</label>
                            <input type="text" class="form-control" name="u_Location_city" id="city" placeholder="请输入城市">
                        </div>

                        <div class="form-group">
                            <label for="documentType">证件类型</label>
                            <input type="text" class="form-control" name="u_DocumentType" id="documentType" placeholder="请输入证件类型">
                        </div>
                        <div class="form-group">
                            <label for="IDNumber">证件号码</label>
                            <input type="text" class="form-control" name="u_IDNumber" id="IDNumber" placeholder="请输入证件号码">
                        </div>

                        <div class="form-group">
                            <label>性别</label>
                            <input type="radio" class="form-inline" name="u_Sex" value="男" >男
                            <input type="radio" class="form-inline" name="u_Sex"  value="女">女
                        </div>
                        <div class="form-group">
                            <label for="date">出生日期</label>
                            <input type="date" class="form-control" name="u_Birth" id="date">
                        </div>

                </div>
                <div class="modal-footer">
                    <span id="errorMsg" style="color: red;"></span>
                    <button type="button" class="btn btn-default" id="closeId" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary"  onclick="registerFun()">注册</button>
                    <input type="reset" class="btn btn-primary" id="resetId"  value="重置">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    // 完成用户注册功能
    function registerFun() {
        // 将用户注册的模态框关闭
        // 使用js代码触发单击事件
        $("#closeId").click();
        // 使用ajax完成用户注册
        var url = "user"; // 请求路径
        var params = $("#registerForm").serialize(); // 序列化表单中的所有数据,将数据转成 key=value&key=value
        //alert(params);
        $.post(url,params,function (data) {
            //alert(data);
                location.href = "register_ok.jsp";
        },"text");
    }
</script>

<!-- Modal 模态框-->
<div class="modal fade" id="loginModel" tabindex="-1" role="dialog" aria-labelledby="loginModelLable">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="loginModelLable">
                    用户登陆
                    <span id="loginErrorMsg" style="color: red;"></span>
                </h4>

            </div>
            <form id="loginForm">
                <div class="modal-body">
                    <%--隐藏域提交数据--%>
                        <input type="hidden" name="method" value="login">
                    <div class="form-group">
                        <label for="loginuseraname">用户名</label>
                        <input type="text" class="form-control" name="name" id="loginuseraname" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" name="passWord" id="loginpassword" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <label for="ucode">验证码: </label>
                        <input type="text" class="form-control" name="ucode"  id="ucode"> <img src="code?method=getCode" alt=""> <br>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="reset" class="btn btn-primary" id="loginResetId"  value="重置">
                    <%--onclick="loginClose()"--%>
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="loginCloseId" >关闭</button>
                    <button type="button" class="btn btn-primary" onclick="loginFun()" >登陆</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    // 完成用户登录
    function loginFun() {
        // 关闭登陆的模态框
        $("#loginCloseId").click();
        // 发送ajax请求完成用户登录
        var url = "user";
        var params = $("#loginForm").serialize();
        $.post(url,params,function (data) {
            //alert(data);
            if(data==1){
                alert("用户名或密码错误");
            }else if(data==3){
                location.href="index.jsp";
            }else if(data==4){
                alert("服务器忙...");
            }else if(data==5){
                alert("验证码不可为空");
            }else if(data==6){
                alert("验证码输入不正确");
            }
        },"text");
    }
</script>

<script>
    function searchClick(){
        var rname=$("#rnameId").val();
        //alert(rname)
        var cid = getParameter("cid");
         rname = decodeURI(rname);
        location.href="RouteServlet?method=findRouteByPage&cid="+cid+"&rname="+rname+"&pageNumber=1";
    }
</script>

