
public class Startup {
    private GameHelper gameHelper = new GameHelper();
    public Startup() {
    }

    public void start(){
        gameHelper.showWelcomeScreen();
        while(!gameHelper.isGameOver()){
            gameHelper.setNPCGameChoice();
            gameHelper.getUserInput("Select one from rock, paper or scissors and enter your answer.");
            while(!gameHelper.IsInputAnswerCorrect()){
                gameHelper.getUserInput("Your answer is incorrect. Select one from rock, paper or scissors and enter correct answer.");
            }
            gameHelper.showResult();
            gameHelper.getUserInput("Do you want play again? Select Yes or No and enter answer.");
            while(!gameHelper.IsInputEndGameCorrect()){
                gameHelper.getUserInput("Your answer is incorrect.Do you want play again? Select Yes or No and enter answer.");
            }
            gameHelper.checkEndAnswer();
        }
    }

}


