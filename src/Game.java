import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	private static final int NUM_OF_DICE = 3; // Konstante max.3 Würfel 
    private static Player attacker;
    private static Player defender;
    private static Integer[] attArr;
    private static Integer[] defArr;
    private static int attackerCount;
    private static int defenderCount;

    public Game() {
    }

    public static int getCountOfStones() {
        return (int)(Math.random() * 10.0D + 1.0D);
    }

    public static void start() {
        setup();

        while(attacker.getStones() != 0 && defender.getStones() != 0) {
            rollTheDice();
            System.out.println("Attacker's number of  stones:" + attacker.getStones());
            System.out.println("Defender's number of stones:" + defender.getStones());
            System.out.println("\n\n=======Game=========");

            for(int i = 0; i < Math.min(attackerCount, defenderCount); ++i) {
                System.out.println("Attaker's dice score - " + attArr[i] + "\nDefender's dice score - " + defArr[i]);
                if (attArr[i] > defArr[i]) {
                    defender.setStones(defender.getStones() - 1);
                    System.out.println("Defender loses 1 stone");
                } else {
                    attacker.setStones(attacker.getStones() - 1);
                    System.out.println("Attacker loses 1 Stone");
                }

                System.out.println("Current attacker's stones:" + attacker.getStones());
                System.out.println("Current defender's stones:" + defender.getStones());
                if (attacker.getStones() == 0) {
                    System.out.println("Attacker is defeated. Game over!");
                    break;
                }

                if (defender.getStones() == 0) {
                    System.out.println("Defender has lost. Game over! ");
                    break;
                }
            }
        }

        restart();
    }
    
// würfeln
    
    public static void rollTheDice() {
        attArr = new Integer[attackerCount];
        defArr = new Integer[defenderCount];

        int i;
        for(i = 0; i < attackerCount; ++i) {
            attArr[i] = Dice.score();
        }

        for(i = 0; i < defenderCount; ++i) {
            defArr[i] = Dice.score();
        }

        Arrays.sort(attArr, Collections.reverseOrder());
        Arrays.sort(defArr, Collections.reverseOrder());
        System.out.println("Attacker's round of scores: - " + Arrays.toString(attArr));
        System.out.println("Defender round of scores: - " + Arrays.toString(defArr));
    }
// erzeugen 2 Spieler und wie viel Würfeln sie haben
    public static void setup() {
        attacker = new Player("Attacker", getCountOfStones());
        defender = new Player("Defender", getCountOfStones());
        if (attacker.getStones() > 3) {
            attackerCount = 3;
        } else {
            attackerCount = attacker.getStones();
        }

        if (defender.getStones() > 3) {
            defenderCount = 3;
        } else {
            defenderCount = defender.getStones();
        }

    }
    
    // nochmal spielen ( "1" von dem Testatur eingeben)

    public static void restart() {
        System.out.println("Would you like to try again ? Press 1 and You will be given a random number of stones again :) ");
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();
        if (ans == 1) {
            start();
        }

    }

}
