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

### DESIGN

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

- (...)

**Consequences**

This pattern will help making easier the addition of new states to the game
without having to change the whole code.

#### RANDOMLY GENERATING ELEMENTS

**Problem in Context**

The game needs to generate random obstacles and collectibles in different ways during gameplay.
But, this generation has to have a logic behind it, for example, two elements
should not spawn in the same position.

**The Pattern**

The **Factory Method** defines an interface for creating an object, but lets subclasses decide which class to instantiate.
It promotes the creation of objects through a common interface

**Implementation**

(METER UML AQUI: como fazer o UML sem métodos?)

- ElementsFactory - Abstract factory defining methods for creating different game elements.
- ObstacleCreator, CollectableCreator - Concrete creators implementing methods to create specific elements
- Collectable, Obstacle - Products.
- Bomb, Boots, Coin, Shield, Building, City, Plane - Concrete products
made by the concrete creators.

**Consequences**

This pattern (with the right logic) will centralize the creation
of elements in ElementsFactory class, making all the logic of the creation isolated from the rest of the code.

------

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%

### UML DIAGRAM
https://www.planttext.com/
![TLFBRi8m43pZht1lhQhyG8GGKaiX4fH3qkUbCiwMMd8SP3jGXFhlzIClf-abySpQixFUzLnf8dLLS7Iblw00J8dSbIBQIt96Y7AY55uImr_G95eJeK4AidnAyBvYXaarqO2L_Q8VX9YDVn8As6wvMCfBz4-oui1D9g5LlSl8K0aWi78_Wr-I-smLOoDdm6gHB5TPWnwsZzb7chmlF64oa9tIab2DVIfdQPhDd726Yp87RbPtfT2ov1oaZT4.svg](..%2F..%2F..%2FDownloads%2FTLFBRi8m43pZht1lhQhyG8GGKaiX4fH3qkUbCiwMMd8SP3jGXFhlzIClf-abySpQixFUzLnf8dLLS7Iblw00J8dSbIBQIt96Y7AY55uImr_G95eJeK4AidnAyBvYXaarqO2L_Q8VX9YDVn8As6wvMCfBz4-oui1D9g5LlSl8K0aWi78_Wr-I-smLOoDdm6gHB5TPWnwsZzb7chmlF64oa9tIab2DVIfdQPhDd726Yp87RbPtfT2ov1oaZT4.svg)
<details>

```
@startuml
!theme carbon-gray

class Game {
	-LanternaGUI gui
	-State state
}

interface GUI {
}

class LanternaGUI implements GUI {
	-Screen screen
	-WIDTH: int
	-HEIGHT: int
	-FONT_SIZE: int
}

abstract class State<T> {
	-T model
	-Controller<T> controller
	-Viewer<T> viewer
}

class MainMenuState extends State {
}

abstract class Controller<T> {
	-T model
	+step()
}

interface MenuInterface {
}

abstract class MenuController extends Controller implements MenuInterface {
	+@Override step()
}

class MainMenuController extends MenuController {
	+entrySelected()
}

abstract class Menu {
	-entries: List<String>
	-currentEntry: String
	+isSelected(): boolean
}

class MainMenu extends Menu {
	+isSelectedStart()
}

abstract class Viewer<T> {
	-T model
	+draw()
}

abstract class MenuViewer extends Viewer {
	-entriesX: int
	-entriesY: int
}

class MainMenuViewer extends MenuViewer {
}

Game --> State
Game --> LanternaGUI
State --> Controller
State --> Viewer
MainMenuState --> MainMenu

@enduml
```

</details>