package com.example.quranclasstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quranbinary.QuranData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Character> quranChar;
    ArrayList<Integer> character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        QuranData data = new QuranData(this);
        quranChar = data.getQuranCharacters();
        character = data.getIndexOfCharacters();
        int size2 = data.getVerseForCharacterIndex(450000);
    }
}
