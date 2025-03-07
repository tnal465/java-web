package cart.controller;

import cart.service.CartService;
import cart.model.CartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
    
	 @GetMapping("/cart")
	    public String cartPage(@RequestParam(value = "memberId", defaultValue = "1") int memberId, Model model) {
	        List<CartItem> cartItems = cartService.getCartItems(memberId);
	        model.addAttribute("cartItems", cartItems);
	        return "cart/cartPage";
	    }
	 
		/*
		 * // setter for DI public void setCartService(CartService cartService) {
		 * this.cartService = cartService; }
		 */
}
