# Java Activities — Carl Jayson Eli Bonaobra

A cleaned and organized collection of previous Java programming activities.
The source files were consolidated from the original archives, duplicate copies were removed, formatting was normalized, and broken/incomplete source code was repaired where a valid copy or clear intent was available.

## Folder Structure

| Section | Activity / Exercise | Main File | Main Concept |
|---|---|---|---|
| `01_Basic_Java` | Hello World | `HelloWorld.java` | `JOptionPane` / basic Java output |
| `02_Array_Exercises` | Exercise 1 | `Exercise1.java` | Sorting numeric and string arrays |
| `02_Array_Exercises` | Exercise 2 | `Exercise2.java` | Summing array values |
| `02_Array_Exercises` | Exercise 5 | `Exercise5.java` | Searching/checking array contents |
| `02_Array_Exercises` | Exercise 7 | `Exercise7.java` | Removing an array element |
| `03_Array_Practice` | Array Loop Sample | `ArrayLoopSample.java` | Array initialization and loops |
| `03_Array_Practice` | String Array Search | `StringArraySample.java` | Searching a string array |
| `03_Array_Practice` | Days of Week Loops | `DaysOfWeek.java` | `while`, `do-while`, and `for` loops |
| `04_Input_and_Loops` | Greatest Number | `GreatestNumber.java` | User input, loops, maximum value |
| `05_Mini_Projects` | Pharmacy POS | `PharmacyPOS.java` | OOP, collections, input, receipt calculation |
| `06_Hashing_Activity` | Custom MD5 Hasher | `CustomMD5Hasher.java` | Hashing algorithm implementation |

## Notes on Cleanup

- Added `CARL JAYSON ELI BONAOBRA` to every Java source file.
- Removed duplicate source copies and compiled `.class` files.
- Removed generated NetBeans build output and private IDE configuration from the cleaned collection.
- Corrected the broken Exercise 7 source and made element removal produce a correctly sized array.
- Improved indentation, variable names, comments, and input handling.
- Preserved the general behavior and learning objective of each original activity.
- Added a `.gitignore` suitable for a Java/NetBeans repository.

## Compile and Run

Each activity is intentionally self-contained. Open a terminal in the folder containing the Java file, then run:

```bash
javac FileName.java
java ClassName
```

Example for Exercise 1:

```bash
cd 02_Array_Exercises/Exercise_01_Array_Sorting
javac Exercise1.java
java Exercise1
```

## Suggested GitHub Repository Name

`java-programming-activities`

## Suggested First Commit

```bash
git init
git add .
git commit -m "Organize and clean Java programming activities"
```
