package Helpers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class AssetLoader {

    public static Texture Diver;
    public static Sprite DiverSprite;
    
    public static Texture BG;
    public static Sprite BGSprite;

    public static Sprite BGSpriteFlipped;
    
    public static Texture Cave;
    public static Sprite CaveSprite;
    
    public static Texture Opaque1;
    public static Sprite OpaqueSprite1;
    
    public static Texture Gradiant;
    public static Sprite gradiantSprite;
    
    public static Texture Mine;
    public static Sprite MineSprite;
    
    public static Texture Ship;
    public static Sprite ShipSprite;
    
    public static ArrayList<Sprite> fishSprites = new ArrayList<Sprite>();
    public static ArrayList<Sprite> fishSpritesFlipped = new ArrayList<Sprite>();
    private static Sprite temp;
    
    public static Texture volumeButton;
    public static Sprite volumeSprite;
    public static Texture muteButton;
    public static Sprite muteSprite;
    
    public static Texture fish1;
    public static Sprite fish1Sprite;
    public static Texture fish2;
    public static Sprite fish2Sprite;
    public static Texture fish3;
    public static Sprite fish3Sprite;
    public static Texture fish4;
    public static Sprite fish4Sprite;
    public static Texture fish5;
    public static Sprite fish5Sprite;
    public static Texture fish6;
    public static Sprite fish6Sprite;
    public static Texture fish7;
    public static Sprite fish7Sprite;
    public static Texture fish8;
    public static Sprite fish8Sprite;
    public static Texture fish9;
    public static Sprite fish9Sprite;
    public static Texture fish10;
    public static Sprite fish10Sprite;
    public static Texture fish11;
    public static Sprite fish11Sprite;
    
    public static BitmapFont font;
    
    public static Sound song;
    
    public static void load() {
        Diver = new Texture(Gdx.files.internal("android/assets/data/Diver.png"));
        DiverSprite = new Sprite(Diver);
        DiverSprite.flip(false,true);

        BG = new Texture(Gdx.files.internal("android/assets/data/background.png"));
        BGSprite = new Sprite(BG);
        BGSprite.flip(false, true);
        BGSpriteFlipped = new Sprite(BG);
        BGSpriteFlipped.flip(true, true);
        
        Cave = new Texture(Gdx.files.internal("android/assets/data/underwatercave.png"));
        CaveSprite = new Sprite(Cave);
        CaveSprite.flip(false, true);
        
        Opaque1 = new Texture(Gdx.files.internal("android/assets/data/Opaque.png"));
        OpaqueSprite1 = new Sprite(Opaque1);
        Gradiant = new Texture(Gdx.files.internal("android/assets/data/gradiant.png"));
        gradiantSprite = new Sprite(Gradiant);
        gradiantSprite.flip(false, false);
        
        Mine = new Texture(Gdx.files.internal("android/assets/data/mine.png"));
        MineSprite = new Sprite(Mine);
        MineSprite.flip(false,true);
        
        Ship = new Texture(Gdx.files.internal("android/assets/data/sunkenship.png"));
        ShipSprite = new Sprite(Ship);
        ShipSprite.flip(false,true);
        
        fish1 = new Texture(Gdx.files.internal("android/assets/data/fish1.png"));
        fish1Sprite = new Sprite(fish1);
        fish1Sprite.flip(false, true);
        
        fish2 = new Texture(Gdx.files.internal("android/assets/data/fish2.png"));
        fish2Sprite = new Sprite(fish2);
        fish2Sprite.flip(false, true);
        
        fish3 = new Texture(Gdx.files.internal("android/assets/data/fish3.png"));
        fish3Sprite = new Sprite(fish3);
        fish3Sprite.flip(false, true);
        
        fish4 = new Texture(Gdx.files.internal("android/assets/data/fish4.png"));
        fish4Sprite = new Sprite(fish4);
        fish4Sprite.flip(false, true);
        
        fish5 = new Texture(Gdx.files.internal("android/assets/data/fish5.png"));
        fish5Sprite = new Sprite(fish5);
        fish5Sprite.flip(false, true);
        
        fish6 = new Texture(Gdx.files.internal("android/assets/data/fish6.png"));
        fish6Sprite = new Sprite(fish6);
        fish6Sprite.flip(false, true);
        
        fish7 = new Texture(Gdx.files.internal("android/assets/data/fish7.png"));
        fish7Sprite = new Sprite(fish7);
        fish7Sprite.flip(false, true);
        
        fish8 = new Texture(Gdx.files.internal("android/assets/data/fish8.png"));
        fish8Sprite = new Sprite(fish8);
        fish8Sprite.flip(false, true);
        
        fish9 = new Texture(Gdx.files.internal("android/assets/data/fish9.png"));
        fish9Sprite = new Sprite(fish9);
        fish9Sprite.flip(false, true);
        
        fish10 = new Texture(Gdx.files.internal("android/assets/data/fish10.png"));
        fish10Sprite = new Sprite(fish10);
        fish10Sprite.flip(false, true);
        
        fish11 = new Texture(Gdx.files.internal("android/assets/data/fish11.png"));
        fish11Sprite = new Sprite(fish11);
        fish11Sprite.flip(false, true);
        
        fishSprites.add(fish1Sprite);
        fishSprites.add(fish2Sprite);
        fishSprites.add(fish3Sprite);
        fishSprites.add(fish4Sprite);
        fishSprites.add(fish5Sprite);
        fishSprites.add(fish6Sprite);
        fishSprites.add(fish7Sprite);
        fishSprites.add(fish8Sprite);
        fishSprites.add(fish9Sprite);
        fishSprites.add(fish10Sprite);
        fishSprites.add(fish11Sprite);
        
        for( int i = 0; i < 11; i ++ ) {
        	fishSprites.get(i).setSize(fishSprites.get(i).getWidth()/15, fishSprites.get(i).getHeight()/15);
        } for( int i = 0; i < 11; i ++ ) {
        	temp = new Sprite( fishSprites.get(i));
        	temp.flip(true, false);
        	fishSpritesFlipped.add(temp);
        }
        
        volumeButton = new Texture(Gdx.files.internal("android/assets/data/volumebutton2.png"));
        volumeSprite = new Sprite(volumeButton);
        volumeSprite.flip(false, true);
        
        muteButton = new Texture(Gdx.files.internal("android/assets/data/mutebutton2.png"));
        muteSprite = new Sprite(muteButton);
        muteSprite.flip(false, true);
     
        font = new BitmapFont(Gdx.files.internal("android/assets/data/font.fnt"), true);
        
        song = Gdx.audio.newSound(Gdx.files.internal("android/assets/data/underwater2.mp3"));
        
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
