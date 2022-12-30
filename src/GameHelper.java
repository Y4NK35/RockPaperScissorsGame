import java.util.Scanner;

public class GameHelper {
    private boolean gameOver = false;
    private String NPCGameElementChoice;
    private String userAnswer;
    private int playerWins = 0;
    private int npcWins = 0;
    private int draws = 0;
    private String result;
    public GameHelper() {
    }
    public void showWelcomeScreen(){
        System.out.println("\n\nWelcome to the game \"rock, paper, scissors\". Let`s play! \n");
    }


    public void getUserInput(String prompt){
        String Answer;
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        Answer= scanner.nextLine().toUpperCase();
        setUserAnswer(Answer);
    }
    public boolean IsInputAnswerCorrect(){
        if (userAnswer.equals(GameElements.PAPER.toString())
                ||userAnswer.equals(GameElements.SCISSORS.toString())
                ||userAnswer.equals(GameElements.ROCK.toString())){
            return true;
        }else {
            return false;
        }
    }
    public void checkResult(){
        if(userAnswer.equals(NPCGameElementChoice)){
            draws++;
            result ="DRAW";
        }else if(userAnswer.equals(GameElements.SCISSORS.toString()) && NPCGameElementChoice.equals(GameElements.PAPER.toString())
               ||userAnswer.equals(GameElements.PAPER.toString()) && NPCGameElementChoice.equals(GameElements.ROCK.toString())
               ||userAnswer.equals(GameElements.ROCK.toString()) && NPCGameElementChoice.equals(GameElements.SCISSORS.toString())){
            playerWins++;
            result ="PLAYER";
        }else{
            npcWins++;
            result ="NPC";
        }
    }

    public void showResult(){
        checkResult();
        if(result.equals("DRAW")){
            System.out.println("This is a draw. You and npc  chosen: "+ userAnswer.toLowerCase()+".");
        }else if(result.equals("PLAYER")){
            System.out.println("You won. You chosen: "+ userAnswer.toLowerCase()+". Npc chosen: "+NPCGameElementChoice.toLowerCase()+ ".");
        }else{
            System.out.println("You lost. You chosen: "+ userAnswer.toLowerCase()+". Npc chosen: "+NPCGameElementChoice.toLowerCase()+ ".");
        }
    }
    public boolean IsInputEndGameCorrect(){
        if (userAnswer.equals("YES")
            ||userAnswer.equals("NO")){
            return true;
        }else {
            return false;
        }
    }
    public void checkEndAnswer(){
        if(userAnswer.equals("NO")){
            endMessage();
            gameOver=true;
        }else
            System.out.println("");
    }
    public void endMessage(){
        System.out.println("Thank you for playing.\nRESULTS: \nWINS: "+ playerWins+"\nDEFEATS: "+ npcWins+ "\nDRAWS: "+draws);
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    public void setNPCGameChoice() {
        this.NPCGameElementChoice = GameElements.randomGameElement().toString();
    }
}
