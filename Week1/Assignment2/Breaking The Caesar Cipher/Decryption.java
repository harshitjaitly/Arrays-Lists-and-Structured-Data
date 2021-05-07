
/**
 * Write a description of Decryption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.* ;
public class Decryption 
{
    public int[] countLetters(String message)
    {
        String alph = "abcdefghijklmnopqrstuvwxyz" ;
        int[] counts = new int[26] ;
        for(int i=0 ; i<message.length() ; i++)
        {
            char ch = Character.toLowerCase(message.charAt(i)) ;
            int index = alph.indexOf(ch) ;
            if(index != -1)
            {
                counts[index]++ ;
            }
        }
        return counts ;
    }
    public int maxIndex(int[] counts)
    {
        int maxIndex = 0 ;
        int maxCount = counts[0] ;
        for(int i = 1 ; i<counts.length ; i++)
        {
            int count = counts[i] ;
            if(count > maxCount)
            {
                maxCount = count ;
                maxIndex = i ;
            }
        }
        return maxIndex ;
    }
    public String decrypt(String message)
    {
        int[] counts = countLetters(message) ;
        int maxIndex = maxIndex(counts) ;
        int decryptKey = maxIndex - 4 ;
        if(maxIndex < 4)
        {
            decryptKey = 26 - (4 - maxIndex) ;
        }
        CaesarCipher cc = new CaesarCipher();
        String decryptedMessage = cc.encrypt(message, 26- decryptKey);
        return decryptedMessage ;
    }
    public String halfOfString(String message , int start)
    {
        String halfString = "" ;
        for(int i = start ; i<message.length() ; i+=2)
        {
            halfString+=message.charAt(i) ;
        }
        return halfString ; 
    }
    public int getEncryptKey(String message)
    {
        int[] counts = countLetters(message) ;
        int maxIndex = maxIndex(counts) ;
        int decryptKey = maxIndex - 4 ;
        if(maxIndex < 4)
        {
            decryptKey = 26 - (4 - maxIndex) ;
        }
        return decryptKey ;
    }
    public String decryptTwoKeys(String message)
    {
        String firstHalf = halfOfString(message, 0) ;
        String secondHalf = halfOfString(message, 1) ;
        
        // Finding keys used to encryt
        int key1 = getEncryptKey(firstHalf) ;
        int key2 = getEncryptKey(secondHalf) ;
        System.out.println("Key1 : "+key1+"\nKey2 :"+key2+"\n") ;
        
        CaesarCipher cc = new CaesarCipher();
        String decryptedMessage = cc.encryptTwoKeys(message, 26 - key1, 26 - key2) ;
        
        return decryptedMessage ;
    }
    public void test()
    {
        String message = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        // String alph = "abcdefghijklmnopqrstuvwxyz" ;
        // int[] counts = countLetters(message) ;
        // for(int i = 0 ; i < alph.length() ; i++)
        // {
            // System.out.println("Count of "+alph.charAt(i)+" : "+counts[i]) ;
        // }
        // int maxIndex = maxIndex(counts) ;
        // System.out.println("Max Occurence : "+alph.charAt(maxIndex)) ;

        // System.out.println("Encrypted Message : "+message) ;
        // System.out.println("Decrypted Message : "+decrypt(message)) ;

        // System.out.println("Message : "+message);
        // System.out.println("Half String 1 : "+halfOfString(message, 0)) ;
        // System.out.println("Half String 1 : "+halfOfString(message, 1)) ;
        
        System.out.println("Encrypted Message : "+message) ;
        String decrypted = decryptTwoKeys(message) ;
        System.out.println("\nDecrypted Message : "+decrypted) ;
    }
    public void decrpytTextFile()
    {
        FileResource fr = new FileResource() ;
        String encrypted = fr.asString() ;
        String decrypted = decryptTwoKeys(encrypted) ;
        System.out.println("Decrypting using Two Keys \n=======================") ;
        System.out.println(decrypted) ;
    }
}
