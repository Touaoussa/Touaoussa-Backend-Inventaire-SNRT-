package com.inventry.project.DTO;

import com.inventry.project.model.Article;
import com.inventry.project.model.Reception;

public class LivraisonDto {
	 Reception reception;
	 Article article;
	 int quantite;
	 
	public LivraisonDto() {
		super();
	}

	public LivraisonDto(Reception reception, Article article, int quantite) {
		super();
		this.reception = reception;
		this.article = article;
		this.quantite = quantite;
	}

	public Reception getReception() {
		return reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	 
	
	
}
