<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关联用户</title>
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
<script language="javascript">
	function deleteAll() {
		var selectuser = document.getElementsByName("userId");
		var flag = false;
		var userIds = "";
		for (var i = 0; i < selectuser.length; i++) {
			if (selectuser[i].checked) {
				userIds += selectuser[i].value + ",";

				flag = true;
			}
		}

		if (!flag) {
			alert("没有选择执行操作的用户！不能执行该操作");
			return false;
		} else {
			var confirmflag = window.confirm("你确定批量添加所选用户吗？");
			if (!confirmflag) {
				return false;
			} else {
               var formID=document.getElementById("searchForm");
				formID.action = "${ctx}/sierac/rdcUser/addAll?id=${id}&userIdList="
						+ userIds;
					var ss=	formID.action;
                
				return true;
			}
		}
	}
	//用户:全部选中/全部不选中
	function checkAllUser(user) {
		var selectuser = document.getElementsByName("userId");
		for (var i = 0; i < selectuser.length; i++) {
			selectuser[i].checked = user.checked;
		}
	}
</script>
<script type="text/javascript">
 var paList=${paList};
     if(paList==0){
      window.confirmx("已没有满足条件的用户可以关联\n请点击'取消'",window.history.go(-1));
     }
</script>
</head>
<body>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sierac/rdcWarehouse/">仓库管理</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="rdcUser" action="" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			
			<li class="btns">
			<input id="BT_Delete" class="btn btn-primary" type="submit" value="保存" name="BT_Delete"
			onclick="deleteAll()"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
     
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			   <th><input type="checkbox" name="selectUserAll" onclick="checkAllUser(this)"></th>
				<th>用户名</th>
				<th>用户姓名</th>
				<shiro:hasPermission name="sierac:rdcUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="user">
			<tr>
			  <td><input type="checkbox" name="userId" id="userId" value="${user.userId }">
</td>
				<%-- <td>
					${rdcWarehouse.id}
				</td> --%>
				<td>
					<%-- <a href="${ctx}/sierac/rdcWarehouse/form?id=${user.id}"> --%>
					${user.loginName}
				</td>
				<td>
					${user.name}
				</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>