
/* *****************************************************************************
 *  Name:    CONGXIN ZHANG
 *  studentID:   954515
 *  Description:  designing and implementing a simple variant of the game of Nim
 *
 *  Written:       28/03/2019
 *  Last updated:  4/4/2019
 **************************************************************************** */

import java.util.Scanner;


  public class Nimsys
  {
      public static void asterisk(int res)        //output asterisk
      {
          System.out.print(res + " stones left:");
          int i = 0;
          while (i < res)
          {
              System.out.print(" *");
              i++;
          }
      }

     public static void main(String[] args)
     {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to Nim\n");

        System.out.println("Please enter Player 1's name:");
        String name1 = keyboard.next();
        System.out.println();
        NimPlayer Player1 = new NimPlayer(name1,keyboard);           //create Player1 as an instance of NimPlayer

        System.out.println("Please enter Player 2's name:");
        String name2 = keyboard.next();
        System.out.println();
        NimPlayer Player2 = new NimPlayer(name2,keyboard);           //create Player2 as an instance of NimPlayer

        String is = "Y";
        while (is.equals("Y"))
        {
            System.out.println("Please enter upper bound of stone removal:");
            int upperNumber = keyboard.nextInt();           //the upper bound of stone removal
            System.out.println();

            System.out.println("Please enter initial number of stones:");
            int initialNumber = keyboard.nextInt();         //the initial number of stones
            System.out.println();

            asterisk(initialNumber);                        //output asterisks of initialNumber

            int res = initialNumber;
            while (res > 0)
            {
                 int removeStone1 = Player1.removeStone();
                 System.out.println();
                 res = res - removeStone1;
                 if(res == 0)                               //if Player1 removes the last stone, Player2 wins
                 {
                     Player2.win();
                     break;
                 }
                 asterisk(res);

                 int removeStone2 = Player2.removeStone();
                 System.out.println();
                 res = res - removeStone2;
                 if(res == 0)                              //if Player2 removes the last stone,Player1 wins
                 {
                    Player1.win();
                    break;
                 }
                 asterisk(res);
            }
            System.out.println();
            System.out.print("Do you want to play again (Y/N):");
            is = keyboard.next();
            System.out.println();
        }
     }
  }
