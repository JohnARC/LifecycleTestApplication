package com.example.me.testapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;


public class MainActivity extends ActionBarActivity {

    protected void onSavedInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("onsave", "saving state ...");
        outState.putString("Name", "Dr. Doom");
    }

    private class Student implements Serializable{
        private String name;
        private int age;

            public  Student(String name,int age){
                this.name =name;
                this.age = age;
            }
        @Override
        public String toString() {
            return this.name + " " + this.age;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("onsave"," ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
        Log.d("finishing",String.valueOf(this.isFinishing()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("info","Activity is Paused");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("onrestore","Restoring state...");
        String retrievedString = savedInstanceState.getString("Name");
        Log.d("onrestore",retrievedString);
    }
}
