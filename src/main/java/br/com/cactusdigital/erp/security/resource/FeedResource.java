package br.com.cactusdigital.erp.security.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cactusdigital.erp.security.model.Feed;
import br.com.cactusdigital.erp.security.repository.FeedRepository;

@RestController
@RequestMapping("/feed")
public class FeedResource {
	
	@Autowired
	private FeedRepository repository;
	
	@PostMapping
	public ResponseEntity<Feed> criar(@RequestBody Feed feed) {
		
		Feed feedSalvo = repository.save(feed);
		return ResponseEntity.status(HttpStatus.CREATED).body(feedSalvo);
	}
	
	@GetMapping
	public List<Feed> listarFeed() {
		return repository.findAll();
	}

}
