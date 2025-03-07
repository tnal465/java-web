package wishlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wishlist.model.WishlistItem;
import wishlist.repository.WishlistDAO;

@Service
public class WishlistService {
    @Autowired
    private WishlistDAO wishlistDAO;

    public void addWishlistItem(String userId, Long productId) {
        WishlistItem item = new WishlistItem();
        item.setUserId(userId);
        item.setProductId(productId);
        wishlistDAO.insertWishlistItem(item);
    }

    public List<WishlistItem> getWishlist(String userId) {
        return wishlistDAO.selectWishlist(userId);
    }

    public void removeWishlistItem(Long wishId) {
        wishlistDAO.deleteWishlistItem(wishId);
    }
}
