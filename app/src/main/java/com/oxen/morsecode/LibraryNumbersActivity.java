package com.oxen.morsecode;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LibraryNumbersActivity extends AppCompatActivity {

    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_numbers);
        txtView = (TextView)findViewById(R.id.editTextNumbers);
        txtView.setClickable(false);


    }

    public void buttonClick(View view) {

        switch (view.getId()) {
            case R.id.buttonOne:
                generateChar(getResources().getStringArray(R.array.numbers)[1]);
                break;
            case R.id.buttonTwo:
                generateChar(getResources().getStringArray(R.array.numbers)[2]);

                break;

            case R.id.buttonThree:
                generateChar(getResources().getStringArray(R.array.numbers)[3]);

                break;

            case R.id.buttonFour:
                generateChar(getResources().getStringArray(R.array.numbers)[4]);
                break;

            case R.id.buttonFive:
                generateChar(getResources().getStringArray(R.array.numbers)[5]);
                break;

            case R.id.buttonSix:
                generateChar(getResources().getStringArray(R.array.numbers)[6]);
                break;

            case R.id.buttonSeven:
                generateChar(getResources().getStringArray(R.array.numbers)[7]);

                break;

            case R.id.buttonEight:
                generateChar(getResources().getStringArray(R.array.numbers)[8]);
                break;

            case R.id.buttonNine:
                generateChar(getResources().getStringArray(R.array.numbers)[9]);
                break;

            case R.id.buttonZero:
                generateChar(getResources().getStringArray(R.array.numbers)[0]);
                break;

            case R.id.buttonAandZ:
                startActivity(new Intent(LibraryNumbersActivity.this, MainActivity.class));
                break;

            case R.id.buttonMenu:
                startActivity(new Intent(LibraryNumbersActivity.this, MainActivity.class));

                break;


           }
    }

    private void generateChar(String word){
        //type = 1 long blink
        //type = 0 short blink
        for(int i=0;i<word.length();i++){
            if (word.charAt(i) == '1'){
                typeBlink(1);
            }else{
                typeBlink(0);
            }
        }
    }

    public void typeBlink(int type){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String word = "01";

        long blinkdelay = 0;
        if (type==0){
            blinkdelay = 250;
        }
        else{
            blinkdelay = 500;
        }

        for(int i=0;i<word.length();i++){
            if (word.charAt(i) == '0'){
                try{
                    String cameraId=cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(cameraId, true);
                }catch (CameraAccessException e){}
            }else{
                try{
                    String cameraId=cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(cameraId, false);
                }catch (CameraAccessException e){}
            } try{
                Thread.sleep(blinkdelay);
            }catch (InterruptedException e){}
        }
    }
}
