# Introduction to Methods

So far, we have been writing code as one long sequence inside the `run()` method. As programs grow, this becomes:
- harder to read,
- harder to debug,
- and harder to extend.

To keep our programs organized, we use **methods**.

A **method** is a **small, named block of code** that does one job.  Once defined, we can **call** the method whenever we need that job done.

### Why Use Methods?

| Benefit | Meaning |
|--------|---------|
| **Avoid repetition** | Write code once, reuse it many times |
| **Clearer organization** | Break a large problem into smaller steps |
| **Easier debugging** | Fix code in one place instead of several |
| **More maintainable** | Changes happen in one location |
| **Modular thinking** | Each method does *one thing well* |

This idea — breaking work into small, meaningful units — is central to all good programming.

<br>

### Example: Using Methods to Reduce Repetition

Suppose we want to draw a simple box using text output:

```
+----------+
|          |
|          |
+----------+
```

#### Without Methods

```java
public void run() {
    System.out.println("+----------+");
    System.out.println("|          |");
    System.out.println("|          |");
    System.out.println("+----------+");
}
```

If we later decide the box should be wider, we must manually update multiple lines. This is **repetitive** and **hard to change**.

#### With Methods
We can define two methods:
```java
private void border() {
    System.out.println("+----------+");
}

private void middle() {
    System.out.println("|          |");
}
```

So now our main program looks like:
```java
public void run() {
    border();
    middle();
    middle();
    border();
}
```

This is a better solution because:

- Changing the width requires only two updates (i.e., one update in the `border()` method, and one update in the `middle()` method)
- `run()` now reflects the structure of the box
- Code becomes easier to understand

#### With Methods (Even Better)

```java
public void run() {
    int height = 10;
    border();
    for (int i = 0; i < height; i++) {
        middle();
    }
    border();
}
```

Now the `height` of the box can be changed by adjusting just one number.


#### Summary of Improvements

| Without Methods | With Methods |
|----------------|--------------|
| Hard to update | Change one method instead of many lines |
| Repeated code everywhere | Repetition is removed |
| Code doesn’t show intent | Code visually matches the shape being drawn |
| Mistakes are easy to introduce | Easier to debug and maintain |


Using methods makes your code:

- Cleaner
- More readable
- Easier to fix and modify
- Better organized

This is the main purpose of methods.

<br>

## Method Structure
One of the methods we defined above looked like this in code:

```java
private void border() {
    System.out.println("+----------+");
}
```

Let's look at the first line of this in more detail:

```
visibility  return  name     { body }
  ↓           ↓       ↓        ↓
private     void    border() { ...  }
```

- `private` — visibility (we will use `private` in this class)
- `void` — this method does not return a value (more on this later)
- `border()` — method name (follows variable naming rules)
- `{ body }` — the statements that run when called

<br>

## Calling a Method (Control Flow)

When you call a method, execution:
1. **pauses** in the calling method
2. **jumps** to the new method
3. runs the method's **body**
4. **returns** to the original location and continues

For example, given the code:

```java
public void run() {
    border();
    middle();
    middle();
    border();
}
```
The execution order goes something like:

```
run() → border() → return and continue run()
      → middle() → return and continue run()
      → middle() → return and continue run()
      → border() → return and continue run()
```

This “jump out and return” idea applies to every method you will write.

<br>

# Practice Problems
Here are several practice problems requiring the use of methods. Your job is to take code that currently has repetition or messy structure and rewrite it using methods.

You can find the starter code in the `src/` folder of this repository.

## Program1.java — Basic Method Call
```java
public class Program1 extends ConsoleProgram {
    public void run() {
        // TODO: Create a method greet() that prints "Hello!"
        // Call it 3 times.
    }
    
    // define greet() below
}
```

## Program2.java — Replace Repetition
```java
public class Program2 extends ConsoleProgram {
    public void run() {
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");
        System.out.println("Good morning!");

        // TODO: replace repetition with morning() method
    }
}
```

## Program3.java — Extract the Chorus
```java
public class Program3 extends ConsoleProgram {
    public void run() {
        // Output:
        // na na na na na
        // na na na na na
        // hey Jude
        // na na na na na

        // TODO: create chorus() for repeated lines
    }
}
```

## Program4.java — Divider Line
```java
public class Program4 extends ConsoleProgram {
    public void run() {
        System.out.println("Menu");
        System.out.println("-------------------");
        System.out.println("1) Play");
        System.out.println("2) Quit");
        System.out.println("-------------------");

        // TODO: replace repeated dashes with line()
    }
}
```

## Program5.java — Baby Shark
```java
public class Program5 extends ConsoleProgram {
    public void run() {
        // Output:
        // Baby shark, doo doo doo doo doo doo
        // Baby shark, doo doo doo doo doo doo
        // Baby shark, doo doo doo doo doo doo
        // Baby shark!

        // Mommy shark, doo doo doo doo doo doo
        // Mommy shark, doo doo doo doo doo doo
        // Mommy shark, doo doo doo doo doo doo
        // Mommy shark!

        // Daddy shark, doo doo doo doo doo doo
        // Daddy shark, doo doo doo doo doo doo
        // Daddy shark, doo doo doo doo doo doo
        // Daddy shark!
        //
        // TODO: create methods to print the lyrics
        //       of the song, reusing code
        //       wherever possible
    }
}
```

## Program6.java — ASCII Tower Builder
```java
public class Program6 extends ConsoleProgram {
    public void run() {
        // Ask the user for a tower height and draw
        // a tower based on their input. For example:
        //
        // Height? 4
        // +----------+
        // |          |
        // |          |
        // +----------+

        // TODO: make methods for the top/bottom and sides
        //       get user input
        //       use a loop to draw tower
    }
}
```

## Program7.java — Modular Ladder (Methods Calling Methods)
```java
public class Program7 extends ConsoleProgram {
    public void run() {
        // We want to draw a ladder with several repeating levels:
        //
        // |    |
        // +----+
        // |    |
        // +----+
        // |    |
        // +----+
        //
        // Ask the user how many levels high the ladder is. The above example is 3 levels high.

        int levels = readInt("How many levels? ");

        // call your methods here

    }

    // fill in the methods below

    private void side() {
        // draw the sides without rungs
    }

    private void rung() {
        // draw the horizontal rung or step
    }

    private void level() {
        // one level is made up of a side plus a rung
    }
}
```

## Program8.java — Flag Builder

```java
public class Program8 extends ConsoleProgram {
    public void run() {
        // We want to draw variations of a simple three-stripe flag:
        //
        // ********************
        // ********************
        // --------------------
        // --------------------
        // ####################
        // ####################
        //
        // Ask the user for the desired overall height. 
        // Calculate and draw the appropriate number of 
        // stripes so that there is always an equal
        // number of topStripe() middleStripe() and bottomStripe()
        // 
        // Hint: After getting user input, if the height is not a multiple of 3, increase it so each stripe is the same height.

        int height = readInt("Enter height of flag: ");

        // do additional stuff
        
    }

    // define your stripes below

    private void topStripe() {
        // do stuff
    }

    private void middleStripe() {
        // do stuff
    }

    private void bottomStripe() {
        // do stuff
    }
}
```



## Program9.java — Simple Menu Loop
```java
public class Program9 extends ConsoleProgram {
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            handleChoice();
        }

        // TODO:
        // Create methods:
        // printMenu()
        // handleChoice()
        //
        // Repeatedly show a menu until the user enters "q" to quit.
        //
        // Example:
        // a) Display Breakfast Menu
        // b) Display Lunch Menu
        // c) Display Dinner Menu
        // q) Quit
        //
        // No parameters yet — all decisions happen inside handleChoice().
    }
}
```


## Program10.java — Challenge: Conditional Story Paths
```java
public class Program10 extends ConsoleProgram {
    public void run() {
        intro();
        choice();

        // TODO:
        // Create methods: intro(), choice(), endingHappy(), endingSad()
        // Ask the user: "Choose path A or B"
        // If A → call endingHappy()
        // If B → call endingSad()
        // Story must still be broken into meaningful stages.
        
        
        // branching happens *inside* choice() using if/else
        // in other words, choice() calls endingHappy() or
        // endingSad()
    }
}
```

