package br.com.cactusdigital.erp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cactusdigital.erp.security.model.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}
