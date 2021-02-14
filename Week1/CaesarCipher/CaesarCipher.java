
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
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" ;
        String shifted_alphabet = alphabet.substring(key,26)+alphabet.substring(0,key)+alphabet.substring(26+key)+alphabet.substring(26,26+key) ;
        
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
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        String dualEncrypted = "" ;
        for(int i=0 ; i<input.length() ; i++)
        {
            String currChar = Character.toString(input.charAt(i)) ;
            if(i%2 != 0)
            {
                dualEncrypted += encrypt(currChar, key2) ;
                continue ;
            }
            dualEncrypted += encrypt(currChar, key1) ;
        }
        return dualEncrypted.toString() ;
    }
    public void testCaesar()
    {
        String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!" ;
        int key = 15 ;
        String encrypted = encrypt(input, key) ;
        System.out.println("Original essage : "+input) ;
        System.out.println("Key : "+key) ;
        System.out.println("Encrypted Message : "+encrypted) ;
    }
    public void testEncryptTwoKeys()
    {
        String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!" ;
        int key1 = 8 ;
        int key2 = 21 ;
        String encrypted = encryptTwoKeys(input, key1, key2) ;
        System.out.println("Original essage : "+input) ;
        System.out.println("Key 1: "+key1) ;
        System.out.println("Key 2: "+key2) ;
        System.out.println("Encrypted Message : "+encrypted) ;
    }
}
