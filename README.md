# Algo-Data-Structures---projet6
In partnership with Zach Morlan (git: zmorlan1) we created two complex sorting algorithms.


The goal of this program/project was to create two methods (one for shell and another for quick sort)

A hundred random numbers are generated to the text file 'Project06_Input.txt', and then our sorting methods puts
them in ascending order.


### You can run this project here - https://onlinegdb.com/FQGxplfup


## RandomIntegerGenerator.java
This class generates a hundred random numbers using a loop and
and the java.random.Random package. These numbers are added to a text file
using the Java PrintWriter.


## MbamiLuka_06.java
This class has the main method, which runs the whole program as a unit.
The shell-sort and quick-sort methods have one parameter, I.e. the array of unsorted numbers.
These are the 100 random generated numbers from the class above.
Last, I have an insertion sort method because shell sort uses insertion sort but effectively.

Shell sort O(n^2)

Quick sort O(n^2)

