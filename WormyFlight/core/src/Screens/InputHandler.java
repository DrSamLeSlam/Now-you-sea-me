package Screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import GameObjects.Diver;
import GameWorld.GameWorld;
import Helpers.AssetLoader;

public class InputHandler implements InputProcessor {
    private Diver myDiver;
    private GameWorld myWorld;
    public InputHandler(Diver worm, GameWorld world){
        myDiver = worm;
        myWorld = world;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	myWorld.hide();
    	
    	return true;
    }
    @Override
    public boolean keyDown(int keycode) {
    	if (keycode == Input.Keys.M){
    		GameWorld.volumeState*=-1;
    	}
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
    	myDiver.Move(screenX,screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
