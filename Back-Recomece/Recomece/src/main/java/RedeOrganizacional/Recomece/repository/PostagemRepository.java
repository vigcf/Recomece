package RedeOrganizacional.Recomece.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import RedeOrganizacional.Recomece.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	public List<PostagemModel> findByTituloContainingIgnoreCase(String titulo);

}
