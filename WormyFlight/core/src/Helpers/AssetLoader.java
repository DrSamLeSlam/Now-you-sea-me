package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class AssetLoader {

    public static Texture texture;
    public static Texture flashlight;
    public static Texture background;
    
    public static Texture Opaque1;
    public static Texture Opaque2;
    public static Texture Opaque3;
    public static Texture Opaque4;
    public static Texture Opaque5;
    public static Texture Opaque6;
    public static Texture Opaque7;
    public static Texture Opaque8;
    public static Texture Opaque9;
    public static Texture Opaque10;
    
    public static Sprite sprite;
    public static Sprite BGSprite;
    
    public static Sprite OpaqueSprite1;
    public static Sprite OpaqueSprite2;
    public static Sprite OpaqueSprite3;
    public static Sprite OpaqueSprite4;
    public static Sprite OpaqueSprite5;
    public static Sprite OpaqueSprite6;
    public static Sprite OpaqueSprite7;
    public static Sprite OpaqueSprite8;
    public static Sprite OpaqueSprite9;
    public static Sprite OpaqueSprite10;
    
    public static void load(){
        texture = new Texture(Gdx.files.internal("android/assets/data/Diver.png"));
        sprite = new Sprite(texture);
        sprite.flip(false,true);
        
//        flashlight = new Texture(Gdx.files.internal("android/assets/data/Dark.png"));
//        Dark = new Sprite(flashlight);
//        Dark.flip(false,true);
        
        background = new Texture(Gdx.files.internal("android/assets/data/background.png"));
        BGSprite = new Sprite(background);
        
        Opaque1 = new Texture(Gdx.files.internal("android/assets/data/Opaque.png"));
        OpaqueSprite1 = new Sprite(Opaque1);
        OpaqueSprite1.flip(false, true);
        Opaque2 = new Texture(Gdx.files.internal("android/assets/data/Opaque2.png"));
        OpaqueSprite2 = new Sprite(Opaque2);
        Opaque3 = new Texture(Gdx.files.internal("android/assets/data/Opaque3.png"));
        OpaqueSprite3 = new Sprite(Opaque3);
        Opaque4 = new Texture(Gdx.files.internal("android/assets/data/Opaque4.png"));
        OpaqueSprite4 = new Sprite(Opaque4);
        Opaque5 = new Texture(Gdx.files.internal("android/assets/data/Opaque5.png"));
        OpaqueSprite5 = new Sprite(Opaque5);
        Opaque6 = new Texture(Gdx.files.internal("android/assets/data/Opaque6.png"));
        OpaqueSprite6 = new Sprite(Opaque6);
        Opaque7 = new Texture(Gdx.files.internal("android/assets/data/Opaque7.png"));
        OpaqueSprite7 = new Sprite(Opaque7);
        Opaque8 = new Texture(Gdx.files.internal("android/assets/data/Opaque8.png"));
        OpaqueSprite8 = new Sprite(Opaque8);
        Opaque9 = new Texture(Gdx.files.internal("android/assets/data/Opaque9.png"));
        OpaqueSprite9 = new Sprite(Opaque9);
        Opaque10 = new Texture(Gdx.files.internal("android/assets/data/Opaque10.png"));
        OpaqueSprite10 = new Sprite(Opaque10);
        
    }

    public static void dispose(){
        texture.dispose();
        flashlight.dispose();
        background.dispose();
        Opaque1.dispose();
        Opaque2.dispose();
        Opaque3.dispose();
        Opaque4.dispose();
        Opaque5.dispose();
        Opaque6.dispose();
        Opaque7.dispose();
        Opaque8.dispose();
        Opaque9.dispose();
        Opaque10.dispose();
        
    }
}
