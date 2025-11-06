public class PoisonEffect extends StatusEffect{

    public PoisonEffect(String name, int duration, RPGCharacter target) {
        super(name, duration, target);
    }

    @Override
    public void onApply() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onTurnStart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
