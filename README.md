
# 📝 To-Do List Manager with Local Storage

## 🚀 Project Overview
The **To-Do List Manager with Local Storage** is a robust, object-oriented Java console application designed to help users create, organize, and manage their daily tasks. It features instant data saving using local storage, ensuring that tasks persist across different user sessions. 

## 🎯 Problem Statement
Managing daily tasks efficiently is crucial for productivity. Many simple task managers lose data once the application is closed, while heavy applications require active internet connections and database setups. This project solves that problem by providing a lightweight, offline-first task manager that securely saves data locally without requiring external databases.

## 🏢 Industry Relevance
This project mirrors real-world enterprise applications. Similar systems are used in:
*   Project management tools (like Jira or Trello).
*   Employee task systems and workflow management platforms.
*   Student assignment trackers and personal planning apps.

It demonstrates crucial industry skills such as client-side data modeling, UI state management, CRUD operations, and file persistence.

## ☕ Java Concepts Used
*   **Object-Oriented Programming (OOP):** Classes, objects, and encapsulation to model Tasks.
*   **Collections Framework:** Using `List` and `ArrayList` to store and manipulate tasks dynamically.
*   **Enums:** For defining restricted, type-safe values for `TaskPriority`, `TaskStatus`, and `TaskCategory`.
*   **File Handling & Serialization:** For reading and writing Java objects directly to a `.dat` file.
*   **Date & Time API:** Using `java.time.LocalDate` to track creation and due dates.
*   **Exception Handling:** Gracefully managing missing files or corrupted data during startup.

## ✨ Features
*   **Add Task:** Create tasks with a title, description, priority, category, and due date.
*   **View All Tasks:** Display a formatted list of all saved tasks.
*   **Mark as Completed:** Change a task's status dynamically using its unique ID.
*   **Delete Task:** Remove tasks permanently.
*   **Overdue Detection:** Automatically identify and list overdue tasks.
*   **Local Storage:** Automatically load tasks on startup and save them on exit.

## 🔄 Task Lifecycle
1.  **Application Start:** Loads existing tasks from local storage.
2.  **Creation:** A new task is instantiated with `PENDING` status.
3.  **Update/Complete:** Task transitions to `COMPLETED` when the user finishes it.
4.  **Deletion:** Task is removed from memory.
5.  **Application Exit:** All current states are serialized and saved back to the disk.

## 🏗️ Architecture & Data Flow
**Data Flow:** `User Input -> Main (Console UI) -> TaskService (Business Logic) -> FileTaskRepository (Storage) -> tasks.dat`

## 📁 Folder Structure
```text
To-Do-List-Manager-Local-Storage/
│
├── src/
│   ├── model/         # Task.java, Enums
│   ├── service/       # TaskService.java
│   ├── repository/    # FileTaskRepository.java
│   ├── utility/       # InputValidator.java
│   └── main/          # Main.java (Application Entry Point)
├── data/              # Storage for tasks.dat
├── outputs/           # Captured terminal outputs
├── logs/              # Application logs
├── screenshots/       # Project screenshots
├── docs/              # Additional documentation
├── README.md          # Project Documentation
└── .gitignore         # Git ignore rules

```

## 💾 Local Storage Approach

This project uses **Java Object Serialization** (`ObjectOutputStream` and `ObjectInputStream`). This approach was chosen because it seamlessly converts complex Java objects into a byte stream to be stored in a `.dat` file, teaching fundamental low-level file I/O operations without relying on external libraries like Jackson or Gson.

## ⚙️ How to Run

**Using Command Line:**

1. Clone the repository: `git clone https://github.com/YourUsername/To-Do-List-Manager-Local-Storage.git`
2. Navigate to the project root: `cd To-Do-List-Manager-Local-Storage`
3. Compile the code:
```bash
javac -d bin src/model/*.java src/repository/*.java src/service/*.java src/utility/*.java src/main/*.java

```


4. Run the application:
```bash
java -cp bin main.Main

```



## 💻 Sample Menu

```text
=========================================
  Welcome to To-Do List Manager  
=========================================

MAIN MENU
1. Add Task
2. View All Tasks
3. Mark Task as Completed
4. Delete Task
5. View Overdue Tasks
6. Exit
Select an option: 

```

## 📸 Screenshots

*(Note: Replace these with your actual image paths once you upload screenshots to the `/screenshots/` folder)*

* [Main Menu UI](https://www.google.com/search?q=./screenshots/main_menu.png)
* [Adding a Task](https://www.google.com/search?q=./screenshots/add_task.png)
* [Viewing All Tasks](https://www.google.com/search?q=./screenshots/view_tasks.png)

## 🚧 Limitations

* Runs strictly in the command line interface (no GUI).


* Serialization is sensitive to changes in the class structure (changing `Task.java` might invalidate old `.dat` files).


* Data is stored locally on a single machine, meaning it cannot be synced across multiple devices.



## 🚀 Future Improvements

* Implement a JavaFX or Swing Graphical User Interface (GUI).


* Migrate data storage to JSON format or an SQLite database for better data portability.


* Add user authentication and login features.


* Include search functionality and filtering (e.g., viewing tasks by specific categories).



## 🧠 Learning Outcomes

Building this project provided hands-on experience with:

* Structuring an application using layered architecture (Model, Service, Repository, Main).


* Handling user inputs and validating dates safely.


* Understanding how data persists in applications after the JVM shuts down.


* Using Git and creating professional technical documentation.



## 👨‍💻 Author

**[Your Name / GitHub Username]**

* LinkedIn: [Your LinkedIn URL]
* Email: [Your Email]
* GitHub: [Your GitHub URL]

```

```