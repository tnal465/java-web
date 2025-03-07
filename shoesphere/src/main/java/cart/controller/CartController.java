package cart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cart.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity, Principal principal) {
        String username = principal.getName();
        cartService.addCartItem(username, productId, quantity);
        return "redirect:/cart/list";
    }

    @GetMapping("/list")
    public String cartList(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("cartList", cartService.getCartList(username));
        return "cart/list";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam Long cartId) {
        cartService.removeCartItem(cartId);
        return "redirect:/cart/list";
    }
}
