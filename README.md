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

### Assignment

1. User Interface Enhancements
   1. Rather than a circle for the plot point, find an icon/image to use and import it into Android Studio as a drawable (via Resource Manager tab on the left, click the + button, then choose Vector Asset for SVG/PSD files or Import Drawable for PNG/JPG files).
   2. Replace the Circle composable with an Image composable that uses the new image asset.
   3. Note that the Sliders from the first week’s assignment don’t really provide any detail about what is being changed. Make sure to build out the MapSlider composable (MapSlider is the name of the custom composable function from the starter project, it could be named differently if you’re working off your existing repo) with the following
      1. A Row composable with a horizontal padding of 16.dp
      2. An inner Text composable for the title string with a start padding of 8.dp and a width of 120.dp.
      3. A Slider composable (used from week 1). The Slider should wire up its onValueChange with the MapSlider's onPercentageChange lambda.
   4. The display of the map and sliders should look good in both portrait and landscape modes.
2. Organizational Best Practices
   1. While you can have multiple composable and preview functions in one file, be careful doing this as you can easily clutter your file with too many functions.
   2. Move out the individual @Composable functions (and their associated @Preview functions) into their own files.
3. Theme the App
   1. Under the ui.theme sub-package of the project there is a Color.kt file.  Open up this file and change the colors and names up a bit and apply them to the themes in Theme.kt.
4. Testing and Bug Fixing
   1. Thoroughly test your app on both emulators and physical devices to identify any bugs or issues.
   2. Debug and fix any problems found during testing to ensure a smooth user experience.
5. Documentation
   1. Update the README.md file in your GitHub repository to include a brief description of your app and its features.
   2. Document any major changes or improvements made during the polishing process.
6. Splash Screen
   1. Not a requirement, but if you want to go above and beyond, come up with a splash screen design and add it to your app!






