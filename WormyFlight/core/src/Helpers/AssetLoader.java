package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class AssetLoader {

    public static Texture texture;
    public static Texture flashlight;
    public static Sprite sprite;
    public static Sprite Fsprite;

    public static void load(){
        texture = new Texture(Gdx.files.internal("android/assets/data/Diver.png"));
        sprite = new Sprite(texture);
        sprite.flip(false,true);
        flashlight = new Texture(Gdx.files.internal("android/assets/data/BlackBackGround.png"));
        Fsprite = new Sprite(flashlight);
        Fsprite.flip(false,true);
    }

    public static void dispose(){
        texture.dispose();
    }
}