<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/js/jquery-1.6.1.min.js"/>"></script>
<script type="text/javascript">
function remover(id){
	$.get('remove?produto.id='+id,function(){
		$('#produto-'+id).hide();
		alert('Removido com sucesso!');
	});
}
function exibeJson(id){
	$.get('/vraptor-produtos/produto/'+id+'/json',function(dados){
		$('#json').html('Id:'+dados.produto.id+'<br/> Nome:'+dados.produto.nome+'<br/> Descrição:'+dados.produto.descricao+'<br/> Cor:'+dados.produto.cor+'<br/> Preço:'+dados.produto.preco);
	});
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produtos</title>
</head>
<body>
	<p>${mensagem}</p>
	<hr/>
	<table>
		<c:forEach var="produto" items="${produtoList}">
			<tr id="produto-${produto.id}">
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>${produto.cor}</td>
				<td>${produto.preco}</td>
				<td><a href="javascript:void(0);" onclick="remover(${produto.id})">Remover</a></td>
				<td><a href="javascript:void(0);" onclick="exibeJson(${produto.id})">Json</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="json"></div>
</body>
</html>