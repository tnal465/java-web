package wishlist.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WishlistItem {
    private Long wishId;
    private String userId;
    private Long productId;
    private LocalDateTime addedDate;
}
