public abstract class RPGCharacter {
    // abstract for character in the RPG
    private String name;
    private int health;
    private String race;

    public RPGCharacter(String name, int health, String race) {
        this.name = name;
        this.health = health;
        this.race = race;
    }

    public abstract void takeDamage(int dmg);

    public abstract void getHeal(int heal);
}
