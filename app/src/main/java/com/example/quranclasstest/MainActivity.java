package com.example.quranclasstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quranbinary.QuranData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> quranVerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quranVerse = new ArrayList<>();

        QuranData data = new QuranData(this);

        int verses = data.getQuranVerses().size();
        int characters = data.getQuranCharacters().size();

        quranVerse = data.getQuranVerses();
        String verse100 = quranVerse.get(100);

        Toast.makeText(this, verse100, Toast.LENGTH_LONG).show();




    }
}
