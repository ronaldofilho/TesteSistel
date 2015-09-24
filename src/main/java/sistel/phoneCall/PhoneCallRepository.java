package sistel.phoneCall;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneCallRepository extends JpaRepository<PhoneCall, Long> {
    //exemplo como filtrar pela descricao
    List<PhoneCall> findByDescription(String description);

    //como pesquisar todos registros, n precisa implementar
    //so com a interface o Spring data já faz o resto
    List<PhoneCall> findAll();
}
