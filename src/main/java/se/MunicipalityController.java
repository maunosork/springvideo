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
public class MunicipalityController {
	@Autowired
	private MunicipalityRepository repository;
    /*@RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }*/
    
    
    /** Metodi saa parametrinaan json-muodossa kunnan ja tallentaa sen tiedot kantaan */
    /** Tässä esimerkki JSON: {"id":1,"fid":0,"fid2":0,"mid":0,"name":"Kunta","nameswedish":"Kommun","x":0.0,"y":0.0}
    * @param jsonProject
    * @return
    */
    @RequestMapping(value = "/municipality" , method = RequestMethod.POST)
    public @ResponseBody Municipality addProject(@RequestBody Municipality jsonProject) {
      return repository.save(jsonProject);
    }
    
    @RequestMapping("/municipalities")
    public Iterable<Municipality> municipalities(@RequestParam(value="name", defaultValue="World") String name) {
        return repository.findAll();
    }
    
    @RequestMapping("/municipality/{mid}")
    public Municipality getMunicipality(@PathVariable("mid") int mid) {
    return repository.findOne(mid);
    }
    
    @RequestMapping(value = "/municipality" , method = RequestMethod.DELETE)
    public void deleteProject(@RequestBody Municipality jsonProject) {
       repository.delete(jsonProject);
    }
    
    /*@RequestMapping(value = "/municipality" , method = RequestMethod.PUT)
    public @ResponseBody Municipality putProject(@RequestBody Municipality jsonProject) {
      return repository.put(jsonProject);
    }*/
}
