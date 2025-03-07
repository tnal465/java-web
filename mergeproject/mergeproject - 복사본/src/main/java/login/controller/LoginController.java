package login.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("")
	public String login() {
		return "login/login"; //프로젝트 설정시 기능의 mapping이름입력
	}
	@GetMapping("accessError")
	public String accessError(Authentication auth, Model model) {
		return "login/accessError";
	}
	@GetMapping("user")
	public String user() {
		return "login/user"; 
    }
}
