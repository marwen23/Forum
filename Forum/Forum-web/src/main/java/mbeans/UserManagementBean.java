package mbeans;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import Entities.User;
import Services.AccountManagementServicesLocal;

@ManagedBean
@ViewScoped
public class UserManagementBean {
	private User user;
	@EJB
	private AccountManagementServicesLocal accountManagementServicesLocal;

	public String doAddUser() {
		accountManagementServicesLocal.addUser(user);
		return "/login?faces-redirect=true";
	}

	@PostConstruct
	private void init() {
		user = new User();
		user.setRole("user");
		user.setEnabled(true);;
	}
	 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
