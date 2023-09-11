# CoordinatePlot

CoordinatePlot is an Android Jetpack-Compose based app that displays a map with sliders.
The sliders select coordinates that are used to position a pointer on the map.

## Week 1

### Assignment

The goal of this assignment is to build a rudimentary coordinate plotter app.  The idea behind this app is to get familiar with utilizing a fairly new project as well as building Compose components. Here is the starter project for this week’s assignment.
The final project for this week should look something like this.
Here is the final project zip: https://drive.google.com/file/d/15cn0ifWDVwBf1Dj5o0Fh4pEQ1NWVdU_m/view?usp=sharing

- Android Studio Project:
    - Ensure the latest stable version of Android Studio is on your computer.
    - This project will be a “Coordinate Plot” app.
    - Run the app on an Android emulator or a physical device to ensure that the project works correctly. A blank screen should appear.
    - Add a Box composable and size it to 300dp for width and height using the Modifier method size(). You can set the background color of the Box to whatever color you want to via the Modifier method background().  For example if you want a blue background simply do: background(Color.Blue).
    - Wire up the slider values so that when the value changes via onValueChange the circle is re-composed in the right position of the Box. To do this, make sure to set the percentage offsets xPercent and yPercent to remembered objects for composition via the remember keyword.

## Week 2

### Changes

1. User Interface Enhancements
   1. Imported arrow.png into Android Studio as a drawable and use as cursor in Map.
   2. Replaced the Circle composable with an Image composable that uses the new arrow.png asset.
   3. MapSlider composable 
      1. Created a Row composable with a horizontal padding of 16.dp
      2. Created an inner Text composable for the title string with a start padding of 8.dp and a width of 120.dp.
      3. Added a Slider composable. The Slider wires up its onValueChange with the MapSlider's onPercentageChange lambda.
   4. Created an adaptive layout so that the display of the map and sliders look good in both portrait and landscape modes.
2. Organizational Best Practices
   1. Moved out the individual @Composable functions (and their associated @Preview functions) into their own files.
3. Theme the App
   1. Changed the colors and names from purple to green and applied them to the themes in Theme.kt.
4. Testing and Bug Fixing
   1. Tested on 2 emulators...a Pixel 2 API 28 and a Pixel 6 Pro API 33.
5. Documentation
   1. Updated the README.md file in your GitHub repository to include a brief description of your app and its features.
   2. Documenteded major changes or improvements made during the polishing process.
6. Splash Screen
   1. TODO






