package RedeOrganizacional.Recomece.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import RedeOrganizacional.Recomece.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long>{
	
	public List<TemaModel> findByCategoriaContainingIgnoreCase(String categoria);
}
