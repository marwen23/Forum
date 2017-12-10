package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import Entities.User;
import mbeans.UserBean;


@FacesConverter("uc")
public class UserConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		UserBean userBean = context.getApplication().evaluateExpressionGet(context, "#{userBean}",
				UserBean.class);
		User user = userBean.doFindUserByUsername(value);

		return user;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String string = null;
		if (value instanceof User) {
			string=((User) value).getUsername();
		}
		
		return string;
	}

}
