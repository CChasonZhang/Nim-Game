
/* *****************************************************************************
 *  Name:    CONGXIN ZHANG
 *  studentID:   954515
 *  Description:  designing and implementing a simple variant of the game of Nim
 *
 *  Written:       28/03/2019
 *  Last updated:  4/4/2019
 **************************************************************************** */

import java.util.Scanner;

public class NimPlayer
{
    private Scanner keyboard;
    private String name;
    private int removeStone;                     //the number of stones input

    NimPlayer(String name, Scanner keyboard)     //constructor NimPlayer()
    {
        this.name = name;
        this.keyboard = keyboard;
    }

    public int removeStone()                    //return the number of stones input
    {
        System.out.println();
        System.out.println(name + "'s turn - remove how many?");
        removeStone = keyboard.nextInt();
        return removeStone;
    }

    public void win()                          //print the name of winner
    {
        System.out.println("Game Over");
        System.out.println(name + " wins!");
    }
}


















