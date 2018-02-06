package boxingMatch.fighters;

import boxingMatch.fightingStyle.FighterAttackActionType;
import boxingMatch.fightingStyle.FighterDefenceActionType;

public interface IFighter {
    boolean isAlive();

    FighterAttackActionType attack();

    FighterDefenceActionType defend();

    void decreaseHp(int power);

    String getName();

    int getHp();

    int getPower();
}
