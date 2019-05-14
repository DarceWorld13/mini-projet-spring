package fr.topcollegues;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@Service
public class MiniService {
	
	@Autowired
	MiniRepo minR;
	

	@Value("${jwt.expires_in}")
	  private Integer EXPIRES_IN;

	  @Value("${jwt.cookie}")
	  private String TOKEN_COOKIE;

	  @Value("${jwt.secret}")
	  private String SECRET; 

	public MiniRepo getMinR() {
		return minR;
	}

	public void setMinR(MiniRepo minR) {
		this.minR = minR;
	}

	public MiniService(MiniRepo minR) {
		super();
		this.minR = minR;
	} 
	
	
	
	
public Collegues recupColEnEntier(String email, String motDePasse, HttpServletResponse response) throws URISyntaxException {
	
	RestTemplate restTemplate = new RestTemplate();
	
	HttpEntity<Collegues> request = new HttpEntity<>(new Collegues(email, motDePasse));
	
	ResponseEntity<Collegues> result = restTemplate.postForEntity("https://amadou--collegues-api.herokuapp.com/auth", request, Collegues.class);
	
	HttpHeaders headers = result.getHeaders();
	List<String> list = headers.get("Set-Cookie");
	
	RequestEntity<?> request2 = RequestEntity.get(new URI("https://amadou--collegues-api.herokuapp.com/me")).header("Cookie", list.get(0)).build();
	
	ResponseEntity<Collegues> reponse2 = restTemplate.exchange(request2, Collegues.class);
	
	Cookie authCookie = new Cookie(TOKEN_COOKIE, list.get(0).split(";")[0].split("=")[1]);

	authCookie.setHttpOnly(true);

	authCookie.setMaxAge(EXPIRES_IN * 1000);

	authCookie.setPath("/");

	response.addCookie(authCookie);
	
	minR.save(reponse2.getBody()); 
	
	return reponse2.getBody()  ; 
}
	

public List<Collegues>trouverInfos(){
	return minR.findAll()
			.stream()
			.map((collegue)->new Collegues(collegue.getEmail(), collegue.getNom(), collegue.getPrenoms(),collegue.getPhotoUrl(), collegue.getScore(), collegue.getRoles()))
			.collect(Collectors.toList()); 
	 
}


@Transactional
public Collegues modifierScore(String email) throws Exception {
	
	Optional<Collegues> collegueTrouv = minR.findByEmail(email); 
	
	Collegues col = collegueTrouv.orElseThrow(() -> new Exception("collegue non trouvé !"));

	col.setScore(col.getScore()+1);
	
	return col; 
	
}
 

@Transactional
public Collegues diminuerScore(String email) throws Exception {
	
Optional<Collegues> collegueTrouv = minR.findByEmail(email); 
	
	Collegues col = collegueTrouv.orElseThrow(() -> new Exception("collegue non trouvé !"));

	col.setScore(col.getScore()-1);
	
	return col;
	
}




	
}
