import java.util.HashMap;

public class Scrabble {
    String myStr;
    Integer[] scores = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,8,4,10};
    String letters1 ="ABCDEFGHIJKLMNOPQRSTUWXYZ";
    //Converting the String into Character[]
    Character[] scrabbleLetters = new String(letters1.toCharArray()).chars().mapToObj(c -> (char) c).toArray(Character[]::new);

    //extended part
    boolean doubleWord , tripleWord;
    Character[] doubleLetters, tripleLetters;

    //HashMap = key abd value
    HashMap<Character, Integer> lettersMap = new HashMap<Character, Integer>();
    public void keyValue(){
        for(int j=0; j< scores.length; j++){
            lettersMap.put(scrabbleLetters[j],scores[j]);
            }
    }

    //Constructor 1
    public Scrabble(String str){
        myStr = (str == null?str="" : str);
    }
    //Constructor 2
    public Scrabble(String str,Character[] doubleL, Character[] tripleL, boolean doubleW, boolean tripleW){
        myStr = (str == null?str="" : str);
        doubleWord = doubleW;
        tripleWord = tripleW;
        doubleLetters = doubleL;
        tripleLetters = tripleL;
    }

    //Preparing the wordInput string and char Array
    public char[] strSplit(){
        return myStr.toUpperCase().toCharArray();
    }

    // Score Calculation
    public int scoreOnlyString(){
        keyValue();
        int result = 0;
        for(char element : strSplit()){
            if (lettersMap.containsKey(element)){
               result += lettersMap.get(element);
            }
        }
        return result;
    }

    //Check if it is double word score and triple word score
    public int doubleWord(){
//        int result = scoreOnlyString();
        return (doubleWord ? scoreOnlyString() : 0);
    }
    public int tripleWord(){
        return (tripleWord ? scoreOnlyString()*2 : 0);
    }

    //Check if it is double letters score and triple letters score
    public int doubleLetters(){
        int result = 0;
       if(doubleLetters != null){
           for (Character l:doubleLetters) {
               result += lettersMap.get(l);
           }
       }
        return result;

    }
    public int tripleLetters(){
        int result = 0;
        if(tripleLetters != null){
            for (Character l:tripleLetters) {
                result += lettersMap.get(l);
            }
        }
        return result *2;
    }

    //Total score
    public long score(){
        return scoreOnlyString()+ doubleWord()+tripleWord()+ doubleLetters()+tripleLetters();
    }

}
