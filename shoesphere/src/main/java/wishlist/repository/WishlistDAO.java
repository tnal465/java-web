package wishlist.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wishlist.model.WishlistItem;

@Repository
public class WishlistDAO {
    @Autowired
    private SqlSession sqlSession;

    public void insertWishlistItem(WishlistItem item) {
        sqlSession.insert("WishlistMapper.insertWishlistItem", item);
    }

    public List<WishlistItem> selectWishlist(String userId) {
        return sqlSession.selectList("WishlistMapper.selectWishlist", userId);
    }

    public void deleteWishlistItem(Long wishId) {
        sqlSession.delete("WishlistMapper.deleteWishlistItem", wishId);
    }
}
