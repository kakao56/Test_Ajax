<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("[value=검색]").click(function(){
			$.ajax({
				url: "list",
				type: "post",
				data: $("form").serialize(),
				success: function(data){
					$("#listdv").html(data);
				},error: function(err){
					console.log(err);
				} 
			});
		});
	});
</script>      
</head>
<body>
	<form>  
		<input type="text" name="searchValue" >
		<input type="button" value="검색">
	</form>
	<div id="listdv">
	</div>
</body>
</html>