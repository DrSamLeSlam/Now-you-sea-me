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
        
        spriteBatch.draw(AssetLoader.BGSprite, myWorld.getBackgroundround().getPosition().x, myWorld.getBackgroundround().getPosition().y, xwidth, yheight);
        
        spriteBatch.draw(AssetLoader.DiverSprite, diver.getX(), diver.getY(), 60, 30);

        //else if (diver.getY()<90 && diver.getY()>45) 
        	//spriteBatch.draw(AssetLoader.DarkBlueFSprite, diver.getX()-240, diver.getY()-290, 600, 600);
       
        //else
        	//spriteBatch.draw(AssetLoader.MedBlueFSprite, diver.getX()-240, diver.getY()-290, 600, 600);
        
        
        
//        if (diver.getY() < (yheight / 10))
//        spriteBatch.draw(AssetLoader.Opaque10, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (yheight/10) && diver.getY() < (2 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque9, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (2*(yheight/10)) && diver.getY() < (3 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque8, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (3*(yheight/10)) && diver.getY() < (4 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque7, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (4*(yheight/10)) && diver.getY() < (5 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque6, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (5*(yheight/10)) && diver.getY() < (6 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque5, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (6*(yheight/10)) && diver.getY() < (7 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque4, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (7*(yheight/10)) && diver.getY() < (8 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque3, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (8*(yheight/10)) && diver.getY() < (9 * (yheight/10)))
//        	spriteBatch.draw(AssetLoader.Opaque2, diver.getX() - 240, diver.getY() - 290, 600, 600);
//        
//        else if (diver.getY() > (9*(yheight/10)) && diver.getY() < (10 * (yheight/10)))
        c = spriteBatch.getColor();
        spriteBatch.setColor(c.r, c.g, c.b, (diver.getY()/yheight));
        spriteBatch.draw(AssetLoader.Opaque1, diver.getX() - 240, diver.getY() - 290, 600, 600);
        
        spriteBatch.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        //if we need any shapes...
        shapeRenderer.end();

    }
}
