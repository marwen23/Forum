package mbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Services.ContentServicesLocal;

@ManagedBean(name="contentView")
@ViewScoped
public class ViewContent implements Serializable {
	
	@EJB
	private ContentServicesLocal contentServicesLocal;
	
	

}
