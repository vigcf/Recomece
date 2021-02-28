package RedeOrganizacional.Recomece.controller;

import java.util.List;

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

import RedeOrganizacional.Recomece.model.ComentarioModel;
import RedeOrganizacional.Recomece.repository.ComentarioRepository;



@RestController
@RequestMapping("/comentario")
@CrossOrigin("*")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository repository;
	
	@PostMapping
	public ResponseEntity<ComentarioModel> criar(@RequestBody ComentarioModel comentario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
	}
	
	@GetMapping
	public List<ComentarioModel> pesquisarTodos() {
		return repository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ComentarioModel> buscarUm(@PathVariable Long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ComentarioModel> atualizar(@PathVariable Long id, @RequestBody ComentarioModel comentario) {
		comentario.setIdComentario(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
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
