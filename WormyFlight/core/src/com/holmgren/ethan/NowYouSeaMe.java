package com.holmgren.ethan;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import Helpers.AssetLoader;
import Screens.GameScreen;

public class NowYouSeaMe extends Game{

	@Override
	public void create() {
		Gdx.app.log("WormGame","Created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
}
