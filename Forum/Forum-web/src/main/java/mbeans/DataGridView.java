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


@ManagedBean(name="grid")
@ViewScoped
public class DataGridView implements Serializable {

	@EJB
	private ContentServicesLocal contentServicesLocal;
	
	private List<Content> contents = new ArrayList<>();
	
	@ManagedProperty(value = "#{identity}")
	private Identity identity;
	
	private Content selectedContent;
	
	private Content contentToAdd;
	
	
	private String searchKeyword;
	private List<Content> searchedContents;
	
	@PostConstruct
    public void init() {	
		contents = new ArrayList<>();
		contents = contentServicesLocal.findAllContents();
		searchedContents = new ArrayList<>();
		
    }
	
	public List<Content> contents(){
		contents=contentServicesLocal.findAllContents();
		return contents;
	}

	public List<Content> getContents() {
		return contents;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public void setAllContent(List<Content> contents) {
		this.contents = contents;
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

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	public String goToAddMovie() {
		
		String navigateTo = "";
		navigateTo = "/pages/user/addContent?faces-redirect=true";

	return navigateTo;
	}

	public Content getContentToAdd() {
		return contentToAdd;
	}

	public void setContentToAdd(Content contentToAdd) {
		this.contentToAdd = contentToAdd;
	}
	
	public String doAddContent() {
		contentServicesLocal.addContentWeb(contentToAdd);
		String navigateTo = "";
		navigateTo = "/pages/user/addContent?faces-redirect=true";

	return navigateTo;
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
