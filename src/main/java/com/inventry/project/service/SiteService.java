package com.inventry.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.SiteRepository;
import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.support.repo.SupportacquistionRepository;

@Service
@Transactional
public class SiteService {

	@Autowired
	SiteRepository siterepository;
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	
	public List<Site> findallsites(){
		return this.siterepository.findAll();
	}
	
	public Site addsite(Site site )
	{
		return this.siterepository.save(site);
	}
	
	
	public Supportacquistion affectersite(Supportacquistion supportacquistion) {
		Supportacquistion supportacquistion2 = this.supportacquistionRepository2.findByReference(supportacquistion.getReference());
		supportacquistion2.setSites(supportacquistion.getSites());
		return this.supportacquistionRepository2.save(supportacquistion2);
		/*for(int i=0;i < supportacquistion.getArticles().size();i++) {
			supportacquistion.getArticles().get(i).setSupport(supportacquistion);
		}
		return this.supportacquistionRepository2.save(supportacquistion);*/
		//supportacquistion.setSites();
	}
	
	
	/*public Supportacquistion affectersite(Supportacquistion supportacquistion) {
		for(int i=0;i < supportacquistion.getArticles().size();i++) {
			supportacquistion.getArticles().get(i).setSupport(supportacquistion);
		}
		return this.supportacquistionRepository2.save(supportacquistion);
	}
	*/
	public Optional<Supportacquistion> findsupportbyrefernce(Long reference) {
		return this.supportacquistionRepository2.findById(reference);
	}
	
	public List<Site> findsitebyresponsable(Long matricule){
		return this.siterepository.getsitebyresponsable(matricule);
	}

}
