<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>生产数据查询</title>
	<meta name="decorator" content="default"/>
	<style type="text/css">
	  table tr th{
	   text-align:center;
	  }
	  table tr td{
	  text-align:center;
	  }
	</style>
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
		<li class="active"><a href="${ctx}/sierac/codeData/">生产数据列表</a></li>
		
	</ul>
	<form:form id="searchForm" modelAttribute="codeData" action="${ctx}/sierac/codeData/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>产品代码：</label>
				<form:input path="pcode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>产品名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>产品批号：</label>
				<form:input path="batchCode" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>单品码：</label>
				<form:input path="code" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>箱码：</label>
				<form:input path="ctnCode" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			   
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>产品代码</th>
				<th>产品名称</th>
				<th>单品码</th>
				<th>单品箱码</th>
				<th>产品批号</th>
				<th>生产线号</th>
				<th>包装日期</th>
				
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="codeData">
			<tr>
				<td>
					${codeData.pcode}
				</td>
				<td>
					${codeData.name}
				</td>
				<td>
					${codeData.code}
				</td>
				<td>
					${codeData.ctnCode}
				</td>
				<td>
					${codeData.batchCode}
				</td>
				<td>
					${codeData.lineCode}
				</td>
				<td >
				<fmt:formatDate value="${codeData.packDate}" pattern="yyyy-MM-dd HH:mm:ss"/>	
				</td>
				<%-- <shiro:hasPermission name="sierac:product:edit"><td>
    				<a href="${ctx}/sierac/product/form?id=${product.id}">修改</a>
					<a href="${ctx}/sierac/product/delete?id=${product.id}" onclick="return confirmx('确认要删除该产品吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>