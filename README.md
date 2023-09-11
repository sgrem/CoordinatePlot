# CoordinatePlot

CoordinatePlot is an Android Jetpack-Compose based app that displays a map with sliders.
The sliders select coordinates that are used to position a pointer on the map.

## Week 1

### Assignment

The goal of this assignment is to build a rudimentary coordinate plotter app.  The idea behind this app is to get familiar with utilizing a fairly new project as well as building Compose components. Here is the starter project for this week’s assignment.
The final project for this week should look something like this.
Here is the final project zip: https://drive.google.com/file/d/15cn0ifWDVwBf1Dj5o0Fh4pEQ1NWVdU_m/view?usp=sharing
1. Set up Git and GitHub:
    - Create a GitHub account if you haven't already.
    - Install Git on your computer, and configure your user name and email.
    - Set up an SSH key and link it to your GitHub account for secure communication.
2. Create a Repository:
    - Start by downloading and unzipping the starter project.  This is the project you’ll be working on to complete the assignment.  It is the beginning of a coordinate plotter app.
    - Create a new public repository on GitHub to host your Android project. You can name it “coordplot”, or something similar, as long as it makes sense to you and your mentors.
    - Initialize a new Git repository locally on your computer. Follow the steps on your new github repo in order to set up the git remote on the starter project.
3. Android Studio Project:
    - Ensure the latest stable version of Android Studio is on your computer.
    - This project will be a “Coordinate Plot” app.
    - Run the app on an Android emulator or a physical device to ensure that the project works correctly. A blank screen should appear.
    - Add a Box composable and size it to 300dp for width and height using the Modifier method size(). You can set the background color of the Box to whatever color you want to via the Modifier method background().  For example if you want a blue background simply do: background(Color.Blue).
4. Version Control:
    - Create a new branch named "week1" for your project.
    - Commit your changes with a descriptive commit message.
    - Push the changes to the remote repository on GitHub.
    - Open an MR and add mentors as reviewers.

NOTE: You can chain Modifier methods together too! For example:
```kotlin
Modifier
    .size(300.dp)
    .background(Color.Blue)
```  

    - Add two Slider composables (range will automatically default from 0 to 1). Each slider represents a percentage offset. One for the horizontal (X) axis, and the other the vertical (Y) axis.
    - Create another Box composable with the square Box.  This inner Box composable should be 36 DP in size, and can be shaped as a circle via the Modifier method clip(shape = CircleShape). Make sure to also set the offset for the circle so it appears appropriately in the middle of your square Box. You can do this via the offset() Modifier method:
```kotlin 
Modifier
  // ...
  .offset((xPercent * 300 - 18).dp, (yPercent * 300 - 18).dp)
```
Note here that the - 18 is there to center the circle on the point, otherwise the point associated with slider positions will be at the top-left of the circle.
- Wire up the slider values so that when the value changes via onValueChange the circle is re-composed in the right position of the Box. To do this, make sure to set the percentage offsets xPercent and yPercent to remembered objects for composition via the remember keyword, you can do so like this:
  var xPercentage: Float by remember { mutableStateOf(0.5f) }
  var yPercentage: Float by remember { mutableStateOf(0.5f) }




### Rubric

To ensure grading efficiency, follow this rubric to award points for each section:

`MEETS EXPECTATIONS:`
- Successful creation of a GitHub account and linking it to Git.
- Proper configuration of user name, email, and SSH key.
- Creation of a public repository on GitHub.
- Successful initialization and connection of the local and remote repositories.
- nstallation and setup of Android Studio.
- Successful creation of an Android project with a working coordinate plotter that updates based on two sliders that are associated with the X and Y axis.
- Creation of a new branch named "week1" with changes committed.
- Successful push of changes to the remote repository with an open MR and mentors as reviewers.

- `ABOVE AND BEYOND:`
- Successful collaboration with a peer, adding them as a collaborator, making changes, and merging them.
      
`NEEDS IMPROVEMENT:`
- Assignment submitted late (after the due date).
- Any point is missing from the meets expectations list.

