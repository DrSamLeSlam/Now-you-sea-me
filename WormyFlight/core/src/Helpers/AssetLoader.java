package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class AssetLoader {

    public static Texture texture;
    public static Texture flashlight;
    public static Texture background;
    public static Texture DarkBlueFlashlight;
    public static Texture MedBlueFlashlight;
    public static Sprite sprite;
    public static Sprite Fsprite;
    public static Sprite BGsprite;
    public static Sprite DarkBlueFSprite;
    public static Sprite MedBlueFSprite;
    
    public static void load(){
        texture = new Texture(Gdx.files.internal("android/assets/data/Diver.png"));
        sprite = new Sprite(texture);
        sprite.flip(false,true);
        flashlight = new Texture(Gdx.files.internal("android/assets/data/BlackBackGround.png"));
        Fsprite = new Sprite(flashlight);
        Fsprite.flip(false,true);
        background = new Texture(Gdx.files.internal("android/assets/data/background.jpg"));
        BGsprite = new Sprite(background);
        DarkBlueFlashlight = new Texture(Gdx.files.internal("android/assets/data/DarkBlue.png"));
        DarkBlueFSprite = new Sprite(DarkBlueFlashlight);
        MedBlueFlashlight = new Texture(Gdx.files.internal("android/assets/data/MedBlue.png"));
        MedBlueFSprite = new Sprite(MedBlueFlashlight);
        
    }

    public static void dispose(){
        texture.dispose();
        flashlight.dispose();
        background.dispose();
        DarkBlueFlashlight.dispose();
       MedBlueFlashlight.dispose();
    }
}
