📦 Supported Book Types
Book Type	Purchasable	Stock-tracked	Requires Shipping	Sends Email	Notes
PaperBook	✅	✅	✅	❌	Tracks quantity, shipped
EBook	✅	❌	❌	✅	Delivered via email
ShowcaseBook	❌	❌	❌	❌	Not for sale, display only

🧩 Core Features & How to Use
1. ✅ Add Books to Inventory
java
Copy
Edit
inventory.addBook(new PaperBook("1", "Java Basics", 2019, 30.0, 10));
inventory.addBook(new EBook("2", "Spring Boot Guide", 2021, 20.0, "PDF"));
inventory.addBook(new ShowcaseBook("3", "Ancient Manuscript", 1990));
Each book is stored using its unique ISBN.

2. 💳 Purchase a Book
java
Copy
Edit
double paid = inventory.buyBook("1", 2, "michael@example.com", "Cairo");
Validates that the book exists

Checks that it is purchasable

For PaperBook: verifies stock, triggers shipping

For EBook: sends email delivery

For ShowcaseBook: throws exception (not purchasable)

3. 🗑️ Remove Outdated Books
Books published more than maxYears ago can be removed.

java
Copy
Edit
List<Book> removed = inventory.removeOutdatedBooks(10);
Returns list of removed books

Useful for cleaning obsolete inventory

4. 📤 Shipping and Email Services
These are static utility services:

java
Copy
Edit
ShippingService.sendTo("Cairo");
// Output: Shipping paper book to Cairo

MailService.sendTo("michael@example.com");
// Output: Email sent to michael@example.com
🧠 Design Highlights
🔄 Interface-Oriented Design
Purchasable for buyable books

ShippingService, MailService for delivery methods

💡 Open/Closed Principle
Easy to extend (AudioBook, ComicBook, etc.)

No need to modify Inventory for new Purchasable types

🧪 Error Handling
Invalid ISBN or non-purchasable books trigger exceptions

PaperBook enforces stock limits at purchase

