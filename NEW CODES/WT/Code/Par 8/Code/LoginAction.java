package com.myapp.struts;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.action.ActionMessage;
public class LoginAction extends ActionSupport {
    
    private String name;
    private String mobileno;
    private String email;

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String string) {
        name = string;
    }

    public LoginAction() {
        super();
    }
     public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (name == null || name.trim().equals("")) {
            errors.add("name", new ActionMessage("error.name.required"));
        } else if (!name.matches("[a-zA-Z ]+")) {
            errors.add("name", new ActionMessage("error.name.invalid"));
        }

        if (mobileno == null || mobileno.trim().equals("")) {
            errors.add("mobile", new ActionMessage("error.mobile.required"));
        } else if (!mobileno.matches("\\d{10}")) {
            errors.add("mobile", new ActionMessage("error.mobile.invalid"));
        }

        if (email == null || email.trim().equals("")) {
            errors.add("email", new ActionMessage("error.email.required"));
        } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            errors.add("email", new ActionMessage("error.email.invalid"));
        }

        return errors;
    }
}
