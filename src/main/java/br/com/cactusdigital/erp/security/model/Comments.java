package br.com.cactusdigital.erp.security.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "codigo_feed")
	private Long codigoFeed;
		
	@Column(name="codigo_usuario")
	private Long codigoUsuario;
	
	@Column(name = "codigo_photo")
	private Long codigoPhoto;
	
	@Column(name = "data_comments")
	private LocalDate dataComment;
	
	private String txt;
	
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Long getCodigoPhoto() {
		return codigoPhoto;
	}

	public void setCodigoPhoto(Long codigoPhoto) {
		this.codigoPhoto = codigoPhoto;
	}

	public LocalDate getDataComment() {
		return dataComment;
	}

	public void setDataComment(LocalDate dataComment) {
		this.dataComment = dataComment;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodigoFeed() {
		return codigoFeed;
	}

	public void setCodigoFeed(Long codigoFeed) {
		this.codigoFeed = codigoFeed;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}	
}
