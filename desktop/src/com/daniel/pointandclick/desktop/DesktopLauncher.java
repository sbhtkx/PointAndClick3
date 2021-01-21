package com.daniel.pointandclick.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.daniel.pointandclick.PointAndClick;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = PointAndClick.WIDTH;
		config.height = PointAndClick.HEIGHT;
		config.title = PointAndClick.TITLE;
		new LwjglApplication(new PointAndClick(), config);
	}
}
