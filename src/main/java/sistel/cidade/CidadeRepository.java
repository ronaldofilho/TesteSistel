package sistel.cidade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	List<Cidade> findAll();
	
	Cidade findByIbge(Cidade ibge);
	
}
