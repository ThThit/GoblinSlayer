public class BleedEffect extends StatusEffect {

    final int damagePerTurn;

    public BleedEffect(String name, int duration, RPGCharacter target, int damagePerTurn) {
        super("Bleed", duration, target);
        this.damagePerTurn = damagePerTurn;
    }

    @Override
    public void onApply() {
        System.out.println(target.name + " is bleeding");
        target.takeDamage(this.damagePerTurn);
    }

    @Override
    public void onTurnStart() {
        System.out.println(" > " + target.name + " suffers from blood loss.");
        target.takeDamage(this.damagePerTurn);
    }

    @Override
    public void removeStatus() {
        
    }
    
}
