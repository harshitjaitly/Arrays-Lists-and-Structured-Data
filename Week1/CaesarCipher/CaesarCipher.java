
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.* ; 
public class CaesarCipher
{
    public String encrypt(String input, int key)
    {
        StringBuilder encrypted = new StringBuilder(input) ;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
        String shifted_alphabet = alphabet.substring(key)+alphabet.substring(0,key) ;
        
        for(int i=0 ; i<encrypted.length() ; i++)
        {
            char currChar = encrypted.charAt(i) ; 
            if(alphabet.indexOf(currChar) != -1)
            {
                char newChar = shifted_alphabet.charAt(alphabet.indexOf(currChar)) ;
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString() ;
    }
    public void testCaesar()
    {
        String input = "FIRST LEGION ATTACK EAST FLANK!" ;
        int key = 23 ;
        String encrypted = encrypt(input, key) ;
        System.out.println("Original essage : "+input) ;
        System.out.println("Key : "+key) ;
        System.out.println("Encrypted Message : "+encrypted) ;
    }
}
