package com.example.quranclasstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quranbinary.QuranData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Character> quranChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quranChar = new ArrayList<>();

        QuranData data = new QuranData(this);
        quranChar = data.getQuranCharacters();

        int size = quranChar.size();

        Toast.makeText(this, "No of Char: " + size, Toast.LENGTH_LONG).show();

    }
}
