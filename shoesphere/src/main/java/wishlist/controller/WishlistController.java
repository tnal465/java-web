package wishlist.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import wishlist.service.WishlistService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public String addToWishlist(@RequestParam Long productId, Principal principal) {
        wishlistService.addWishlistItem(principal.getName(), productId);
        return "redirect:/wishlist/list";
    }

    @GetMapping("/list")
    public String wishlist(Model model, Principal principal) {
        model.addAttribute("wishlist", wishlistService.getWishlist(principal.getName()));
        return "wishlist/list";
    }

    @PostMapping("/remove")
    public String removeFromWishlist(@RequestParam Long wishId) {
        wishlistService.removeWishlistItem(wishId);
        return "redirect:/wishlist/list";
    }
}

