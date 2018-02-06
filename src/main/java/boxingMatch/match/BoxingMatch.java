package boxingMatch.match;

import boxingMatch.fightingStyle.FighterAttackActionType;
import boxingMatch.fightingStyle.FighterDefenceActionType;
import boxingMatch.fighters.IFighter;

import java.util.Random;

public class BoxingMatch implements IFightingMatch {
    private IFighter fighter1;
    private IFighter fighter2;

    public BoxingMatch(IFighter fighter1, IFighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    @Override
    public void fight() {
        IFighter first;
        IFighter second;

        Random random = new Random();
        int randomValue = random.nextInt();
        if (randomValue % 2 == 0) {
            first = fighter1;
            second = fighter2;
        } else {
            first = fighter2;
            second = fighter1;
        }

        IFighter winner;
        IFighter loser;

        while (true) {
            FighterAttackActionType f1_attack = first.attack();
            FighterDefenceActionType f2_block = second.defend();

            if (fighterWasHit(f1_attack, f2_block)) {
                if(first.getHp()>10){ second.decreaseHp(first.getPower()); }else{ second.decreaseHp(first.getPower()*first.getPower());}
                System.out.println(first.getName() + " zadaje cios "+ f1_attack.toString()+" o sile "+first.getPower());
                System.out.println(second.getName()+" ma "+second.getHp() + " punkty zycia");
                System.out.println();
            }


            if (!second.isAlive()) {
                winner = first.isAlive() ? first : second;
                loser = first.isAlive() ? second : first;
                break;
            }

            FighterAttackActionType f2_attack = second.attack();
            FighterDefenceActionType f1_block = first.defend();
            if (fighterWasHit(f2_attack, f1_block)) {
                if(second.getHp()>10){first.decreaseHp(second.getPower());}else{first.decreaseHp(second.getPower()*second.getPower());}
                System.out.println(second.getName() + " zadaje cios "+ f2_attack.toString() + " o sile " +second.getPower());
                System.out.println(first.getName()+" ma "+first.getHp() + " punkty zycia");
                System.out.println();
            }
            if (!first.isAlive()) {
                winner = first.isAlive() ? first : second;
                loser = first.isAlive() ? second : first;
                break;
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(loser.getName() + " K.O.");
        System.out.println("Walke wygrywa: " + winner.getName());
    }

    private boolean fighterWasHit(FighterAttackActionType f1_attack, FighterDefenceActionType f2_block) {
        boolean hitSuccessfull = false;

        if (f1_attack.equals(FighterAttackActionType.HIGH_PUNCH)
                && f2_block.equals(FighterDefenceActionType.LOW_BLOCK)) {
            hitSuccessfull = true;
        }
        if (f1_attack.equals(FighterAttackActionType.LOW_PUNCH)
                && f2_block.equals(FighterDefenceActionType.HIGH_BLOCK)) {
            hitSuccessfull = true;
        }

        return hitSuccessfull;
    }
}
