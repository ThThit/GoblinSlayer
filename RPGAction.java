import java.util.Scanner;

public class RPGAction {
    // main class 
    // will have a MC and goblin
    // choose mc attack and apply status based on the attack 
    // goblin will attack back with random attack and random effect
    // loop until on one 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // crate characters
        RPGCharacter hero = new Player("Duke", 100, sc);
        RPGCharacter goblin = new Goblin("Dudu", 50);

        System.out.println("Battle Start!");
        System.out.println(hero.name + ": " + hero.getHealth() + " HP");
        System.out.println(goblin.name + ": " + goblin.getHealth() + " HP");
        System.out.println("=====================================\n");

        // main game loop
        while (hero.isAlive() && goblin.isAlive()) {
            System.out.println(">>> --- " + hero.name + "'s Turn --- <<<");
            hero.performCharacterTurn(goblin);

            if (!goblin.isAlive()) {
                break;
            }

            System.out.println("\n-------------------------------------");
            System.out.println(">>> --- " + goblin.name + "'s Turn --- <<<");
            goblin.performCharacterTurn(hero);

            if (!hero.isAlive()) {
                break;
            }

            System.out.println("\n===== END OF TURN STATUS =====");
        }


        
    }
}
