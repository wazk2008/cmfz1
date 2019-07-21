<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="en">
<head>
    <title>持明法洲后台管理系统</title>
    <%--引入bootstrap的主题样式--%>
    <link rel="stylesheet" href="statics/boot/css/bootstrap.min.css">
    <%--引入bootstrap和jqgrid的整合样式--%>
    <link rel="stylesheet" href="statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">

    <%--引入基本js文件--%>
    <script src="statics/boot/js/jquery-2.2.1.min.js"></script>
    <%--引入bootstrap的js文件--%>
    <script src="statics/boot/js/bootstrap.min.js"></script>

    <%--引入jqgrid的js文件--%>
    <script src="statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="statics/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="statics/jqgrid/js/ajaxfileupload.js"></script>



    <script src="kindeditor/kindeditor-all.js"></script>
    <script src="kindeditor/lang/zh-CN.js"></script>

    <%--引入echarts的js--%>
    <script src="user/echarts.min.js"></script>
    <script src="user/china.js"></script>
    <%--<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>--%>

</head>
<body>
    <%--顶部导航条--%>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">持明法洲后台管理系统</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a>欢迎:${loginAdmin.nickname}</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/exit">安全退出</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <%--中间栅格系统--%>
    <div class="row">
        <%--左侧--%>
        <div class="col-xs-2">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title text-center">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                <h4>轮播图管理</h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body text-center">
                            <a href="javascript:$('#contentLayout').load('banner/banner-show.jsp')" class="btn btn-default">所有轮播图</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title text-center">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                <h4>专辑管理</h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body text-center">
                            <a href="javascript:$('#contentLayout').load('album/album-show.jsp')" class="btn btn-default">所有专辑</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title text-center">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                <h4>文章管理</h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                        <div class="panel-body text-center">
                            <a href="javascript:$('#contentLayout').load('article/article-show.jsp')" class="btn btn-default">所有文章</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingFour">
                        <h4 class="panel-title text-center">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                <h4>用户管理</h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                        <div class="panel-body text-center">
                            <a href="javascript:$('#contentLayout').load('user/user-show.jsp')" class="btn btn-default">所有用户</a>
                            <br><br>
                            <a href="javascript:$('#contentLayout').load('user/user-line.jsp')" class="btn btn-default">用户注册趋势</a>
                            <br><br>
                            <a href="javascript:$('#contentLayout').load('user/user-map.jsp')" class="btn btn-default">用户地区分布</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--右侧--%>
        <div class="col-xs-10" id="contentLayout">
            <div class="jumbotron" style="padding-left: 100px">
                <h3>欢迎来到持明法洲后台管理系统!</h3>
            </div>
            <img src="img/shouye.jpg" style="width: 100%">
        </div>
    </div>


    <%--页面底部--%>
    <div class="panel panel-footer text-center">
        <h5>持明法洲后台管理系统@百知教育2019.7.8</h5>
    </div>


</body>
</html>