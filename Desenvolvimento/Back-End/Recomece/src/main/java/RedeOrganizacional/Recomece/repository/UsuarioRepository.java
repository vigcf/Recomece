package RedeOrganizacional.Recomece.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import RedeOrganizacional.Recomece.model.UsuarioModel;


public interface UsuarioRepository extends JpaRepository <UsuarioModel, Long> {
		public Optional<UsuarioModel> findByNomeContainingIgnoreCase(String nome);

		public Optional<UsuarioModel> findByUserName(String userName);
}