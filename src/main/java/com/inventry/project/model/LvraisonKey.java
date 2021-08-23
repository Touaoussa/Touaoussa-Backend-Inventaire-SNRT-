package com.inventry.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LvraisonKey implements Serializable {

	@Column(name = "reception_id")
    Long receptionId;

    @Column(name = "article_id")
    Long articleId;

    public LvraisonKey() {
    	
    }
	public LvraisonKey(Long receptionId, Long articleId) {
		super();
		this.receptionId = receptionId;
		this.articleId = articleId;
	}
	public Long getReceptionId() {
		return receptionId;
	}
	public void setReceptionId(Long receptionId) {
		this.receptionId = receptionId;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleId == null) ? 0 : articleId.hashCode());
		result = prime * result + ((receptionId == null) ? 0 : receptionId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LvraisonKey other = (LvraisonKey) obj;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		if (receptionId == null) {
			if (other.receptionId != null)
				return false;
		} else if (!receptionId.equals(other.receptionId))
			return false;
		return true;
	}
    
	
	
    

    // standard constructors, getters, and setters
    // hashcode and equals implementation
    
}
