
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
 
public class WordLengths 
{
    public String convertToWord(String word)
    {
        if(!Character.isLetter(word.charAt(0)))
        {
            word = word.substring(1) ;
        }
        int length = word.length() ;
        if( !Character.isLetter(word.charAt(length-1)))
        {
            word = word.substring(0,length-1) ;
        }
        return word ; 
    }
    public int[] countWordLengths(FileResource resource, int[] counts)
    {
        for(String s: resource.words())
        {
            s = convertToWord(s) ;
            int length = s.length() ;
            if(length < counts.length)
            {
                counts[length]++ ;
                continue ;
            }
            counts[counts.length-1]++ ;
        }
        return counts ;
    }
    public void testCountWordLengths()
    {
        // String filePath = "data/smallHamlet.txt" ;
        FileResource fr = new FileResource() ;
        int[] counts = new int[31] ;
        int[] lengths = countWordLengths(fr, counts) ;
        for(int i=0 ; i<lengths.length ; i++)
        {
            if(lengths[i] > 0)
            {
                System.out.println("Number of Words : "+lengths[i]+ " Length : "+i );
            }
        }
    }
}
