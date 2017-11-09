package com.movilla.externalstorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class second_activity extends AppCompatActivity {
    TextView tvdisplay;
    FileInputStream fis;
    SharedPreferences preferences;
    BufferedReader br;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

    }
    public void GoBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        tvdisplay = (TextView) findViewById(R.id.tv_display);
        startActivity(intent);

    }
    public void LoadInfoInStore (View view) throws IOException {
        String read = "";
        try{
            fis = openFileInput("output.txt");
            br = new BufferedReader(new InputStreamReader(fis));
            if ((read = br.readLine()) != null)
                msg = read;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tvdisplay.setText(msg);
    }
    public void LoadInfoExStore(View view){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try{
            fis = openFileInput("output1.txt");
            while((fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        tvdisplay.setText(buffer.toString());
    }
    public void LoadInfoInStorage (View view) throws IOException {
        String read = "";
        try{
            fis = openFileInput("output2.txt");
            br = new BufferedReader(new InputStreamReader(fis));
            if ((read = br.readLine()) != null)
                msg = read;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tvdisplay.setText(msg);
    }
    public void loadPref (View view){
        String msg = preferences.getString("msg", "");

        tvdisplay.setText(msg);
    }
}
