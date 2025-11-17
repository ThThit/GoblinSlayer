# ⚔️ GoblinSlayer: A Java OOP Project

A simple, turn-based console RPG game where you (the Player) fight a Goblin.

This project was built as a group project to demonstrate the Object-Oriented Programming (OOP) principle of **Abstraction**.

## 🎓 Group Project: Explaining Abstraction

The main goal of this project is to provide a clear, working example of abstraction.

### What is Abstraction?

In OOP, **abstraction** is the concept of hiding complex implementation details and only showing the essential features (the "what") of an object, rather than the "how."

It helps us manage complexity. Think of a TV remote: you just press the "Volume Up" button. You don't need to know about the circuits, a-plifiers, or signals. The button is the **abstraction**; the complex circuits are the **implementation**.

In Java, we achieve abstraction using **Abstract Classes** and **Interfaces**.

---

### How Abstraction is Used in This Project

We use abstraction in two key places: `RPGCharacter` and `StatusEffect`.

#### 1. The `RPGCharacter` Abstract Class

* **Abstract Idea:** We know our game needs "characters." We also know all characters must have `health` and be able to `attack()` or `takeDamage()`. However, a "Player" and a "Goblin" attack in different ways.
* **Our Solution:** We created an **abstract class** called `RPGCharacter.java`.

    ```java
    // Inside RPGCharacter.java (Simplified)
    public abstract class RPGCharacter {
        int health;
        String name;

        // An abstract method has no body.
        // We are saying "Every character MUST be able to attack,
        // but we don't know how yet."
        public abstract void attack(RPGCharacter target);

        // A concrete method can also exist in an abstract class
        public void takeDamage(int amount) {
            this.health -= amount;
        }
    }
    ```

* **Concrete Classes:** The `Player.java` and `Goblin.java` classes **extend** `RPGCharacter`. They are forced by the compiler to provide the *how* (the implementation) for the `attack()` method.

    ```java
    // Inside Player.java
    public class Player extends RPGCharacter {
        // We MUST provide this method
        @Override
        public void attack(RPGCharacter target) {
            // Player's specific attack logic...
            System.out.println("You swing your sword!");
        }
    }

    // Inside Goblin.java
    public class Goblin extends RPGCharacter {
        // We MUST provide this method
        @Override
        public void attack(RPGCharacter target) {
            // Goblin's specific attack logic...
            System.out.println("The goblin bites you!");
        }
    }
    ```
* **Why this is good:** Our main game loop doesn't care if it's a `Player` or a `Goblin`. It can treat them both simply as an `RPGCharacter` and call `.attack()`.

#### 2. The `StatusEffect` Interface

* **Abstract Idea:** We wanted different "effects" in our game, like poison, bleeding, or being stunned. Each one is applied differently.
* **Our Solution:** We created an **interface** called `StatusEffect.java`. An interface is 100% abstract. It's a "contract" that guarantees a class can perform a certain action.

    ```java
    // Inside StatusEffect.java
    public interface StatusEffect {
        // Any class that implements this MUST provide an applyEffect method.
        void applyEffect(RPGCharacter target);
    }
    ```

* **Concrete Classes:** We then created concrete classes that **implement** this interface.

    * `BleedEffect.java`
    * `PoisonEffect.java`
    * `StunEffect.java`

    Each of these files contains different logic inside its `applyEffect()` method (e.g., Poison reduces health over time, Stun skips a turn).

* **Why this is good:** This makes our code flexible. We can easily add a new `FireEffect` or `FreezeEffect` just by creating a new class that implements the `StatusEffect` interface, without ever changing the `Player` or `Goblin` code.

## 🚀 How to Run

1.  Clone the repository:
    ```sh
    git clone [https://github.com/ThThit/GoblinSlayer.git](https://github.com/ThThit/GoblinSlayer.git)
    ```
2.  Navigate to the project directory:
    ```sh
    cd GoblinSlayer
    ```
3.  Compile all the `.java` files:
    ```sh
    javac *.java
    ```
4.  Run the main game file:
    *(Note: You will need to replace `MainGame` with the name of the file that contains your `public static void main(String[] args)` method.)*
    ```sh
    java MainGame
    ```

## 👥 Contributors

* [ThThit](https://github.com/ThThit) (Thu Htin Thit)
* [kywzallthwin](https://github.com/kywzallthwin) (Kyaw Zall Thwin)
