public class Game{
  public static final int MAX_MISSES = 7;
  private String mAnswer;               //Answer for the Hangman Game
  private String mHits;
  private String mMisses;
  
  public Game(String answer){           //Constructor for getting the answer
    mAnswer = answer;
    mHits = "";                         //for keeping count of Hits
    mMisses = "";                       //for keeping count of Misses
  }
  
   private char validateGuess(char letter){
    if(! Character.isLetter(letter)){
      throw new IllegalArgumentException("A letter is required");
    }
    letter = Character.toLowerCase(letter);
    if(mMisses.indexOf(letter) >= 0 ){
      throw new IllegalArgumentException(letter + "has already been guessed");
    }
    return letter;
  }
  
  public boolean applyGuess(String letters){
    if(letters.length() == 0){
      throw new IllegalArgumentException("No letter found");
    }
      return applyGuess(letters.charAt(0));
  }
  
  public boolean applyGuess(char letter){
    letter = validateGuess(letter);
    boolean isHit = mAnswer.indexOf(letter) >= 0;
    if(isHit){
      mHits += letter; 
    }else{
      mMisses += letter;
    }
    return isHit;
  }
  
  public String getCurrentProgress(){
    String progress = "";
    for(char letter : mAnswer.toCharArray()){
      char display = '-';
      if(mHits.indexOf(letter) >= 0){
        display = letter;
      }
      progress += display;
    }
    return progress;
  }
  
  public int getRemainingTries(){
    return MAX_MISSES - mMisses.length();
  }
  
  public boolean isSolved(){
    return getCurrentProgress().indexof('-') == -1;
  }
  
  public String getAnswer(){
    return mAnswer;
  }
}