package br.com.cactusdigital.erp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cactusdigital.erp.security.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
