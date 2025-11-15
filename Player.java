import java.util.Random;
import java.util.Scanner;

public class Player extends RPGCharacter {
    private Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    public Player(String name, int health, Scanner sc) {
        super(name, health);
        this.sc = sc;
    }

    @Override
    public void takeDamage(int dmg) {
        super.takeDamage(dmg);
    }

    @Override
    public void performCharacterTurn(RPGCharacter opponent) {
        System.out.println("Choose Your action: ");
        System.out.println(" 1. Basic Attack (Deals 10 damage)");
        System.out.println(" 2. Cast 'Posion' (Deals 5 damage for 3 turns)");
        System.out.println(" 3. Cast 'Stun' (75% chance to Stop enemy for 1 turn with Base damage of 5)");
        System.out.println(" 4. Cast 'Bleed' (Deals 2 damage for 5 turns)");
        System.out.println(" 5. Block (absorb 95% of the incoming damage)");
        System.out.print("Your choice: ");

        // try case to prevent undefined action
        int choice;
        while (true) {
            choice = sc.nextInt();
            if (choice >= 1 && choice <= 5) {

                break;
            }
            System.out.println("Action not available. Try again.");
        }
        System.out.println("-----------------------------------------");
        switch (choice) {
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
                int chance = random.nextInt(100);
                if (chance < 75) {
                    opponent.addStatusEffect(new StunEffect("Stun", 1, opponent));
                } else { 
                    System.out.println(" > Stun unsuccessful!");
                    opponent.takeDamage(5);
                }
                break;
            case 4:
                System.out.println(this.name + " casts 'Bleed' on " + opponent.name + "!");
                opponent.addStatusEffect(new BleedEffect("Bleed", 5, opponent, 2));
                break;
            case 5:
                System.out.println(this.name + " is blocking " + opponent.name + "'s attack!");
                this.isBlocking = true;
                break;
            default:
                System.out.println(this.name + " does nothing.");
        }
    }

    
}
