package cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.model.CartItem;
import cart.repository.CartMapper;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    public void addCartItem(String userId, Long productId, int quantity) {
        CartItem item = new CartItem();
        item.setUserId(userId);
        item.setProductId(productId);
        item.setQuantity(quantity);
        cartMapper.insertCartItem(item);
    }

    public List<CartItem> getCartList(String userId) {
        return cartMapper.selectCartList(userId);
    }

    public void removeCartItem(Long cartId) {
        cartMapper.deleteCartItem(cartId);
    }
}
