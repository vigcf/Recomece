package RedeOrganizacional.Recomece.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_comentario")
public class ComentarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComentario;


	@Column
	private String texto;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	/////////////////////////////    CHAVES ESTRANGEIRAS    /////////////////////////////
	@ManyToOne
	@JsonIgnoreProperties({"comentario" ,"email", "telefone", "comentario", "sexo", "senha", "postagem"})
	private UsuarioModel autoria;
	
	@ManyToOne
	@JsonIgnoreProperties({"usuario", "comentario"})
	private PostagemModel postagem;
	/////////////////////////////    CHAVES ESTRANGEIRAS    /////////////////////////////
	
	
	
	
	// Getters and Setters
	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UsuarioModel getAutoria() {
		return autoria;
	}

	public void setAutoria(UsuarioModel autoria) {
		this.autoria = autoria;
	}

	public PostagemModel getPostagem() {
		return postagem;
	}

	public void setPostagem(PostagemModel postagem) {
		this.postagem = postagem;
	}

	
	
}
