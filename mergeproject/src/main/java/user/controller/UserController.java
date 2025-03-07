package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/user")
@Controller
public class UserController {
	
	/*
	@Autowired
	private UserService userService;

	@RequestMapping("/user")
		public String userInfo(Model model) {
		    List<Order> orders = userService.getOrderList();
		model.addAttribute("orders", orders); 
		return "user"; 
	}
	*/
	
	/*
	@RequestMapping("user")
	public String user() {
		return "user";
	}
	
	
    @PostMapping("/save")
    public String saveProfile(@RequestParam String nickname) {
        System.out.println("저장된 닉네임: " + nickname);
        return "redirect:/user/success";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success"; 
    }
    */
}
