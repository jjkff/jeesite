<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

<html>
<head>
	<title>退货单据信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">


        $(document).ready(function() {


            //$("#name").focus();
			changeCode();
			$("#inputForm").validate({

                rules:{
                    orderCode:{
                        required:true,
                        rangelength:[3,10],
//                        remote: {
                            remote:"${ctx}/sierac/rdcReturnHeader/checkOrderCode?oldcode=" + encodeURIComponent('${rdcReturnHeader.orderCode}')
						    <%--url: "${ctx}/sierac/rdcReturnHeader/ajaxOrderCode",     //后台处理程序--%>
						    <%--type: "post",               //数据发送方式--%>
						    <%--dataType: "json",           //接受数据格式--%>
						    <%--data: {                     //要传递的数据--%>
						        <%--code: function() {--%>
						            <%--return $("#orderCode").val();--%>
						        <%--}--%>
						    <%--}--%>
//						}
                    },
                    submitDate:{
                        required:true,
                    },
                    name:{
                        maxlength:10,
                        required:true,
                    },
                    receiveId:{
                        required:true,
                        maxlength:5
                    },
                    receivePhone:{
                        required:true,
                        mobile : true,
                    },
                    receiveAddress:{
                        required:true,
                        maxlength:5
                    },
                    scanTime:{
                        required:true,
                    },
                    updateTime:{
                        required:true,
                    },
                    billStatus:{
                        required:true,
                        number:true
                    },
                    remarks:{
                        /* required:true */
			         },

                    agree: "required"
                },
                messages:{
                    orderCode: {
                        required: "请输入退货单号",
                        rangelength:"长度介于3到10之间"	,
                    	remote:"该出库单号已存在,请重新输入"
                    },
                    submitDate:{
                        required:"请输入退货日期",
                    },
                    name:{
                        required:"请输入退货仓名称",
                    },
                    receiveId:{
                        required:"请输入收货仓id",
                    },
                    receivePhone:{
                        required:"请输入收货仓电话",
                        mobile :  "请正确填写手机号码",


                    },

                    receiveAddress:{
                        required:"请输入收货仓地址",
                    },
                    scanTime:{
                        required:"请输入开始扫描时间"
                    },
                    updateTime:{
                        required:"请输入上传日期"
                    },
                    billStatus:{
                        required:"请输入单据状态"
                    },
                    remarks:{
                        required:"请输入备注信息"
					}
                },

                submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
//            if ($("#receivePhone").val() == "") {
//                $("#moileMsg").html("<font color='red'>手机号码不能为空！</font>");
//                $("#mobile").focus();
//                return false;
//            }
//
//            if (!$("#receivePhone").val().match(/^(((13[0-9]{1})|159|153)+\d{8})$/)) {
//                $("#moileMsg").html("<font color='red'>手机号码格式不正确！请重新输入！</font>");
//                $("#mobile").focus();
//                return false;
//            }
		});
		$(function() {
			$("#name").change(function() {
				changeCode();
			});
		});
		function changeCode() {
			$("#msg").html("");
			if ($("#name").val() == "") {
				return;
			}
			$.ajax({
				async : false,
				url : "${ctx}/sierac/rdcReturnHeader/ajax",
				type : "post",
				data : {
					name : $("#name").val()
				},
				dataType : "json",
				success : function(data) {
					$("#code").val(data.code);
					$("#code").attr("value",data.code);
				}
			});
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sierac/rdcReturnHeader/">退货信息列表</a></li>
		<li class="active"><a href="${ctx}/sierac/rdcReturnHeader/form?id=${rdcReturnHeader.id}">退货信息<shiro:hasPermission name="sierac:rdcReturnHeader:edit">${not empty rdcReturnHeader.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sierac:rdcReturnHeader:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="rdcReturnHeader" action="${ctx}/sierac/rdcReturnHeader/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label" id="orderCode">退货单号：</label>
			<div class="controls">
			<c:choose>
					<c:when test="${empty rdcReturnHeader.id}">
						<form:input path="orderCode" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
					</c:when>
					<c:otherwise>
						<form:input path="orderCode" htmlEscape="false" maxlength="64" class="input-xlarge required" readonly="true"/>
					</c:otherwise>
				</c:choose>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" id="submitDate">退货日期：</label>
			<div class="controls">
				<input name="submitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${rdcReturnHeader.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退货仓代码：</label>
			<div class="controls">
				<!-- <input id="code" class="input-xlarge" type="text" value="" disabled/> -->
				<form:input id="code" path="returnCode" htmlEscape="false" class="input-xlarge" readonly="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退货仓名称：</label>
			 <div class="controls">
				<form:select class="input-xlarge" id="name" path="returnName">
					<c:forEach items="${warehouse }" var="warehouse" >
							<option  class="controls" value="${warehouse.name}">${warehouse.name }</option>
					</c:forEach>
				</form:select>
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
			<div class="control-group">
			<label class="control-label" id="receiveId">收货仓id：</label>
			<div class="controls">
				<form:input path="receiveId" htmlEscape="false" maxlength="64" class="input-xlarge "/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
			<div class="control-group">
			<label class="control-label" id="receivePhone">收货仓电话：</label>
			<div class="controls">
				<form:input path="receivePhone" htmlEscape="false" maxlength="64" class="input-xlarge "/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" id="receiveAddress">收货仓地址：</label>
			<div class="controls">
				<form:input path="receiveAddress" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" id="scanTime">开始扫描时间：</label>
			<div class="controls">
				<input name="scanTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${rdcReturnHeader.scanTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" id="updateTime">上传日期：</label>
			<div class="controls">
				<input name="updateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${rdcReturnHeader.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" id="billStatus">单据状态：</label>
			<div class="controls">
				<%-- <form:input path="billStatus" htmlEscape="false" maxlength="11" class="input-xlarge "/> --%>
				<form:select path="billStatus" id="billStatus" class="input-xlarge">
					<form:option value="" label="请选择"/>
					 <form:options items="${fns:getDictList('billStatus')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				 </form:select> 
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" id="remarks">备注信息：</label>
			<div class="controls">
				<%--<form:input path="remarks" htmlEscape="false" maxlength="11" class="input-xlarge "/>--%>
				<form:textarea id="name" htmlEscape="true" path="remarks" rows="4" maxlength="200" class="input-xxlarge"/>
				<tags:ckeditor replace="name" uploadPath="/test " />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sierac:rdcReturnHeader:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>