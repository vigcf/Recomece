package RedeOrganizacional.Recomece.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostagem;
	
	@Column
	private String titulo;
	
	@Column
	private String texto;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	
	//////////////////////////////Integração com o Front //////////////////////////////////
	
	
	
	//////////////////////////////Integração com o Front //////////////////////////////////
	
	
	/////////////////////////////    CHAVES ESTRANGEIRAS    /////////////////////////////
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;
	
	@ManyToOne
	@JsonIgnoreProperties({"postagem", "email", "telefone", "comentario", "sexo", "senha"})
	private UsuarioModel usuario;
	
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("postagem")
	private List<ComentarioModel> comentario;
	/////////////////////////////    CHAVES ESTRANGEIRAS    /////////////////////////////

	
	
	
	
	//Getters and Setters
	public Long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public List<ComentarioModel> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioModel> comentario) {
		this.comentario = comentario;
	}

	
	
	}
