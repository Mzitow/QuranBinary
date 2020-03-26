package com.example.quranbinary;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        //private static File quranFile = new File("/src/main/assets/quran_text.txt");

    public ArrayList<Character> getQuranCharacters() {
        return quranCharacters;
    }

    public ArrayList<String> getQuranVerses() {
        return quranVerses;
    }

    public QuranData(Context context)
        {
            myContext = context;

            quranCharacters = new ArrayList<>();
            quranVerses = new ArrayList<>();

            InputStream ins = myContext.getResources().openRawResource(
                    myContext.getResources().getIdentifier("quran_text",
                            "raw", myContext.getPackageName()));

            try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(ins)))
            {
                String verse = bufReader.readLine();
                while (verse != null)
                    {
                        quranVerses.add(verse);
                        //adding the verse to a List
                        char[] charsOfCurrentVerse = verse.toCharArray();
                        List<char[]> asList = Arrays.asList(charsOfCurrentVerse);
                        for (char c : charsOfCurrentVerse)
                            quranCharacters.add(c);


                        verse = bufReader.readLine();
                    }

                bufReader.close();

            }
            catch (FileNotFoundException e) {
               Toast.makeText(myContext, "No such file!" + e.toString(),Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                e.printStackTrace();
            }

        }
}