package br.com.cactusdigital.erp.security.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cactusdigital.erp.security.model.Usuario;
import br.com.cactusdigital.erp.security.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/user")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository repository;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		Usuario usuarioSalvo = repository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

}
