package com.movilla.externalstorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    FileOutputStream fos;
    EditText etext;
    EditText etext2;
   SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etext = (EditText) findViewById(R.id.e_text1);
        etext2 = (EditText) findViewById(R.id.e_text2);
    }
    public void saveInternalCache (View view){

        File folder = getCacheDir();
        File file = new File(folder, "output.txt");
        fos = null;
        String message = etext.getText().toString();
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      Toast.makeText(this, "Internal Cache!", Toast.LENGTH_LONG).show();
    }
    public void saveExternalCache (View view){

        File folder1 = getExternalCacheDir();
        File file1 = new File(folder1, "output1.txt");
        fos = null;
        String message = etext.getText().toString();
        try {
            fos = new FileOutputStream(file1);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "External Cache!", Toast.LENGTH_LONG).show();
    }
    public void saveShared (View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("msg", etext.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Shared Saved!", Toast.LENGTH_SHORT).show();

    }
    public void saveInternalStorage (View view) {
        String user = etext.getText().toString();
        String sp = ("\r\n");

        try {
            fos = openFileOutput("output2.txt", Context.MODE_PRIVATE);
            fos.write(user.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Internal Storage Saved!", Toast.LENGTH_SHORT).show();
    }

    public void NextAct(View view){
        Intent intent = new Intent(this, second_activity.class);

        startActivity(intent);

    }

    }

