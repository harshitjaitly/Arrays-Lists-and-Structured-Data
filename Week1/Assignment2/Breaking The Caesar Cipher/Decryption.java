
/**
 * Write a description of Decryption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    public void test()
    {
        String message = "Yjhi p ithi higxcv lxiw adih du ttttttttttttttttth";
        // String alph = "abcdefghijklmnopqrstuvwxyz" ;
        // int[] counts = countLetters(message) ;
        // for(int i = 0 ; i < alph.length() ; i++)
        // {
            // System.out.println("Count of "+alph.charAt(i)+" : "+counts[i]) ;
        // }
        // int maxIndex = maxIndex(counts) ;
        // System.out.println("Max Occurence : "+alph.charAt(maxIndex)) ;
        System.out.println("Encrypted Message : "+message) ;
        System.out.println("Decrypted Message : "+decrypt(message)) ;
    }
}
