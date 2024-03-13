package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.mycompany.practice.databinding.ActivityQrGeneratorBinding;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QrGeneratorActivity extends AppCompatActivity {
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    ActivityQrGeneratorBinding binding;
    ImageView imgPrevious, imgNext, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qr_generator);
        init();
    }

    public void init() {
        imgPrevious = findViewById(R.id.imgPrevious);

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QrGeneratorActivity.this, SwipeButtonActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(QrGeneratorActivity.this, RandomNoGeneratorActivity.class));
//                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QrGeneratorActivity.this, FirstActivity.class));
                finish();
            }
        });

        binding.btnGenerateQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(binding.etText.getText().toString())) {
                    Toast.makeText(QrGeneratorActivity.this, "Enter some text to generate QR Code", Toast.LENGTH_SHORT).show();
                } else {
                    // below line is for getting the windowmanager service.
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                    // initializing a variable for default display.
                    Display display = manager.getDefaultDisplay();

                    // creating a variable for point which is to be displayed in QR Code.
                    Point point = new Point();
                    display.getSize(point);

                    // getting width and height of a point
                    int width = point.x;
                    int height = point.y;

                    // generating dimension from width and height.
                    int dimen = width < height ? width : height;
                    dimen = dimen * 3 / 4;

                    // setting this dimensions inside our qr code  encoder to generate our qr code.
                    qrgEncoder = new QRGEncoder(binding.etText.getText().toString(), null, QRGContents.Type.TEXT, dimen);

                    try {
                        // getting our qrcode in the form of bitmap.
                        bitmap = qrgEncoder.encodeAsBitmap();

                        Glide.with(QrGeneratorActivity.this)
                                .load(bitmap)
                                .into(binding.imgQrcode);

                    } catch (WriterException e) {
                        // this method is called for exception handling.
                        Log.e("Tag", e.toString());
                    }
                }
            }
        });
    }
}