package com.example.lenovo.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SignatureActivity extends AppCompatActivity {


    private CanvasView canvasView;
    public static Bitmap bmp;
    public static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);

        canvasView=(CanvasView)findViewById(R.id.canvas);
    }

    public void clearCanvas(View view) {
        canvasView.clearCanvas();

    }

    public void submitCanvas(View view) throws IOException {

        canvasView.setDrawingCacheEnabled(true);
        bitmap=canvasView.getDrawingCache();
        String path = Environment.getExternalStorageDirectory().toString();
        OutputStream fOut = null;
        Integer counter = 0;
        File file = new File(path, "FitnesdddsGirl"+counter+".png"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
        fOut = new FileOutputStream(file);

        bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate
        fOut.flush(); // Not really required
        fOut.close(); // do not forget to close the stream


        Intent signatueIntent=new Intent();
        signatueIntent.putExtra("SIGNATUE","success");
        setResult(2,signatueIntent);
        finish();
    }


}
