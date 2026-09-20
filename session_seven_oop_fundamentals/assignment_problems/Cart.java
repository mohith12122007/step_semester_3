package session_seven_oop_fundamentals.assignment_problems;

public class Cart {

    private final double[] prices; // fixed max size, never exposed
    private int count = 0;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
    }

    public void addItem(double price) {
        if (count >= prices.length) {
            System.out.println("Cart is full");
            return;
        }
        prices[count] = price;
        count++;
    }

    public double getTotal() {   // computed on request — no running-total field
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(cart.getTotal());     // 500.0
        System.out.println(cart.getItemCount()); // 3
    }
}