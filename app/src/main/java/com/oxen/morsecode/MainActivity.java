package com.oxen.morsecode;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.graphics.Matrix;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageFlashlight;
    private static final int CAMERA_REQUEST = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageFlashlight = (ImageView) findViewById(R.id.imageFlashlight);

        //starts image animation
        Animation rotation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        rotation.setFillAfter(true);
        imageFlashlight.startAnimation(rotation);


        imageFlashlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //request permissions to access camera
                ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, CAMERA_REQUEST);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case CAMERA_REQUEST :
                if (grantResults.length > 0  &&  grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    imageFlashlight.setEnabled(true);

                    //creates the application
                    startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied for the Camera", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}