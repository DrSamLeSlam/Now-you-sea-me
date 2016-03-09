package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class AssetLoader {

    public static Texture Diver;
    public static Sprite DiverSprite;
    
    public static Texture BG;
    public static Sprite BGSprite;

    public static Sprite CaveBGSprite;
    
    public static Texture Cave;
    public static Sprite CaveSprite;
    
    public static Texture Opaque1;
    public static Sprite OpaqueSprite1;
    
    public static Texture Gradiant;
    public static Sprite gradiantSprite;
    
    public static Texture Mine;
    public static Sprite MineSprite;
    
    public static void load(){
        Diver = new Texture(Gdx.files.internal("android/assets/data/Diver.png"));
        DiverSprite = new Sprite(Diver);
        DiverSprite.flip(false,true);

        BG = new Texture(Gdx.files.internal("android/assets/data/fuckthis.png"));
        BGSprite = new Sprite(BG);
        BGSprite.flip(false, true);
        CaveBGSprite = new Sprite(BG);
        CaveBGSprite.flip(true, true);
        
        Cave = new Texture(Gdx.files.internal("android/assets/data/underwatercave.png"));
        CaveSprite = new Sprite(Cave);
        CaveSprite.flip(false, true);
        
        Opaque1 = new Texture(Gdx.files.internal("android/assets/data/OpaqueA.png"));
        OpaqueSprite1 = new Sprite(Opaque1);
        Gradiant = new Texture(Gdx.files.internal("android/assets/data/gradiant.png"));
        gradiantSprite = new Sprite(Gradiant);
        gradiantSprite.flip(true, false);
        
        Mine = new Texture(Gdx.files.internal("android/assets/data/mine.png"));
        MineSprite = new Sprite(Mine);
        MineSprite.flip(false,true);
        
    }
    
    public static void flip() {
    	DiverSprite.flip(true, false);
    }

    public static void dispose(){
    	Diver.dispose();
    	BG.dispose();
        Opaque1.dispose();
        Mine.dispose();
        
    }
}
