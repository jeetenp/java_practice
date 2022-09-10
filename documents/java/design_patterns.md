# Design Patterns

- [What's a design pattern](#Whats-a-design-pattern)
- [Classification of patterns](#Classification-of-patterns)
- Creational patterns
  - [Factory Method](#Factory-Method)
  - Abstract Factory
  - Builder 
  - Prototype
  - Singleton

## What's a design pattern?
![](../../images/line.png)

[Back To Top](#Table-Of-Contents)

Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.

[Back To Top](#Table-Of-Contents)

## Classification of patterns
![](../../images/line.png)

[Back To Top](#Table-Of-Contents)

### Creational patterns 
Provide object creation mechanisms that increase flexibility and reuse of existing code.

* Factory Method: Also known as: Virtual Constructor
* Abstract Factory
* Builder
* Prototype
* Singleton

### Structural patterns 

Explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.

* Adapter:  Also known as: Wrapper
* Bridge
* Composite:  Also known as: Object Tree
* Decorator:   Also known as: Wrapper
* Facade
* Flyweight:   Also known as: Cache
* Proxy

### Behavioral patterns 

Take care of effective communication and the assignment of responsibilities between objects.

* Chain of Responsibility: Also known as: CoR, Chain of Command
* Command: Also known as: Action, Transaction
* Iterator: Mediator: Also known as: Intermediary, Controller
* Memento: Also known as: Snapshot
* Observer: Also known as: Event-Subscriber, Listener
* State
* Strategy
* Template Method
* Visitor


[Back To Top](#Table-Of-Contents)


## Factory Method
![](../../images/line.png)

[Back To Top](#Table-Of-Contents)

References:
* [https://refactoring.guru/design-patterns/factory-method](https://refactoring.guru/design-patterns/factory-method)

### Intent

Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

### Solution
The Factory Method pattern suggests that you replace direct object construction calls (using the new operator) with calls to a special factory method. 

Don’t worry: the objects are still created via the new operator, but it’s being called from within the factory method.

### Applicability
* Use the Factory Method when you don’t know beforehand the exact types and dependencies of the objects your code should work with.
* Use the Factory Method when you want to provide users of your library or framework with a way to extend its internal components.
* Use the Factory Method when you want to save system resources by reusing existing objects instead of rebuilding them each time.

Example 1: 

![](../../images/design_patterns/cp_factory_method_1.png)

![](../../images/design_patterns/cp_factory_method_2.png)

Example 2:

![](../../images/design_patterns/cp_factory_method_3.png)

Example 3:

![](../../images/design_patterns/cp_factory_method_4.png)

[Back To Top](#Table-Of-Contents)


## Abstract Factory
![](../../images/line.png)

[Back To Top](#Table-Of-Contents)

[Back To Top](#Table-Of-Contents)

## Topic
![](../../images/line.png)

[Back To Top](#Table-Of-Contents)

[Back To Top](#Table-Of-Contents)


[arbitrary_text]: https://www.somewebsite.org
