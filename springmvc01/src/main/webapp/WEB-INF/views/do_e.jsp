<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>do_e.jsp</title>
		<script type="text/javascript">
			var message = "${message}";
			if (message == "success"){
				alert("제품 조회 완료");
			}
		</script>
	</head>
	<body>
		<h1>do_e.jsp</h1>
		<!-- productVo.getName() -->
		<!-- EL : Expession Language -->
		<h2>제품명 : ${productVo.name}</h2>
		<h2>가격 : ${productVo.price}</h2>
	</body>
</html>