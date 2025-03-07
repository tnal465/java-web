package cart.repository;

import cart.model.CartItem;
import java.util.List;

public interface CartMapper {

    List<CartItem> selectCartList(String userId);

    void insertCartItem(CartItem item);

    void deleteCartItem(Long cartId);
}