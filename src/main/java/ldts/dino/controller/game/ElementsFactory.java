package ldts.dino.controller.game;


import ldts.dino.model.game.Game;
import ldts.dino.model.game.creators.ObstacleCreator;

public class ElementsFactory {
  private final Game game;
    private ObstacleCreator obstacleCreator;

  public ElementsFactory(Game game) {
    this.game = game;
    this.obstacleCreator = new ObstacleCreator();
  }

  public void generateObstacle() {
    game.addBuilding(obstacleCreator.createBuilding());
  }

  public void step() {
//      if (game.getSteps() == 0)
      // TODO: IMPLEMENT STEPS !!
      // steps++ if(steps = 20) steps = 0;
          generateObstacle();
      //incrementSteps();
  }
}