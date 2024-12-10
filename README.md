# **Real-Time Game Leaderboard**

This project is a Spring Boot application designed to provide a real-time leaderboard system for an online game. It integrates **Redis** for high-performance score storage and retrieval, and **WebSocket with STOMP** for real-time updates to connected clients.

---

## **Features**
- **Real-time updates:** Automatically notify clients when the leaderboard changes.
- **Sorted Leaderboard:** Retrieve player scores in both ascending and descending order.
- **WebSocket Integration:** Clients can subscribe to real-time leaderboard updates.
- **Redis Integration:** Efficient storage and sorting of player scores.

---

## **Technologies Used**
- **Spring Boot:** Core framework for the application.
- **Redis:** In-memory data store for leaderboard management.
- **WebSocket (STOMP):** For real-time communication between server and clients.
- **Maven:** Dependency management and build tool.

---

## **Setup Instructions**

### **Prerequisites**
1. **Java 17 or later**
2. **Redis Server:** Ensure Redis is installed and running.
3. **Maven:** To build and run the project.
4. **Postman or a WebSocket client:** For testing the APIs and WebSocket.

