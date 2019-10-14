package br.com.cactusdigital.erp.security.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cactusdigital.erp.security.model.Usuario;

@RestController
@RequestMapping("/api")
public class AccountInfoResource {
	
	//@Autowired
	//private UserRepository userRepository;

	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> userinfo(Authentication authentication)
			throws JsonGenerationException, JsonMappingException, IOException {
		Usuario user = (Usuario) authentication.getPrincipal();
		Map<String, Object> map = new HashMap<>();
		// map.put("name", user.getUsername());
		map.put("user", new ObjectMapper().writeValueAsString(user));

		// validar a estrutura das informações que é requerido no ResourceServer
		map.put("authorities", authentication.getAuthorities());
		return ResponseEntity.ok(map);
	}

}
