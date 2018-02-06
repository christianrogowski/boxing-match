package boxingMatch.fighters;

import boxingMatch.fightingStyle.FighterAttackActionType;
import boxingMatch.fightingStyle.FighterDefenceActionType;
import boxingMatch.fightingStyle.IFighterStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Boxer implements IFighter {
    private String name;
    private int hp;
    private IFighterStyle style;
    protected int power;

    protected Map<FighterAttackActionType, Integer> attackStatistics = new HashMap<>();

    public Boxer(String name, int hp, IFighterStyle style, int power) {
        this.name = name;
        this.hp = hp;
        this.style = style;
        this.power = power;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public FighterAttackActionType attack() {
        Random random = new Random();
        int hitPorbability = random.nextInt(100);

        FighterAttackActionType attack = hitPorbability < style.getLowPercentage()
                ? FighterAttackActionType.LOW_PUNCH : FighterAttackActionType.HIGH_PUNCH;
        //logAttackStatistics(attack);

        return attack;
    }

    private void logAttackStatistics(FighterAttackActionType attack) {
        if(attackStatistics.containsKey(attack)){
            attackStatistics.put(attack, 1);
        }else{
            Integer tempCounter = attackStatistics.get(attack);
            tempCounter++;
            attackStatistics.put(attack, tempCounter);
        }
    }

    @Override
    public FighterDefenceActionType defend() {
        Random random = new Random();
        int blockPorbability = random.nextInt(100);
        FighterDefenceActionType block = blockPorbability < style.getLowPercentage()
                ? FighterDefenceActionType.LOW_BLOCK : FighterDefenceActionType.HIGH_BLOCK;
        return block;
    }

    @Override
    public void decreaseHp(int power) {
     /*   if(hp<10) {
            hp -= (power * power);
            System.out.println("CRITICAL HIT !!!");
        } else{*/
        hp-=power;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getPower() {
        return power;
    }
}
