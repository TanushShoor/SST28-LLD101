# SST28-LLD101 — SOLID Refactoring Assignment

This repository contains my refactored solutions for Exercises 1–6 of the SOLID Refactoring Assignment as part of the LLD101 course at Scaler School of Technology.

## Objective

The goal of this assignment is to refactor existing Java programs to comply with the SOLID principles while preserving the original behavior and console output.

The SOLID principles applied include:

- **S — Single Responsibility Principle (SRP)**
- **O — Open/Closed Principle (OCP)**
- **L — Liskov Substitution Principle (LSP)**
- **I — Interface Segregation Principle (ISP)** *(covered in later exercises, not included here)*
- **D — Dependency Inversion Principle (DIP)** *(covered in later exercises, not included here)*

This submission includes refactored solutions for Exercises 1 through 6.

---

## Repository Structure
```bash
SST28-LLD101/
└── SOLID/
├── Ex1/
│  └── src/
├── Ex2/
│  └── src/
├── Ex3/
│  └── src/
├── Ex4/
│  └── src/
├── Ex5/
│  └── src/
└── Ex6/
   └── src/
```


Each exercise contains:

- Refactored Java source files
- Original README.md (provided with assignment)
- Compile-ready and run-ready code

---

## How to Compile and Run

Navigate to any exercise folder, for example:

```bash
cd SOLID/Ex1/src
javac *.java
java Main
```

No external libraries or build tools are required.

Java version: Java 17

Key Refactoring Improvements

Across the exercises, the following improvements were made:

Separation of concerns (SRP)

Removal of rigid conditional logic using polymorphism (OCP)

Ensured substitutability of subclasses (LSP)

Clear abstraction boundaries

Improved modularity and extensibility

All refactoring preserves the original observable behavior as required.

Author

Tanush Shoor

Scaler School of Technology

LLD101 — SOLID Refactoring Assignment
