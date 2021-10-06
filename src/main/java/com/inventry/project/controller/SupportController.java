package com.inventry.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventry.project.model.*;
import com.inventry.project.service.MyUserDetailsService;
import com.inventry.project.service.SupportService;
import com.inventry.project.support.repo.SupportacquistionRepository;
import com.inventry.project.util.JwtUtil;
import com.inventry.project.configuration.*;
import com.inventry.project.datasource2.repo.ArticleLocalRepository;
import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.direction.repo.DirectionRepository;
import com.inventry.project.firstdatasource.repo.ArticleJdeRepository;
import com.inventry.project.security.*;
@CrossOrigin
@RestController
@RequestMapping("/microservice1")
@EnableTransactionManagement
public class SupportController {
	
	//@Autowired
	//DirectionRepository directionrepository ;
	@Autowired
	SupportacquistionRepository supportacquistionRepository ;
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	@Autowired
	ArticleJdeRepository articlejderepository;
	
	@Autowired
	ArticleLocalRepository articlelocalrepository;
	
	
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService myUserDetailsService ;
	
	@Autowired
	SupportService supportservice;
	
	@Autowired
	JwtUtil jwtTokenutil;
	
	int test3;

	
	/*@GetMapping("/")
	public void getAllDirections() {
		
	}*/
	
	@Transactional
	public Supportacquistion Recupérer_support_acquisition(){
		List<Supportacquistion> listsupportacquistion =  supportacquistionRepository.getsupports();
		return listsupportacquistion.get(0);
	}
	
	
	@GetMapping("/Supportacquistion")
	public Supportacquistion add_support_acquisition(){
		Supportacquistion supportacquisition = this.Recupérer_support_acquisition();
		//Supportacquistion supportacquisition = new Supportacquistionlocal(supportacquisition.getReference(),supportacquisition.getType());
		supportacquistionRepository2.save(supportacquisition);
		return supportacquisition;		
	}
	
	/*@GetMapping("/{intitule}")
	public Object Recupérer_nombre_personnel(@PathVariable String intitule){
		//Direction direction=directionrepository.findByIntitule(intitule);
		List<Object> listsupportacquistion =  supportacquistionRepository.getsupports();
		return listsupportacquistion.get(0);
	}*/
	
/*	@GetMapping("/{Supportacquistion}")
		public Object Recupérer_support_acquisition(){
		List<Object> listsupportacquistion =  supportacquistionRepository.getsupports();
		//Long nbr = supportacquistionRepository.count();
		return listsupportacquistion.get(0);
	}*/
	
	@RequestMapping(value = "/authenticate" , method =RequestMethod.POST)
	public AuthenticationResponse createAthenticationToken(@RequestBody AuthenticationRequest authenticationrequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationrequest.getUsername() ,authenticationrequest.getPassword())
					);
		}catch(BadCredentialsException e) {
			throw new Exception("le login ou le mot de passe est erroné",e);
		}
		
		final Utilisateur userDetails =(Utilisateur) myUserDetailsService
				.loadUserByUsername(authenticationrequest.getUsername());
		final String jwt = jwtTokenutil.generateToken(userDetails);
		
		return new AuthenticationResponse(jwt,Constants.ACCESS_TOKEN_VALIDITY_SECONDS,userDetails.getUsername(), userDetails.getMatricule(),userDetails.getAuthorities());
	}
	

	
	 @PostMapping(path = "/uploadfile/support/") 
	    public Map<String,Object> uploadPhoto(MultipartFile file) throws Exception{
	        String name=file.getOriginalFilename();
	        int i= name.lastIndexOf(".");
	        if (i<0) throw new Exception();
	        name= Calendar.getInstance().getTimeInMillis()+name.substring(i);
	       // Files.write(Paths.get(System.getProperty("user.home")+"/upload/support/"+name),file.getBytes());
	        Files.write(Paths.get(System.getProperty("user.dir")+"/upload/support/"+name),file.getBytes());
	        Map<String,Object> resp=new HashMap<>();
	        resp.put("path",name);
	        return resp;
	    }
	 
	 
	 
	 @PostMapping(path = "/setarticles") 
	    public List<ArticleJde> AddArticles(@RequestBody Supportacquistion supportacquisition) throws Exception{
		List<ArticleJde> articles = articlejderepository.getarticles(supportacquisition.getReference(),supportacquisition.getType());
		double prix =articles.get(0).getPrixunitaire();
		//System.out.println(String.format("%1.2f",prix));
		System.out.println(prix/10000);
		
		for(int i=0; i < articles.size();i++) {
			
			/*articles.get(i).setQuantite(articles.get(i).getQuantite());
			System.out.println(articles.get(i).getQuantite());
			articles.get(i).setPrixunitaire(articles.get(i).getPrixunitaire());
			articles.get(i).setPrixtotal(articles.get(i).getPrixtotal());
			*/
			articles.get(i).setQuantite(articles.get(i).getQuantite()/100);
			System.out.println(articles.get(i).getQuantite()/100);
			articles.get(i).setPrixunitaire(articles.get(i).getPrixunitaire()/10000);
			articles.get(i).setPrixtotal(articles.get(i).getPrixtotal()/100);
		} 
		
		for(int i=0; i < articles.size();i++) {
		Article article = new Article(articles.get(i).getNumarticle(),
				articles.get(i).getNomarticle(),
				articles.get(i).getDescription(),
				articles.get(i).getQuantite(),
				articles.get(i).getPrixunitaire(),
				articles.get(i).getPrixtotal(),
				new Supportacquistion(articles.get(i).getSupport_id())
				);
		this.supportacquistionRepository2.save(supportacquisition);
		articlelocalrepository.save(article);
		}
		 return articles;
	    }
	
	 
	 
	
	
	 /*@PostMapping(path = "/setarticles") 
	    public Supportacquistion AddArticles(@RequestBody Supportacquistion supportacquisition) throws Exception{
		
		return this.supportacquistionRepository2.save(supportacquisition);
	    }*/
	 
	 
	 @PostMapping(path = "/setarticles2") 
	    public Article AddArticle(@RequestBody Article article) throws Exception{	
		return articlelocalrepository.save(article);
		}
	 
	 @GetMapping("/getarticles") 
	    public List<Supportacquistion> GetAllArticles() throws Exception{	
		//return this.articlelocalrepository.findAll();
		 return this.supportservice.findsupports();
		} 
		
	    
	 @GetMapping(value = "/FileSupport/{reference}",produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource>  File(@PathVariable (name ="reference")Long reference)throws Exception{
		 Supportacquistion supportacquistion=supportacquistionRepository2.findById(reference).get();
	       /* String FileName=supportacquistion.getPath();
	        File file=new File(System.getProperty("user.home")+"/upload/support/"+FileName);
	        Path path= Paths.get(file.toURI());
	        System.out.println(path);
	        return Files.readAllBytes(path);*/
		 String FileName=supportacquistion.getPath();
		 String filepath =System.getProperty("user.dir")+"/upload/support/"+ FileName;
		 File file = new File(filepath);
	      HttpHeaders headers = new HttpHeaders();      
	      headers.add("content-disposition", "inline;filename=" +FileName);
	        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	        return ResponseEntity.ok()
	                .headers(headers)
	                .contentLength(file.length())
	                .contentType(MediaType.parseMediaType("application/pdf"))
	                .body(resource);
		
	    }
	 
	
	
	 
}
