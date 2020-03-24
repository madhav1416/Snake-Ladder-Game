
import SnakeLadder.*;
import java.util.*;

public class Main {

   public static void main(String args[])
   {
       Scanner sc= new Scanner(System.in);
       System.out.println("\t\t\t\t\t\tWant to play Snake and Ladder Game");
       System.out.println("Press Y/N for yes or no ?");
       char pressEnter=sc.next().charAt(0);
       if(pressEnter=='y'||pressEnter=='Y')
       {
           SnakeGame snake=new SnakeGame();
           snake.displayBoard();
            snake.playGame();
            snake.playAgain();

       }
       else
       {
           System.out.println("Thanks for the visit");
       }
       sc.close();
   }
}