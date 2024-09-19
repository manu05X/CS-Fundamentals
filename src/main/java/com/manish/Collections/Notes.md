
| **Aspect**                    | **Collection**                                           | **Collections**                                          |
|-------------------------------|---------------------------------------------------------|---------------------------------------------------------|
| **Type**                      | Interface                                               | Utility class                                           |
| **Purpose**                   | Represents a group of objects (elements)               | Provides static methods for operations on collections   |
| **Hierarchy**                 | Root of the Java Collections Framework                  | Part of the Java Collections Framework                  |
| **Methods**                   | Contains instance methods like `add()`, `remove()`, `size()`, etc. | Contains only static methods like `sort()`, `min()`, `max()`, etc. |
| **Implementation**            | Can be implemented by custom classes                    | Cannot be instantiated; all methods are static          |
| **Generics Support**          | Supports generics for type-safe operations              | Does not directly support generics; operates on Collection types |
| **Examples of Subinterfaces** | List, Set, Queue                                        | N/A (Utility class does not have subinterfaces)         |
| **Usage Context**             | Used to define data structures                           | Used to perform common operations on collections        |