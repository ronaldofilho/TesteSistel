package sistel.cidade;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	CidadeRepository cidadeRepository;

	@RequestMapping
	public Collection<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cidade save(@RequestBody Cidade cidade) {
		return cidadeRepository.saveAndFlush(cidade);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cidade get(@PathVariable("id") long id) {
		return cidadeRepository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		cidadeRepository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Cidade update(@PathVariable("id") long id,
							@RequestBody @Valid Cidade telefonema) {
		return cidadeRepository.save(telefonema);
	}

}
