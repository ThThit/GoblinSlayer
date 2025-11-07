public class Goblin extends RPGCharacter {

    public Goblin(String name, int health) {
        super(name, health);
    }

    @Override
    public void takeDamage(int dmg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void performCharacterTurn(RPGCharacter character) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
