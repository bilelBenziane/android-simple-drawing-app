package com.example.lenovo.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView=(TextView)findViewById(R.id.texto);
        mImageView=(ImageView)findViewById(R.id.imageView);

    }

    public void startCanvas(View view) {

        Intent intentSignature=new Intent(this,SignatureActivity.class);
        startActivityForResult(intentSignature, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==2){
            if(data !=null){
                mImageView.setImageBitmap(SignatureActivity.bitmap);

                String signature=data.getStringExtra("SIGNATUE");
                mTextView.setText(signature);

            }
        }
    }
}
