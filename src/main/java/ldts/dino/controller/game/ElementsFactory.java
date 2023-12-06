package ldts.dino.controller.game;


import ldts.dino.model.game.Game;
import ldts.dino.model.game.creators.ObstacleCreator;

public class ElementsFactory {
  private final Game game;
    private final ObstacleCreator obstacleCreator;

  public ElementsFactory(Game game) {
    this.game = game;
    this.obstacleCreator = new ObstacleCreator();
  }

  public void generateObstacle() {
    game.addObstacle(obstacleCreator.create());
  }

  public void step() {
    if(game.getClock() % 50 == 0) {
      generateObstacle();
    }
    game.incrementClock();
  }
}