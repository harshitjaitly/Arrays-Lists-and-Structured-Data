
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.* ;
public class WordPlay 
{
    public boolean isVowel(char ch)
    {
        String check = "AEIOU" ;
        ch = Character.toUpperCase(ch) ;
        for(int i=0 ; i < check.length() ; i++)
        {
            if(check.charAt(i)== ch)
            {
                return true ;
            }
        }
        return false ;
    }
    public String replaceVowels(String phrase , char ch)
    {
        StringBuilder sb = new StringBuilder(phrase) ;
        for(int i=0 ; i<sb.length() ; i++)
        {
            if(isVowel(phrase.charAt(i)))
            {
                sb.setCharAt(i, ch); 
            }
        }
        return sb.toString() ;
    }
    public String emphasize(String phrase , char ch)
    {
        StringBuilder sb = new StringBuilder(phrase) ;
        for(int i=0 ; i<sb.length() ; i++)
        {
            if(phrase.charAt(i) == ch)
            {
                if(i%2 == 0)
                {
                    sb.setCharAt(i, '*');    
                    continue ;
                }
                sb.setCharAt(i, '+');    
            }
        }
        return sb.toString() ;
    }
    public void testReplaceVowels()
    {
        String phrase = "Hello World" ;
        char ch = '*' ;
        System.out.println("Phrase : "+phrase) ;
        System.out.println("Character : "+ch) ;
        System.out.println("Replaced : "+replaceVowels(phrase, ch)) ;
    }
    public void testEmphasize()
    {
        String phrase = "dna ctgaaactga" ;
        char ch = 'a' ;
        System.out.println("Phrase : "+phrase) ;
        System.out.println("Character : "+ch) ;
        System.out.println("Emphasized : "+emphasize(phrase, ch)) ;
    }
}
