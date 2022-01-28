package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.ArticleLocalRepository;
import com.inventry.project.datasource2.repo.IHistoriqueLivraison;
import com.inventry.project.datasource2.repo.LivraisonRepository;
import com.inventry.project.datasource2.repo.ReceptionRepository;
import com.inventry.project.model.Article;
import com.inventry.project.model.HistoriqueLivraison;
import com.inventry.project.model.Livraison;
import com.inventry.project.model.LvraisonKey;
import com.inventry.project.model.Reception;

@Service
@Transactional
public class LivraisonService {
	
	@Autowired
	LivraisonRepository livraisonrpository;
	
	@Autowired
	ReceptionRepository receptionrepository;
	
	@Autowired
	ArticleLocalRepository articlerepository;
	
	public Livraison addLivraison(Livraison livraison) {
		/*Article article = this.articlerepository.findById(livraison.getArticle().getNumarticle()).get();
		Reception reception = this.receptionrepository.findById(livraison.getReception().getId_reception()).get();
		livraison.setArticle(article);
		livraison.setReception(reception);*/
		return this.livraisonrpository.save(livraison);
	}
	
	public void deleteLivraison(Livraison livraison) {
		LvraisonKey livraisonkey = new LvraisonKey(livraison.getReception().getId_reception(),livraison.getArticle().getNumarticle());
		 this.livraisonrpository.deleteById(livraisonkey);
		//Reception reception= this.receptionrepository.findById(livraison.getReception().getId_reception()).get();
		//Article article = this.articlerepository.findById(livraison.getArticle().getNumarticle()).get();
		//this.livraisonrpository.deleteByReceptionAndArticle(reception , article );
	}
	
	public List<Long> getnumarticles(Long idreception){
		return this.livraisonrpository.getnumarticles(idreception);
	}
	/*public Reception addLivraison(Reception reception) {
		Reception reception2= this.receptionrepository.findById(reception.getId_reception()).get();
		List<Livraison> livraisons= reception.getLivraisons();
		for(int i=0;i < livraisons.size();i++) {
			Livraison livraison = new Livraison(livraisons.get(i).getReception()
					,livraisons.get(i).getArticle(),
					livraisons.get(i).getQuantite());
			this.livraisonrpository.save(livraison);;
		}
		return receptionrepository.save(reception2);
	} */
	
	public List<IHistoriqueLivraison> gethstoriquelivraison(String reference){
		
		return this.livraisonrpository.gethstoriquelivraison(reference);
	}
}
