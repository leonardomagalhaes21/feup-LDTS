## LDTS_0603 - Dino

This game is strongly inspired on the hidden Chrome browser game when there is no internet. The objective of the game is to control Dino avoiding colliding with obstacles (cities and planes) coming from the right.
There are collectables that, if you catch them, can help you to score more points. The points are counted by the distance you travelled since the start of the game.
This project was developed by:
- **Guilherme Silveira Rego** (up202207041)
- **João Pedro Nogueira da Hora Santos** (up202205784)
- **Leonardo de Sousa Magalhães Teixeira** (up202208726)

LDTS 2023/24 <br>
Software Design and Testing Laboratory

### IMPLEMENTED FEATURES

- **Menu** - The game has a menu that can be accessed at the beginning of the game as soon as we run it, and when we lose. The menu has four options:
  - **Start** - Starts a new game.
  - **Instructions** - Displays the instructions of the game.
  - **Leaderboard** - Displays the three highest scores.
  - **Exit** - Exits the game.
- **Playable character** - Dino jumps when the arrow up  key or the space bar is pressed, crouches when the arrow down key is pressed, and uses a bomb if he has it his inventory pressing the arrow left key. If the arrow key or the space bar are pressed when Dino is crouched he will return to his "normal mode".
- **Random obstacles** - There is two possible obstacles that can be randomly generated: a plane, or a city, which is a group of buildings that are either small or large, and could appear as a group of three, two, or just one building.
- **Collectables** -The game has collectable objects that can be consumed by the player:
  - **Bomb** - If the player catches a bomb, it will be stored in his inventory (which is represented in the top right corner, with a counter of the number of bombs the player has) to use whenever he wants to explode the next obstacle. There is a maximum capacity of the inventory of 5 bombs.
  - **Shield** - Dino is able to wear a shield that protects him for a short time (that is represented ion the top left corner). If he collides with an obstacle when he's wearing the shield, the player will not lose.
  - **Boots** - The game character has a higher jump during a certain period of time (which is represented ion the top left corner).
  - **Coin** - The coin will add 100 points to the player's score.
- **Collision detector** - The game has the ability to detect when Dino collides with the obstacles to make the player lose or when Dino catches a collectable to consume it.
- **Difficulty controller** - To make the game more dynamic, the more points you have, the faster it will become, making it increasingly difficult.
- **Music and sound effects** - There is background music and many sound effects throughout the game for each player's action.
- **Game Over** - The game displays a game over screen when the player collides with an obstacle. The player will have two options:
  - **Start** - Starts a new game.
  - **Menu** - The player goes to the main menu.

### PLANNED FEATURES

- Every feature has been implemented.

![menu.gif](src%2Fmain%2Fresources%2Fmockups%2Fmenu.gif)
<br/>
![game.gif](src%2Fmain%2Fresources%2Fmockups%2Fgame.gif)
<br/>
![gameover.gif](src%2Fmain%2Fresources%2Fmockups%2Fgameover.gif)

### DESIGN

#### CODE'S STRUCTURE

**Problem in Context**

As the game's complexity grows, the code becomes increasingly intricate, making it harder to comprehend and maintain over time.
This challenge escalates as new features are added, demanding more effort to manage and update the codebase effectively.

**The Pattern**

The MVC (Model-View-Controller) architecture proves beneficial as it segregates the code into three core components: the model, the view, and the controller.
The model handles data, the view manages the visual interface, and the controller oversees the game's logic.
These distinct components operate independently yet collaboratively, synergizing their functionalities to ensure the seamless operation of the game. This segregation enables efficient development, modification, and enhancement of each component without compromising the overall functionality of the game.

**Implementation**

![mvc.jpg](src%2Fmain%2Fresources%2Fuml%2Fmvc.jpg)

These classes could be found in the following files:

- [Model](./src/main/java/ldts/dino/model/game/Game.java)
- [View](./src/main/java/ldts/dino/viewer/Viewer.java)
- [Controller](./src/main/java/ldts/dino/controller/Controller.java)

**Consequences**

Implementing MVC simplifies managing the game's complexity by dividing it into distinct parts: model, view, and controller. This division streamlines development, making it easier to update or enhance specific components without affecting the entire game's functionality.
It promotes a clearer structure and facilitates smoother collaboration between different aspects of the game, easing the management and evolution of the codebase as the game grows.


#### LANTERNA LIBRARY SIMPLIFICATION

**Problem in Context**

The GUI librabry (Lanterna) could be confusing and more extensive than we really need.
We should be able to make this framework easy to handle without affecting the rest of the code.

**The Pattern**

To solve this problem we use the **Facade** Pattern since it provides a
simplified interface to the library we are working with and assures that it can be easily changed.

**Implementation**

![facade.jpg](src%2Fmain%2Fresources%2Fuml%2Ffacade.jpg)

- Application - Client that uses our simplified interface GUI.
- GUI - Simplified interface of Lanterna library.
- LanternaGUI - Implements methods defined in GUI interface.

These classes could be found in the following files:

- [Application](./src/main/java/ldts/dino/Application.java)
- [GUI](./src/main/java/ldts/dino/gui/GUI.java)
- [LanternaGUI](./src/main/java/ldts/dino/gui/LanternaGUI.java)

**Consequences**

By using the Facade Pattern, handling the Lanterna GUI library becomes simpler and more straightforward.
It reduces confusion and makes it easier for us to work with the library without needing extensive knowledge.
It makes our system easier to maintain and adapt, allowing us to make updates without causing major issues in the overall structure.


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

Using the State Pattern simplifies managing different game states.
It enables smooth transitions between states based on user interactions and streamlines state-specific behaviors.
This approach ensures clearer code and easier future modifications or additions of new states, making the overall game development process more straightforward.


#### DIFFERENT COLLECTABLES MUST HAVE DIFFERENT EFFECTS

**Problem in Context**

Our game has various elements, these elements could be collectables.
There are four collectables (Bomb, Boots, Coin, Shield),
each one has a different effect on the game, so we need to have
a way to execute the effect of the collectable without having to check the
type.

**The Pattern**

To solve this we use the **Command** Pattern which grants
each collectable its own execute command when they are collected
and consumed by the player.

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

**Consequences**

Since each collectible possesses its unique command, applying the Command Pattern
we can seamlessly introduce new collectibles without requiring modifications in the game's existing code.
This approach enhances the flexibility and ease of maintenance in the codebase.
Additionally, this pattern offers the advantage of isolating the
consumption of code from the rest of the game.


#### RANDOMLY GENERATING DIFFERENT TYPES OF ELEMENTS

**Problem in Context**

The game needs to generate random obstacles and collectibles in different ways during gameplay.
But, this generation has to have a logic behind it, for example, two elements
should not spawn in the same position.

**The Pattern**

The **Abstract Factory Method** Pattern provides an interface for creating families of related
or dependent objects without specifying their concrete classes, that is exactly what we need to solve this problem
as we want to create different types of buildings, cities and planes, and different types of collectables.

**Implementation**

![abstractfactory.png](src%2Fmain%2Fresources%2Fuml%2Fabstractfactory.png)

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
- [City](./src/main/java/ldts/dino/model/game/elements/obstacles/City.java)
- [Plane](./src/main/java/ldts/dino/model/game/elements/obstacles/Plane.java)

**Consequences**

Using the Abstract Factory Method Pattern allows us to create different types of elements
without having to specify their concrete classes, which makes it easier to add new types of elements
in the future.

#### CREATING DIFFERENT TYPES OF BUILDINGS

**Problem in Context**

In the game there are two types of buildings, small and large, and they
can appear as a group of three, two, or just one building. We need to
create these buildings in a way that they can be randomly generated
during gameplay.

**The Pattern**

The **Factory Method** Pattern defines an interface for creating an object,
but lets subclasses decide which class to instantiate. It solves the problem
of creating objects without specifying the exact class of object that will be created.

**Implementation**

[Building](./src/main/java/ldts/dino/model/game/elements/obstacles/Building.java) class:
```java
public class Building extends Obstacle {

  private Building(Position position, int width, int height) {
    super(position, width, height);
  }

  public static final class Factory {

    private Factory() {
    }

    public static Building build(Position position, int height) {
      return new Building(position, Building.WIDTH, height);
    }

    public static Building buildLarge(Position position) {
      return build(position, LARGE_BUILDING_HEIGHT);
    }

    public static Building buildSmall(Position position) {
      return build(position, SMALL_BUILDING_HEIGHT);
    }
  }
}
```

[City](./src/main/java/ldts/dino/model/game/elements/obstacles/City.java) class:
```java
public class City extends Obstacle {
    
  public City() {
    super(new Position(LanternaGUI.WIDTH, Ground.HEIGHT), 0, 0);
    // ...
    addBuildings();
  }

  public void addBuildings() {
    int numberOfBuildings = random.nextInt(3) + 1;

    boolean isSmall = random.nextBoolean();

    for (int i = 0; i < numberOfBuildings; i++) {

      Building newBuilding;
      if (isSmall) {
        Position nextPosition = new Position(lastPosition.getX(), Ground.HEIGHT - Building.SMALL_BUILDING_HEIGHT);
        newBuilding = Building.Factory.buildSmall(nextPosition);
      } else {
        Position nextPosition = new Position(lastPosition.getX(), Ground.HEIGHT - Building.LARGE_BUILDING_HEIGHT);
        newBuilding = Building.Factory.buildLarge(nextPosition);
      }
      // ...
    }
  }
}
```

**Consequences**

Using the Factory Method Pattern allows us to create different types of buildings
without having to specify their concrete classes, which makes it easier to add new types of buildings
in the future. This approach enhances the flexibility and ease of maintenance in the codebase.


#### MANAGING SOUNDS

**Problem in Context**

The music and sound effects are a resource shared among the
controllers that use them on their own way, so we need to
manage them by a single class, so that we can access them
from anywhere in the code.

**The Pattern**

To solve this we use the **Singleton** Pattern,
that ensures that only one instance of the class is created
responsible for playing the music and sound effects.
This object is accessible from everywhere, so that there is
a single point to access the music and sound effects.

**Implementation**

![singleton.jpg](src%2Fmain%2Fresources%2Fuml%2Fsingleton.jpg)

These classes could be found in the following files:

- [SoundManager](./src/main/java/ldts/dino/utils/SoundManager.java)
- [DinoController](./src/main/java/ldts/dino/controller/game/elements/DinoController.java)
- [CollisionController](./src/main/java/ldts/dino/controller/game/CollisionController.java)
- [GameController](./src/main/java/ldts/dino/controller/game/GameController.java)
- [MenuController](./src/main/java/ldts/dino/controller/menu/MenuController.java)
- [Application](./src/main/java/ldts/dino/Application.java)

**Consequences**

Now the code is isolated from the music and sound effects,
we can access them from anywhere in the code, and, because
there is only a single object of the class, there is no
problems of two overlapping sound effects, for example.
Changing or adding more music and sound effects turns out to
be an easy task with the singleton pattern implemented.

#### MANAGING DINO'S FORMS

**Problem in Context**

Dino has two forms, the normal form and the crouched form.
The game should be able to change Dino's form depending on the
user interaction with the game.

**The Pattern**

The **Strategy** Pattern solves this problem by defining two algorithms,
Normal Dino and Crouched Dino, that can be used interchangeably.
The client can choose which algorithm to use at runtime.

**Implementation**

![strategy.jpg](src%2Fmain%2Fresources%2Fuml%2Fstrategy.jpg)

These classes could be found in the following files:

- [Dino](./src/main/java/ldts/dino/model/game/elements/dino/Dino.java)
- [NormalDino](./src/main/java/ldts/dino/model/game/elements/dino/NormalDino.java)
- [CrouchDino](./src/main/java/ldts/dino/model/game/elements/dino/CrouchDino.java)

**Consequences**

Using the Strategy Pattern simplifies managing Dino's forms,
it enables smooth transitions between forms based on user interactions.
This approach ensures clearer code and easier future modifications or additions of new forms,
making the overall game development process more straightforward.

------

### CODE SMELLS

We consider that the code is well-structured and easy to understand in
general, using the design patterns and refactoring techniques we learned
in the course to make it cleaner and more readable. Still, we could
point out some possible code smells in the code, like long classes and
methods, for example, in the Game class. 

------

### TESTING

![coverage1.png](src%2Fmain%2Fresources%2Ftests%2Fcoverage1.png)
![coverage2.png](src%2Fmain%2Fresources%2Ftests%2Fcoverage2.png)

### SELF-EVALUATION

- Guilherme Rego: 33.3%
- João Santos: 33.3%
- Leonardo Magalhães: 33.3%

### UML DIAGRAM

![uml.jpg](src%2Fmain%2Fresources%2Fuml%2Fuml.jpg)
