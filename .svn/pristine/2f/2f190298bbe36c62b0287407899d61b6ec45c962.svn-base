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
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sierac/queryReport">条码信息</a></li>
		<li class="active"><a href="${ctx}/sierac/queryReportDetail">条码详情</a></li>
	</ul>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>查询时间</th>
				<th>IP地址</th>
				<th>所在地</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="requeryReportDetail">
			<tr>
				<td>
				<fmt:formatDate value="${requeryReportDetail.queryTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					
				</td>
				<td>
					${requeryReportDetail.queryIp}
				</td>
				<td>
					${requeryReportDetail.location}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>