package boxingMatch;


import boxingMatch.fighters.Boxer;
import boxingMatch.fighters.IFighter;
import boxingMatch.fightingStyle.IFighterStyle;
import boxingMatch.match.BoxingMatch;
import boxingMatch.match.IFightingMatch;

public class App
{
    public static void main( String[] args )
    {
        IFighter fighter1 = new Boxer("Tyson", 70, IFighterStyle.HIGH, 7);
        IFighter fighter2 = new Boxer("Gołota", 70, IFighterStyle.LOW, 4);
        IFightingMatch match = new BoxingMatch(fighter1, fighter2);
        match.fight();
    }
}
