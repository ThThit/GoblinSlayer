
import java.util.Random;

public class Goblin extends RPGCharacter {

    private static final Random rand = new Random();

    public Goblin(String name, int health) {
        super(name, health);
    }

    @Override
    public void takeDamage(int dmg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void performCharacterTurn(RPGCharacter opponent) {
        int num = rand.nextInt(5) + 1; // 1 to 5

        switch (num) {
            case 1 -> System.out.println(this.name + " attacks " + opponent.name + "!");
            case 2 -> System.out.println(this.name + " casts 'Poison' on " + opponent.name + "!");
            case 3 -> System.out.println(this.name + " casts 'Stun' on " + opponent.name + "!");
            case 4 -> System.out.println(this.name + " casts 'Bleed' on " + opponent.name + "!");
            case 5 -> System.out.println(this.name + " is blocking " + opponent.name + "'s attack!");
            default -> System.out.println(this.name + " does nothing.");
        }
    }

    

}
