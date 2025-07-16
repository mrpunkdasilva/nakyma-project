# Nakyma Project

## Description

This project is a Java-based application for visualizing various sorting algorithms. It includes a graphical user interface (GUI) to demonstrate how different sorting algorithms work in real-time.

## Technologies Used

*   Java
*   Maven

## How to Build and Run

To build the project, navigate to the root directory (`nakyma-project`) and run:

```bash
mvn clean install
```

To run the application, execute the following command from the root directory:

```bash
mvn exec:java -Dexec.mainClass="org.punkdomus.Main"
```

## Features

*   Visualization of multiple sorting algorithms (Bubble Sort, Quick Sort, Selection Sort).
*   Interactive GUI for controlling the visualization.
*   Command-line argument handling for various options.

## Project Structure

```
src/
├── main/
│   ├── java/ (Main application source code)
│   └── resources/ (Application resources like sounds and images)
└── tests/ (Unit tests)
```
