package br.com.cactusdigital.erp.security.resource;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cactusdigital.erp.security.model.Comments;
import br.com.cactusdigital.erp.security.model.Feed;
import br.com.cactusdigital.erp.security.repository.CommentsRepository;
import br.com.cactusdigital.erp.security.repository.FeedRepository;

@RestController
@RequestMapping("/feed")
public class FeedResource {

	@Autowired
	private FeedRepository repository;
	
	@Autowired
	private CommentsRepository commentsRepository;

	@PostMapping
	public ResponseEntity<Feed> criar(@RequestBody Feed feed) {

		Feed feedSalvo = repository.save(feed);
		return ResponseEntity.status(HttpStatus.CREATED).body(feedSalvo);
	}

	@GetMapping
	public ResponseEntity<List<Feed>> listarFeed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}

	@PostMapping("/photo/like/{codigo}")
	public ResponseEntity<Feed> like(@PathVariable Long codigo) {

		//Buscar o feed
		Feed feed = repository.findOne(codigo);
		
		if (feed.getIs_like().equals("S")) {
			Long contadorUsuario = feed.getLikeCount() -1L;
			feed.setLikeCount(contadorUsuario);
			feed.setIs_like("N");
		} else if (feed.getIs_like().equals("N") || feed.getIs_like() == null) {
			feed.setLikeCount( ( feed.getLikeCount() == null ? 0 : feed.getLikeCount() ) + 1L);
			feed.setIs_like("S");
		}
		Feed salvar = repository.save(feed);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
	}

	@DeleteMapping
	public ResponseEntity<Feed> desLike(Long codigo) {
		repository.delete(codigo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping("/comments")
	public ResponseEntity<Comments> addComments(@RequestBody Comments comments) {
		comments.setDataComment(LocalDate.now());
		comments.setCodigoPhoto(1L);
		
		Comments commentsSalvo = commentsRepository.save(comments);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(commentsSalvo);
	}

}
