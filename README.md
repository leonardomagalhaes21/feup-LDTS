## LDTS_0603 - Dino

This game is strongly inspired on the hidden Chrome browser game when there is no internet. The objective of the game is to control Dino avoiding colliding with obstacles (buildings,  cities and planes) coming from the right.
There are collectables that, if you catch them, can help you to score more points. The points are counted by the distance you travelled since the start of the game.
This project was developed by:
- **Guilherme Silveira Rego** (up202207041)
- **João Pedro Nogueira da Hora Santos** (up202205784)
- **Leonardo de Sousa Magalhães Teixeira** (up202208726)

LDTS 2023/24 <br>
Software Design and Testing Laboratory

### IMPLEMENTED FEATURES

- **Menu** - Part of the menu is already implemented.

### PLANNED FEATURES

- **Jumping** - Dino will jump when the arrow up  key is pressed.
- **Squatting** - The game character will squat when the arrow down key is pressed.
- **Menu** - The game has a menu that can be accessed at the beginning of the game as soon as we run it, and when we lose. The menu has four options:
    - **Start** - Starts a new game.
    - **Instructions** - Displays the instructions of the game.
    - **Leaderboard** - Displays the highest scores.
    - **Exit** - Exits the game.
- **Random obstacles** - We want to generate buildings, cities and planes at random (but logical) positions.
- **Collectables** -The game will have collectable objects that can be collected by the player:
  - **Bomb** - If the player catches a bomb, it will be stored in his inventory to use whenever he wants. The bomb explodes the nearest obstacle.
  - **Shield** - Dino will be able to wear a shield that protects him for a short time. If he collides with an obstacle when he's wearing the shield, the player will not lose.
  - **Boots** - The game character will have a higher jump during a certain period of time.
  - **Coin** - The coin will increase the player score.
- **Collision detector** - It is important to make the game detect when Dino collides with the obstacles so that we can know when the player lost or caught a collectable.
- **Music and sound effects** - Our idea is to implement background music and sound effects for the game.
- **Game Over** - The game needs to display a game over screen when the player collides with an obstacles. The player will have two options:
  - **Start** - Starts a new game.
  - **Menu** - The player goes to the Menu.
  - **Coin Multiplier** - (OPTIONAL) It's an idea for a future feature that implements the Strategy
Pattern to create a coin multiplicator depending on how far the player in his run.

### DESIGN

#### LANTERNA LIBRARY SIMPLICATION

**Problem in Context**

In order to make the game development easier and more scalable you should
be able to easily change the UI library without changing the rest of the code.

**The Pattern**

To solve this problem we use the **Facade** Pattern since it provides a
simplified interface to a library, a framework, or any other complex set of classes.

**Implementation**

(meter UML aqui)

- Client - Application ligado ao GUI e o GUI ligado ao Facade
- Facade - LanternaGUI ligado à nuvem
- Mete classes dos métodos na nuvem

#### MANAGING GAME STATE TRANSITIONS

**Problem in Context**

The game contains different states (main menu, gameplay, game over) with specific behaviors and transitions between them.
The program should be able to easily change the state depending on the user
interaction with the game.

**The Pattern**

The **State** Pattern allows an object to alter its behavior when its internal state changes.
It'll help manage different game states and simplify state-specific behavior.

**Implementation**

![state.jpg](..%2F..%2FAppData%2FLocal%2FTemp%2Fstate.jpg)

- Application - The application will have a private state attribute. 
- State - It's the interface for the concrete states.
- MainMenuState, InstructionsState, ScoresState and GameOverState -
Concrete states.

These classes could be found in the following files:

- [Application](./src/main/java/ldts/dino/Application.java)
- (fazer o mesmo para os outros)

**Consequences**

This pattern will help making easier the addition of new states to the game
without having to change the whole code.

#### Different collectables must have different effects

**Problem in Context**

Our game has various elements, these elements could be collectables.
There are four collectables (Bomb, Boots, Coin, Shield),
each one has a different effect on the game, so we need to have
a way to execute the effect of the collectable without having to check the
type.

**The Pattern**

To solve this we use the **Command** Pattern which grants 
each collectable its own execute command when they are collected by
the player.

**Implementation**

(fazer uml)

- Invoker - Game
- Command - Collectable
- Concrete command - todos os collectables
- Receiver - classes afetadas por cada colectable (ignorar no uml)

#### RANDOMLY GENERATING ELEMENTS

**Problem in Context**

The game needs to generate random obstacles and collectibles in different ways during gameplay.
But, this generation has to have a logic behind it, for example, two elements
should not spawn in the same position.

**The Pattern**

The **Factory Method** Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate.
It promotes the creation of objects through a common interface

**Implementation**

(METER UML AQUI: como fazer o UML sem métodos?)

- Creator - Abstract factory defining methods for creating different game elements.
- ObstacleCreator, CollectableCreator - Concrete creators implementing methods to create specific elements
- Collectable, Obstacle - Elements.
- Bomb, Boots, Coin, Shield, Building, City, Plane - Concrete elements
made by the concrete creators.
- ElementsFactory - Controls the concrete creators.

**Consequences**

This pattern (with the right logic) will centralize the creation
of elements in ElementsFactory class, making all the logic of the creation isolated from the rest of the code.

------

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

- Guilherme Rego: 33.3%
- João Santos: 33.3%
- Leonardo Magalhães: 33.3%

### UML DIAGRAM
https://www.planttext.com/
![TLFBRi8m43pZht1lhQhyG8GGKaiX4fH3qkUbCiwMMd8SP3jGXFhlzIClf-abySpQixFUzLnf8dLLS7Iblw00J8dSbIBQIt96Y7AY55uImr_G95eJeK4AidnAyBvYXaarqO2L_Q8VX9YDVn8As6wvMCfBz4-oui1D9g5LlSl8K0aWi78_Wr-I-smLOoDdm6gHB5TPWnwsZzb7chmlF64oa9tIab2DVIfdQPhDd726Yp87RbPtfT2ov1oaZT4.svg](..%2F..%2F..%2FDownloads%2FTLFBRi8m43pZht1lhQhyG8GGKaiX4fH3qkUbCiwMMd8SP3jGXFhlzIClf-abySpQixFUzLnf8dLLS7Iblw00J8dSbIBQIt96Y7AY55uImr_G95eJeK4AidnAyBvYXaarqO2L_Q8VX9YDVn8As6wvMCfBz4-oui1D9g5LlSl8K0aWi78_Wr-I-smLOoDdm6gHB5TPWnwsZzb7chmlF64oa9tIab2DVIfdQPhDd726Yp87RbPtfT2ov1oaZT4.svg)
