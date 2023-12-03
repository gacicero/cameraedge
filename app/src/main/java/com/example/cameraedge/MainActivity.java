package com.example.cameraedge;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.Manifest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.opencv.android.CameraActivity;
import org.opencv.android.CameraBridgeViewBase;

import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.Collections;
import java.util.List;



public class MainActivity extends CameraActivity {



    CameraBridgeViewBase cameraBridgeViewBase;
    private Button startButton;
    private Button greenButton;


    private Button blueButton;


    private Button redButton;

    private Button pinkButton;


    private Button yellowButton;


    private Button originalButton;

    private boolean isStartButtonClicked = false;

    private boolean isGreen = false;
    private boolean isRed = false;
    private boolean isBlue = false;

    private boolean isPink = false;
    private boolean isYellow = false;
    private boolean isOriginal = false;




    private TextView welcomeTextView;
    private TextView startTextView;
    private
    Mat gray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        startTextView = findViewById(R.id.startTextView);
        startButton = findViewById(R.id.startButton);
        greenButton = findViewById(R.id.greenButton);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        pinkButton = findViewById(R.id.pinkButton);
        yellowButton = findViewById(R.id.yellowButton);
        originalButton = findViewById(R.id.originalButton);

        startButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               getPermission();
                                               //vanish startButton
                                               startButton.setVisibility(View.GONE);
                                               isStartButtonClicked = true;
                                               // vanish welcomeTextView
                                               welcomeTextView.setVisibility(View.GONE);
                                               startTextView.setVisibility(View.GONE);
                                               cameraBridgeViewBase.enableView();
                                           }

    });

        greenButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               //vanish startButton
                                               isGreen = true;
                                               isBlue = false;
                                               isRed = false;
                                               isYellow = false;
                                               isOriginal = false;
                                               isPink = false;


                                           }
                                       });



        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGreen = false;
                isRed = false;
                isBlue = true;
                isYellow = false;
                isPink = false;
                isOriginal = false;





            }});

        redButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isGreen = false;
                    isRed = true;
                    isBlue = false;
                    isYellow = false;
                    isPink = false;
                    isOriginal = false;



                }});


        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGreen = false;
                isRed = false;
                isBlue = false;
                isYellow = true;
                isPink = false;
                isOriginal = false;





            }});
        pinkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isGreen = false;
                    isRed = false;
                    isBlue = false;
                    isYellow = false;
                    isPink = true;
                    isOriginal = false;





                }});


                originalButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isGreen = false;
                        isRed = false;
                        isBlue = false;
                        isYellow = false;
                        isPink = false;
                        isOriginal = true;





                    }});











                    cameraBridgeViewBase = findViewById(R.id.cameraView);
        cameraBridgeViewBase.setCvCameraViewListener(new CameraBridgeViewBase.CvCameraViewListener2() {
            @Override
            public void onCameraViewStarted(int width, int height) {

            }


            @Override
            public void onCameraViewStopped() {

            }

            @Override
            public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
                gray = inputFrame.gray();
                Mat rotationMatrix = Imgproc.getRotationMatrix2D(new Point(gray.cols() / 2, gray.rows() / 2), -90, 1);
                Imgproc.warpAffine(gray, gray, rotationMatrix, gray.size());
                Imgproc.Canny(gray, gray, 80, 100);

                if (isGreen == true)
                {
                    Mat color = new Mat();
                    Imgproc.applyColorMap(gray,color,Imgproc.COLORMAP_SUMMER);
                    return color;
                }
                if (isRed == true)
                {
                    Mat color = new Mat();
                    Imgproc.applyColorMap(gray,color,Imgproc.COLORMAP_JET);
                    return color;
                }
                if (isBlue == true)
                {
                    Mat color = new Mat();
                    Imgproc.applyColorMap(gray,color,Imgproc.COLORMAP_AUTUMN);
                    return color;
                }

                if(isYellow == true)
                {
                    Mat color = new Mat();
                    Imgproc.applyColorMap(gray,color,Imgproc.COLORMAP_COOL);
                    return color;
                }
                if(isPink == true)
                {
                    Mat color = new Mat();
                    Imgproc.applyColorMap(gray,color,Imgproc.COLORMAP_SPRING);
                    return color;
                }
                if(isOriginal == true)
                {
                    Mat color = new Mat();
                    Imgproc.applyColorMap(gray,color,Imgproc.COLORMAP_BONE);
                    return color;
                }

                return gray;




            }
        });

    }

    @Override
    protected List<? extends CameraBridgeViewBase> getCameraViewList() {
        return Collections.singletonList(cameraBridgeViewBase);
    }
     @Override
    protected void onResume() {
        super.onResume();
        // Ensure that OpenCVLoader is initialized
        if (!OpenCVLoader.initDebug()) {

            // Handle initialization error if needed
        } else {
            // Start the camera view
            if (isStartButtonClicked && cameraBridgeViewBase != null) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    cameraBridgeViewBase.enableView();
                } else {
                    // Request camera permission
                    getPermission();
                }
            }
        }
    }
     @Override
    protected void onPause() {
        super.onPause();
        // Disable the camera view to release resources
        if (cameraBridgeViewBase != null) {
            cameraBridgeViewBase.disableView();
        }
    }
    void getPermission() {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
            } else {
                // Permission already granted, start camera
                cameraBridgeViewBase.enableView();
            }
    }

        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == 101) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, start camera
                    cameraBridgeViewBase.enableView();
                }
            }
        }
    }
