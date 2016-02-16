package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class AssetLoader {

    public static Texture texture;
    public static Texture flashlight;
    public static Texture background;
    public static Texture Dark1Flashlight;
    public static Texture Dark2Flashlight;
    public static Texture Dark3Flashlight;
    public static Texture Dark4Flashlight;
    public static Texture Dark5Flashlight;
    public static Texture Dark6Flashlight;
    
    public static Sprite sprite;
    public static Sprite BGSprite;
    
    public static Sprite Dark;
    public static Sprite Dark1Sprite;
    public static Sprite Dark2Sprite;
    public static Sprite Dark3Sprite;
    public static Sprite Dark4Sprite;
    public static Sprite Dark5Sprite;
    public static Sprite Dark6Sprite;
    
    public static void load(){
        texture = new Texture(Gdx.files.internal("android/assets/data/Diver.png"));
        sprite = new Sprite(texture);
        sprite.flip(false,true);
        
        flashlight = new Texture(Gdx.files.internal("android/assets/data/Dark.png"));
        Dark = new Sprite(flashlight);
        Dark.flip(false,true);
        
        background = new Texture(Gdx.files.internal("android/assets/data/background.png"));
        BGSprite = new Sprite(background);
        
        Dark1Flashlight = new Texture(Gdx.files.internal("android/assets/data/Dark1.png"));
        Dark1Sprite = new Sprite(Dark1Flashlight);
        Dark2Flashlight= new Texture(Gdx.files.internal("android/assets/data/Dark2.png"));
        Dark2Sprite = new Sprite(Dark2Flashlight);
        Dark3Flashlight= new Texture(Gdx.files.internal("android/assets/data/Dark3.png"));
        Dark3Sprite = new Sprite(Dark3Flashlight);
        Dark4Flashlight= new Texture(Gdx.files.internal("android/assets/data/Dark4.png"));
        Dark4Sprite = new Sprite(Dark4Flashlight);
        Dark5Flashlight= new Texture(Gdx.files.internal("android/assets/data/Dark5.png"));
        Dark5Sprite = new Sprite(Dark5Flashlight);
        Dark6Flashlight= new Texture(Gdx.files.internal("android/assets/data/Dark6.png"));
        Dark6Sprite = new Sprite(Dark6Flashlight);
    }

    public static void dispose(){
        texture.dispose();
        flashlight.dispose();
        background.dispose();
        Dark1Flashlight.dispose();
       Dark2Flashlight.dispose();
       Dark3Flashlight.dispose();
       Dark4Flashlight.dispose();
       Dark5Flashlight.dispose();
       Dark6Flashlight.dispose();
    }
}
