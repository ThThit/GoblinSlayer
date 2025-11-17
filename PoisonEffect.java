public class PoisonEffect implements  StatusEffect{

    protected String name;
    protected int duration;
    protected RPGCharacter target;

    protected final int damagePerTurn;

    public PoisonEffect(String name, int duration, RPGCharacter target, int damagePerTurn) {
        this.name = name;
        this.duration = duration;
        this.target = target;
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
        System.out.println("  > " + target.name + " is no longer poisoned.");
    }

    @Override
    public void decrementDuration() {
        this.duration--;
    }

    @Override
    public boolean isFinished() {
        return this.duration <= 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }
    
}
