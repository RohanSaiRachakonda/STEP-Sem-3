public class ShoppingCart {

    // Cart class storing item prices internally and computing total on request
    public static class Cart {
        private final String cartId;
        private final int[] itemPrices;
        private int itemCount;

        public Cart(String cartId, int capacity) {
            this.cartId = cartId;
            this.itemPrices = new int[capacity];
            this.itemCount = 0;
        }

        public void addItem(int price) {
            if (price >= 0 && itemCount < itemPrices.length) {
                itemPrices[itemCount++] = price;
            }
        }

        // Read-only total computed on request by summing internal prices
        public int getTotal() {
            int total = 0;
            for (int i = 0; i < itemCount; i++) {
                total += itemPrices[i];
            }
            return total;
        }

        // Read-only item count
        public int getItemCount() {
            return itemCount;
        }

        public String getCartId() {
            return cartId;
        }
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
