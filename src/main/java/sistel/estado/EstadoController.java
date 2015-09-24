package sistel.estado;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	EstadoRepository estadoRepository;

	@RequestMapping
	public Collection<Estado> findAll(){
		return estadoRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Estado get(@PathVariable("id") long id){
		return estadoRepository.findOne(id);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Estado save(@RequestBody Estado estado){
		return estadoRepository.saveAndFlush(estado);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Estado update(@PathVariable("id") long id,@RequestBody Estado estado){
		return estadoRepository.save(estado);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		estadoRepository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
