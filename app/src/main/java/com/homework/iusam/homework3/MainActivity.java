package com.homework.iusam.homework3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // my code
        Button button = (Button)findViewById(R.id.button_sayhello);
        button.setOnClickListener(setName);
        Toast.makeText(MainActivity.this, "Hello ", Toast.LENGTH_SHORT).show();
     }

     private  static final int ACTIVITY_SET_NAME = 1 ;

    private OnClickListener setName = new  OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent() ;
            intent.setClass(MainActivity.this,Main2Activity.class) ;
            startActivityForResult(intent,ACTIVITY_SET_NAME);
        }
    } ;
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){

        String showname ;

        if(intent == null)
            return ;

        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode){
            case ACTIVITY_SET_NAME:
                showname = intent.getStringExtra("KEY_NAME") ;

                Toast.makeText(MainActivity.this, "Hello "+showname, Toast.LENGTH_LONG).show();

                break ;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about :
                AlertDialog.Builder ad = new AlertDialog.Builder(this) ;
                ad.setTitle("About this APP") ;
                ad.setMessage("Author : Iu-Sam Chong") ;

                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    public  void onClick(DialogInterface di, int i){
                    }
                } ;

                ad.setPositiveButton("OK", listener) ;
                ad.show() ;
                break ;
            case R.id.action_reset :
               // EditText cleartext = (EditText) findViewById(R.id.editText);
              //  cleartext.setText("");
                break ;
            case R.id.action_web :
                String url = "http://www.google.com" ;
                Intent i = new Intent(Intent.ACTION_VIEW) ;
                i.setData(Uri.parse(url)) ;
                startActivity(i) ;
                break ;
        }
        return super.onOptionsItemSelected(item);
    }

}
