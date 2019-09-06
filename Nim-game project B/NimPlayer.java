
/* *****************************************************************************
 *  Name:    CONGXIN ZHANG
 *  studentID:   954515
 *  Description:  designing and implementing a simple variant of the game of Nim
 *
 *  Written:       26/04/2019
 *  Last updated:  06/05/2019
 **************************************************************************** */

import java.util.Scanner;

public class NimPlayer
{
     private Scanner keyboard;
     String userName;
     String givenName;
     String familyName;
     private String fullName;
     int numberPlayed;
     int numberWon;
     float ratio = 0;

    //constructor NimPlayer()
    NimPlayer(String fullName, String givenName, Scanner keyboard)
    {
        this.fullName = fullName;
        this.givenName = givenName;
        this.keyboard = keyboard;
    }

    NimPlayer(String userName, String familyName, String givenName,int numberWon,int numberPlayed)
    {
        this.userName = userName;
        this.familyName = familyName;
        this.givenName = givenName;
        this.numberWon = numberWon;
        this.numberPlayed = numberPlayed;
    }

    //return the number of stones input
    int removeStone()
    {
        System.out.println();
        System.out.println(givenName + "'s turn - remove how many?");
        //the number of stones input
        return keyboard.nextInt();
    }

    //print the name of winner
    void win()
    {
        System.out.println("Game Over");
        System.out.println( fullName+ " wins!");
    }
}


















