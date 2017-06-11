<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>出库信息管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(
			function() {
				//$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
										} else {
											error.insertAfter(element);
										}
									}
								});
			});
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sierac/rdcReturnHeader/">退货信息列表</a></li>
		<li class="active"><a
			href="#">查看</a></li>
	</ul>
	<br />
	<div class="form-horizontal">
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">退货单号：</label>
			<div class="controls">
				<input class="input-xlarge" type="text" value="${rdcReturnDetail.orderCode}" disabled />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退货日期：</label>
			<div class="controls">
				<input class="input-xlarge" type="text" value="<fmt:formatDate value="${rdcReturnDetail.submitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退货仓代码：</label>
			<div class="controls">
			<input class="input-xlarge" type="text" value="${rdcReturnDetail.returnCode}" disabled />
			</div>
		</div>	
		<div class="control-group">
			<label class="control-label">退货仓名称：</label>
			<div class="controls">
			<input class="input-xlarge" type="text" value="${rdcReturnDetail.returnName}" disabled />
			</div>
		</div>
	<div class="control-group">
		<label class="control-label">收货仓代码：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${rdcReturnDetail.receiveId}" disabled />
		</div>
	</div>
	<div>
	<div class="control-group">
		<label class="control-label">收货仓电话：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${rdcReturnDetail.receivePhone}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">收货仓地址：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${rdcReturnDetail.receiveAddress}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">产品名称：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${rdcReturnDetail.pName}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">产品代码：</label>
		<div class="controls">
		<input class="input-xlarge" type="text" value="${rdcReturnDetail.pCode}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">计划退货数量：</label>
		<div class="controls">
			<input class="input-xlarge" type="text" value="${rdcReturnDetail.expectPcsQty}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">成功退货数量：</label>
		<div class="controls">
			<input class="input-xlarge" type="text" value="${rdcReturnDetail.actualPcsQty}" disabled />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">差异数量：</label>
		<div class="controls">
			<input class="input-xlarge" type="text" value="${rdcReturnDetail.expectPcsQty-rdcReturnDetail.actualPcsQty}" disabled />
		</div>
	</div>
</body>
</html>