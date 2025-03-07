package home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "board";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
	    return "mypage";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/shop")
	public String shop() {
		return "shop";
	}
	
	@RequestMapping("/product")
	public String product(@RequestParam("id") int id, Model model) {
        model.addAttribute("productId", id);
        model.addAttribute("productName", "상품 " + id);
        return "product";
    }
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/index"; // 로그아웃 후 리다이렉트할 페이지
	}
}
