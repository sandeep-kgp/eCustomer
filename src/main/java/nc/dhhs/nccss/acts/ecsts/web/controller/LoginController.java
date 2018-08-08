package nc.dhhs.nccss.acts.ecsts.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login.htm")

    public String userLogin(Model model)

    {
		System.out.println("Login Page ");
            return "login";

    }

	
	@RequestMapping(value = "/welcome.htm")

    public String LoginSuccess(Model model)

    {
		System.out.println("Login Success go to Welcome Page");
            return "welcome";

    }
}
