public class StunEffect extends StatusEffect{

    public StunEffect(String name, int duration, RPGCharacter target) {
        super(name, duration, target);
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
    
}
