<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produto</title>
</head>
<body>
	<table>
		<tr>
			<td>
				${produto.nome}
			</td>
			<td>
				${produto.descricao}
			</td>
			<td>
				${produto.cor}
			</td>
			<td>
				${produto.preco}
			</td>
		</tr>
	</table>
</body>
</html>