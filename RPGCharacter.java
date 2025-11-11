import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RPGCharacter {
    // abstract for character in the RPG
    protected  String name;
    protected  int health;
    protected boolean canAct; // for stun effect

    // list to store effects
    protected List<StatusEffect> activeEffecList;

    public RPGCharacter(String name, int health) {
        this.name = name;
        this.health = health;
        this.canAct = true;
        this.activeEffecList = new ArrayList<>(); // to store multiple effect
    }

    // abstract method to do character action when its turn
    public abstract void performCharacterTurn(RPGCharacter character);


    public void takeDamage(int dmg) {
        this.health -= dmg;
        if (this.health < 0)
            this.health = 0;
        // print status
        System.out.println(this.name + " takes " + dmg + " damage");
        System.err.println("HP reaming: " + this.health);
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

            effect.dercementDuration();
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
        return this.canAct;
    }

    public int getHealth() {
        return this.health;
    }
    
    // check if a character is alive or not
    public boolean isAlive() {
        return this.health > 0;
    }
}
