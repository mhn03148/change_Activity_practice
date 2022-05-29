package com.example.change_activity_practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    public static final int REQUST_CODE_MENU = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_newactivity = findViewById(R.id.btn_newactivity);
        btn_newactivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                startActivityForResult(intent, REQUST_CODE_MENU);
            }
        });
        setContentView(R.layout.map_page);
        Button btn_gps = findViewById(R.id.btn_gps);
        btn_gps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUST_CODE_MENU){
            Toast.makeText(getApplicationContext(),"onActivityResult 함수 호출됨. 요청 코드 : " + resultCode,
                    Toast.LENGTH_SHORT).show();
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(),"응답으로 전달된 name : " + name, Toast.LENGTH_SHORT).show();
            }
        }
    }
}