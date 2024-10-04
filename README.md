# Matrix Assignment

The goal of this assignment is to help students understand exceptions, enums, interfaces, and class inheritance. The starter code provided represents minimal code and likely contains poor Java coding practices. As the semester progresses, you will learn about additional Java keywords and implementations that will make the project more portable and reliable.

### IntelliJ Directions

IntelliJ is the recommended IDE for Java development.  After you clone this repo to your local computer, the directory MatrixAssignment is the directory you should select when opening the project in IntelliJ.

## Project Owner Statement

As a Java instructor, I need to evaluate your ability to debug errors and implement the following: 

* Interfaces
* Class inheritance
* Enums with constructors
* Custom exceptions

I have provided some starter code that may not compile. Below are just a few of the issues you may need to consider:

* Handling methods that throw errors
* Improper casting of objects
* Protected vs. private variables:
  * Protected variables behave like private variables to external classes.
  * Protected variables can be accessed like public variables in extending classes.
  * Protected variables can be accessed like public variables in instances created within the same class.

## Acceptance Criteria

Below are the acceptance criteria for achieving full credit on this assignment:

* Do not alter the unit tests in any way (even adding a space will cause them to fail).
* Do not modify the Java interface files (the autograder may delete and replace these with the intended versions).
* Do not alter the enum containing error messages and status codes.
* You will likely need to add error handling to the method signatures.
* Some methods in the `SquareMatrix` class may cause casting errors. Remember, `SquareMatrix` extends `Matrix`.
  * Every instance of `SquareMatrix` is essentially an instance of `Matrix`, but not every instance of `Matrix` is an instance of `SquareMatrix`.
  * Casting errors occur because you may be trying to force a `Matrix` instance to be a `SquareMatrix`.
  * Without these errors, you could potentially bypass type and compatibility checks incorporated into the constructor(s) of `SquareMatrix`.

There may be other considerations, but the above points are a good starting place.

## Grading

Here is an overview of how this assignment will be graded:

* 10 points for accepting the assignment.
* 20 points for pushing at least one commit to your repository.
* 70 points (all or nothing) for passing all unit tests.

You may not modify the unit test files in any way. An SHA-256 checksum has been computed for each of the unit test files. If the checksum fails, the unit tests will fail. Even adding a single space to one of the files will cause the checksum to fail. My advice is to leave the files in the test directories untouched.
