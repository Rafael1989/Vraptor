package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProdutoController {
	
	private final RepositorioDeProdutos produtos;
	private Result result;
	private Validator validator;

	public ProdutoController(RepositorioDeProdutos produtos, Result result, Validator validator) {
		this.produtos = produtos;
		this.result = result;
		this.validator = validator;
	}
	
	public void formulario() {}
	
	public void adiciona(final Produto produto) {
		/*if(produto.getPreco()<0.1) {
			validator.add(new I18nMessage("preco", "produto.preco.invalido"));
		}*/
		validator.checking(new Validations() {{
			that(produto.getPreco()>0.1, "Preço", "produto.preco.invalido");
			that(produto.getDescricao()!=null&&!produto.getDescricao().equals(""), "Descrição", "produto.descricao.vazia");
			that(produto.getNome()!=null&&produto.getNome().length()>=3&&produto.getNome().length()<=100, "Nome", "produto.nome.tamanho");
		}});
		validator.onErrorUsePageOf(ProdutoController.class).formulario();
		this.produtos.salva(produto);
		result.include("mensagem", "Produto adicionado com sucesso");
		result.redirectTo(ProdutoController.class).lista();
	}
	
	public void remove(Produto produto) {
		this.produtos.remove(produto);
		result.nothing();
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









