package com.riforin.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.riforin.gameobjects.Tile;
import com.riforin.gameobjects.Tile.TILETYPE;
import com.riforin.ui.Button.BUTTONTYPE;

public class UIManager {
	
	private Tile chosenTile;
	
	private Button ring;
	private Button newtower;
	private Button newinfantry;
	private Button destroy;
	private Button upgrade;
	
	public UIManager(Stage stage) {
		
		ring = new Button(BUTTONTYPE.wheel, this);
		newtower = new Button(BUTTONTYPE.tower, this);
		newinfantry = new Button(BUTTONTYPE.infantry, this);
		destroy = new Button(BUTTONTYPE.destroy, this);
		upgrade = new Button(BUTTONTYPE.upgrade, this);
		
		ring.setVisible(false);
		newtower.setVisible(false);
		newinfantry.setVisible(false);
		destroy.setVisible(false);
		upgrade.setVisible(false);
		
		stage.addActor(ring);
		stage.addActor(newtower);
		stage.addActor(newinfantry);
		stage.addActor(destroy);
		stage.addActor(upgrade);
		
	}
	
	public void show(Tile tile) {
		chosenTile = tile;
		
		ring.show(tile);
		if (chosenTile.getType() == TILETYPE.tower) {
			if (chosenTile.isOccupied()) {
				displayExistingMenu(tile);
			} else {
				displayVacantMenu(tile);
			}
		}
	}
	
	private void displayVacantMenu(Tile tile) {
		newtower.show(tile);
		newinfantry.show(tile);
	}
	
	private void displayExistingMenu(Tile tile) { 
		destroy.show(tile);
		upgrade.show(tile);
	}
	
	
	
	
}