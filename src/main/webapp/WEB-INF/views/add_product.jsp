<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/products">Quay lại</a>
<form action="<%=request.getContextPath()%>/products/add" method="post" enctype="multipart/form-data">
	<div>
		<label for="name">Name:</label> <br>
		<input type="text" name="name" id="name">
	</div>
	<div>
		<label for="description">Description:</label> <br>
		<textarea name="description" id="description" cols="30" rows="10"></textarea>
	</div>
	<div>
		<label for="image">Image</label> <br>
		<input type="file" name="image" id="image">
	</div>
	<button type="submit">ADD</button>
</form>
</body>
</html>
