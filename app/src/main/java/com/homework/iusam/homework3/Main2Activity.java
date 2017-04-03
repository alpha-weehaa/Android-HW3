package com.homework.iusam.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText editText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button Back = (Button)findViewById(R.id.button_back) ;
        Back.setOnClickListener(showtoast) ;
        editText = (EditText)findViewById(R.id.editText) ;
        //editText.setText("UNKNOW NAME");
    }

    private OnClickListener showtoast = new OnClickListener() {
        public void onClick(View v) {
            String Name = editText.getText().toString() ;

            Intent intent = new Intent();
            intent.putExtra("KEY_NAME",Name);
            setResult(RESULT_OK, intent);
            finish();
        }
     } ;
}
