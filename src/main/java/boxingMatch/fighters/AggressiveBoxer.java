package boxingMatch.fighters;

import boxingMatch.fightingStyle.IFighterStyle;

public class AggressiveBoxer extends Boxer {
    int baseHp;

    public AggressiveBoxer(String name, int hp, IFighterStyle style, int power) {
        super(name, hp, style, power);
        this.baseHp = hp;
    }

    @Override
    public int getPower() {
        int powerToReturn = power;
        if (getHp() < baseHp / 2) {
            powerToReturn += 3;
        }
        return powerToReturn;
    }
}
