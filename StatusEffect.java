public abstract class StatusEffect {
    // abstract class for attack effects 
    // damage overtime values and others

    private String name;
    private int duration;
    private RPGCharacter target; // the character who is effected

    public StatusEffect(String name, int duration, RPGCharacter target) {
        this.name = name;
        this.duration = duration;
        this.target = target;
    }

    public void dercementDuration() {
        this.duration--;
    }

    public boolean isFinished() {
        return this.duration <= 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }

    // abstract methods
    // what happen when the effect is applied
    // print message and change stat
    public abstract void onApply();

    // what happen at the start of the target turn?
    // has posion and blead deal damage, stun skip turn.
    public abstract void onTurnStart();

    // remove status when the duration is zero
    public abstract void removeStatus();

}
