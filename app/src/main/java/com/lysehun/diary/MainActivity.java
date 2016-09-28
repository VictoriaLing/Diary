package com.lysehun.diary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends Activity {

    private TextView leftbottom,leftbottom1,leftbottom2,leftbottom3,leftbottom4,leftbottom5,leftbottom6;
    private Button right,right1,right2,right3,right4,right5,right6;
    private ButtonListener listener;
    private static final int rcode=100,rcode1=200,rcode2=300,rcode3=400,rcode4=500,rcode5=600,rcode6=700;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindView();
        listener = new ButtonListener();
        SetClickListener();

    }



    private void FindView() {

        leftbottom=(TextView)findViewById(R.id.leftbottom);
        leftbottom1=(TextView)findViewById(R.id.leftbottom1);
        leftbottom2=(TextView)findViewById(R.id.leftbottom2);
        leftbottom3=(TextView)findViewById(R.id.leftbottom3);
        leftbottom4=(TextView)findViewById(R.id.leftbottom4);
        leftbottom5=(TextView)findViewById(R.id.leftbottom5);
        leftbottom6=(TextView)findViewById(R.id.leftbottom6);
        right=(Button)findViewById(R.id.right);
        right1=(Button)findViewById(R.id.right1);
        right2=(Button)findViewById(R.id.right2);
        right3=(Button)findViewById(R.id.right3);
        right4=(Button)findViewById(R.id.right4);
        right5=(Button)findViewById(R.id.right5);
        right6=(Button)findViewById(R.id.right6);

    }
    private void SetClickListener() {
        right.setOnClickListener(listener);
        right1.setOnClickListener(listener);
        right2.setOnClickListener(listener);
        right3.setOnClickListener(listener);
        right4.setOnClickListener(listener);
        right5.setOnClickListener(listener);
        right6.setOnClickListener(listener);

    }
    private  class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.right:
                    msg = leftbottom.getText().toString();
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("msg",msg);
                    startActivityForResult(intent,rcode);
                    break;
                case R.id.right1:
                    msg = leftbottom1.getText().toString();
                    Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                    intent1.putExtra("msg",msg);
                    startActivityForResult(intent1,rcode1);
                    break;
                case R.id.right2:
                    msg = leftbottom2.getText().toString();
                    Intent intent2 = new Intent(MainActivity.this,SecondActivity.class);
                    intent2.putExtra("msg",msg);
                    startActivityForResult(intent2,rcode2);
                    break;
                case R.id.right3:
                    msg = leftbottom3.getText().toString();
                    Intent intent3 = new Intent(MainActivity.this,SecondActivity.class);
                    intent3.putExtra("msg",msg);
                    startActivityForResult(intent3,rcode3);
                    break;
                case R.id.right4:
                    msg = leftbottom4.getText().toString();
                    Intent intent4 = new Intent(MainActivity.this,SecondActivity.class);
                    intent4.putExtra("msg",msg);
                    startActivityForResult(intent4,rcode4);
                    break;
                case R.id.right5:
                    msg= leftbottom5.getText().toString();
                    Intent intent5 = new Intent(MainActivity.this,SecondActivity.class);
                    intent5.putExtra("msg",msg);
                    startActivityForResult(intent5,rcode5);
                    break;
                case R.id.right6:
                    msg = leftbottom6.getText().toString();
                    Intent intent6 = new Intent(MainActivity.this,SecondActivity.class);
                    intent6.putExtra("msg",msg);
                    startActivityForResult(intent6,rcode6);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case rcode:
                if(resultCode ==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String rs = bundle.getString("rs");
                    right.setText(rs);

                }else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this,"没改。。。",Toast.LENGTH_SHORT).show();
                }
                break;
            case rcode1:
                if(resultCode ==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String rs = bundle.getString("rs");
                    right1.setText(rs);

                }else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this,"还是没写日记。。。",Toast.LENGTH_SHORT).show();
                }
                break;
            case rcode2:
                if(resultCode ==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String rs = bundle.getString("rs");
                    right2.setText(rs);

                }else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this,"还是没写日记。。。",Toast.LENGTH_SHORT).show();
                }
                break;
            case rcode3:
                if(resultCode ==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String rs = bundle.getString("rs");
                    right3.setText(rs);

                }else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this,"还是没写日记。。。",Toast.LENGTH_SHORT).show();
                }
                break;
            case rcode4:
                if(resultCode ==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String rs = bundle.getString("rs");
                    right4.setText(rs);

                }else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this,"还是没写日记。。。",Toast.LENGTH_SHORT).show();
                }
                break;
            case rcode5:
                if(resultCode ==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String rs = bundle.getString("rs");
                    right5.setText(rs);

                }else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this,"还是没写日记。。。",Toast.LENGTH_SHORT).show();
                }
                break;
            case rcode6:
                if(resultCode ==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String rs = bundle.getString("rs");
                    right6.setText(rs);

                }else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this,"还是没写日记。。。",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

}
