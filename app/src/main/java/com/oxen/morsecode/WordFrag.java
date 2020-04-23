package com.oxen.morsecode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WordFrag extends Fragment {

    private boolean flashLightStatus = false;
    boolean hasCameraFlash;
    private String mCameraId;
    private View view;
    private TextView textView;
    private EditText inputText;
    private ProgressDialog dialog;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_word_convert, container, false);
        textView = (TextView)view.findViewById(R.id.textView);
        textView.setClickable(false);

        hasCameraFlash = getContext().getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        addListenerOnButton();
        return view;
    }

    public WordFrag() {
    }



    public void addListenerOnButton() {
        inputText = (EditText) view.findViewById(R.id.editText);
        Button translateButton = (Button) view.findViewById(R.id.button);
        Button menuButton = (Button) view.findViewById(R.id.buttonMenu);

        translateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hideKeyboard(getActivity());

                if (inputText.getText().toString().length()==0){
                    Toast.makeText(getContext(),"Please insert the text to be generated",Toast.LENGTH_SHORT).show();
                }
                else{

                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);

                    MyAsyncTask myAsyncTask = new MyAsyncTask(getContext());
                    myAsyncTask.execute(inputText.getText().toString());

                }


            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
    }
    private void generate(String text) {

        text = text.toLowerCase();
        //replace string \n to " "
        String replace_word = text.replaceAll("[\\t\\n\\r]+"," ");
        //remove any metachar
        replace_word = replace_word.replaceAll("[-+.^:,?!]","");

        //separate words with dots
        replace_word = replace_word.replaceAll("[ ]","..");

        //split string char by char
        String[] character = replace_word.split("(?!^)");


        for (int i=0;i<character.length;i++){
            switch (character[i]){

                case "a":
                    generateChar(getResources().getStringArray(R.array.alphabet)[0]);
                    break;
                case "b":
                    generateChar(getResources().getStringArray(R.array.alphabet)[1]);
                    break;
                case "c":
                    generateChar(getResources().getStringArray(R.array.alphabet)[2]);
                    break;
                case "d":
                    generateChar(getResources().getStringArray(R.array.alphabet)[3]);
                    break;
                case "e":
                    generateChar(getResources().getStringArray(R.array.alphabet)[4]);
                    break;
                case "f":
                    generateChar(getResources().getStringArray(R.array.alphabet)[5]);
                    break;
                case "g":
                    generateChar(getResources().getStringArray(R.array.alphabet)[6]);
                    break;
                case "h":
                    generateChar(getResources().getStringArray(R.array.alphabet)[7]);
                    break;
                case "i":
                    generateChar(getResources().getStringArray(R.array.alphabet)[8]);
                    break;
                case "j":
                    generateChar(getResources().getStringArray(R.array.alphabet)[9]);
                    break;
                case "k":
                    generateChar(getResources().getStringArray(R.array.alphabet)[10]);
                    break;
                case "l":
                    generateChar(getResources().getStringArray(R.array.alphabet)[11]);
                    break;
                case "m":
                    generateChar(getResources().getStringArray(R.array.alphabet)[12]);
                    break;
                case "n":
                    generateChar(getResources().getStringArray(R.array.alphabet)[13]);
                    break;
                case "o":
                    generateChar(getResources().getStringArray(R.array.alphabet)[14]);
                    break;
                case "p":
                    generateChar(getResources().getStringArray(R.array.alphabet)[15]);
                    break;
                case "q":
                    generateChar(getResources().getStringArray(R.array.alphabet)[16]);
                    break;
                case "r":
                    generateChar(getResources().getStringArray(R.array.alphabet)[17]);
                    break;
                case "s":
                    generateChar(getResources().getStringArray(R.array.alphabet)[18]);
                    break;
                case "t":
                    generateChar(getResources().getStringArray(R.array.alphabet)[19]);
                    break;
                case "u":
                    generateChar(getResources().getStringArray(R.array.alphabet)[20]);
                    break;
                case "v":
                    generateChar(getResources().getStringArray(R.array.alphabet)[21]);
                    break;
                case "x":
                    generateChar(getResources().getStringArray(R.array.alphabet)[22]);
                    break;
                case "y":
                    generateChar(getResources().getStringArray(R.array.alphabet)[23]);
                    break;
                case "w":
                    generateChar(getResources().getStringArray(R.array.alphabet)[24]);
                    break;
                case "z":
                    generateChar(getResources().getStringArray(R.array.alphabet)[25]);
                    break;
                case ".":
                    generateChar(".");
                    break;


            }
        }
    }

    private void generateChar(String word){
        //type = 1 long blink
        //type = 0 short blink
        for(int i=0;i<word.length();i++){
            if (word.charAt(i) == '1'){
                typeBlink(1);
            }else if (word.charAt(i) == '0'){
                typeBlink(0);
            }else{
                typeBlink(2);
            }
        }
    }

    public void typeBlink(int type){
        CameraManager cameraManager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);
        String word = "01";

        long blinkdelay;

        if (type==0){
            blinkdelay = 150;
        }
        else if (type==1){
            blinkdelay = 500;
        }
        else{
            blinkdelay = 700;
        }

        for(int i=0;i<word.length();i++){
            if (blinkdelay!=700){
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
                }
            }
             try{
                Thread.sleep(blinkdelay);
            }catch (InterruptedException e){}
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }




    class MyAsyncTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        Context context;

        public MyAsyncTask(Context c){
            this.context=c;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Sending your secret message!");
            dialog.show();
        }


        @Override
        protected Void doInBackground(String... strings) {
            generate(inputText.getText().toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            dialog.dismiss();
        }



    }


}
