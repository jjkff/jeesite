<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>出库信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出出库单明细数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sierac/rdcOutDetail/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true}, 
					bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
			});
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
		<form id="importForm" action="${ctx}/sierac/rdcOutDetail/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/sierac/rdcOutDetail/import/template">下载模板</a>
		</form>
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sierac/rdcOutDetail/">出库单明细</a></li>
		<%-- <shiro:hasPermission name="sierac:rdcOutHeader:edit"><li><a href="${ctx}/sierac/rdcOutHeader/form">出库信息添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="rdcOutDetail" action="${ctx}/sierac/rdcOutDetail/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>出库单号：</label>
				<form:input path="orderCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>发货仓代码：</label>
				<form:input path="sendCode" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>出库单日期：</label>
				<input name="beginSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${rdcOutDetail.beginSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${rdcOutDetail.endSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>发货仓名称：</label>
				<form:input path="sendName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>产品代码：</label>
				<form:input path="pCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>产品名称：</label>
				<form:input path="pName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
				<!-- <input id="btnImport" class="btn btn-primary" type="button" value="导入"/> -->
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>出库单号</th>
				<th>出库日期</th>
				<th>发货仓代码</th>
				<th>发货仓名称</th>
				<th>客户姓名</th>
				<th>客户电话</th>
				<th>客户地址</th>
				<th>产品代码</th>
				<th>产品名称</th>
				<th>计划发货数量</th>
				<th>成功发货数量</th>
				<th>差异数量</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rdcOutDetail">
			<tr>
				<td>
					${rdcOutDetail.orderCode}
				</td>
				<td>
					<fmt:formatDate value="${rdcOutDetail.sumitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${rdcOutDetail.sendCode}
				</td>
				<td>
					${rdcOutDetail.sendName}
				</td>
				<td>
					${rdcOutDetail.receiveName}
				</td>
				<td>
					${rdcOutDetail.receivePhone}
				</td>
				<td>
					${rdcOutDetail.receiveAddress}
				</td>
				<td>
					${rdcOutDetail.pCode}
				</td>
				<td>
					${rdcOutDetail.pName}
				</td>
				<td>
					${rdcOutDetail.expectPcsQty}
				</td>
				<td>
					${rdcOutDetail.actualPcsQty}
				</td>
				<td>
					<%-- ${rdcOutDetail.diffQty} --%>
					${rdcOutDetail.expectPcsQty-rdcOutDetail.actualPcsQty}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>