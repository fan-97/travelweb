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
    <%--<link rel="stylesheet" type="text/css" href="css/common.css">--%>
    <%--<link rel="stylesheet" href="css/search.css">--%>
    <script src="js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">


    <link href="css/user_style.css" rel="stylesheet" type="text/css"/>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script>
        $(function () {
            $(".right_style").hide();
            $("#right"+2).show();
            $(".modify").click(function () {
                $('.text').attr("disabled", false);
                $('.text').addClass("add");
                $('#Personal').find('.xinxi').addClass("hover");

            });
        });
        function show(index){
            $(".right_style").hide();
            $("#right"+index).show();
        }
        function addprice() {
            var price = $("#price").val();
            location.href = "user?method=chongzhi&id=${user.u_ID}&addprice=" + price;
        }
    </script>
</head>
<body>
<!--引入头部-->

<jsp:include page="header.jsp"></jsp:include>
<!-- 模态框（Modal） -->
<div class="modal fade" id="addprice" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    充值
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="price">充值金额</label>
                    <input type="text" class="form-control" id="price" onkeyup="value=value.replace(/[^\d.]/g,'')"
                           placeholder="请输入金额">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="addprice()">
                    确定充值
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!--用户中心样式-->
<div class="user_style clearfix" style="padding-left: 10%;padding-bottom: 30px;padding-top: 30px">
    <div class="user_center clearfix">
        <!--左侧样式-->
        <div class="left_style" style="width: 160px;">
            <div class="menu_style">
                <div class="user_title">用户中心</div>
                <div class="user_Head">
                    <div class="user_name">
                        <p><span class="name">${user.u_Name}</span></p>
                    </div>
                </div>
                <div class="sideMen">
                    <!--菜单列表图层-->
                    <dl class="accountSideOption1">
                        <dd>
                            <ul>
                                <li onclick="show(2)"><a href="#">用户信息</a></li>
                                <li onclick="show(1)"><a href="#">账户管理</a></li>
                                <li onclick="show(3)"><a href="#">我的收藏</a></li>
                            </ul>
                        </dd>
                    </dl>
                </div>
        </div>
    </div>
        <div class="right_style" id="right3">
            <div class="title_style"><em></em>我的收藏</div>
        </div>
    <div class="right_style" id="right1">
        <div class="title_style"><em></em>账户管理</div>
        <div class="user_Account_style">
            <div class="user_Account">
                <div class="title_name">我的账户余额：</div>
                <div class="Balance clearfix">
                    <p class="je_Balance">账户余额：<b>${user.u_price}</b>元 </p>
                    <p class="clearfix Account_btn"><a href="#" class="Recharge_btn" id="Recharge_btn"
                                                       data-toggle="modal" data-target="#addprice">充值</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!--右侧样式-->
    <div class="right_style" id="right2">
        <!--消费记录样式-->
        <div class="user_address_style">
            <div class="title_style"><em></em>用户信息</div>
            <!--用户信息样式-->
            <!--个人信息-->
            <div class="Personal_info" id="Personal">
                <ul class="xinxi">
                    <form action="user?method=edituser" method="post" id="userform">
                        <input name="u_ID" value="${user.u_ID}" type="hidden">
                        <li><label class="label">用户名：</label><span><input name="u_Name" type="text"
                                                                          value="${user.u_Name}" class="text"
                                                                          disabled="disabled"/></span></li>
                        <li><label class="label">性别：</label> <span><input name="u_Sex" type="text"
                                                                          value="${user.u_Sex}" class="text"
                                                                          disabled="disabled"/></span></li>
                        <li><label class="label">生日：</label> <span><input name="u_Birth" type="text"
                                                                          value="${user.u_Birth}" class="text"
                                                                          disabled="disabled"/></span></li>
                        <li><label class="label">证件类型：</label> <span><input name="u_DocumentType" type="text"
                                                                            value="${user.u_DocumentType}"
                                                                            class="text"
                                                                            disabled="disabled"/></span></li>
                        <li><label class="label">证件号码：</label> <span><input name="u_IDNumber" type="text"
                                                                            value="${user.u_IDNumber}" class="text"
                                                                            disabled="disabled"/></span></li>
                        <li><label class="label">省：</label> <span><input name="u_Location_prov" type="text"
                                                                         value="${user.u_Location_prov}"
                                                                         class="text" disabled="disabled"/></span>
                        </li>
                        <li><label class="label">市：</label> <span><input name="u_Location_city" type="text"
                                                                         value="${user.u_Location_city}"
                                                                         class="text" disabled="disabled"/></span>
                        </li>
                        <li><label class="label">区：</label> <span><input name="u_Location_coun" type="text"
                                                                         value="${user.u_Location_coun}"
                                                                         class="text" disabled="disabled"/></span>
                        </li>
                        <div class="bottom">
                            <input type="button" value="修改信息" class="modify"/>
                            <input type="submit" value="确认修改" class="confirm"/>
                            <script>
                                // onclick = "confirm()"
                                //
                                // function confirm() {
                                //     var params = $("#userform").serializeArray();
                                //     alert(params);
                                //     location.href = "user?method=edituser&" + params;
                                // }
                            </script>
                        </div>
                    </form>

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
