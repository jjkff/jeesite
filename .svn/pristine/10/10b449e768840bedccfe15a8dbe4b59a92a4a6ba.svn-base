<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>crud管理</title>
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
		<li class="active"><a href="${ctx}/test_audit/test_audit/">crud列表</a></li>
		<shiro:hasPermission name="test_audit:test_audit:edit"><li><a href="${ctx}/test_audit/test_audit/form">crud添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="test_audit" action="${ctx}/test_audit/test_audit/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>编号：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>归属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${test_audit.office.id}" labelName="office.name" labelValue="${test_audit.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>学历：</label>
				<form:input path="edu" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="test_audit:test_audit:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="test_audit">
			<tr>
				<td><a href="${ctx}/test_audit/test_audit/form?id=${test_audit.id}">
					<fmt:formatDate value="${test_audit.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${test_audit.remarks}
				</td>
				<shiro:hasPermission name="test_audit:test_audit:edit"><td>
    				<a href="${ctx}/test_audit/test_audit/form?id=${test_audit.id}">修改</a>
					<a href="${ctx}/test_audit/test_audit/delete?id=${test_audit.id}" onclick="return confirmx('确认要删除该crud吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>