package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProdutoController {
	
	private final ProdutoDao produtos;
	private Result result;

	public ProdutoController(Result result) {
		this.produtos = new ProdutoDao();
		this.result = result;
	}
	
	public void formulario() {}
	
	public void adiciona(Produto produto) {
		this.produtos.salva(produto);
		result.include("mensagem", "Produto adicionado com sucesso");
		result.redirectTo(ProdutoController.class).lista();
	}
	
	public List<Produto> lista(){
		return produtos.pegaTodos();
	}
	
	@Path("/produto/{id}")
	public Produto mostra(Long id) {
		return produtos.pegaPorId(id);
	}
	
	@Path("/produto/{id}/xml")
	public void toXml(Long id) {
		Produto produto = this.produtos.pegaPorId(id);
		result.use(Results.xml()).from(produto).serialize();
	}
	
	@Path("/produto/{id}/json")
	public void toJson(Long id) {
		Produto produto = this.produtos.pegaPorId(id);
		result.use(Results.json()).from(produto).serialize();
	}
}









