package cart.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartItem {
	private Long cartId;
    private String userId;
    private Long productId;
    private int quantity;
    private LocalDateTime addedDate;
}
