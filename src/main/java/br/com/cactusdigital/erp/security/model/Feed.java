package br.com.cactusdigital.erp.security.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "feed")
@Entity
public class Feed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String name;

	@Column(name="codigo_usuario")
	private Long codigUsuario;

	@Column(name = "like_count")
	private Long likeCount;

	private String url;

	@Column(name="date_comment")
	private LocalDate dateComment;

	@Column(name="avatar")
	private String avatar;

	private String is_like;

	@OneToMany(mappedBy = "codigoUsuario", cascade = CascadeType.ALL)
    private List<Comments> comments;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigUsuario() {
		return codigUsuario;
	}

	public void setCodigUsuario(Long codigUsuario) {
		this.codigUsuario = codigUsuario;
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

	/**
	 * @return the dateComment
	 */
	public LocalDate getDateComment() {
		return dateComment;
	}

	/**
	 * @param dateComment the dateComment to set
	 */
	public void setDateComment(LocalDate dateComment) {
		this.dateComment = dateComment;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the comments
	 */
	public List<Comments> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	/**
	 * @return the is_like
	 */
	public String getIs_like() {
		return is_like;
	}

	/**
	 * @param is_like the is_like to set
	 */
	public void setIs_like(String is_like) {
		this.is_like = is_like;
	}
}
