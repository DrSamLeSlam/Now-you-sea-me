package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

import GameObjects.Background;
import GameObjects.Diver;
import Helpers.AssetLoader;

public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private float xwidth = 480;
    private float yheight = 270;
    public static Vector3 mousePosition;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 480, 270);
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        
        mousePosition = new Vector3(0,0,0);
    }
    public OrthographicCamera getCam() {
    	return cam;
    }
    public void render() {
    	mousePosition.x = Gdx.input.getX();
    	mousePosition.y = Gdx.input.getY();
    	
    	cam.unproject(mousePosition);
    	
        Diver diver = myWorld.getDiver();

        Gdx.gl.glClearColor(51 / 255.0f, 102 / 255.0f, 255 / 255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        Color c = spriteBatch.getColor();
        
        spriteBatch.setColor(c.r, c.g, c.b, 1f);
        
        spriteBatch.enableBlending();

        spriteBatch.draw(AssetLoader.BGSprite, myWorld.getBackground().getPosition().x, myWorld.getBackground().getPosition().y, xwidth, yheight);
        spriteBatch.draw(AssetLoader.BGSpriteFlipped, myWorld.getCaveBackground().getPosition().x, myWorld.getCaveBackground().getPosition().y, xwidth, yheight);
        spriteBatch.draw(AssetLoader.BGSprite, myWorld.getShipBackground().getPosition().x, myWorld.getShipBackground().getPosition().y, xwidth, yheight);
        for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 0.5f ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 0.6f ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if ( myWorld.getFish(i).getLayer() == 0.7f ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 0.8f ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 0.9f ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        }
        spriteBatch.draw(AssetLoader.CaveSprite, myWorld.getCave().getPosition().x, myWorld.getCave().getPosition().y, xwidth, yheight);
        
        if (myWorld.hidden()) {
        	spriteBatch.setColor(c.r, c.g, c.b, myWorld.getHiddenDiver().getOpacity());
        	spriteBatch.draw(AssetLoader.DiverSprite, myWorld.getHiddenDiver().getX(), myWorld.getHiddenDiver().getY(), 60, 30 );
        }

        c = spriteBatch.getColor();
        spriteBatch.setColor(c.r, c.g, c.b, diver.getOpacity());
        
        spriteBatch.draw(AssetLoader.DiverSprite, diver.getX(), diver.getY(), 60, 30);
  
        c = spriteBatch.getColor();
        spriteBatch.setColor(c.r, c.g, c.b, 1f);
        
        spriteBatch.draw(AssetLoader.ShipSprite, myWorld.getShip().getPosition().x, myWorld.getShip().getPosition().y, xwidth, yheight);
        
        for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 1.1 ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 1.2 ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 1.3 ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 1.4 ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        } for( int i = 0; i < myWorld.getFishes().size(); i ++ ) {
        	if( myWorld.getFish(i).getLayer() == 1.5 ) {
        	spriteBatch.draw(myWorld.getFish(i).getSprite(), 
        			myWorld.getFish(i).getPosition().x, myWorld.getFish(i).getPosition().y, 
        			myWorld.getFish(i).getSize().x, myWorld.getFish(i).getSize().y);
        	}
        }
        if (myWorld.getVolumeState() == 1){
        	spriteBatch.draw(AssetLoader.volumeSprite,430,10,30,30);
        }
        if (myWorld.getVolumeState() == -1){
        	spriteBatch.draw(AssetLoader.muteSprite,430,10,30,30);
        }
        
        AssetLoader.font.draw(spriteBatch, Integer.toString(myWorld.getClock()), 5, 7, 0, 10, false);
        
        if(myWorld.getState() == 0)
        	AssetLoader.font.draw(spriteBatch, "Click to hide!", 70, 100, 0, 10, false);
        
        if(myWorld.getState() == 2)
        	AssetLoader.font.draw(spriteBatch, "Click to seek!", 70, 100, 0, 10, false);
        
        if(myWorld.youWin())
        	AssetLoader.font.draw(spriteBatch, "YOU WIN!", 150, 100, 0, 10, false);
        	
        if(myWorld.close())
        	AssetLoader.font.draw(spriteBatch, "Close!", 250, 7, 0, 10, false);
        	
        if(myWorld.tryAgain())
        	AssetLoader.font.draw(spriteBatch, "Try Again!", 200, 7, 0, 10, false);

        if(myWorld.tooSlow())
        	AssetLoader.font.draw(spriteBatch, "TOO SLOW!", 150, 100, 0, 10, false);
        
        c = spriteBatch.getColor();
        spriteBatch.setColor(c.r, c.g, c.b, (diver.getY()/yheight));
        spriteBatch.draw(AssetLoader.Opaque1, diver.getX() - 1440, diver.getY() - 790, 3000, 1600);
        spriteBatch.setColor(c.r, c.g, c.b, 1f);
        spriteBatch.draw(AssetLoader.gradiantSprite, 0, diver.getY()-200, 960, 540);
        
        spriteBatch.end();

    }
}
