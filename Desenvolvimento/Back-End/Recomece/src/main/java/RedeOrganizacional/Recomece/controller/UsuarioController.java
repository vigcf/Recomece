package RedeOrganizacional.Recomece.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RedeOrganizacional.Recomece.model.UserLogin;
import RedeOrganizacional.Recomece.model.UsuarioModel;
import RedeOrganizacional.Recomece.repository.UsuarioRepository;
import RedeOrganizacional.Recomece.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService; 

	
	//Métodos que usam a camada de segurança
	@PostMapping("/logar")
	public ResponseEntity <UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("cadastrar")
	public ResponseEntity<UsuarioModel> Post(@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}
	//Métodos que usam a camada de segurança
	
	@PostMapping
	public ResponseEntity<UsuarioModel> criar(@RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> buscarTodos() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> buscarUm(@PathVariable Long id) {
		return repository.findById(id).map(usuarioId -> ResponseEntity.ok(usuarioId))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Optional<UsuarioModel>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioModel> atualizar(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
		usuario.setIdUsuario(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}


	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id) {
		try {
			repository.deleteById(id);
		return "sucesso";
		}catch(Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
	
}
