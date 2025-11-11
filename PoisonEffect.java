public class PoisonEffect extends StatusEffect{

    protected  final int damagePerTurn;

    public PoisonEffect(String name, int duration, RPGCharacter target, int damagePerTurn) {
        super(name, duration, target);
        this.damagePerTurn = damagePerTurn;
    }

    @Override
    public void onApply() {
        System.out.println("  > " + target.name + " has been poisoned!");
    }

    @Override
    public void onTurnStart() {
        System.out.println("  > " + target.name + " takes " + this.damagePerTurn + " poison damage!");
        target.takeDamage(this.damagePerTurn);
    }

    @Override
    public void removeStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
