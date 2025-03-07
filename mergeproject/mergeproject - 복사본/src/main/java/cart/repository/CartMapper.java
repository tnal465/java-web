package cart.repository;

import cart.model.CartItem;
import java.util.List;

public interface CartMapper {
    List<CartItem> getCartItemsByMemberId(int memberId);
}
