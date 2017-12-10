package mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.ResponsibilityOf;
import Entities.User;
import Services.AccountManagementServicesLocal;


@ManagedBean
@SessionScoped
public class Identity {
	@EJB
	private AccountManagementServicesLocal accountManagementServicesLocal;
	private Boolean loggedInAsUser = false;
	private User user = new User();
	private boolean isLogged = false;
	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = accountManagementServicesLocal.Authentification(user.getUsername(), user.getPassword());
		if (userLoggedIn != null) {
			isLogged = true;
			user = userLoggedIn;
			if ((userLoggedIn .getRole().equals("user"))&&(userLoggedIn.getEnabled()==true)) {
				loggedInAsUser = true;
				
				navigateTo = "/pages/user/home?faces-redirect=true";
				 
			}
			else if (userLoggedIn .getRole().equals("moderator")) {
				if((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.MOVIES)){
				loggedInAsUser = true;
				
				navigateTo = "/pages/moderator/homemovies?faces-redirect=true";
				}else if ((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.GAMES)){
					loggedInAsUser = true;
					
					navigateTo = "/pages/moderator/homegames?faces-redirect=true";
				}
			}else if ((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.TV)){
				loggedInAsUser = true;
				
				navigateTo = "/pages/moderator/hometv?faces-redirect=true";
			
			}
		else if ((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.MUSIC)){
			loggedInAsUser = true;
			
			navigateTo = "/pages/moderator/homemusic?faces-redirect=true";
		
		}
				
		} else {
			   FacesMessage message=new FacesMessage("Error","login or password incorrect!");
				FacesContext.getCurrentInstance().addMessage(null, message);		
				return null;	
		}
		return navigateTo;
	}
	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsUser() {
		return loggedInAsUser;
	}

	public void setLoggedInAsUser(Boolean loggedInAsUser) {
		this.loggedInAsUser = loggedInAsUser;
	}

	  public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
	    }
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
