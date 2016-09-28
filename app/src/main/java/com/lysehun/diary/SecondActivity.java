package com.lysehun.diary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by lysehun on 2016/9/25.
 */

public class SecondActivity extends Activity {

    private Button btnsave;
    private EditText etright;
    private TextView tv;
    private SaveObject sofile,getfile;
    private String filename;
    private String empstr="";
    private String strmsg;
    private static String btnmsg="今天我还没有写日记。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnsave=(Button)findViewById(R.id.btnsave);
        etright=(EditText)findViewById(R.id.etright);


        final Intent data = getIntent();
        sofile = new SaveObject();

        filename="object_"+data.getStringExtra("msg");
        if(getObject(filename)!=null){
            sofile=(SaveObject) getObject(filename);
            strmsg=sofile.getDairytext();
            etright.setText(strmsg);
        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                sofile.setDairytext(etright.getText().toString());

//保存对象到本地
                saveObject(filename);

//得到保存于本地路径的对象

                strmsg=sofile.getDairytext();
                Bundle bundle =new Bundle();
                bundle.putString("rs",strmsg);
                data.putExtras(bundle);
                setResult(RESULT_OK,data);
                finish();
            }
        });
    }
    private void saveObject(String name){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = this.openFileOutput(name, MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sofile);
        } catch (Exception e) {
            e.printStackTrace();
            //这里是保存文件产生异常
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    //fos流关闭异常
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    //oos流关闭异常
                    e.printStackTrace();
                }
            }
        }
    }
    private Object getObject(String name){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = this.openFileInput(name);
            ois = new ObjectInputStream(fis);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            //这里是读取文件产生异常
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    //fis流关闭异常
                    e.printStackTrace();
                }
            }
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    //ois流关闭异常
                    e.printStackTrace();
                }
            }
        }
        //读取产生异常，返回null
        return null;
    }
}
