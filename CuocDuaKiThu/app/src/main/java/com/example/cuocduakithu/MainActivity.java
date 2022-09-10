package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textViewDiemSo;
    EditText edittextDiemCuoc;
    SeekBar seekBarOne,seekBarTwo,seekBarThree;
    CheckBox checkBoxOne,checkBoxTwo,checkBoxThree;
    ImageButton buttonPlay;
    int soDiem= 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        seekBarOne.setEnabled(false);
        seekBarTwo.setEnabled(false);
        seekBarThree.setEnabled(false);
        textViewDiemSo.setText(100+"");
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                Random random= new Random();
                if(seekBarOne.getProgress()>=seekBarOne.getMax()){
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Mouse Win", Toast.LENGTH_SHORT).show();
                    if(checkBoxOne.isChecked()){
                       soDiem+=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3;
                        Toast.makeText(MainActivity.this, "Ban da thang: "+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3, Toast.LENGTH_SHORT).show();
                    }else{
                     soDiem-=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                        Toast.makeText(MainActivity.this, "ban da thua: "+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText())), Toast.LENGTH_SHORT).show();
                    }
                    textViewDiemSo.setText(soDiem+"");
                    enableCheckbox();
                    edittextDiemCuoc.setVisibility(View.VISIBLE);
                }
                if(seekBarTwo.getProgress()>=seekBarTwo.getMax()){
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Dragon Win", Toast.LENGTH_SHORT).show();
                    if(checkBoxTwo.isChecked()){
                        soDiem+=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3;
                        Toast.makeText(MainActivity.this, "Ban da thang: "+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3, Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem-=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                        Toast.makeText(MainActivity.this, "ban da thua: "+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText())), Toast.LENGTH_SHORT).show();
                    }
                    textViewDiemSo.setText(soDiem+"");
                    enableCheckbox();
                    edittextDiemCuoc.setVisibility(View.VISIBLE);
                }
                if(seekBarThree.getProgress()>=seekBarThree.getMax()){
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Dog Win", Toast.LENGTH_SHORT).show();
                    if(checkBoxThree.isChecked()){
                        soDiem+=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3;
                        Toast.makeText(MainActivity.this, "Ban da thang: "+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3, Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem-=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                        Toast.makeText(MainActivity.this, "ban da thua: "+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText())), Toast.LENGTH_SHORT).show();
                    }
                    textViewDiemSo.setText(soDiem+"");
                    enableCheckbox();
                    edittextDiemCuoc.setVisibility(View.VISIBLE);
                }
                seekBarOne.setProgress(seekBarOne.getProgress()+random.nextInt(2));
                seekBarTwo.setProgress(seekBarTwo.getProgress()+random.nextInt(2));
                seekBarThree.setProgress(seekBarThree.getProgress()+random.nextInt(2));
            }

            @Override
            public void onFinish() {

            }
        };

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittextDiemCuoc.length()!=0&&checkBoxOne.isChecked() || edittextDiemCuoc.length()!=0&&checkBoxTwo.isChecked()|| edittextDiemCuoc.length()!=0&&checkBoxThree.isChecked()){
                    int diemCuoc= Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                    if(diemCuoc<=Integer.parseInt(String.valueOf(textViewDiemSo.getText())))
                    {
                        if(Integer.parseInt(String.valueOf(textViewDiemSo.getText()))>0){
                            edittextDiemCuoc.setVisibility(View.INVISIBLE);
                            seekBarOne.setProgress(0);
                            seekBarTwo.setProgress(0);
                            seekBarThree.setProgress(0);
                            buttonPlay.setVisibility(View.INVISIBLE);
                            countDownTimer.start();
                            disableCheckBox();
                        }else
                            Toast.makeText(MainActivity.this, "Ban da het diem de dac cuoc!!", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(MainActivity.this, "Ban khong du diem cuoc!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Ban phai dat cuoc truoc khi choi!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });
        checkBoxTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxOne.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });
        checkBoxThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxOne.setChecked(false);
                    checkBoxTwo.setChecked(false);
                }
            }
        });
    }


    public void anhXa(){
        textViewDiemSo= (TextView) findViewById(R.id.textviewDiemSo);
        seekBarOne=(SeekBar) findViewById(R.id.seekbarOne);
        seekBarTwo=(SeekBar) findViewById(R.id.seekbarTwo);
        seekBarThree=(SeekBar) findViewById(R.id.seekbarThree);
        checkBoxOne= (CheckBox) findViewById(R.id.checkboxOne);
        checkBoxTwo= (CheckBox) findViewById(R.id.checkboxTwo);
        checkBoxThree= (CheckBox) findViewById(R.id.checkboxThree);
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);
        edittextDiemCuoc=(EditText) findViewById(R.id.edittextNhapCuoc);
    }
    public void enableCheckbox(){
        checkBoxOne.setEnabled(true);
        checkBoxTwo.setEnabled(true);
        checkBoxThree.setEnabled(true);
    }
    public void disableCheckBox(){
        checkBoxOne.setEnabled(false);
        checkBoxTwo.setEnabled(false);
        checkBoxThree.setEnabled(false);
    }
}