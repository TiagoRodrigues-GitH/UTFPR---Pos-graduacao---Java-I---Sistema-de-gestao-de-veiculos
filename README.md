# 🚗 Vehicle Management System - Java (Console and GUI)
Concepts:
Abstract and final classes,
Inheritance and polymorphism,
Encapsulation,
Checked exceptions,
Interface,
Arrays,
Java Swing (manual GUI),
Events (ActionListener).


## 🧱 Project Structure (based on the diagram)

- `Veiculo` (abstract)
- `Passeio` (final) - Passenger vehicle
- `Carga` (final) - Cargo vehicle
- `Motor`
- `Calc` (interface)
- `VeicExistException` (checked exception)
- `VelocException` (checked exception)
- `Leitura` (helper class for data input)
- `Teste` (main class with menu and GUI)

## ⚙️ Features

- Register passenger and cargo vehicles (max. 5 each)
- Duplicate license plate validation
- Maximum speed validation (80 to 110 Km/h)
- Speed conversion:
  - Passenger: Km/h → M/h (meters per hour)
  - Cargo: Km/h → Cm/h (centimeters per hour)
- Special calculation via `Calc` interface:
  - Passenger: sum of letters in String attributes
  - Cargo: sum of numeric attributes
- Search vehicle by license plate
- Print all vehicles of a given type
- GUI (Activity 08) with manual windows and "Exit" button

## ▶️ How to run

### Console version (Activity 07)
```bash
javac *.java
java Teste

<img width="720" height="651" alt="Captura de tela 2026-06-01 144641" src="https://github.com/user-attachments/assets/e01df40f-2161-49dd-b8a7-3780e711799f" />

<img width="809" height="465" alt="Captura de tela 2026-06-01 144618" src="https://github.com/user-attachments/assets/c3679675-6ce6-4a5b-8ee0-35131ada5fd5" />

