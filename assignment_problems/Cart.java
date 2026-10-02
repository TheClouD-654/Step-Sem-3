public class Cart {
    private final String cartId;
    private final int[] prices;
    private int itemCount;

    // Constructor: locks the cart ID and initializes array with maximum capacity
    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        if (maxItems <= 0) {
            maxItems = 10; // safe default capacity
        }
        this.prices = new int[maxItems];
        this.itemCount = 0;
    }

    // Adds an item's price to the cart
    public void addItem(int price) {
        if (price <= 0) {
            System.out.println("Invalid price: must be positive.");
            return;
        }
        if (itemCount < prices.length) {
            prices[itemCount++] = price;
        } else {
            System.out.println("Cart is full. Cannot add item with price: " + price);
        }
    }

    // Computes and returns the total sum on request (no separate running total stored)
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    // Returns the total number of items currently in the cart
    public int getItemCount() {
        return itemCount;
    }

    // Read-only getter for final cart ID
    public String getCartId() {
        return cartId;
    }

    // Note: No getter exists for 'prices' array to prevent external modification

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
