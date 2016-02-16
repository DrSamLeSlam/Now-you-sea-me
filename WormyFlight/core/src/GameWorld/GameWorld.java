package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import GameObjects.Ground;
import GameObjects.Diver;

public class GameWorld {
    private Diver diver;
    private Ground ground;
    public GameWorld(){
        diver = new Diver(100,100,20,20);
        ground = new Ground(0,400,408, 20);
    }
    public void update(float delta) {
        diver.update(delta);
        ground.update(delta);
    }
    public Diver getDiver(){
        return diver;
    }
    public Ground getGround(){
    	return ground;
    }
}
