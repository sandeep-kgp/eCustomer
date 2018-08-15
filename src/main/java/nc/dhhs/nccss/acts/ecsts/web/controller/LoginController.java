package nc.dhhs.nccss.acts.ecsts.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model){
		System.out.println("Redirecting to login");
		return "login";
    }
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model){
		System.out.println("Index Page");
		return "index";
    }
	
	@RequestMapping(value = {"/logout","/logout-success"})
    public String userLogOut(HttpServletRequest servletRequest){
		servletRequest.getSession(true).invalidate();
		SecurityContextHolder.clearContext();
		System.out.println("Logout Page ");
        return "logout";
    }
		
	@RequestMapping(value = "/accessdenied")
    public String userAceesDeniedt(Model model){
		System.out.println("Access denied Page ");
        return "accessdenied";
    }
	
	@RequestMapping(value = "/welcome")
    public String LoginSuccess(Model model){
		System.out.println("Login Success go to Welcome Page");
		return "welcome";
    }
}
