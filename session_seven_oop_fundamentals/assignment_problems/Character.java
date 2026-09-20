package session_seven_oop_fundamentals.assignment_problems;

public class Character {

    private int health;
    private final int maxHealth; // fixed at creation

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // starts at full health
    }

    public void takeDamage(int amount) {
        health = health - amount;
        if (health < 0) {        // clamp at 0 — extra damage is wasted
            health = 0;
        }
    }

    public void heal(int amount) {
        health = health + amount;
        if (health > maxHealth) { // clamp at max — extra healing is wasted
            health = maxHealth;
        }
    }

    public int getHealth() {   // read-only — no setter exists
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth()); // 70
        c.heal(50);
        System.out.println("health = " + c.getHealth()); // 100 (capped)
        c.takeDamage(150);
        System.out.println("health = " + c.getHealth()); // 0 (floored)
    }

    public static boolean isDigit(char charAt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDigit'");
    }
}