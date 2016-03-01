package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

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

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 480, 270);
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }
    public void render() {
        Diver diver = myWorld.getDiver();

        Gdx.gl.glClearColor(51 / 255.0f, 102 / 255.0f, 255 / 255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        Color c = spriteBatch.getColor();
        
        spriteBatch.setColor(c.r, c.g, c.b, 1f);
        
        spriteBatch.enableBlending();
        

        spriteBatch.draw(AssetLoader.BGSprite, myWorld.getBackgroundround().getPosition().x%xwidth, myWorld.getBackgroundround().getPosition().y, xwidth, yheight);
        spriteBatch.draw(AssetLoader.BGSprite, myWorld.getBackgroundround().getPosition().x%xwidth - 480, myWorld.getBackgroundround().getPosition().y, xwidth, yheight);
        spriteBatch.draw(AssetLoader.BGSprite, myWorld.getBackgroundround().getPosition().x%xwidth + 480, myWorld.getBackgroundround().getPosition().y, xwidth, yheight);
        
        spriteBatch.draw(AssetLoader.MineSprite, 100, 145, 97, 130);
        
        spriteBatch.draw(AssetLoader.DiverSprite, diver.getX(), diver.getY(), 60, 30);

        
        c = spriteBatch.getColor();
        spriteBatch.setColor(c.r, c.g, c.b, (diver.getY()/yheight));
        spriteBatch.draw(AssetLoader.Opaque1, diver.getX() - 1440, diver.getY() - 790, 3000, 1600);
        
        spriteBatch.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        //if we need any shapes...
        shapeRenderer.end();

    }
}
