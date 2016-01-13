package com.cade.conklin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import Helpers.AssetLoader;
import Screens.GameScreen;

public class WGame extends Game{

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
