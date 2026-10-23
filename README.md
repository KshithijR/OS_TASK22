
Synchronization in Java: Dining Philosophers & Readers–Writers
Interactive visualizations and Java implementations of two classic concurrency problems using monitors and semaphores. The HTML pages replay recorded thread executions so you can step through events and inspect how shared resources are coordinated.

Overview
This repository explores two operating-systems synchronization problems:

Dining Philosophers — five philosopher threads share five forks.
Readers–Writers — reader threads may access shared data concurrently, while writers require exclusive access.
Each problem includes Java source code and HTML visualizations for understanding the synchronization sequence.

Features
Java multithreading examples using Thread.
Monitor-based synchronization with synchronized, wait(), and notifyAll().
Semaphore-based synchronization with java.util.concurrent.Semaphore.
Interactive HTML event timelines with play, pause/step, reset, and speed controls (depending on the visualization).
Visual state indicators for waiting, reading/writing, eating, and resource ownership.
Recorded execution traces that can be replayed in a browser.
Responsive layouts and reduced-motion support in the visualizations.
Project Structure
.
├── DiningPhilosophersMonitor.java
├── DiningPhilosophersSemaphore.java
├── ReadersWritersMonitor.java
├── dining_philosophers_monitor(1).html
├── dining_philosophers_semaphore(1).html
├── readers_writers_monitor (1).html
└── Readers_writers_semaphore.html
The tree above reflects the uploaded filenames. You can rename the HTML files to remove spaces and (1) suffixes if desired; update the names in this README if you do.

Concepts Demonstrated
1. Dining Philosophers — Monitor
DiningPhilosophersMonitor.java creates five philosopher threads and a shared Table object. Synchronized methods coordinate fork access. A philosopher waits while either neighbour is eating, marks itself as eating when allowed, and calls notifyAll() after putting the forks down.

Key concepts:

Mutual exclusion through synchronized.
Condition waiting with while (...) wait().
Rechecking conditions after waking.
Notifying waiting threads with notifyAll().
2. Dining Philosophers — Semaphores
DiningPhilosophersSemaphore.java uses:

Five binary semaphores, one for each fork.
A room semaphore initialized with four permits, allowing at most four philosophers to compete for forks simultaneously.
acquire() and release() to coordinate access.
Each philosopher requests the left fork and then the right fork, eats, and releases both forks and the room permit.

3. Readers–Writers — Monitor
ReadersWritersMonitor.java uses a shared resource guarded by synchronized methods. Multiple readers may read at the same time when no writer is active. A writer waits until there are no active readers and no other writer. When the last reader exits or a writer finishes, notifyAll() wakes waiting threads to re-check their conditions.

Key concepts:

Concurrent readers.
Exclusive writer access.
Shared state (readerCount, writerActive, and sharedData).
Monitor coordination using wait() and notifyAll().
4. Readers–Writers — Semaphore Visualization
Readers_writers_semaphore.html visualizes a reader-preference readers–writers implementation using semaphores. It replays a recorded execution showing reader groups sharing access and writers acquiring exclusive access to the shared resource.

The corresponding semaphore-based Java source file was not included among the uploaded files, so this page is documented as a standalone recorded-run visualization.

Running the Java Programs
Install a JDK (Java Development Kit) and verify that Java is available:

java -version
javac -version
The source files declare Java packages. Keep each file in the directory matching its package declaration, or adjust the package declaration and directory structure consistently.

Dining Philosophers — Monitor
The file declares package diningPhilosophersMonitor.

javac diningPhilosophersMonitor/DiningPhilosophersMonitor.java
java diningPhilosophersMonitor.DiningPhilosophersMonitor
Dining Philosophers — Semaphores
The file declares package diningPhilosophersSemaphore.

javac diningPhilosophersSemaphore/DiningPhilosophersSemaphore.java
java diningPhilosophersSemaphore.DiningPhilosophersSemaphore
Readers–Writers — Monitor
The file declares package dining_with_monitor.

javac dining_with_monitor/ReadersWritersMonitor.java
java dining_with_monitor.ReadersWritersMonitor
Note: The commands above assume the source files are placed in matching package folders from the project root. If your files are all in one folder, move them into those folders first or compile/run them from your IDE with the package structure configured.

Viewing the HTML Animations
No server or external library is required for the uploaded HTML visualizations.

Download or clone this repository.
Open any .html file in a modern browser.
Use the on-page controls to play the recorded trace, step through events, change playback speed, or jump to an event in the timeline where available.
The visualizations replay recorded traces; they do not execute the Java source code inside the browser.

Technologies Used
Java — threads and synchronization primitives.
HTML5 — visualization structure.
CSS — layout, status styling, responsive design, and transitions.
JavaScript — replay controls, event timelines, and state rendering.
SVG — visual representation of philosophers, forks, and resource states.
Learning Outcomes
After exploring the examples, you should be able to explain:

How a monitor coordinates threads around shared state.
How wait() releases a monitor lock and allows a waiting thread to block.
Why a thread must re-check its condition after waking.
How semaphores control access to individual resources and limit concurrent contenders.
Why readers can share access while writers need exclusive access.
How event traces can help debug and understand concurrent execution.
Limitations
The HTML pages contain recorded traces, so their displayed events represent a particular run rather than a live connection to the Java programs.
Thread scheduling and console output order may vary between executions.
The uploaded files include a monitor-based Java implementation for Readers–Writers, but no matching semaphore-based Java source file was provided.
License
No license file was included with the uploaded files. Add a LICENSE file if you want to specify how others may use, modify, and distribute this project.

