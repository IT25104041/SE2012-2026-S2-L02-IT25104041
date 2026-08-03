# SE2012 Practical 2 - Student Management System

## Repository Context
This repository is for **SE2012 Java Programming - Practical 2**.

The assignment focuses on building and evolving a **Student Management System** while practicing:
- Java classes and object-oriented design
- Package organization (`models`, `services`, `mainapp`)
- Control structures (`switch`, loops)
- Array-based sorting and searching
- JavaDoc documentation generation

Core classes expected by the practical:
- `Student` (student id and name)
- `Course` (course code and title)
- `Main` (menu, input handling, program flow)
- `EnrollmentManager` (after package refactor)

## Code Architecture & How It Works
The application uses a modular structure to separate data storage from processing and user interface interaction.

### 1. Data Layer (`models/`)
* **`Student.java` & `Course.java`:** These function as standard data blueprints. They encapsulate fields (like `id` and `name`) using `private` visibility modifiers and expose them cleanly via public getter and setter methods.

### 2. Logic Layer (`services/`)
* **Tracking Tracker:** An internal pointer index tracks the active number of enrolled students. This pointer steps forward by 1 whenever a new record is added.
* **Linear Search Logic:** The system loops through the `Student[]` array sequentially. It compares the target ID string against each student's ID, stopping right at the tracking pointer index to avoid processing blank `null` memory blocks.
* **Bubble Sort Logic:** The system compares adjacent elements inside the array pairwise. It uses `String.compareToIgnoreCase()` to check alphabetical hierarchy. If a preceding student name is out of order, the two objects trade memory positions inside the array. This continues until a complete pass occurs with zero swaps.

### 3. Application UI Layer (`mainapp/`)
* **`Main.java`:** Operates an continuous `do-while` loop rendering the CLI command choices. It processes system selections using a structural `switch-case` block and hands off all text parameters down to the logic layer.

## Suggested Project Structures

### Part 1 (No packages)

```text
StudentManagement/
|-- Student.java
|-- Course.java
`-- Main.java
```

### Part 2+ (With packages)

```text
StudentManagement/
|-- models/

|   |-- Student.java
|   `-- Course.java
|-- services/
|   `-- EnrollmentManager.java
`-- mainapp/
    `-- Main.java
```

## Prerequisites
- JDK 17+ (or your module-required Java version)
- Command prompt/terminal

Check installation:

```bash
java -version
javac -version
```

## How to Compile and Run

### Option A: Part 1 (without packages)
Run these commands from the folder containing `Main.java`:

```bash
javac Student.java Course.java Main.java
java Main
```

### Option B: Part 2+ (with packages)
Run these commands from the project root (`StudentManagement/`):

```bash
javac models/*.java services/*.java mainapp/Main.java
java mainapp.Main
```

## JavaDoc Generation
After adding JavaDoc comments to all public classes and methods:

```bash
javadoc -d docs models/*.java services/*.java
```

Then open:
- `docs/index.html`

## Functional Expectations
Your final program should support:
- Adding/enrolling students through a menu
- Listing students
- Searching student by ID (linear search)
- Sorting students by name (for example, bubble sort)
- Exit option

## Interactive Menu Operation Examples
When you run the code, it runs inside your command line terminal as follows:

### Enrolling a Student (Option 1)
```text
=== STUDENT MANAGEMENT SYSTEM ===
1. Enroll Student
2. List Students
3. Search Student by ID
4. Sort Students by Name
5. Exit
Enter choice: 1

Enter Student ID: S101
Enter Student Name: John 
Student enrolled successfully.
```

### List Students (Option 2)
```text
Enter choice: 2
Student List:
ID: S101 Name: John 
Enter Student ID to search: S101

```

### Searching a Student by ID (Option 3)
```text
Enter choice: 3
Enter Student ID to search: S101

 Record Found:
   ID: S101
   Name: John 
```

### Sort Students (Option 4)
```text
Enter choice: 4
Students sorted successfully
```
