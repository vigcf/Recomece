package RedeOrganizacional.Recomece.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_Tema")
public class TemaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTema;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE) //Alterando o cascade de .ALL para .REMOVE
	@JsonIgnoreProperties("tema")
	private List<PostagemModel>postagem;
	
	@Column
	private String categoria;
	
	@Column
	private String nome;

	
	//Getters and Setters
	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long id) {
		this.idTema = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}



	
	

	
	
}
