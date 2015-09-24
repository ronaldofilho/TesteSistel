package sistel.phoneCall;

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
@RequestMapping("/phoneCall")
public class PhoneCallController {

	@Autowired
    PhoneCallRepository phoneCallRepository;

	@RequestMapping
	Collection<PhoneCall> findAll() {
        return phoneCallRepository.findAll();
	}

    @RequestMapping(method = RequestMethod.POST)
    public PhoneCall save(@RequestBody @Valid PhoneCall telefonema) {
        return phoneCallRepository.saveAndFlush(telefonema);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public PhoneCall get(@PathVariable("id") long id) {
        return phoneCallRepository.findOne(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public PhoneCall update(@PathVariable("id") long id, @RequestBody @Valid PhoneCall telefonema) {
        return phoneCallRepository.save(telefonema);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
        phoneCallRepository.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
