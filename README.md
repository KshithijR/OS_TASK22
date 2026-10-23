# Java Synchronization: Dining Philosophers & Readers–Writers

This repository contains Java implementations of classic operating system synchronization problems using **Monitors** and **Semaphores**, along with interactive HTML visualizations that demonstrate their execution.

## 📌 Projects

### 1. Dining Philosophers Problem

The Dining Philosophers Problem demonstrates process synchronization and resource sharing when multiple threads compete for limited resources.

**Implementations:**
- **Monitor:** Uses Java's `synchronized`, `wait()`, and `notifyAll()` to coordinate philosophers.
- **Semaphore:** Uses semaphores to control access to forks and limit the number of philosophers competing for resources simultaneously.

**Key concepts:**
- Thread synchronization
- Mutual exclusion
- Deadlock prevention
- Resource allocation

### 2. Readers–Writers Problem

The Readers–Writers Problem demonstrates how multiple readers and writers access a shared resource while maintaining data consistency.

**Implementations:**
- **Monitor:** Uses synchronized methods, a reader counter, and wait/notification mechanisms to coordinate access.
- **Semaphore Visualization:** Demonstrates reader-preference synchronization using semaphores.

**Key concepts:**
- Shared resource management
- Mutual exclusion
- Concurrent reading
- Exclusive writing
- Thread coordination

## ✨ Features

- Java implementations of synchronization problems
- Monitor-based and semaphore-based approaches
- Interactive HTML visualizations of execution sequences
- Playback, step-by-step navigation, reset, and speed controls where available
- Visual representation of thread states and resource access
- Simple interface for understanding operating system concepts

**Note:** The HTML visualizations replay predefined execution traces. They are separate from the Java programs and do not display live Java thread execution.

## 📂 Project Structure

```text
.
├── DiningPhilosophersMonitor.java
├── DiningPhilosophersSemaphore.java
├── ReadersWritersMonitor.java
├── dining_philosophers_monitor.html
├── dining_philosophers_semaphore.html
├── readers_writers_monitor.html
└── Readers_writers_semaphore.html
```

*Note: Java files may need to be placed in directories matching their declared package names. Rename the HTML files in this structure to match the actual filenames in your repository.*

## 🛠️ Technologies Used

- **Java** — Multithreading and synchronization
- **HTML5** — Visualization structure
- **CSS3** — Styling and layout
- **JavaScript** — Animation controls and execution-tr
