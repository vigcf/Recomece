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

import RedeOrganizacional.Recomece.model.PostagemModel;
import RedeOrganizacional.Recomece.model.TemaModel;
import RedeOrganizacional.Recomece.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	@PostMapping
	public ResponseEntity<TemaModel> criar(@RequestBody TemaModel tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@GetMapping
	public List<TemaModel> pesquisarTodos() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> buscarUm(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	

	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<TemaModel>> buscarPorNome (@PathVariable String categoria) {
		return ResponseEntity.ok(repository.findByCategoriaContainingIgnoreCase(categoria));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TemaModel> atualizar(@PathVariable Long id, @RequestBody TemaModel tema) {
		tema.setIdTema(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
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
