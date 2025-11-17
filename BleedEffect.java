public class BleedEffect implements  StatusEffect {

    protected String name;
    protected int duration;
    protected RPGCharacter target;

    protected final int damagePerTurn;

    public BleedEffect(String name, int duration, RPGCharacter target, int damagePerTurn) {
        this.damagePerTurn = damagePerTurn;
        this.name = name;
        this.duration = duration;
        this.target = target;
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
