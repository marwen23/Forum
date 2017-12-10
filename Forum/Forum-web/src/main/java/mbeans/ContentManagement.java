package mbeans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import Entities.Content;
import Services.ContentServicesLocal;


@ManagedBean(name="contentManagement")
@ViewScoped
public class ContentManagement implements Serializable {

	@EJB
	private ContentServicesLocal contentServicesLocal;
	
	
	@ManagedProperty(value = "#{identity}")
	private Identity identity;
		
	private Content contentToAdd;
    public static Content ContentToEdit;
	
	

public static Content singleContent;
	
	public Content getSingleContent() {
		return singleContent;
	}

	public void setSingleContent(Content singleContent) {
		this.singleContent = singleContent;
	}



	private UploadedFile file;
	private UploadedFile fileToEdit=null;
	 
   
	public UploadedFile getFile() {
		return file;
	}




	public void setFile(UploadedFile file) {
		this.file = file;
	}




	@PostConstruct
    public void init() {
		contentToAdd = new Content();
	//	singleContent = new Content();
		
		
		
    }
	
	
	
	
	public Content getContentToAdd() {
		return contentToAdd;
	}

	public void setContentToAdd(Content contentToAdd) {
		this.contentToAdd = contentToAdd;
	}
	
	
	public String doEditContent() throws FileNotFoundException{
		
		
		String navigateTo = "";
		System.out.println("ezzzzzzzzz:."+fileToEdit.getFileName()+".");

		if (fileToEdit != null)
		
		{
			
			String fileName = fileToEdit.getFileName();
		    String contentType = fileToEdit.getContentType();
		    byte[] contents = fileToEdit.getContents();
		    System.out.println("fffff"+contentType);
		    String path = "C:/Users/Marwen/git/Forum3/Forum/Forum-web/src/main/webapp/resources/img";
		    SecureRandom random = new SecureRandom();
		    String randomName = new BigInteger(130, random).toString(32);
		    
		    FileOutputStream fos = new FileOutputStream(path+"/"+randomName+".jpg");
		    try {
				fos.write(contents);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ContentToEdit.setImage(randomName+".jpg");
			
			
		}
	
		
		
	    contentServicesLocal.updateContent(ContentToEdit);
		ContentToEdit = new Content();
	
	    // ... Save it, now!
		
		navigateTo = "/pages/user/home?faces-redirect=true";

	return navigateTo;
	}
	
	public String doAddContent() throws FileNotFoundException {
		
		String navigateTo = "";
		
	
		String fileName = file.getFileName();
	    String contentType = file.getContentType();
	    byte[] contents = file.getContents();
	    System.out.println("fffff"+contentType);
	    String path = "C:/Users/Marwen/git/Forum3/Forum/Forum-web/src/main/webapp/resources/img";
	    SecureRandom random = new SecureRandom();
	    String randomName = new BigInteger(130, random).toString(32);
	    
	    FileOutputStream fos = new FileOutputStream(path+"/"+randomName+".jpg");
	    try {
			fos.write(contents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    contentToAdd.setImage(randomName+".jpg");
	    contentServicesLocal.addContentWeb(contentToAdd);
		contentToAdd = new Content();
	
	    // ... Save it, now!
		
		navigateTo = "/pages/user/home?faces-redirect=true";

	return navigateTo;
	}
	
	public String doDeleteContent(Content contentToDelete) {
		
		System.out.println("ahhahahahahah");
		contentServicesLocal.deleteContent(contentToDelete);
		
		String navigateTo="";
		navigateTo = "/pages/user/home?faces-redirect=true";
		return navigateTo;
		
	}


	
	
	

	public ContentServicesLocal getContentServicesLocal() {
		return contentServicesLocal;
	}




	public void setContentServicesLocal(ContentServicesLocal contentServicesLocal) {
		this.contentServicesLocal = contentServicesLocal;
	}




	public Identity getIdentity() {
		return identity;
	}




	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	public String goToSingleContetnt(Content content)
	{
		singleContent = content;
		String navigateTo = "";
		
		System.out.println("hey: "+singleContent.getTitle());
		
		
		navigateTo = "/pages/user/displayContent?faces-redirect=true";
		
		return navigateTo;
	}
	
	public String goToEditContent(Content content)
	{
		ContentToEdit = content;
		String navigateTo = "";
		
		System.out.println("hey: "+singleContent.getTitle());
		
		
		navigateTo = "/pages/user/editContent?faces-redirect=true";
		
		return navigateTo;
	}

	public Content getContentToEdit() {
		return ContentToEdit;
	}

	public void setContentToEdit(Content contentToEdit) {
		ContentToEdit = contentToEdit;
	}

	public UploadedFile getFileToEdit() {
		return fileToEdit;
	}

	public void setFileToEdit(UploadedFile fileToEdit) {
		this.fileToEdit = fileToEdit;
	}


	
}
