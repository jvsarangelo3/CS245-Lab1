# CS245-Lab1
Connor Barski, Jacelle Sarangello 9/4/2020

Our sudoku program runs and compiles as it should, with comments explaining the code. When given a solveable puzzle, it prints the solution using recursion and backtracking. 
When given an unsolvable puzzle, the program prints "No Solution". The programs main functions are printBoard, to print the unsolved and solved board, checker to check rows,
columns, and 3x3 square to see if the number can be put in that position, solveBoard which uses recursion and backtracing to solve the puzzle and a main function
to run the functions. The biggest issues we faced were the implimentation of the solveBoard function and checking a 3x3 area. The solveBoard implementation
first uses the base case to check for empty slots on the board, and breaks the loop when it finds one, which that position is then used to place a number 1-9, which 
when ran through checker, if works, then calls the function recursively until either all slots are correcetly filled or a number cannot be placed at a position and the program
then backtracks.
