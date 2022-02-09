package com.inventry.project.model;

import java.util.List;

import com.inventry.project.DTO.PvreceptionDto;

public class PvArticle {
	 PvreceptionDto pv;
	 List<Article> articles;
 
	public PvArticle() {
		super();
	}
	public PvArticle(PvreceptionDto pv, List<Article> articles) {
		super();
		this.pv = pv;
		this.articles = articles;
	}
	public PvreceptionDto getPv() {
		return pv;
	}
	public void setPv(PvreceptionDto pv) {
		this.pv = pv;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticle(List<Article> articles) {
		this.articles = articles;
	}
	 
 
}
