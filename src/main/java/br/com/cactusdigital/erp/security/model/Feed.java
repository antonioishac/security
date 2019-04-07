package br.com.cactusdigital.erp.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name = "feed")
@Entity
public class Feed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "codigo_usuario")
	@ManyToOne
	@JoinColumn(name="CODIGO_USUARIO")
	private Usuario usuario;
	
	@Column(name = "like_count")
	private Long likeCount;
	
	private String url;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Comments> contatos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comments> getContatos() {
		return contatos;
	}

	public void setContatos(List<Comments> contatos) {
		this.contatos = contatos;
	}	
}
