
/* *****************************************************************************
*  Name:    CONGXIN ZHANG
*  studentID:   954515
*  Description:  an implementation of the game of Nim
*
*  Written:       26/04/2019
*  Last updated:  06/05/2019
**************************************************************************** */

import java.util.Scanner;
import java.text.NumberFormat;


public class Nimsys {
  //Sort by the order of the alphabets in the string
  private static int alphabetOrder(String str1, String str2) {
    int i =0;
    int length1 = str1.length();
    int length2 = str2.length();
    for (int k = 0; k < length1 && k < length2; k++) {
      //Compare the size of each letter in turn
      char alphabet1 = str1.charAt(k);
      char alphabet2 = str2.charAt(k);
      if (alphabet1 < alphabet2) {
          break;
      } else if (alphabet1 > alphabet2) {
          i = 1;
          break;
      }
    }
    return i;
  }
  //Output sorted results
  private static void rankingsOutput(float ratio, int num, String givenName, String familyName){
    //Convert ratio to a percentage
    NumberFormat nt = NumberFormat.getPercentInstance();
    nt.setMinimumFractionDigits(0);
    String str = nt.format(ratio);
    //Leave five spaces
    str = String.format("%-5s", str);
    //Display with two digits
    String str1 = String.format("%02d", num);
    System.out.println(str + "| " + str1 + " games " + "| " + givenName + " " + familyName);
  }


  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    NimGame game = new NimGame(keyboard);
    int i;
    int j;
    int t;
    //a is used to exchange two arrays
    NimPlayer a;
    String winnerName;
    String frontCommand = "";
    String backCommand = "";
    String command = "";
    NimPlayer[] player = new NimPlayer[100];
    System.out.println("Welcome to Nim");
    System.out.println();
    System.out.print("$");
    while(!command.equals("exit")){
      command = keyboard.nextLine();
      //The command does not include spaces
      if (!command.contains(" ")) {
        frontCommand = command;
      }else{
        frontCommand = command.substring(0, command.indexOf(" "));
        backCommand = command.substring(command.indexOf(" ") + 1);

      }
      switch(frontCommand) {
        case "addplayer":
          //split command by ","
          String[] name = backCommand.split(",");
          if (player[0] == null) {
            //Assign values to object properties
            player[0] = new NimPlayer(name[0], name[1], name[2], 0, 0);
          } else {
            for (i = 0; i < player.length; i++) {
              if (player[i] == null) {
                //Assign values to object properties
                player[i] = new NimPlayer(name[0], name[1], name[2], 0, 0);
                break;
              } else if (player[i].userName.equals(name[0])) {
                System.out.println("The player already exists.");
                break;

              }
            }
          }
          System.out.println();
          System.out.print('$');
          break;

        case "removeplayer":
          if (!command.contains(" ")) {
            System.out.println(("Are you sure you want to remove all players? (y/n)"));
            String is = keyboard.next();
            if (is.equals("y")) {
              for (i = 0; player[i] != null; i++) {
                //remove all players
                player[i] = null;
              }
            }
            System.out.println();
            System.out.print('$');
            break;
          } else {
              for (i = 0; i < player.length; i++) {
                //there is no such player in the array
                if (player[i] == null) {
                  System.out.println("The player does not exist.");
                  break;
                } else if (player[i].userName.equals(backCommand)) {
                  //remove the ith player,and move the player after i forward
                    for (int k = 0; player[k] != null ; k++) {
                      if (k >= i) {
                        player[k] = player[k + 1];
                      }
                    }
                    break;
                }
              }
              System.out.println();
            System.out.print('$');
            break;
          }

        case "editplayer":
          String[] name1 = backCommand.split(",");
            for (i = 0; i < player.length; i++) {
              if (player[i] == null) {
                System.out.println("The player does not exist.");
                break;
              } else if (player[i].userName.equals(name1[0])) {
                //update familyName and givenName
                player[i].familyName = name1[1];
                player[i].givenName = name1[2];
                break;
              }
            }
            System.out.println();
          System.out.print('$');
          break;

        case "resetstats":
          if (!command.contains(" ")) {
            System.out.println(("Are you sure you want to reset all player statistics? (y/n)"));
            String is = keyboard.next();
            if (is.equals("y")) {
              for (i = 0; player[i] != null; i++) {
                //resetstats means both numberPlayed and numberWon are 0
                player[i].numberPlayed = 0;
                player[i].numberWon = 0;
                player[i].ratio = 0;
              }
            }
            System.out.println();
            System.out.print('$');
            break;
          } else {
              for (i = 0; i < player.length; i++) {
                //there is no such player
                if (player[i] == null) {
                  System.out.println("The player does not exist.");
                  break;
                }
                if (player[i].userName.equals(backCommand)) {
                  //reset the ith player
                  player[i].numberPlayed = 0;
                  player[i].numberWon = 0;
                  player[i].ratio = 0;
                  break;
                }
              }

              System.out.println();
            System.out.print('$');
            break;
          }

        case "displayplayer":
          if (!command.contains(" ")) {
              for (i = 0; player[i] != null; i++) {
                for (j = i + 1; player[j] != null; j++) {
                  //according to the alphabet order sorting
                  t = alphabetOrder(player[i].userName, player[j].userName);
                  if (t == 1) {
                    a = player[i];
                    player[i] = player[j];
                    player[j] = a;
                  }
                }
              }
              for (i = 0; player[i] != null; i++) {
                System.out.println(player[i].userName + ',' + player[i].givenName + ',' +
                        player[i].familyName + ',' + player[i].numberPlayed + " " +
                        "games" + "," + player[i].numberWon + " " + "wins");
              }
            System.out.println();
            System.out.print('$');
            break;
          } else {
              for (i = 0; i < player.length; i++) {
                if (player[i] == null) {
                  System.out.println("The player does not exist.");
                  break;
                } else if (player[i].userName.equals(backCommand)) {
                  //display the ith player
                  System.out.println(player[i].userName + ',' + player[i].givenName + ',' +
                          player[i].familyName + ',' + player[i].numberPlayed + " " +
                          "games" + "," + player[i].numberWon + " " + "wins");
                  break;
                }
              }
              System.out.println();
            System.out.print('$');
            break;
          }

        case "rankings":
          //command contains whitespace and in ascending order
          if (command.contains(" ") && backCommand.equals("asc")) {
            for (i = 0; player[i] != null; i++) {
              for (j = i + 1; player[j] != null; j++) {
                if (player[i].ratio > player[j].ratio) {
                  //exchange two player in the array
                  a = player[i];
                  player[i] = player[j];
                  player[j] = a;
                } else if (player[i].ratio == player[j].ratio) {
                  //compare the alphabet order if the ratio is the same
                  t = alphabetOrder(player[i].userName, player[j].userName);
                  if (t == 1) {
                    a = player[i];
                    player[i] = player[j];
                    player[j] = a;
                  }
                }
              }
            }
            for (i = 0; player[i] != null; i++) {
              rankingsOutput(player[i].ratio, player[i].numberPlayed, player[i].givenName,
                      player[i].familyName);
            }

            System.out.println();
            System.out.print('$');
            break;
          } else {
            //ranking in descending order
              for (i = 0; player[i] != null; i++) {
                for (j = i + 1; player[j] != null; j++) {
                  if (player[i].ratio < player[j].ratio) {
                    a = player[i];
                    player[i] = player[j];
                    player[j] = a;
                  } else if (player[i].ratio == player[j].ratio) {
                    //compare the alphabet order if the ratio is the same
                    t = alphabetOrder(player[i].userName, player[j].userName);
                    if (t == 1) {
                      a = player[i];
                      player[i] = player[j];
                      player[j] = a;
                    }
                  }
                }
              }
              for (i = 0; player[i] != null; i++) {
                rankingsOutput(player[i].ratio, player[i].numberPlayed, player[i].givenName,
                        player[i].familyName);
              }

              System.out.println();
              System.out.print('$');
              break;
          }

        case "startgame":
          //split the backcommand
          String[] initialization = backCommand.split(",");
          //transfer the string into integer
          int initialNumber = Integer.parseInt(initialization[0]);
          int upperNumber = Integer.parseInt(initialization[1]);
          // if there are less than two players
          if(player[1] == null){
            System.out.println("One of the players does not exist.");
            System.out.println();
          }else{
            for(i=0; i < player.length ;i++){
              //cannot find the first player
              if(player[i] ==null){
                System.out.println("One of the players does not exist.");
                System.out.println();
                break;
              }else if(player[i].userName.equals(initialization[2])){
                //have found the first player,serch for the second player
                for(j=0; j < player.length; j++){
                  if(player[j] == null){
                    System.out.println("One of the players does not exist.");
                    System.out.println();
                    break;
                  }else if(player[j].userName.equals(initialization[3])){
                    //have found both players
                    String fullName1 = player[i].givenName+" "+player[i].familyName;
                    String fullName2 = player[j].givenName+" "+player[j].familyName;
                    //nimgame beginning
                    winnerName = game.game(initialNumber,upperNumber,fullName1,fullName2);
                    //after game,the numberplayer will increase
                    player[i].numberPlayed = player[i].numberPlayed+1;
                    player[j].numberPlayed = player[j].numberPlayed+1;
                    if(winnerName.equals(player[i].givenName)){
                      //according to new numberplayed and numberWon to compute the ratio
                      player[i].numberWon = player[i].numberWon +1;
                      player[i].ratio = (float)player[i].numberWon/player[i].numberPlayed;
                      player[j].ratio = (float)player[j].numberWon/player[j].numberPlayed;
                    }else if(winnerName.equals(player[j].givenName)){
                      //according to new numberplayed and numberWon to compute the ratio
                      player[j].numberWon = player[j].numberWon + 1;
                      player[i].ratio = (float)player[i].numberWon/player[i].numberPlayed;
                      player[j].ratio = (float)player[j].numberWon/player[j].numberPlayed;
                    }
                    break;
                  }
                }
                break;
              }
            }
          }
          System.out.print('$');
          break;

        case "exit":
          System.out.println();
          break;
      }
    }
  }
}

