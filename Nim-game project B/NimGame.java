
/* *****************************************************************************
 *  Name:    CONGXIN ZHANG
 *  studentID:   954515
 *  Description:  designing and implementing a simple variant of the game of Nim
 *
 *  Written:       26/04/2019
 *  Last updated:  06/05/2019
 **************************************************************************** */

import java.util.Scanner;


public class NimGame {
    private Scanner keyboard;

    NimGame(Scanner keyboard){
        this.keyboard = keyboard;
    }

    //output asterisk
    private void asterisk(int res)
    {
        System.out.print(res + " stones left:");
        int i = 0;
        while (i < res) {
            System.out.print(" *");
            i++;
        }
    }

    private void invalidMove(int num){
        System.out.println("Invalid move. You must remove between 1 and "+num+ " stones.");
        System.out.println();
    }



    String game(int initialNumber, int upperNumber, String fullName1, String fullName2) {
        String winner = "";
        String givenName1 = fullName1.substring(0, fullName1.indexOf(" "));
        String givenName2 = fullName2.substring(0, fullName2.indexOf(" "));

        //create Player1 as an instance of NimPlayer
        NimPlayer Player1 = new NimPlayer(fullName1, givenName1, keyboard);
        //create Player2 as an instance of NimPlayer
        NimPlayer Player2 = new NimPlayer(fullName2, givenName2, keyboard);

        System.out.println();
        System.out.println("Initial stone count: " + initialNumber);
        System.out.println("Maximum stone removal: " + upperNumber);
        System.out.println("Player 1: " + fullName1);
        System.out.println("Player 2: " + fullName2);
        System.out.println();

        int res = initialNumber;
        int removeStone1 = 0;
        int removeStone2 = 0;
        while (res > 0) {
            //output asterisks of initialNumber
            asterisk(res);
            removeStone1 = Player1.removeStone();
            System.out.println();
            if(res>upperNumber){
                //display the upperNumber as upper bound
                if(removeStone1<1 || removeStone1 >upperNumber){
                    invalidMove(upperNumber);
                    continue;
                }
            } else{
                //display the res as upper bound
                if(removeStone1<1 || removeStone1 >upperNumber){
                    invalidMove(res);
                    continue;
                }
            }
            res = res - removeStone1;
            //if Player1 removes the last stone, Player2 wins
            if (res == 0)
            {
                Player2.win();
                winner = givenName2;
                break;
            }

            while(true) {
                asterisk(res);
                removeStone2 = Player2.removeStone();
                System.out.println();
                if(res>upperNumber){
                    //display the upperNumber as upper bound
                    if(removeStone2<1 || removeStone2 >upperNumber){
                        invalidMove(upperNumber);
                        continue;
                    }
                } else{
                    //display the res as upper bound
                    if(removeStone2<1 || removeStone2 >upperNumber){
                        invalidMove(res);
                        continue;
                    }
                }
                res = res - removeStone2;
                //if Player2 removes the last stone,Player1 wins
                if (res == 0)
                {
                    Player1.win();
                    winner = givenName1;
                    break;
                }
                break;
            }
        }
        System.out.println();
        return winner;
    }
}


