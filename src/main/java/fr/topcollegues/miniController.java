package fr.topcollegues;

import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class miniController {
	
	@Autowired
	MiniService srv; 
	
	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.POST)
	public Collegues trouverCollegue (@RequestBody Collegues c, HttpServletResponse response) throws URISyntaxException {
		
		return srv.recupColEnEntier(c.getEmail(),c.getMotDePasse(), response); 
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET)
	public List<Collegues> toutesLesPhotos() {
		 
		return srv.trouverInfos();  
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(path = "likes", method = RequestMethod.PATCH)
	public  Collegues modifierScore(@RequestParam("email") String email) throws Exception {
		return srv.modifierScore(email);
			
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(path="dislikes", method = RequestMethod.PATCH)
	public Collegues diminuerScore(@RequestParam("email") String email) throws Exception {
		
		return srv.diminuerScore(email); 
	}
	 
	
	

}
