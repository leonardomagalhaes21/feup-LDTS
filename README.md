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

#### DIFFERENT TYPES OF COLLECTABLES SHOULD FOLLOW A BEHAVIOR PATTERN

**Problem in Context**

The game involves various collectables (Bomb, Shield, Boots and Coin) with different behaviors. It needs a way to encapsulate these behaviors independently and allow for dynamic selection during runtime.

**The Pattern**

The **Strategy** Pattern is selected to encapsulate each collectable behavior into separate classes, enabling them to be interchanged at runtime.

**Implementation**

![img_1.png](img_1.png)

- Context (Collectable) interfaces with the Strategy interface (CollectableBehavior).
- Each collectable behavior (GunBehavior, ShieldBehavior, etc.) implements the Strategy interface.
- Collectable classes (Gun, Shield, etc.) hold a reference to the specific behavior interface, allowing dynamic behavior changes.

These classes could be found in the following files:

- (...)

**Consequences**

This pattern allows for easy addition of new collectables without modifying existing code. It enhances code reusability by keeping behaviors separate. Alternative approaches like a switch-case statement would lead to code duplication and reduced flexibility.

# Faltam aqui as restantes patterns

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