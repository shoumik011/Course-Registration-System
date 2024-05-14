# Student and Course Management System

This Java program implements a Student and Course Management System, allowing registration and dropping of courses by students. It includes classes for `Student`, `RegisteredStudent`, `Course`, and custom exceptions like `PrerequisiteException` and `RegistrationException`.

## Classes

### `Student`

- Abstract class representing a generic student.
- Attributes:
  - `id`: Student ID
  - `name`: Student name
  - `courses`: List of courses taken by the student
- Methods:
  - `addCourse(course: Course)`: Abstract method to add a course to the student's course list.
  - `dropCourse(course: Course)`: Abstract method to drop a course from the student's course list.
  - Getters and setters for attributes.

### `RegisteredStudent`

- Subclass of `Student`, representing a registered student.
- Implements `Comparable` interface for comparing students by ID.
- Methods:
  - `addCourse(course: Course)`: Overrides method to add a course with prerequisite and offering checks.
  - `dropCourse(course: Course)`: Overrides method to drop a course from the student's course list.
  - Overrides `equals()` and `hashCode()` methods.
  - Implements `compareTo()` method for sorting.

### `Course`

- Class representing a course.
- Attributes:
  - `name`: Course name
  - `prerequisite`: Prerequisite course (if any)
  - `offered`: Flag indicating if the course is offered
- Methods:
  - Constructors to initialize attributes.
  - Getters and setters for attributes.
  - Overrides `equals()` method.

### `PrerequisiteException` and `RegistrationException`

- Custom exceptions for handling registration errors.

## Usage

To use the classes in your Java application:

1. Import the necessary classes.
2. Create instances of `Student`, `RegisteredStudent`, and `Course`.
3. Use methods like `addCourse()` and `dropCourse()` to manage student courses.
4. Handle exceptions like `PrerequisiteException` and `RegistrationException` where necessary.

## Note

- Ensure proper error handling when adding or dropping courses to avoid exceptions.
- Make sure to set prerequisites and offering flags for courses correctly.
