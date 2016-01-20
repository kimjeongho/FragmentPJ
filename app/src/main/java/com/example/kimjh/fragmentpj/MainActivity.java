package com.example.kimjh.fragmentpj;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FirstFragment firstFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = (FirstFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        //Activity에 배치된 Fragment를 얻어오기 위해서는 FragmentManager().findFragmentById를 가져와서 Id를 지정한 fragment를 얻어 올수 있다.
        //정적 Fragment얻어오기

        Button btn = (Button)findViewById(R.id.btn_show);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstFragment = new FirstFragment();        //Fragment생성
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //getSupportFragmentManager()로 FragmentManager를 가져온 다음에.beginTransaction()으로 FragmentTransaction을 생성.
                ft.replace(R.id.container,firstFragment);//replace로 fragment를 배치할 Layout의 id와 배치할 fragment지정하여 추가.
                //replace : 기존에 fragment가 있으면 삭제하고 새로 생성 add: 기존에 있는것 포함하여 생성.
                ft.commit();    //화면에 배치
            }
        });

        btn = (Button)findViewById(R.id.btn_message);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = firstFragment.getMessage();//?? firstFragment에 있는 getMessage 메소드를 가져온다.
                Toast.makeText(MainActivity.this,"message:"+message,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
