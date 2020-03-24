package SnakeLadder;
import java.util.*;
public class SnakeGame {

    static Scanner sc=new Scanner(System.in);
    Random rand =new Random();
    Player p1=new Player();
    Player p2=new Player();
    int flag=0;
    public void displayBoard()
    {
        System.out.println("\n\n\n");
        int counter=100;
        System.out.println("-----------------------------------------------------------------------------Game Board---------------------------------------------------------------------");
        while(counter>0)
        {

            if(counter%2==0)
            {
                for(int i=counter;i>=counter-9;i--)
                {
                    if(i==99||i==92||i==76||i==50||i==23)
                    System.out.print("\t"+"S"+"\t");
                    else if(i==9||i==26||i==39||i==58||i==73)
                    System.out.print("\t"+"L"+"\t");
                    else
                    System.out.print("\t"+i+"\t");
                }
                System.out.println();
                counter -=9;
            }
            else
            {
                counter-=10;
                for(int i=counter;i<=counter+9;i++)
                {
                    if(i==99||i==92||i==76||i==50||i==23)
                    System.out.print("\t"+"S"+"\t");
                    else if(i==9||i==26||i==39||i==58||i==73)
                    System.out.print("\t"+"L"+"\t");
                    else
                    System.out.print("\t"+i+"\t");
                }
                System.out.println();
                counter -=1;
            }

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    //play a Game
    public void playGame()
{
    
        while(p1.pos!=100 || p2.pos!=100)
        {
        System.out.println("P1 roll a dice .Press R for roll");
        char roll=sc.next().charAt(0);
        if(roll=='R')
        {int player1=diceRoll();
        p1.pos += player1;
        move(p1);
        flag=1;
        win(p1,flag);
        Smashed(p1,p2,flag);
        if(p1.pos>100)
        p1.pos -= player1;
        }
        System.out.println("P2 roll a dice .Press R for roll");
         roll=sc.next().charAt(0);
        if(roll=='R')
        {int player2=diceRoll();
        p2.pos += player2;
        move(p2);
        flag=2;
        win(p2,flag);
        Smashed(p1,p2,flag);
        if(p2.pos>100)
        p2.pos -= player2;
        }
        displayBoard();
        System.out.println("Position of Player1 is "+p1.pos);
        System.out.println("Position of Player2 is "+p2.pos);
        }
}

  // to Roll adice
    public int diceRoll()
    {
        return (rand.nextInt(6)+1);
    }
    // It is used to check that dice has bitten or pick up a ladder
   public void move(Player p) {
        //for snake bitten
       if(p.pos==99)
       { System.out.println("Snake has bitten up .So, you drop to 2");
       p.pos=2;
       }
       else if(p.pos==92)
       { System.out.println("Snake has bitten up .So, you drop to 70");
       p.pos=70;
       }
       else if(p.pos==76)
       { System.out.println("Snake has bitten up .So, you drop to 45");
       p.pos=45;
       }else if(p.pos==50)
       { System.out.println("Snake has bitten up .So, you drop to 28");
       p.pos=28;
       }else if(p.pos==23)
       { System.out.println("Snake has bitten up .So, you drop to 5");
       p.pos=5;
       }
       //for ladder
       else if(p.pos==9)
       { System.out.println("Your token has lift upto 13");
       p.pos=13;
       }
       else if(p.pos==26)
       { System.out.println("Your token has lift upto 48");
       p.pos=48;
       }
       else if(p.pos==39)
       { System.out.println("Your token has lift upto 41");
       p.pos=41;
       }
       else if(p.pos==58)
       { System.out.println("Your token has lift upto 98");
       p.pos=98;
       }
       else if(p.pos==73)
       { System.out.println("Your token has lift upto 91");
       p.pos=91;
       }

    }

    //for Winning 
    public void win(Player p,int flag)
    {
        int temp=0;
        if(p.pos==100 && flag==1)
        {
            System.out.println("Player P1 has won the match");
            temp=1;
        }
        if(p.pos==100 && flag==2)
        {
            System.out.println("Player P2 has won the match");
            temp=1;
        }
        if(temp==1)
        {
        System.out.println("Do you want to play Again?");
        System.out.println("Enter Y/N");
        char replay=sc.next().charAt(0);
        if(replay=='y'||replay=='Y')
        playAgain();
        else
        System.out.println("Thanks for the Visit");
        }
        // sc.close();

    }

    //For Smashing
   public void Smashed(Player p1,Player p2,int flag) {
        if((p1.pos==p2.pos)&&flag==1)
        {  p2.pos=0;
           System.out.println("Player p1 smashed Player p2");
        }
        if((p1.pos==p2.pos)&&flag==2)
        {  p1.pos=0;
            System.out.println("Player p2 smashed Player p1");
         }
    }
    //For PlayAgain
    public void playAgain() {
        p1.pos=0;
        p2.pos=0;
        displayBoard();
        playGame();
    }
}