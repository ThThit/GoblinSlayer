import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RPGCharacter {
    // abstract for character in the RPG
    protected  String name;
    protected  int health;
    protected boolean canAct; // for stun effect
    protected boolean isBlocking;

    // list to store effects
    protected List<StatusEffect> activeEffecList;

    public RPGCharacter(String name, int health) {
        this.name = name;
        this.health = health;
        this.canAct = true;
        this.isBlocking = false; // not block at default
        this.activeEffecList = new ArrayList<>(); // to store multiple effect
    }

    // abstract method to do character action when its turn
    public abstract void performCharacterTurn(RPGCharacter character);


    public void takeDamage(int dmg) {
        int actDmg = dmg;

        // block 95% dmg
        if (this.isBlocking = true) {
            actDmg = (int) (dmg * 0.95);
            System.out.println("  > " + this.name + " blocks the attack, taking only " + actDmg + " damage!");
        } else {
            System.out.println("  > " + this.name + " takes " + actDmg + " damage!");
        }
        this.health -= actDmg;
        if (this.health < 0) this.health = 0;
        // print health
        System.out.println("  > HP remaining: " + this.health);
    };

    public void addStatusEffect(StatusEffect effect) {
        this.activeEffecList.add(effect);
        effect.onApply(); // apply effect debuff on character. 
    }

    // loop through the effects and process each effect 
    public void processTurnStartEffects() {
        Iterator<StatusEffect> iterator = activeEffecList.iterator();

        if (iterator.hasNext()) {
            StatusEffect effect = iterator.next();

            // apply the effect when turn start
            effect.onTurnStart();

            effect.decrementDuration();

            if (effect.isFinished()) {
                System.out.println("  > " + effect.getName() + " has worn off from " + this.name + ".");
                // effect.removeStatus(); // clean effect 
                iterator.remove(); // Safely remove the effect from the list
            }
        }
    }

    // get the list of active effects
    public String getActiveEffectNames() {
        if (activeEffecList.isEmpty())
            return "None";
        
        String result = "";
        for (StatusEffect effect : activeEffecList) {
            if (!result.isEmpty())
                result += ", ";
            result += effect.getName();
        }
        return result;
    }
    
    public void setCanAct(boolean canAct) {
        this.canAct = canAct;
    }

    public boolean canAct() {
        if (!this.canAct) {
            System.out.println("  > " + this.name + " is Stunned and cannot act!");
            return false;
        }
        // set true for next turn 
        return true;
    }

    public int getHealth() {
        return this.health;
    }
    
    // check if a character is alive or not
    public boolean isAlive() {
        return this.health > 0;
    }
}
