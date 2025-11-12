import java.util.Random;

public class Goblin extends RPGCharacter {

    private static final Random rand = new Random();

    public Goblin(String name, int health) {
        super(name, health);
    }

    @Override
    public void takeDamage(int dmg) {
        super.takeDamage(dmg);
    }

    @Override
    public void performCharacterTurn(RPGCharacter opponent) {
        int num = rand.nextInt(5) + 1; // 1 to 5
        // int num = 2;

        switch (num) {
            case 1:
            System.out.println(this.name + " attacks " + opponent.name + "!");
            opponent.takeDamage(10);
            break;
            case 2:
                System.out.println(this.name + " casts 'Poison' on " + opponent.name + "!");
                opponent.addStatusEffect(new PoisonEffect("Poison", 3, opponent, 5));
                break;
            case 3:
                System.out.println(this.name + " casts 'Stun' on " + opponent.name + "!");
                //75% chance to stun
                int chance = rand.nextInt(100);
                if (chance < 75) {
                    opponent.addStatusEffect(new StunEffect("Stun", 1, opponent));
                    System.out.println(" > Stun successful! " + opponent.name + " is stunned for 1 turn!");
                } else { 
                    System.out.println(" > Stun unsuccessful!");
                    opponent.takeDamage(5);
                }
                break;
            case 4:
                System.out.println(this.name + " casts 'Bleed' on " + opponent.name + "!");
                opponent.addStatusEffect(new BleedEffect("Bleed", 3, opponent, 3));
                break;
            case 5:
                System.out.println(this.name + " is blocking " + opponent.name + "'s attack!");
                break;
            default:
                System.out.println(this.name + " does nothing.");
        }
    }

    

}
