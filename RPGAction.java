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
            hero.processTurnStartEffects();

            // do alive and can act
            if (hero.isAlive() && hero.canAct()) {
                hero.performCharacterTurn(goblin);
            } else if (!hero.isAlive()) {
                break; // Died from poison/bleed
            }

            if (!goblin.isAlive()) {
                break;
            }

            // goblin turn 
            System.out.println("\n-------------------------------------");
            System.out.println(">>> --- " + goblin.name + "'s Turn --- <<<");
            goblin.processTurnStartEffects();

            if (goblin.isAlive() && goblin.canAct()) {
                goblin.performCharacterTurn(hero);
            } else if (!goblin.isAlive()) {
                break; // Died from poison/bleed
            }

            if (!hero.isAlive()) {
                break;
            }

            System.out.println("\n===== END OF TURN STATUS =====");
            System.out.println(hero.name + ": " + hero.getHealth() + "HP Effects: " + hero.getActiveEffectNames());
            System.out
                    .println(goblin.name + ": " + goblin.getHealth() + "HP Effects: " + goblin.getActiveEffectNames());
            System.out.println();
        }

        // game end
        System.out.println("\n!!!!!!!! BATTLE OVER !!!!!!!!");
        if (hero.isAlive()) {
            System.out.println(hero.name + " is victorious!");
        } else if (goblin.isAlive()) {
            System.out.println(goblin.name + " has defeated you!");
        } else {
            System.out.println("The battle is a draw!");
        }

        
    }
}
