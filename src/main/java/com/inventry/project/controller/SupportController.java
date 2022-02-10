package com.inventry.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventry.project.model.*;
import com.inventry.project.service.MyUserDetailsService;
import com.inventry.project.service.SupportService;
import com.inventry.project.support.repo.SupportacquistionRepository;
import com.inventry.project.util.JwtUtil;
import com.inventry.project.DTO.SupportacquistionDto;
import com.inventry.project.Exception.BadRequestException;
import com.inventry.project.configuration.*;
import com.inventry.project.datasource1.repo.ArticleJdeRepository;
import com.inventry.project.datasource2.repo.ArticleLocalRepository;
import com.inventry.project.datasource2.repo.FournisseurRepository;
import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.direction.repo.DirectionRepository;
import com.inventry.project.security.*;
//@CrossOrigin
@RestController
@RequestMapping("/microservice1")
@EnableTransactionManagement
public class SupportController {
	
	//@Autowired
	//DirectionRepository directionrepository ;
	@Autowired
	SupportacquistionRepository supportacquistionRepository ;
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2  ;
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
	FournisseurRepository fournisseurrepository;
	
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
	
	 @GetMapping(value = "/support") 
	    public Supportacquistion Getsupportreference(@RequestParam (name ="reference") String reference) throws Exception{	
		//return this.articlelocalrepository.findAll();
		 return this.supportservice.findsupportbyid(reference);
		} 
	

	@RequestMapping(value = "/authenticate" , method =RequestMethod.POST)
	public AuthenticationResponse createAthenticationToken(@RequestBody AuthenticationRequest authenticationrequest) throws Exception,BadRequestException{
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
	

	 
	 
	 @PostMapping(path = "/setarticles") 
	    public List<ArticleJde> AddArticles(@RequestBody SupportacquistionDto supportacquisitiondto) throws Exception{
		 
	
		 /*********************Déja existé ********************/
		 
		if( this.supportacquistionRepository2.existsByReference(supportacquisitiondto.getReference() )){
			List<ArticleJde> articles ;
			String[] arr = new String [] {"M1", "M2", "M3", "M4","M5","M6","M7","M8","M9"};
			if( Arrays.asList(arr).contains(supportacquisitiondto.getType()) ) {
				System.out.println(supportacquisitiondto.getType());
			//	return null;
				
			articles = articlejderepository.getarticlesMarche(supportacquisitiondto.getReference(),supportacquisitiondto.getType());
			}
			else {
				 articles = articlejderepository.getarticles(supportacquisitiondto.getReference(),supportacquisitiondto.getType());
			}
			
			
			/*******************Ajout des supports ***************/
			
			Supportacquistion supportacquistion =new Supportacquistion();
			Direction d= new Direction();
			d.setIddirection(Long.valueOf(1));
			supportacquisitiondto.setDirection(d);
			
			Fournisseur f =new Fournisseur();
			f.setNomfournisseur(articles.get(0).getFournisseur());
			Fournisseur f2=fournisseurrepository.save(f);
			supportacquisitiondto.setFournisseur(f);
			
			supportacquistion.setReference(supportacquisitiondto.getReference());
			supportacquistion.setType(supportacquisitiondto.getType());
			supportacquistion.setPath(supportacquisitiondto.getPath());
			supportacquistion.setDirection(supportacquisitiondto.getDirection());
			supportacquistion.setFournisseur(supportacquisitiondto.getFournisseur());
			
			 this.supportacquistionRepository2.save(supportacquistion);

			
			  return articles ;
			
		}
		
		
		
		/**********************Non existé ***************/
		
		
		List<ArticleJde> articles = new ArrayList<ArticleJde>() ;
		String[] arr = new String [] {"M1", "M2", "M3", "M4","M5","M6","M7","M8","M9"};
		if( Arrays.asList(arr).contains(supportacquisitiondto.getType()) ) {
			System.out.println("yes");
		articles = articlejderepository.getarticlesMarche(supportacquisitiondto.getReference(),supportacquisitiondto.getType());
		}
		else {
			System.out.println("no");
			 articles = articlejderepository.getarticles(supportacquisitiondto.getReference(),supportacquisitiondto.getType());
		}
		
		/*******************Ajout des supports ***************/
	
		Supportacquistion supportacquistion =new Supportacquistion();
		Direction d= new Direction();
		d.setIddirection(Long.valueOf(1));
		supportacquisitiondto.setDirection(d);
		
		Fournisseur f =new Fournisseur();
	//	f.setIdfournisseur(Long.valueOf(1));
		f.setNomfournisseur(articles.get(0).getFournisseur());
		Fournisseur f2=fournisseurrepository.save(f);
		supportacquisitiondto.setFournisseur(f);
		
		supportacquistion.setReference(supportacquisitiondto.getReference());
		supportacquistion.setType(supportacquisitiondto.getType());
		supportacquistion.setPath(supportacquisitiondto.getPath());
		supportacquistion.setDirection(supportacquisitiondto.getDirection());
		supportacquistion.setFournisseur(supportacquisitiondto.getFournisseur());
		
		 this.supportacquistionRepository2.save(supportacquistion);

		/**********Ajout des articles *****************/
		 
		for(int i=0; i < articles.size();i++) {
			//System.out.println("num article= "+articles.get(i).getNumarticle());
		Article article = new Article(
				articles.get(i).getNumarticle(),
				articles.get(i).getNomarticle(),
				articles.get(i).getDescription(),
				articles.get(i).getQuantite(),
				articles.get(i).getPrixunitaire(),
				articles.get(i).getPrixtotal(),
				supportacquistion
				);
		articlelocalrepository.save(article);
		}
	 return articles ;
	    }
	

	 
	
	

	 @GetMapping("/getarticles") 
	    public List<Supportacquistion> GetAllArticles() throws Exception{	 
		//return this.articlelocalrepository.findAll();
		 return this.supportservice.findsupports();
		} 
	 
	 /*upload File */
	 @PostMapping(path = "/uploadfile/support/") 
	    public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
	        String name=file.getOriginalFilename();
	        int i= name.lastIndexOf(".");
	        if (i<0) throw new Exception();
	        name= Calendar.getInstance().getTimeInMillis()+name.substring(i);
	       // Files.write(Paths.get(System.getProperty("user.home")+"/upload/support/"+name),file.getBytes());
	        Files.write(Paths.get(System.getProperty("user.dir")+"/upload/support/"+name).normalize(),file.getBytes());
	        Map<String,Object> resp=new HashMap<>();
	        resp.put("path",name);
	        return resp;
	    }
	 
	 
	 
	 /*GetFile */
		
	    
	 @GetMapping(value = "/FileSupport",produces = MediaType.APPLICATION_PDF_VALUE)
	 
	    public ResponseEntity<InputStreamResource>  File(@RequestParam (name ="reference")String reference)throws Exception{
		 Supportacquistion supportacquistion=supportacquistionRepository2.findByReference(reference);
		 System.out.println(reference);
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
	      headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
	      //headers.add("Authorization", "Bearer "+token);
	      //headers.setBearerAuth("Bearer "+ token);
	        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	        return ResponseEntity.ok()
	                .headers(headers)
	                .contentLength(file.length())
	                .contentType(MediaType.parseMediaType("application/pdf"))
	                .body(resource);
	    }
	  
}
