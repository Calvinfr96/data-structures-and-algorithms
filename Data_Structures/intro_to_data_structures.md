# Introduction To Data Structures

## Purpose
- Data structures are collections of values, the relationships among them, and the functions or operations that can be applied to the data.
- Different data structures excel at different things. Some are highly specialized while others, like arrays, are more genetically used.
- The more time you spend as a developer, the more likely it is you’ll need to use one the more specialized data structures to solve a problem. Also, there are certain specialized data structures you regularly interact with as a programmer.
    - The DOM is a tree data structure.
    - Certain APIs may return data in the form of a graph.
    - Knowing how these specialized data structures work will help you interact with them, and problem solve more efficiently.
- Data structures also come up a lot during interviews.
- There is no one best data structures, the all excel in different environments. For example, a linked list can be used as an alternative to an array when you need to quickly insert and remove data from the beginning or middle.
## JS Class Syntax Review
- A class is a blueprint for creating objects with predefined properties and methods which can be called on said object.
- JavaScript classes are primarily syntactical sugar over JavaScript’s existing prototype-based inheritance. This class syntax does not introduce a new object-oriented inheritance model to JavaScript.
- Data Structures are typically implemented using classes, so it’s good to be familiar with the JS class syntax.
- Classes in JS and other OOP languages typically start with a capital letter.
- In other OOP languages like Ruby, the constructor is a method with the same name as the class. In JS however, the constructor method must be named ‘constructor’.
- The constructor is an instance method, that means the ‘this’ keyword refers to an instance of the class. In class methods, ‘this’ refers to the class itself.
- Instances of classes are created (instantiated) with the ‘new’ keyword.
- When you define a class in JS (ES2015), you don’t need to explicitly define a getter and setter methods, they are automatically included.
## Instance and Class Methods
- Instance methods provide functionality that pertains to a single instance of a class. The push method is an example of an instance method that is called on an instance of an array. Inside of instance methods, ‘this’ refers to the individual instance.
- Unlike functions defined outside of a class, which can be called independently, instance methods must be called on an instance of the class in which they are defined. They cannot be called on any other type of class. For example, you can’t call the push method by itself, and you can’t call it on an object, it must be called on an array.
- Class methods in JS are defined using the static keyword. The static keyword defines a static method for the class. Static methods are called without instantiating the class and cannot be called through a class instance.
    - Static methods are often used to create utility functions for an application.
    - An example of a static method taken from Ruby would be a ‘getStudents’ method that returned all instances of a class created. This would need to be accompanied by a ‘save’ instance method that pushed an instance into an ‘all’ instance property that is an array which held the instances.
    - Inside of instance methods, ‘this’ refers to the class.
- When using classes to define data structures, you mostly use the constructor and instance methods. Class methods are rarely used.
