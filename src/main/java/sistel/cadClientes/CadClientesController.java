package sistel.cadClientes;

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
@RequestMapping("/clientes")
public class CadClientesController {

	@Autowired
	CadClientesRepository cadClientesRepository;
	
	@RequestMapping
	public Collection<CadClientes> findAll(){
		return cadClientesRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public CadClientes get(@PathVariable("id") Long id){
		return cadClientesRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CadClientes save(@RequestBody CadClientes cadClientes){
		return cadClientesRepository.saveAndFlush(cadClientes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CadClientes update(@PathVariable("id") long id, 
							  @RequestBody CadClientes cadClientes	){
		return cadClientesRepository.save(cadClientes);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
		cadClientesRepository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);		
	}
	
}
