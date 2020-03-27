
//In the Name of Allah Most Gracious Most Merciful

package com.example.quranbinary;

import android.content.Context;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuranData {


    //open an ArrayList for the Lists: quranVerses
    //another list for the Characters: quranCharacters

    /*
    while(not all lines read from the file)
    {
           read new line()
                add the characters of the current Line into the quranCharacters
     }
     return the characterList, its size
     return the versesList, its size
     should all happen in the constructor
     make sure to get context
     */


        private Context myContext;
        private ArrayList<Character> quranCharacters ;
        private ArrayList<String> quranVerses;
        private ArrayList<Integer> indexOfVerseHeaders;
        private ArrayList<Integer> indexOfCharacters;


        //private static File quranFile = new File("/src/main/assets/quran_text.txt");
        //Avoided this method of finding file... very messy

    public ArrayList<Integer> getIndexOfVerseHeaders() { return indexOfVerseHeaders; }

    public ArrayList<Integer> getIndexOfCharacters() { return indexOfCharacters; }

    public ArrayList<Character> getQuranCharacters() {
        return quranCharacters;
    }

    public ArrayList<String> getQuranVerses() {
        return quranVerses;
    }

    public QuranData(Context context)
        {
            myContext = context;
            indexOfCharacters = new ArrayList<>();
            indexOfVerseHeaders = new ArrayList<>();
            quranCharacters = new ArrayList<>();
            quranVerses = new ArrayList<>();

            InputStream inputStream = myContext.getResources().openRawResource(
                    myContext.getResources().getIdentifier("quran_text",
                            "raw", myContext.getPackageName()));

            try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream)))
            {
                String verse = bufReader.readLine();
                while (verse != null)
                    {
                        indexOfVerseHeaders.add(quranCharacters.size());
                        quranVerses.add(verse);
                        //adding the verse to a List
                        char[] charsOfCurrentVerse = verse.toCharArray();
                        List<char[]> asList = Arrays.asList(charsOfCurrentVerse); //This lines has alot to say!
                        for (char c : charsOfCurrentVerse) {
                            if (c != ' ') {
                                quranCharacters.add(c);
                                indexOfCharacters.add(quranCharacters.size());
                            }
                        }
                        verse = bufReader.readLine();

                    }
                bufReader.close();
            }
            catch (FileNotFoundException e) {
               Toast.makeText(myContext, "No such file!" + e.toString(),Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                Toast.makeText(myContext, "Input Error" + e.toString(),Toast.LENGTH_LONG).show();
            }
        }

    public int getVerseForCharacterIndex(int myCharchter)
    {   //look for it in the indexOfVerseHeaders and return the index of the closest
       Integer nearestValue = 0;
        ArrayList<Integer> indexOFVerses  = getIndexOfVerseHeaders();

       for (Integer value :indexOFVerses)
       {
           if ( myCharchter <= value  ) {
               nearestValue = value;
               break;
           }

       }
        if (myCharchter > 330696 ) nearestValue = 330696;

       return indexOFVerses.indexOf(nearestValue);
    }
}