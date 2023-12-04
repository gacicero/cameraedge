# cameraedge

Cartoonify App
Overview
The Cartoonify App is an Android application that uses OpenCV to perform real-time edge detection on the camera feed. Users can interact with the app to change the edge color dynamically.
Features
Real-time camera feed with edge detection.
Ability to change the edge color.
Minimalist user interface with a start button.
Permission handling for camera access.
Getting Started
Prerequisites
Android Studio installed on your development machine.
Basic understanding of Android development and Java.

Download and Configure OpenCV:
Visit the OpenCV website: https://opencv.org/releases/
Download the OpenCV Android SDK for the appropriate version.
Extract the downloaded SDK to a location on your machine.
In your Android Studio project:
Open File > New > Import Module.
Select the sdk directory inside the extracted OpenCV SDK as the source directory.
Click Finish to add the OpenCV module to your project.
Update Build Configuration:
Open your app's build.gradle file.
Add the following lines to the dependencies block:
gradle
implementation project(':opencv')


Open the project in Android Studio.
Build and run the app on an Android device or emulator.

Installation
Clone the repository:
Bash- 	https://github.com/gacicero/cameraedge.git


Open the project in Android Studio.
Build and run the app on an Android device or emulator.
Usage
Launch the app on your Android device.
Grant camera permissions when prompted.
Click the "Start" button to begin real-time edge detection.
Optionally, click on the color buttons (Yellow, Blue, Red, Pink, Green and Original(Black & white) to change the edge color dynamically.
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
