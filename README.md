# cameraedge

Cartoonify App
Overview
The Cartoonify App is an Android application that uses OpenCV to perform real-time edge detection on the camera feed. Users can interact with the app to change the edge color dynamically.


Features
  1)  Real-time camera feed with edge detection.
  2)  Ability to change the edge color.
  3)  Minimalist user interface with a start button.
  4)  Permission handling for camera access.


Getting Started:
1)  Prerequisites
  a)  Android Studio installed on your development machine.
  b)  Basic understanding of Android development and Java.
2)  Download and Configure OpenCV:
  a)  Visit the OpenCV website: https://opencv.org/releases/
  b)  Download the OpenCV Android SDK for the appropriate version.
  c)Extract the downloaded SDK to a location on your machine.
  d)In your Android Studio project:
    i)  Open File > New > Import Module.
    ii)  Select the sdk directory inside the extracted OpenCV SDK as the source directory.
    iii) Click Finish to add the OpenCV module to your project.
3)Update Build Configuration:
  a)  Open your app's build.gradle file.
  b)  Add the following lines to the dependencies block:
  i)gradle
  ii)implementation project(':opencv')
4)  Open the project in Android Studio.
5)  Build and run the app on an Android device or emulator.


Installation
  1)  Clone the repository:
    a)  Bash-  https://github.com/gacicero/cameraedge.git
  2)  Open the project in Android Studio.
  3)  Build and run the app on an Android device or emulator.


Usage
  1)  Launch the app on your Android device.
  2)  Grant camera permissions when prompted.
  3)  Click the "Start" button to begin real-time edge detection.
  4)  Optionally, click on the color buttons (Yellow, Blue, Red, Pink, Green and Original(Black & white) to change the edge color dynamically.


Troubleshooting
If the app crashes or does not function as expected, ensure that you have granted the necessary camera permissions.

Contributing
Contributions are welcome! Feel free to submit issues or pull requests.

License
This project is licensed under the BU License

Acknowledgments
The app uses OpenCV for image processing.

Contact
For any inquiries or feedback, please contact [Lillian Snow lilysnow@bu.edu, George Cicero gacicero@bu.edu, Siri Allegra-Berger siriab@bu.edu, Jack Hutchison jhutch07@bu.edu].
