public class StunEffect implements StatusEffect {
    
    protected String name;
    protected int duration;
    protected RPGCharacter target;

    public StunEffect(String name, int duration, RPGCharacter target) {
        this.name = name;
        this.duration = duration;
        this.target = target;
    }

    @Override
    public void onApply() {
        System.out.println(" > " + target.name + " has been stunned!");
        target.setCanAct(false);
        target.takeDamage(5);
    }

    @Override
    public void onTurnStart() {
        target.setCanAct(false);
        // System.out.println(" > " + target.name + " is still stunned!");
    }

    @Override
    public void removeStatus() {
        target.setCanAct(true);
        System.out.println(" > " + target.name + " can act again!");
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
