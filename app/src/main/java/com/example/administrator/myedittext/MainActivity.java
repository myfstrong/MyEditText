package com.example.administrator.myedittext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.myedittext.R;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;

    Button faceBtn1;
    Button faceBtn2;
    Button faceBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);

        faceBtn1 = (Button)findViewById(R.id.faceBtn1);
        faceBtn2 = (Button)findViewById(R.id.faceBtn2);
        faceBtn3 = (Button)findViewById(R.id.faceBtn3);

        //实例1:在editText控件中输入字符后，当控件失去焦点时触发setOnFocusChangeListener监听事件
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

        //实例2：EditText中插入图片
        faceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step2.1:将图片资源face1包装成bitmap1对象
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.face1);
                //step2.2:将bitmap1对象再包装成imageSpan1对象，因ImageSpan类传给spannableString1.setSpan()的是图片，
                //而bitmap1传后显示的是字符串“face1”
                ImageSpan imageSpan1 = new ImageSpan(MainActivity.this,bitmap1);
                //step2.3:SpannableString标记的对象可以被附加和分离
                SpannableString spannableString1 = new SpannableString("face1");
                //step2.4:通过setSpan()将字符串“face1”替换成imageSpan1
                spannableString1.setSpan(imageSpan1,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                //step2.5:在editText5中追加字符串
                editText5.append(spannableString1);
            }
        });

        faceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.face2);
                ImageSpan imageSpan2 = new ImageSpan(MainActivity.this,bitmap2);
                SpannableString spannableString2 = new SpannableString("face2");
                spannableString2.setSpan(imageSpan2, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                editText5.append(spannableString2);
            }
        });

        faceBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.mipmap.face3);
                ImageSpan imageSpan3 = new ImageSpan(MainActivity.this,bitmap3);
                SpannableString spannableString3 = new SpannableString("face3");
                spannableString3.setSpan(imageSpan3,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                editText5.append(spannableString3);
            }
        });
    }
}
