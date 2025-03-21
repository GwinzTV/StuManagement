# Student Management App

Welcome to the **Student Management App**, a lightweight Java application designed to efficiently manage student data. As part of a performance experiment, this app also includes a custom in-memory database built using **HashMaps**, which was benchmarked against a traditional MySQL database for query times.

## Features

- **Add and manage student records**: Easily create, update, and delete student data.
- **Custom HashMap-based database**: Super fast data retrieval using a simple key-value structure.
- **MySQL integration (optional)**: Supports data storage and querying via a MySQL database if needed.
- **Benchmark comparisons**: See performance results between a relational database and an in-memory solution.

## Performance Benchmark

One of the core features of this project is the custom database implementation using Java's **HashMap**. This provides an alternative to traditional relational databases like MySQL, focusing on **speed** and **simplicity** for specific use cases.

### Benchmark Results:

- **MySQL query**: `22 milliseconds`
- **Custom HashMap query**: `0.025 milliseconds`

These results show a significant performance advantage when using the in-memory HashMap database, making it the ideal solution for scenarios that prioritize speed over complex relational data handling.

### Key Insights:

- **Blazing fast lookups**: The custom HashMap database excels at near-instantaneous lookups due to its efficient key-value pair structure.
- **Use-case optimized**: While MySQL is designed to handle complex relationships and large datasets, the HashMap-based solution is ideal for applications where quick data retrieval and simple data structures are key, like our Student Management system.
- **Simplicity with speed**: Traditional databases come with many features that may be unnecessary for smaller applications. A HashMap-based solution is lightweight and easy to implement while still delivering impressive performance.

However, it's worth noting that the **HashMap database is entirely in-memory**, so there are no persistence guarantees out-of-the-box. If the application crashes or restarts, data will be lost unless additional persistence mechanisms (e.g., serialization) are implemented.

## When to Use HashMap vs. MySQL?

The HashMap database is perfect for use cases where:

- You need **fast, in-memory data retrieval**.
- Your data structure is relatively simple (key-value pairs).
- Data persistence isn’t a major concern (or is handled separately).
- You are working with smaller datasets that can fit into memory.

On the other hand, MySQL is a better choice when:

- You need **persistent storage** across application restarts.
- Your data involves **complex relationships** (e.g., foreign keys, joins).
- You need **transactional support** and **data consistency guarantees**.

## Setup & Installation

### Prerequisites:

- Java 8 or higher
- [MySQL](https://www.mysql.com/) (optional, for MySQL database integration)
