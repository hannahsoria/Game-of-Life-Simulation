# Game-of-Life-Simulation

In this project I created a representation of the Game of Life, originally a game created by Conway. This game utilizes a 2D array that displays individual cells that are alive or dead (true or false) and updates to be alive, dead, or remain so according to the status of the cells that surround it. The final result is a grid display of cells that update every 250 milliseconds. To complete this project many classes, arrays, Graphics to draw the cells, and a 2D array are used to create first an individual cell then add cells to the 2D array and adjust their status, to finally create a visual representation.

<img width="204" alt="Screen Shot 2023-02-11 at 6 51 15 PM" src="https://user-images.githubusercontent.com/113323340/218285901-36e7289d-5a27-4cf3-bcf1-56f115b5d598.png">

<img width="204" alt="Screen Shot 2023-02-11 at 6 51 34 PM" src="https://user-images.githubusercontent.com/113323340/218285905-422f5ea4-982c-4330-9012-83e44f18c831.png">

On the left is frame 31 and on the right is frame 32. The rules of the update for the cell status are: if the cell is dead and three neighboring cells are alive the cell will become alive, if the cell is alive and two or three neighboring cells exactly are alive the cell will remain alive, otherwise the cell will die. This can be seen above looking from the left image to the right image.
