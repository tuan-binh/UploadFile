<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/products/add">Thêm mới</a>
<table border="1" cellspacing="10" cellpadding="10">
	<thead>
	<tr>
		<th>STT</th>
		<th>NAME</th>
		<th>DESC</th>
		<th>IMAGE</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${products}" var="p" varStatus="loop">
		<tr>
			<td>${loop.count}</td>
			<td>${p.name}</td>
			<td>${p.description}</td>
			<td>
				<img src="/image/${p.image}"
				     alt="img"
				     style="width: 80px;height: 80px;border-radius: 50%;object-fit: cover"
				/>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
