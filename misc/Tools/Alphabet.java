package Tools;

public class Alphabet {
    final String[] digits = {"","0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};


    private String input;
    private int[] valueArray;
    public Alphabet(String input)
    {
        this.input = input.toLowerCase();
        analyse();
    }

    private void analyse(){
        valueArray = new int[input.length()];
        for ( int i = 0 ;i < input.length() ; i++ ){
            for ( int l = 0 ; l < digits.length ; l++ ){
                if ( input.substring(i, i+1).equals(digits[l]) ){
                    valueArray[i] = l ;
                }
            }
            if ( Integer.valueOf(valueArray[i]).equals(null)  ){
                valueArray[i] = 0;
            }
        }
    }

    public int[] getValueArray(){
        return valueArray;
    }

    public String getString(){
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
