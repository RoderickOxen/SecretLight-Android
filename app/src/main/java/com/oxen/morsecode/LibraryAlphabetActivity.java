package com.oxen.morsecode;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class LibraryAlphabetActivity extends AppCompatActivity {

    private Button backButton;
    private Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z, numbers, punct;
    private TextView txtView;

    private boolean flashLightStatus = false;
    boolean hasCameraFlash;
    private String mCameraId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_library_alphabet);

        addListenerOnButton();
        txtView = (TextView)findViewById(R.id.editText3);
        txtView.setClickable(false);

        hasCameraFlash = getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

    }

    private void addListenerOnButton() {
        backButton = (Button) findViewById(R.id.buttonMenu2);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryAlphabetActivity.this, MainActivity.class));

            }
        });

        numbers = (Button) findViewById(R.id.buttonNumbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryAlphabetActivity.this, LibraryNumbersActivity.class));

            }
        });


        a = (Button) findViewById(R.id.buttonA);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[0]);
            }
        });
        b = (Button) findViewById(R.id.buttonB);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[1]);
            }
        });

        c = (Button) findViewById(R.id.buttonC);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[2]);

            }
        });
        d = (Button) findViewById(R.id.buttonD);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[3]);

            }
        });
        e = (Button) findViewById(R.id.buttonE);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[4]);

            }
        });
        f = (Button) findViewById(R.id.buttonF);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[5]);

            }
        });
        g = (Button) findViewById(R.id.buttonG);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[6]);

            }
        });
        h = (Button) findViewById(R.id.buttonH);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[7]);

            }
        });
        i = (Button) findViewById(R.id.buttonI);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[8]);

            }
        });
        j = (Button) findViewById(R.id.buttonJ);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[9]);

            }
        });
        k = (Button) findViewById(R.id.buttonK);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[10]);

            }
        });
        l = (Button) findViewById(R.id.buttonL);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[11]);

            }
        });
        m = (Button) findViewById(R.id.buttonM);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[12]);

            }
        });
        n = (Button) findViewById(R.id.buttonN);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[13]);

            }
        });
        o = (Button) findViewById(R.id.buttonO);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[14]);

            }
        });
        p = (Button) findViewById(R.id.buttonP);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[15]);

            }
        });
        q = (Button) findViewById(R.id.buttonQ);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[16]);

            }
        });
        r = (Button) findViewById(R.id.buttonR);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[17]);

            }
        });
        s = (Button) findViewById(R.id.buttonS);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[18]);

            }
        });
        t = (Button) findViewById(R.id.buttonT);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[19]);

            }
        });
        u = (Button) findViewById(R.id.buttonU);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[20]);

            }
        });
        v = (Button) findViewById(R.id.buttonV);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[21]);

            }
        });
        w = (Button) findViewById(R.id.buttonW);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[22]);

            }
        });
        x = (Button) findViewById(R.id.buttonX);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[23]);

            }
        });
        y = (Button) findViewById(R.id.buttonY);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[24]);

            }
        });
        z = (Button) findViewById(R.id.buttonZ);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[25]);

            }
        });

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
