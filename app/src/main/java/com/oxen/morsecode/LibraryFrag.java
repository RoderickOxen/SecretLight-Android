package com.oxen.morsecode;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LibraryFrag extends Fragment {
    private Button backButton;
    private Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z, numbers, punct;
    private TextView txtView;

    private boolean flashLightStatus = false;
    boolean hasCameraFlash;
    private String mCameraId;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_library_alphabet, container, false);
        addListenerOnButton();
        txtView = (TextView)view.findViewById(R.id.editText3);
        txtView.setClickable(false);

        hasCameraFlash = getContext().getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);


        return view;
    }


    public LibraryFrag() {
    }

    private void addListenerOnButton() {
        backButton = (Button) view.findViewById(R.id.buttonMenu2);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));

            }
        });

        a = (Button) view.findViewById(R.id.buttonA);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[0]);
            }
        });
        b = (Button) view.findViewById(R.id.buttonB);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[1]);
            }
        });

        c = (Button) view.findViewById(R.id.buttonC);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[2]);

            }
        });
        d = (Button) view.findViewById(R.id.buttonD);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[3]);

            }
        });
        e = (Button) view.findViewById(R.id.buttonE);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[4]);

            }
        });
        f = (Button) view.findViewById(R.id.buttonF);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[5]);

            }
        });
        g = (Button) view.findViewById(R.id.buttonG);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[6]);

            }
        });
        h = (Button) view.findViewById(R.id.buttonH);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[7]);

            }
        });
        i = (Button) view.findViewById(R.id.buttonI);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[8]);

            }
        });
        j = (Button) view.findViewById(R.id.buttonJ);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[9]);

            }
        });
        k = (Button) view.findViewById(R.id.buttonK);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[10]);

            }
        });
        l = (Button) view.findViewById(R.id.buttonL);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[11]);

            }
        });
        m = (Button) view.findViewById(R.id.buttonM);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[12]);

            }
        });
        n = (Button) view.findViewById(R.id.buttonN);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[13]);

            }
        });
        o = (Button) view.findViewById(R.id.buttonO);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[14]);

            }
        });
        p = (Button) view.findViewById(R.id.buttonP);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[15]);

            }
        });
        q = (Button) view.findViewById(R.id.buttonQ);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[16]);

            }
        });
        r = (Button) view.findViewById(R.id.buttonR);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[17]);

            }
        });
        s = (Button) view.findViewById(R.id.buttonS);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[18]);

            }
        });
        t = (Button) view.findViewById(R.id.buttonT);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[19]);

            }
        });
        u = (Button) view.findViewById(R.id.buttonU);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[20]);

            }
        });
        v = (Button) view.findViewById(R.id.buttonV);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[21]);

            }
        });
        w = (Button) view.findViewById(R.id.buttonW);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[22]);

            }
        });
        x = (Button) view.findViewById(R.id.buttonX);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[23]);

            }
        });
        y = (Button) view.findViewById(R.id.buttonY);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChar(getResources().getStringArray(R.array.alphabet)[24]);

            }
        });
        z = (Button) view.findViewById(R.id.buttonZ);
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
        CameraManager cameraManager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);
        String word = "01";

        long blinkdelay = 0;
        if (type==0){
            blinkdelay = 250;
        }
        else{
            blinkdelay = 900;
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
