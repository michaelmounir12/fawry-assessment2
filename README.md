# 📚 Quantum Bookstore – Java Inventory System

A command-line Java application for managing an inventory of different types of books. Demonstrates object-oriented principles like abstraction, inheritance, and interface-based behavior with support for real-world purchasing, shipping, and email notifications.

---

## ✨ Getting Started

### Requirements

* Java 11+
* Maven

### Run the Application

```bash
git clone https://github.com/michaelmounir12/[YOUR-REPO-NAME].git
cd [YOUR-REPO-NAME]
mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

---

## 📦 Supported Book Types

| Book Type      | Purchasable | Stock-tracked | Requires Shipping | Sends Email | Notes                      |
| -------------- | ----------- | ------------- | ----------------- | ----------- | -------------------------- |
| `PaperBook`    | ✅           | ✅             | ✅                 | ❌           | Tracks quantity, shipped   |
| `EBook`        | ✅           | ❌             | ❌                 | ✅           | Delivered via email        |
| `ShowcaseBook` | ❌           | ❌             | ❌                 | ❌           | Not for sale, display only |

---

## 🤩 Core Features & How to Use

### 1. ✅ Add Books to Inventory

```java
inventory.addBook(new PaperBook("1", "Java Basics", 2019, 30.0, 10));
inventory.addBook(new EBook("2", "Spring Boot Guide", 2021, 20.0, "PDF"));
inventory.addBook(new ShowcaseBook("3", "Ancient Manuscript", 1990));
```

Each book is stored using its unique ISBN.

---

### 2. 💳 Purchase a Book

```java
double paid = inventory.buyBook("1", 2, "michael@example.com", "Cairo");
```

* Validates that the book exists
* Checks that it is **purchasable**
* For `PaperBook`: verifies **stock**, triggers **shipping**
* For `EBook`: sends **email delivery**
* For `ShowcaseBook`: throws exception (`not purchasable`)

---

### 3. 🗑️ Remove Outdated Books

Books published more than `maxYears` ago can be removed.

```java
List<Book> removed = inventory.removeOutdatedBooks(10);
```

* Returns list of removed books
* Useful for cleaning obsolete inventory

---

### 4. 🛄 Shipping and Email Services

These are static utility services:

```java
ShippingService.sendTo("Cairo");
// Output: Shipping paper book to Cairo

MailService.sendTo("michael@example.com");
// Output: Email sent to michael@example.com
```

---

## 🫠 Design Highlights

### 🔄 Interface-Oriented Design

* `Purchasable` for buyable books
* `ShippingService`, `MailService` for delivery methods

### 💡 Open/Closed Principle

* Easy to extend (`AudioBook`, `ComicBook`, etc.)
* No need to modify `Inventory` for new `Purchasable` types

### 🧪 Error Handling

* Invalid ISBN or non-purchasable books trigger exceptions
* `PaperBook` enforces stock limits at purchase

---

## 🛠️ Project Structure

```
org.example/
├── Book.java             # Abstract base class
├── PaperBook.java        # Purchasable & Shippable
├── EBook.java            # Purchasable & Emailable
├── ShowcaseBook.java     # Non-purchasable display
├── Purchasable.java      # Marker interface with buy()
├── Inventory.java        # Main logic: add/remove/buy books
├── MailService.java      # Static utility for sending emails
├── ShippingService.java  # Static utility for shipping
└── Main.java             # Demo and test runner
```

---

## 🧪 Sample Output

```
Quantum book store: Paid amount = 60.0
Email sent to michael@example.com
Quantum book store: Book is not purchasable
Quantum book store: Removing outdated books...
Removed book isbn: 3
```

---


