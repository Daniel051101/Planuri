package ro.upt.ac.planuri.utilizatori;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
    @GetMapping("/login")
    public String login() 
    {
        return "login";
    }
    
    @GetMapping("/signup")
    public String signup() 
    {
        return "signup";
    }
    
    @PostMapping("/signup")
    public String processSignUp(@RequestParam String username,
                                 @RequestParam String email,
                                 @RequestParam String password) 
    {
        return "redirect:/home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) 
    {
        // Invalidează sesiunea curentă
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        // Redirecționează utilizatorul după logout
        return "redirect:/home";
    }
}

