package Screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import GameObjects.Worm;

public class InputHandler implements InputProcessor {
    private Worm myWorm;
    public InputHandler(Worm worm){
        myWorm = worm;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.DPAD_UP){
            myWorm.KeyUp();
        }
        if (keycode == Input.Keys.DPAD_DOWN){
            myWorm.KeyDown();
        }
        if (keycode == Input.Keys.DPAD_LEFT){
            myWorm.KeyLeft();
        }
        if (keycode == Input.Keys.DPAD_RIGHT){
            myWorm.KeyRight();
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

        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
