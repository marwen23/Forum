package mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import Entities.Content;
import Services.ContentServicesLocal;


@ManagedBean(name="search")
@SessionScoped
public class SearchBean implements Serializable {

	@EJB
	private ContentServicesLocal contentServicesLocal;
	
	
	@ManagedProperty(value = "#{identity}")
	private Identity identity;
	
	private Content selectedContent;
	
	
	
	private String searchKeyword;
	private List<Content> searchedContents;
	
	@PostConstruct
    public void init() {	
		
		searchedContents = new ArrayList<>();
		
    }
	
	

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}



	public ContentServicesLocal getContentServicesLocal() {
		return contentServicesLocal;
	}

	public void setContentServicesLocal(ContentServicesLocal contentServicesLocal) {
		this.contentServicesLocal = contentServicesLocal;
	}

	public Content getSelectedContent() {
		return selectedContent;
	}

	public void setSelectedContent(Content selectedContent) {
		this.selectedContent = selectedContent;
	}

	
	
public String SearchMovie() {
	searchedContents = new ArrayList<>();
	searchedContents = contentServicesLocal.searchContent(searchKeyword);
	
		String navigateTo = "";
		navigateTo = "/pages/user/searchResults?faces-redirect=true";

	return navigateTo;
	}

public String getSearchKeyword() {
	return searchKeyword;
}

public void setSearchKeyword(String searchKeyword) {
	this.searchKeyword = searchKeyword;
}

public List<Content> getSearchedContents() {
	return searchedContents;
}

public void setSearchedContents(List<Content> searchedContents) {
	this.searchedContents = searchedContents;
}
	
	
	
}
