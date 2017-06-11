<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>出库信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出退货单明细数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sierac/rdcReturnDetail/export");
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
		<li class="active"><a href="${ctx}/sierac/rdcReturnDetail/">退货单明细</a></li>
		<%-- <shiro:hasPermission name="sierac:rdcOutHeader:edit"><li><a href="${ctx}/sierac/rdcOutHeader/form">出库信息添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="rdcReturnDetail" action="${ctx}/sierac/rdcReturnDetail/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>退货单号：</label>
				<form:input path="orderCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>退货仓代码：</label>
				<form:input path="returnCode" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>退货日期：</label>
				<input name="beginSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${rdcReturnDetail.beginSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${rdcReturnDetail.endSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>退货仓名称：</label>
				<form:input path="returnName" htmlEscape="false" maxlength="255" class="input-medium"/>
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
				<!-- <th>id</th> -->
				<th>退货单号</th>
				<th>退货日期</th>
				<th>退货仓代码</th>
				<th>退货仓名称</th>
				<th>收货仓代码</th>
				<th>收货仓电话</th>
				<th>收货仓地址</th>
				<th>产品代码</th>
				<th>产品名称</th>
				<th>计划退货数量</th>
				<th>成功退货数量</th>
				<th>差异数量</th>
				<%-- <shiro:hasPermission name="sierac:rdcOutHeader:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rdcReturnDetail">
			<tr>
				<%-- <td><a href="${ctx}/sierac/rdcOutHeader/form?id=${rdcOutHeader.id}">
					${rdcOutHeader.id}
				</a></td> --%>
				<td>
					${rdcReturnDetail.orderCode}
				</td>
				<td>
					<fmt:formatDate value="${rdcReturnDetail.submitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${rdcReturnDetail.returnCode}
				</td>
				<td>
					${rdcReturnDetail.returnName}
				</td>
				<td>
					${rdcReturnDetail.receiveId}
				</td>
				<td>
					${rdcReturnDetail.receivePhone}
				</td>
				<td>
					${rdcReturnDetail.receiveAddress}
				</td>
					<td>
					${rdcReturnDetail.pCode}
				</td>
					<td>
					${rdcReturnDetail.pName}
				</td>
				<td>
					${rdcReturnDetail.expectPcsQty}
				</td>
				<td>
					${rdcReturnDetail.actualPcsQty}
				</td>
				<td>
					${rdcReturnDetail.expectPcsQty-rdcReturnDetail.actualPcsQty}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>