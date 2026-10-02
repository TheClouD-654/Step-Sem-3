public class Character {
    private final int maxHealth;
    private int health;

    // Constructor: locks maximum health in place; starts at full health
    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            this.maxHealth = 100; // safe default fallback
        } else {
            this.maxHealth = maxHealth;
        }
        this.health = this.maxHealth;
    }

    // Reduces health; never drops below 0 (excess damage is wasted)
    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        this.health = Math.max(0, this.health - amount);
    }

    // Increases health; never exceeds maxHealth (excess healing is wasted)
    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        this.health = Math.min(this.maxHealth, this.health + amount);
    }

    // Read-only getter for current health (no setter exists)
    public int getHealth() {
        return health;
    }

    // Read-only getter for maximum health
    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getHealth());

        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getHealth() + " (capped)");

        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}
