package com.daniel.pointandclick.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.daniel.pointandclick.PointAndClick;
import com.daniel.pointandclick.sprites.GameObject;

public class MenuState extends State{

    private Texture background;
    private GameObject playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background0.png");
        Texture playBtnTexture = new Texture("playbtn.png");
        playBtn = new GameObject((PointAndClick.WIDTH / 2) - (playBtnTexture.getWidth() / 2), PointAndClick.HEIGHT / 2, playBtnTexture);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            Gdx.app.debug("debug", "x: " + x + ", y: " + y);
            if (playBtn.contains(Gdx.input.getX(), PointAndClick.HEIGHT - Gdx.input.getY())) {
                gsm.set(new StateOne(gsm));

            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn.getTexture(), playBtn.getPositionStart().x, playBtn.getPositionStart().y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
