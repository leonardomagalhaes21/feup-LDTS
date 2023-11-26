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

![facade.jpg](src%2Fmain%2Fresources%2Fuml%2Ffacade.jpg)

- Application - Client that uses our simplified interface GUI.
- GUI - Simplified interface of Lanterna library.
- LanternaGUI - Implements methods defined in GUI interface.

These classes could be found in the following files:

- [Application](./src/main/java/ldts/dino/Application.java)
- [GUI](./src/main/java/ldts/dino/gui/GUI.java)
- [LanternaGUI](./src/main/java/ldts/dino/gui/LanternaGUI.java)


#### MANAGING GAME STATE TRANSITIONS

**Problem in Context**

The game contains different states (main menu, gameplay, game over) with specific behaviors and transitions between them.
The program should be able to easily change the state depending on the user
interaction with the game.

**The Pattern**

The **State** Pattern allows an object to alter its behavior when its internal state changes.
It'll help manage different game states and simplify state-specific behavior.

**Implementation**

![state.jpg](src%2Fmain%2Fresources%2Fuml%2Fstate.jpg)

- Application - The application will have a private state attribute. 
- State - It's the interface for the concrete states.
- GameState, MainMenuState, InstructionsState, ScoresState and GameOverState -
Concrete states.

These classes could be found in the following files:

- [Application](./src/main/java/ldts/dino/Application.java)
- [State](./src/main/java/ldts/dino/state/State.java)
- [GameState](./src/main/java/ldts/dino/state/GameState.java)
- [MainMenuState](./src/main/java/ldts/dino/state/MainMenuState.java)
- [InstructionsState](./src/main/java/ldts/dino/state/InstructionsState.java)
- [ScoresState](./src/main/java/ldts/dino/state/ScoresState.java)
- [GameOverState](./src/main/java/ldts/dino/state/GameOverState.java)

**Consequences**

This pattern will help making easier the addition of new states to the game
without having to change the whole code.

#### DIFFERENT COLLECTABLES MUST HAVE DIFFERENT EFFECTS

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

![command.jpg](src%2Fmain%2Fresources%2Fuml%2Fcommand.jpg)

- Game - Invoker.
- Collectable - Command.
- Bomb, Boots, Coin, Shield - Concrete commands.

These classes could be found in the following files:

- [Game](./src/main/java/ldts/dino/model/game/Game.java)
- [Collectable](./src/main/java/ldts/dino/model/game/elements/collectables/Collectable.java)
- [Bomb](./src/main/java/ldts/dino/model/game/elements/collectables/Bomb.java)
- [Boots](./src/main/java/ldts/dino/model/game/elements/collectables/Boots.java)
- [Coin](./src/main/java/ldts/dino/model/game/elements/collectables/Coin.java)
- [Shield](./src/main/java/ldts/dino/model/game/elements/collectables/Shield.java)

#### RANDOMLY GENERATING ELEMENTS

**Problem in Context**

The game needs to generate random obstacles and collectibles in different ways during gameplay.
But, this generation has to have a logic behind it, for example, two elements
should not spawn in the same position.

**The Pattern**

The **Factory Method** Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate.
It promotes the creation of objects through a common interface

**Implementation**

![factorymethod.jpg](src%2Fmain%2Fresources%2Fuml%2Ffactorymethod.jpg)

- Creator - Abstract factory defining methods for creating different game elements.
- ObstacleCreator, CollectableCreator - Concrete creators extending methods to create specific elements
- Collectable, Obstacle - Elements.
- Bomb, Boots, Coin, Shield, Building, City, Plane - Concrete elements
made by the concrete creators.
- ElementsFactory - Controls the concrete creators.

These classes could be found in the following files:

- [Creator](./src/main/java/ldts/dino/model/game/creators/Creator.java)
- [CollectableCreator](./src/main/java/ldts/dino/model/game/creators/CollectableCreator.java)
- [ObstacleCreator](./src/main/java/ldts/dino/model/game/creators/ObstacleCreator.java)
- [Collectable](./src/main/java/ldts/dino/model/game/elements/collectables/Collectable.java)
- [Obstacle](./src/main/java/ldts/dino/model/game/elements/obstacles/Obstacle.java)
- [Bomb](./src/main/java/ldts/dino/model/game/elements/collectables/Bomb.java)
- [Boots](./src/main/java/ldts/dino/model/game/elements/collectables/Boots.java)
- [Coin](./src/main/java/ldts/dino/model/game/elements/collectables/Coin.java)
- [Shield](./src/main/java/ldts/dino/model/game/elements/collectables/Shield.java)
- [Building](./src/main/java/ldts/dino/model/game/elements/obstacles/Building.java)
- [City](./src/main/java/ldts/dino/model/game/elements/obstacles/City.java)
- [Plane](./src/main/java/ldts/dino/model/game/elements/obstacles/Plane.java)

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
