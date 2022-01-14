package com.example.simplecalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1,edtNum2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    TextView tvResult;
    String num1, num2;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar=getSupportActionBar(); //액션바 정보를 얻어옴
        bar.setTitle("간단한 계산기");
        bar.setIcon(R.drawable.blue); //아이콘 세팅
        bar.setDisplayShowHomeEnabled(true); //아이콘을 보여줌
//      bar.hide();
        edtNum1=findViewById(R.id.edtNum1);
        edtNum2=findViewById(R.id.edtNum2);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);
        tvResult=findViewById(R.id.tvResult);

        // 더하기 버튼 기능
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edtNum1.getText().toString(); //edtNum1의 텍스트를 문자형태로 가져옴
                num2 = edtNum2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    showToast("입력값이 비었습니다.");

                } else {
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                    tvResult.setText("계산결과 : " + result);
                    }
            }
        });
        // 빼기 버튼 기능
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edtNum1.getText().toString(); //edtNum1의 텍스트를 문자형태로 가져옴
                num2 = edtNum2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    showToast("입력값이 비었습니다.");
                }else{
                    result = Integer.parseInt(num1)-Integer.parseInt(num2);
                    tvResult.setText("계산결과 : " + result);

                }
            }
            });

        //곱하기 버튼 기능
        btnMul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = edtNum1.getText().toString(); //edtNum1의 텍스트를 문자형태로 가져옴
                    num2 = edtNum2.getText().toString();
                    if (num1.equals("") || num2.equals("")) {
                        showToast("입력값이 비었습니다.");
                    }else{
                        result = Integer.parseInt(num1)*Integer.parseInt(num2);
                        tvResult.setText("계산결과 : " + result);
                    }
                }
        });

        // 나누기 버튼 기능
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* public void onClick (View view){
               try {
                    num1 = edtNum1.getText().toString();
                    num2 = edtNum2.getText().toString();
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    tvResult.setText("계산결과 : " + result);
                }catch (ArithmeticException e){
                    Toast.makeText(getApplicationContext(),"0으로 나누지 마세요.",Toast.LENGTH_SHORT).show();
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT).show();
                }*/

                    num1 = edtNum1.getText().toString(); //edtNum1의 텍스트를 문자형태로 가져옴
                    num2 = edtNum2.getText().toString();
                    if (num1.equals("") || num2.equals("")) {
                        showToast("입력값이 비었습니다.");
                    } else if (num2.equals("0")) {
                        showToast("0으로 나누지 마세요.");
                    } else {
                        result = Integer.parseInt(num1) / Integer.parseInt(num2);
                        tvResult.setText("계산결과 : " + result);
                    }
                }
        });

    }//onCreat 메서드 종료
    //토스트 처리 메서드
    void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}//MainActivity 메서드 종료