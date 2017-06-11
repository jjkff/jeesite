<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>模块菜单管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sierac/sysMenu/">模块菜单列表</a></li>
		<shiro:hasPermission name="sierac:sysMenu:edit"><li><a href="${ctx}/sierac/sysMenu/form">模块菜单添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysMenu" action="${ctx}/sierac/sysMenu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>编号：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>编码</th>
				<th>名称</th>
				<th>上级编码</th>
				<th>Url</th>
				<th>排序号</th>
				
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sierac:sysMenu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysMenu">
			<tr>
				<td><a href="${ctx}/sierac/sysMenu/form?id=${sysMenu.id}">
					${sysMenu.id}
				</a></td>
				<td>
					${sysMenu.name}
				</td>
				<td>
					${sysMenu.parent.id}
				</td>
				<td>
					${sysMenu.href}
				</td>
				<td>
					${sysMenu.sort}
				</td>
				
				<td>
					<fmt:formatDate value="${sysMenu.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysMenu.remarks}
				</td>
				<shiro:hasPermission name="sierac:sysMenu:edit"><td>
    				<a href="${ctx}/sierac/sysMenu/form?id=${sysMenu.id}">修改</a>
					<a href="${ctx}/sierac/sysMenu/delete?id=${sysMenu.id}" onclick="return confirmx('确认要删除该模块菜单吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>