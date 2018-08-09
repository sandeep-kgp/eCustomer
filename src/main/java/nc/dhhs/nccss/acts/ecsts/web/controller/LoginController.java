package nc.dhhs.nccss.acts.ecsts.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login.htm")

    public String userLogIn(HttpServletRequest request, Model model)

    {
		System.out.println("Login Page User");
            return "login";

    }

	@RequestMapping(value = "/logout.htm")

    public String userLogOut(Model model)

    {
		System.out.println("Logout Page ");
            return "logout";

    }
	
	
	@RequestMapping(value = "/accessdenied.htm")

    public String userAceesDeniedt(Model model)

    {
		System.out.println("Access denied Page ");
            return "accessdenied";

    }
	
	@RequestMapping(value = "/welcome.htm")

    public String LoginSuccess(Model model)

    {
		System.out.println("Login Success go to Welcome Page");
            return "welcome";

    }
}
