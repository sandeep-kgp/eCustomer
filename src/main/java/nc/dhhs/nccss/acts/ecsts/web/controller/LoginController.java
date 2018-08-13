package nc.dhhs.nccss.acts.ecsts.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nc.dhhs.nccss.acts.ecsts.web.form.LoginForm;

@Controller
public class LoginController {
	
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model){
		System.out.println("Redirecting to login");
		return "login";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogIn(HttpServletRequest request, @ModelAttribute("loginForm") LoginForm form, Model model){
		if (form.getUsername().equals("test") && form.getPassword().equals("test123"))
			return "welcome";
		else{
			model.addAttribute("message", "Login Failed");
			return "login";
		}
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String userLogOut(Model model){
		System.out.println("Logout Page ");
            return "logout";
    }
	
	
	@RequestMapping(value = "/accessdenied")
    public String userAceesDeniedt(Model model){
		System.out.println("Access denied Page ");
        return "accessdenied";
    }
	
	@RequestMapping(value = "/welcome")

    public String LoginSuccess(Model model)

    {
		System.out.println("Login Success go to Welcome Page");
            return "welcome";

    }
}
