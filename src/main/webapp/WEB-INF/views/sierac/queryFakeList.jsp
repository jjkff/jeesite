<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>条码查询统计</title>
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
<div id="importBox" class="hide">
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sierac/queryFake">防窜货查询</a></li>
		<%-- <shiro:hasPermission name="sierac:rdcOutHeader:edit"><li><a href="${ctx}/sierac/rdcOutHeader/form">出库信息添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="queryFake" action="${ctx}/sierac/queryFake/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>编码：</label>
				<form:input path="cCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<!-- <input id="btnExport" class="btn btn-primary" type="button" value="导出"/> -->
				<!-- <input id="btnImport" class="btn btn-primary" type="button" value="导入"/> -->
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<br />
	<div class="form-horizontal">
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">编码：</label>
			<div class="controls">
				<input class="input-xlarge" type="text" value="${queryFake.cCode}" disabled />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产品代码：</label>
			<div class="controls">
				<input class="input-xlarge" type="text" value="${queryFake.pCode}" disabled />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产品名称：</label>
			<div class="controls">
			<input class="input-xlarge" type="text" value="${queryFake.pName}" disabled />
			</div>
		</div>	
		<div class="control-group">
			<label class="control-label">规格：</label>
			<div class="controls">
			<input class="input-xlarge" type="text" value="${queryFake.spec}" disabled />
			</div>
		</div>	
		<div class="control-group">
			<label class="control-label">保质期：</label>
			<div class="controls">
			<input class="input-xlarge" type="text" value="${queryFake.shelfLife}" disabled />
			</div>
		</div>	
	<div class="control-group">
		<label class="control-label">有效：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="<fmt:formatDate value="${queryFake.validPeriod}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled />
		</div>
	</div>
		<div class="control-group">
			<label class="control-label">批号：</label>
			<div class="controls">
			<input class="input-xlarge" type="text" value="${queryFake.batchCode}" disabled />
			</div>
		</div>
	<div class="control-group">
		<label class="control-label">包装日期：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="<fmt:formatDate value="${queryFake.packDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled />
		</div>
	</div>
		<div class="control-group">
		<label class="control-label">查询次数：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${queryFake.qQty}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">单据号：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${queryFake.orderCode}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">扫描日期：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="<fmt:formatDate value="${queryFake.scanBeginTimeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">提交日期：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="<fmt:formatDate value="${queryFake.sumbitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">发货仓名称：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${queryFake.sendName}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">客户姓名：</label>
		<div class="controls">
			<input class="input-xlarge" type="text" value="${queryFake.receiveName}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">客户手机号：</label>
		<div class="controls">
			<input class="input-xlarge" type="text" value="${queryFake.receivePhone}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">客户地址：</label>
		<div class="controls">
			<input class="input-xlarge" type="text" value="${queryFake.receiveAddress}" disabled />
		</div>
	</div>
</body>
</html>