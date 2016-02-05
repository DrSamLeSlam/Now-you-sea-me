package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import GameObjects.Ground;
import GameObjects.Worm;
import Helpers.AssetLoader;

public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }
    public void render() {
        Worm worm = myWorld.getWorm();

        Ground ground = myWorld.getGround();

        Gdx.gl.glClearColor(51 / 255.0f, 102 / 255.0f, 255 / 255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.sprite, worm.getX(), worm.getY(), 60, 30);
        spriteBatch.enableBlending();
        
       if (worm.getY()>90)
       spriteBatch.draw(AssetLoader.flashlight, worm.getX() - 240, worm.getY() - 290, 600, 600);
       
        else if (worm.getY()<90 && worm.getY()>45) 
       spriteBatch.draw(AssetLoader.DarkBlueFSprite, worm.getX()-240, worm.getY()-290, 600, 600);
       
        else
        	spriteBatch.draw(AssetLoader.MedBlueFSprite, worm.getX()-240, worm.getY()-290, 600, 600);
        
        	
        	
        
        spriteBatch.end();

    }
}
