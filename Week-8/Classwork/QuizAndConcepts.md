# Week 8 - Object-Oriented Programming: Quiz & Concept Questions

---

## 📝 Part 1: Quiz Questions

### Question 1
**Question**: A system processes Document objects. It initially had `PDFDocument` and `WordDocument` classes, both inheriting from `Document` and implementing a `render()` method. A developer observes repeated `if-else if` blocks checking the document type before calling `render()`. What is the most appropriate OOP principle to apply to eliminate this conditional logic?  
- **Correct Answer**: **C) Polymorphism**  
- **Explanation**: Polymorphism allows calling `document.render()` on a base-type reference (`Document`), letting dynamic dispatch invoke the appropriate overridden `render()` method at runtime without checking concrete types with `if-else`.

---

### Question 2
**Question**: Which of the following scenarios represent a genuine 'is-a' relationship, making inheritance a suitable design choice? (Select all that apply)  
- **Correct Answers**:  
  - **A) A `Car` is a `Vehicle`.**  
  - **B) A `Rectangle` is a `Shape`.**  
  - **C) A `DatabaseConnection` is a `NetworkResource`.**  
- **Explanation**: Options A, B, and C represent valid semantic subtyping where the derived class is a specialized type of the base class. Option D represents composition ('has-a'), not inheritance ('is-a').

---

### Question 3
**Question**: Consider a `Vehicle` base class with a method `startEngine()` and two derived classes, `Car` and `Motorcycle`, both overriding `startEngine()`. What mechanism ensures the correct implementation is called during polymorphic iteration?  
- **Correct Answer**: **C) Runtime method dispatch**  
- **Explanation**: In Java, non-static, non-final methods use virtual method invocation (dynamic dispatch via vtable) at runtime based on the actual object instance.

---

### Question 4
**Question**: A `Shape` base class has a method `calculateArea()`. `Circle` and `Rectangle` are derived classes overriding `calculateArea()`. Storing them in a list and calling `calculateArea()` on each demonstrates:  
- **Correct Answer**: **C) Inheritance-based polymorphism**  
- **Explanation**: Iterating over base references and having each subclass execute its specific behavior through an overridden method is inheritance-based runtime polymorphism.

---

### Question 5
**Question**: A software component manages `LibraryItem` types like `Book` and `DVD`. Both inherit from `LibraryItem` with `getLoanPeriod()`. `Book` extends it for new releases, while `DVD` sets a fixed loan period. Which statements are accurate? (Select all that apply)  
- **Correct Answers**:  
  - **A) `getLoanPeriod()` in `Book` is an example of extending inherited behavior.**  
  - **C) The `LibraryItem` class defines the common behavior for all library items.**  
  - **D) A `DVD` object can be processed as a `LibraryItem` through a common reference.**  

---

### Question 6
**Question**: Consider a base class `Animal` with `makeSound()` and derived classes `Dog` ('Woof') and `Cat` ('Meow'). Which statements are correct? (Select all that apply)  
- **Correct Answers**:  
  - **A) If a `Dog` object is referred to by an `Animal` reference, calling `makeSound()` will execute `Dog`'s `makeSound()`.**  
  - **C) The `makeSound()` method in `Dog` is an example of overridden behavior.**  

---

### Question 7
**Question**: `PaymentProcessor` processes `CardPayment` and `BankTransferPayment` derived from `Payment`. What is the primary benefit when adding `WalletPayment`?  
- **Correct Answer**: **C) It allows adding `WalletPayment` without modifying the existing `PaymentProcessor`'s iteration logic.**  
- **Explanation**: This satisfies the Open/Closed Principle (OCP): open for extension, closed for modification.

---

### Question 8
**Question**: Why is using inheritance solely for superficial code reuse between unrelated classes generally considered inappropriate?  
- **Correct Answer**: **A) It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid.**  
- **Explanation**: Inheritance creates strong coupling. If classes do not have an authentic conceptual 'is-a' relationship, composition should be preferred over inheritance.

---

### Question 9
**Question**: What are the advantages of using inheritance and polymorphism in a `Notification` system (`EmailNotification`, `SMSNotification`, `PushNotification`)? (Select all that apply)  
- **Correct Answers**:  
  - **A) It allows a generic `NotificationSender` to send various types of notifications without knowing their concrete types.**  
  - **C) It simplifies the process of adding a new notification channel, like `InAppNotification`, without altering existing sender logic.**  

---

### Question 10
**Question**: Which of the following are benefits of using polymorphic collections (e.g., a list of base class references holding derived class objects)? (Select all that apply)  
- **Correct Answers**:  
  - **A) It simplifies iterating over diverse but related objects.**  
  - **B) It allows for uniform processing of objects with specialized behavior.**  
  - **C) It reduces the need for explicit type casting in common processing loops.**  

---

## 💡 Part 2: Concept Questions & Comprehensive Answers

### Question 1: Inheritance for Code Reuse and Extension
**Answer**:  
Inheritance allows derived classes to automatically inherit common fields and methods from a base class while overriding or adding specialized behavior.  
*Business Example*: An e-commerce platform has an `Order` base class handling order ID, customer details, and standard checkout logic. A `SubscriptionOrder` subclass inherits this setup but extends the behavior by adding recurring billing schedules and overriding the `processPayment()` method to execute tokenized recurring billing.

---

### Question 2: The 'is-a' Relationship
**Answer**:  
The 'is-a' relationship asserts that a derived class is a specialized version of the base class and adheres to the Liskov Substitution Principle (LSP). If class B inherits from class A, anywhere an A is expected, a B should function correctly without breaking expectations. Misidentifying 'is-a' leads to fragile code, inheritance hierarchy pollution, and unexpected runtime bugs.

---

### Question 3: Method Overriding
**Answer**:  
Method overriding occurs when a subclass provides a specific implementation of a method already defined in its superclass, keeping the same method signature.  
*Business Scenario*: An `Employee` class defines `calculateSalary()`. A `SalariedEmployee` computes salary as a fixed monthly amount, a `CommissionEmployee` calculates salary based on sales percentage, and an `HourlyEmployee` computes wage based on hours worked. Each subclass overrides `calculateSalary()` according to its own compensation rules.

---

### Question 4: Runtime Polymorphism (Dynamic Dispatch)
**Answer**:  
Dynamic dispatch is the mechanism by which a call to an overridden method is resolved at runtime rather than compile time. When a method is called on a reference of a superclass type, the Java Virtual Machine (JVM) inspects the actual object type in the heap and consults its internal virtual method table (vtable) to invoke the concrete subclass implementation.

---

### Question 5: Polymorphic Collections
**Answer**:  
A polymorphic collection is a data structure (like `List<Shape>` or `Account[]`) typed to a base class or interface that holds heterogeneous instances of any of its derived subclasses.  
*Advantage*: It decouples client code from specific implementations. A single loop `for (Shape s : shapes) s.draw();` can render circles, squares, and triangles seamlessly without requiring type checks or casting.

---

### Question 6: Polymorphism vs. Type-Based Conditional Logic
**Answer**:  
Using `if-else if (obj instanceof TypeA)` or `switch` statements creates brittle code. Every time a new type is introduced, every single conditional block across the codebase must be found and modified. Polymorphism centralizes type-specific behavior inside the respective class itself, adhering to the Open/Closed Principle.

---

### Question 7: Extensibility Without Modifying Processing Logic
**Answer**:  
When code is written against an abstraction (e.g. `PaymentMethod.calculateFee()`), adding a new payment method like `CryptoPayment` requires only writing the new class. The existing billing processor iterates through payment references and executes `calculateFee()` polymorphically without needing a single line of modification.

---

### Question 8: Inherited Behavior vs. Overridden Behavior
**Answer**:  
- **Inherited Behavior**: Used when the logic defined in the superclass applies identically to the subclass (e.g. `getUserName()` or `getId()`).
- **Overridden Behavior**: Used when the subclass requires specialized, different, or enhanced logic for the same operation (e.g. a `SavingsAccount` overriding `calculateInterest()` while keeping `getBalance()` inherited from `Account`).

---

### Question 9: Inheritance Solely for Code Reuse (Anti-pattern)
**Answer**:  
Inheriting solely for convenience when there is no genuine 'is-a' relationship (e.g. making `Stack` inherit from `Vector`) violates encapsulation and exposes methods that are semantically invalid on the subclass (like inserting into the middle of a Stack). Composition ("has-a") should always be preferred over inheritance when only code reuse is needed.

---

### Question 10: Case Study: Vehicle Rental System
**Answer**:  
In a vehicle rental system, `VehicleRental` serves as the base class encapsulating common state and logic: rental duration, customer record, baseline insurance, and reservation confirmation.  
- `CarRental` overrides pricing to factor in passenger seat count and optional child seat additions.  
- `TruckRental` overrides pricing to incorporate cargo tonnage, trailer hitch allowances, and commercial license verification.  
Inheritance models this cleanly by sharing standard administrative behavior while delegating vehicle-specific capacity and safety calculations to polymorphic method overrides.
