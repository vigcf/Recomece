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
import RedeOrganizacional.Recomece.repository.PostagemRepository;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@PostMapping
	public ResponseEntity<PostagemModel> criar(@RequestBody PostagemModel post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	
	@GetMapping
	public List<PostagemModel> pesquisarTodos() {
		return repository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> buscarUm(@PathVariable Long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> buscarPorNome (@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(titulo));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostagemModel> atualizar(@PathVariable Long id, @RequestBody PostagemModel post) {
		post.setIdPostagem(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	
	@PutMapping
	public ResponseEntity<PostagemModel> put(@RequestBody PostagemModel tema){
		return ResponseEntity.ok(repository.save(tema));
	}

	/*
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id) {
		try {
			repository.deleteById(id);
		return "sucesso";
		}catch(Exception e) {
			return "Erro: " + e.getMessage();
		}
	}*/
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	} 

}
