package Tools;

public class Alphabet_Letter
{
    private final String[] digits = {"","0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private char letter;
    private int value;
    public Alphabet_Letter(char letter)
    {
        this.letter = Character.toLowerCase(letter);
        analyse();
    }

    private void analyse(){
        for ( int l = 1 ; l < digits.length ; l++ ){
            if ( letter == digits[l].charAt(0) ){
                value = l ;
            }
        }
        if ( (Integer.valueOf( value ).equals(null) ) ){
            value = 0;
        }
    }

    public int getValue(){
        return value;
    }

    public void setLetter(char letter){
        this.letter = Character.toLowerCase(letter);
        analyse();
    }

}
