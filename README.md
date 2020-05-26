## Chessboard

The chessboard is an 8 x 8 grid with 64 cells in it.
With 8 rows (A, B, C.... H) and 8 columns (1, 2, 3.... 8), each cell can be uniquely
identified with its cell number.

#### Chess Pieces and their movements

The game of chess has 6 unique types of pieces, with their own unique types
of movements. These are:
* King – Can move only 1 step at a time in all 8 directions (horizontal, vertical
and diagonal)
* Queen – Can move across the board in all 8 directions
* Bishop – Can move across the board only diagonally
* Horse – Can move across the board only in 2.5 steps (2 vertical steps and 1
horizontal step)
* Rook – Can move across the board only vertically and horizontally
* Pawn – Can move only 1 step at a time, in the forward direction, vertically.
  Can also move 1 step forward diagonally, in order to eliminate an opposing
  piece.
  
### Objective of your program

Your program should simulate the movement of each unique chess piece on an
empty chessboard.
* Input – The input string to your program will be the Type of chess piece and
its Position (cell number) on the chessboard. E.g. “King D5”
* Output – Once you execute the program, the output will be a string of all
possible cells in which the chess piece can move.

### Tech

This project requires java 8 or above installed on your machine. It is a simple console app build using gradle-init task using type java-application.
- Java 8
- gradle 4.7


### How to Run
Please run below comman from command prompt/terminal which should be at the base of the project directory.
For e.g. if the project is copied in /Users/ashish/workspace, you should run below command from /Users/ashish/workspace/chessboard
```shell script
./gradlew run -q --console=plain
Input : <enter a valid input>
Output : <All the possible moves of the chess piece you entered>
```

### How to Test :
```shell script
./gradlew test
```

###Assumption
Assume that the board is empty. This means that the pawn cannot move 
diagonally. 
