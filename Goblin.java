public class Goblin extends RPGCharacter {

    public Goblin(String name, int health, String race) {
        super(name, health, race);
    }

    @Override
    public void takeDamage(int dmg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getHeal(int heal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
