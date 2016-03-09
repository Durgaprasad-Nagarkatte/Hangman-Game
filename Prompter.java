import java.io.Console;
public class Prompter{                  //Created for taking input/output
  private Game mGame;
  
  public Prompter(Game game){
    mGame = game;
  }
  
  public void Play(){
    while(mGame.getRemainingTries() > 0 && !mGame.isSolved()){
      displayProgress();
      promptForGuess();
    }
    if(mGame.isSolved()){
      System.out.printf("Congragulations you win with %d tires remaining.\n",mGame.getRemainingTries());
    }
    else{
      System.out.printf("Bummer the word was :%s",mGame.getAnswer());
    }
  }
  
  public boolean promptForGuess() {
        Console console = System.console();
        boolean isHit = false;
        boolean isValidGuess = false;

        while (!isValidGuess) {
        String guessAsString = console.readLine("Enter a letter:  ");
          try {
            isHit = mGame.applyGuess(guessAsString);
            isValidGuess = true;
          } catch (IllegalArgumentException iae) {
            console.printf("%s. Please try again.\n", iae.getMessage());
          }
       }
         return isHit;
      }
  
  public void displayProgress(){
    System.out.printf("You have %d tries to solve :%s", mGame.getRemainingTries(),mGame.getCurrentProgress());
  }
  
  
}