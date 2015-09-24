package sistel.cadClientes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CadClientesRepository extends JpaRepository<CadClientes, Long>{
	List<CadClientes> findAll();
	
	CadClientes findById(Long id);
}
