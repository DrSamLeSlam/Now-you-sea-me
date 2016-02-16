package Screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import GameObjects.Diver;

public class InputHandler implements InputProcessor {
    private Diver myDiver;
    public InputHandler(Diver worm){
        myDiver = worm;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	return true;
    }
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.DPAD_UP){
            //myWorm.KeyUp();
        }
        if (keycode == Input.Keys.DPAD_DOWN){
            //myWorm.KeyDown();
        }
        if (keycode == Input.Keys.DPAD_LEFT){
            //myWorm.KeyLeft();
        }
        if (keycode == Input.Keys.DPAD_RIGHT){
            //myWorm.KeyRight();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
    	if (keycode == Input.Keys.DPAD_UP){
            //myWorm.EndKeyUp();
        }
        if (keycode == Input.Keys.DPAD_DOWN){
            //myWorm.EndKeyDown();
        }
        if (keycode == Input.Keys.DPAD_LEFT){
            //myWorm.EndKeyLeft();
        }
        if (keycode == Input.Keys.DPAD_RIGHT){
            //myWorm.EndKeyRight();
        }
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
