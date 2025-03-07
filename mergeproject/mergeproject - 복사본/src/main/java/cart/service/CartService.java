package cart.service;

import cart.model.CartItem;
import cart.repository.CartMapper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
    private CartMapper cartMapper;
    
    public List<CartItem> getCartItems(int memberId) {
        return cartMapper.getCartItemsByMemberId(memberId);
    }
    
	/*
	 * // setter for DI public void setCartMapper(CartMapper cartMapper) {
	 * this.cartMapper = cartMapper; }
	 */
}
