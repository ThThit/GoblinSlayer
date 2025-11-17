public interface StatusEffect {
    // an interface for attack effects 
    // damage overtime values and others

    public void decrementDuration();

    public boolean isFinished();

    public String getName();

    public int getDuration();

    // abstract methods
    // what happen when the effect is applied
    // print message and change stat
    public void onApply();

    // what happen at the start of the target turn?
    // has posion and blead deal damage, stun skip turn.
    public void onTurnStart();

    // remove status when the duration is zero
    public void removeStatus();

}
