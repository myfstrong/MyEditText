package com.example.administrator.myedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    String s = editText.getText().toString();
                    if(s.length()<5 || s.length()>10)
//                        Toast.makeText(MainActivity.this,s + "字符串长度不符合要求",Toast.LENGTH_SHORT).show();
                        editText.setError(s + "字符串长度不符合要求");
                    else
                        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
