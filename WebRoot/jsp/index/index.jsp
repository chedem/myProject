<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>中国电能——首页</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--[if lt IE 9]>
		    <meta http-equiv="refresh" content="0;ie.html" />
		<![endif]-->
<link href="jsp/css/bootstrap.min.css?v=3.3.6" rel="stylesheet"
	type="text/css"></link>
<link href="jsp/css/font-awesome.css?v=4.4.0" rel="stylesheet"
	type="text/css"></link>
<link href="jsp/css/animate.css" rel="stylesheet" type="text/css"></link>
<link rel="stylesheet" href="jsp/css/style.css" type="text/css"></link>
<!-- 全局js -->
<script type="text/javascript" src="jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="jsp/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="jsp/js/plugins/cookie/jquery.cookie.js"></script>
<script type="text/javascript"
	src="jsp/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script type="text/javascript"
	src="jsp/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="jsp/js/plugins/layer/layer.min.js"></script>
<!-- 自定义js -->
<script type="text/javascript" src="jsp/js/hplus.js"></script>
<script type="text/javascript" src="jsp/js/contabs.js"></script>
<script type="text/javascript" src="jsp/index/byPowerIndex.js"></script>
<script type="text/javascript" src="jsp/index/hideLeftNav.js"></script>
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
	<div id="wrapper">
		<div class="c_top bg-info">
			<nav class="c_logo"> <img src="jsp/img/bitug_favicon.gif"
				alt="CPECC" href="javascript:void(0);" /> <strong class="c_font">报表平台</strong>
			</nav>
		</div>
		<div class="row">
			<!--左侧导航-->
			<nav id="leftNav" class="navbar-default navbar-static-side"
				role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span><img alt="image" class="img-circle"
								src="jsp/img/profile_small.jpg" /> </span> <a data-toggle="dropdown"
								class="dropdown-toggle" href="javascript:void(0);"
								aria-expanded="false"> <span class="clear"> <span
									class="block m-t-xs" style="color:#fff;"><strong
										class="font-bold"></strong> </span> <span class="text-muted block">超级管理员<b
										class="caret"></b> </span> </span> </a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<!-- <li><a class="J_menuItem" href="profile.html">个人信息</a>
	                                </li> -->
								<li><a class="J_menuItem" href="javascript:void(0);">联系我们</a>
								</li>
								<li class="divider"></li>
								<li><a href="jsp/login/login.html">安全退出</a></li>
							</ul>
						</div></li>
					<li class="hidden"><a href="javascript:void(0);"> <i
							class="glyphicon glyphicon-cog"></i> <span class="nav-label">基础设置</span>
							<span class="fa arrow"></span> </a>
						<ul class="nav nav-second-level">
							<li><a id="userAdmin" class="J_menuItem"
								data-index="0">用户管理</a>
							</li>
						</ul></li>
					<li class="hidden"><a href="javascript:void(0);"> <i
							class="glyphicon glyphicon-list-alt"></i> <span class="nav-label">预算管理</span>
							<span class="fa arrow"></span> </a>
						<ul class="nav nav-second-level">
							<li>
								<a class="J_menuItem" href="jsp/onload/index3.jsp">预算导入</a>
							</li>
						</ul></li>
					<li class="hidden"><a href="javascript:void(0);"> <i
							class="glyphicon glyphicon-sort"></i> <span class="nav-label">预算调整</span>
					</a></li>
					<li class="hidden"><a href="javascript:void(0);"> <i
							class="glyphicon glyphicon-book"></i> <span class="nav-label">版本管理</span>
					</a></li>
					<li class="hidden"><a href="javascript:void(0);"> <i
							class="glyphicon glyphicon-retweet"></i> <span class="nav-label">流程管理</span>
					</a></li>
					<li><a href="javascript:void(0);"> <i
							class="glyphicon glyphicon-stats"></i> <span class="nav-label">报表管理</span>
							<span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<li class="hidden"><a class="J_menuItem baoBiao">子公司管理报表</a>
							</li>
							<li class="hidden"><a class="J_menuItem baoBiao">物装管理报表</a>
							</li>
							<li class="hidden"><a class="J_menuItem baoBiao">成套管理报表</a>
							</li>
							<li class="hidden"><a class="J_menuItem baoBiao">总表下载</a>
							</li>
							<li class="hidden"><a class="J_menuItem baoBiao">应收账款余额表</a>
							</li>
							<li class="hidden"><a class="J_menuItem baoBiao">应收账款余额表（基础统计表）</a>
							</li>
						</ul></li>
					<li class="hidden"><a href="javascript:void(0);"> <i
							class="glyphicon glyphicon-option-horizontal"></i> <span
							class="nav-label">工具</span> </a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="javascript:void(0);">取数平台</a>
							</li>
						</ul></li>
				</ul>
			</div>
			</nav>
			<!--右侧选项卡-->
			<div id="page-wrapper" class="gray-bg dashbard-1">
				<div class="row content-tabs">
					<button id="showOrhide" class="roll-nav roll-left btn">
						<i class="fa fa-backward"></i>
					</button>
					<nav class="page-tabs J_menuTabs">
					<div class="page-tabs-content">
						<a href="javascript:void(0);" class="active J_menuTab"
							data-id="index_v1.html">首页</a>
					</div>
					</nav>
					<button class="roll-nav roll-right J_tabRight">
						<i class="fa fa-forward"></i>
					</button>
					<div class="btn-group roll-nav roll-right">
						<button class="J_tabClose">
							关闭操作<span class="caret"></span>
						</button>
					</div>
					<a href="jsp/login/login.jsp"
						class="roll-nav roll-right J_tabExit"><i
						class="fa fa fa-sign-out"></i> 退出</a>
				</div>
				<div align="center" style="margin:0 auto;">
					<div id="content_box">
						<div class="J_mainContent" id="content-main">
							<iframe class="J_iframe" id="external-frame" name="iframe0"
								width="800" height="560" scrolling="no" src="jsp/main/main.jsp"
								frameborder="0" data-id="index_v1.html" seamless> </iframe>
						</div>
					</div>
				</div>
			</div>
</body>
</html>