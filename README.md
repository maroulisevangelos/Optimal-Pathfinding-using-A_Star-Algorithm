# Optimal-Pathfinding-using-A_Star-Algorithm
This project implements the A* search algorithm to find the optimal path in a maze using Java. Two heuristic functions are used: 1) Manhattan distance and 2) Euclidean distance.


Features:

    Manhattan Distance Heuristic: Uses the Manhattan distance as a heuristic to guide the search.
    
    Euclidean Distance Heuristic: Uses the Euclidean distance as a heuristic to guide the search.
    
    Pathfinding Execution: Executes the pathfinding algorithm via the command line.
    
    User Input: Accepts the name of a text file containing the maze for which the solution needs to be found.
    
    Output Path: Displays the optimal path found in the format of coordinates.

Implementation Details:

  Manhattan Distance Execution:

    javac Manhattan.java
    java Manhattan
    
  Euclidean Distance Execution:

    javac Euclidean.java
    java Euclidean
    
  User Input: Prompts the user for the name of the text file (without the .txt extension) that contains the maze. The text file should be in the same directory as the code.
  
  Example Output:
  
    Path: {[0, 0], [0, 1], [0, 2], [0, 3], [0, 4], [0, 5], [0, 6], [1, 6], [1, 7], [1, 8], [2, 8], [2, 9], [3, 9], [4, 9], [4, 10]}
    
Files Included:

  Manhattan.java: Implements the pathfinding algorithm using the Manhattan distance heuristic.
  
  Euclidean.java: Implements the pathfinding algorithm using the Euclidean distance heuristic.
