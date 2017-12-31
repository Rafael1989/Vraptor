<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produto</title>
</head>
<body>
	<c:forEach items="${errors}" var="error">
		<p style="color: red">${error.category} - ${error.message}</p>
	</c:forEach>
	<form action="<c:url value="/produto/adiciona"/>" method="post">
		Nome:<input type="text" name="produto.nome"/><br/>
		Preço:<input type="text" name="produto.preco"/><br/>
		Cor:<input type="text" name="produto.cor"/><br/>
		Descrição:<input type="text" name="produto.descricao"/><br/>
		<input type="submit"/>
	</form>
</body>
</html>