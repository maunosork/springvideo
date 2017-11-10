package se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensordataController {
	@Autowired
	private SensordataRepository repository;
  /*  @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }*/
    
    @RequestMapping("/sensordatas")
    public Iterable<Sensordata> sensordatas(@RequestParam(value="name", defaultValue="World") String name) {
        return repository.findAll();
    }
    @RequestMapping(value = "/sensordata" , method = RequestMethod.POST)
    public @ResponseBody Sensordata addProject(@RequestBody Sensordata jsonProject) {
      return repository.save(jsonProject);
    }
    
    @RequestMapping("/sensordata/{id}")
    public Sensordata getSensordata(@PathVariable("id") int id) {
    return repository.findOne(id);
    }
    
    @RequestMapping(value = "/sensordata" , method = RequestMethod.DELETE)
    public void deleteProject(@RequestBody Sensordata jsonProject) {
       repository.delete(jsonProject);
    }
}
