package com.daniel.pointandclick.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.daniel.pointandclick.PointAndClick;
import com.daniel.pointandclick.sprites.GameObject;

public class StateOne extends State{

    private Texture background;
    GameObject potion, exit;


    public StateOne(GameStateManager gsm) {
        super(gsm);
        background = new Texture("doors1.png");
        potion = new GameObject(200, 10, new Texture("potion.png"));
        exit = new GameObject(150, 400, new Texture("exit.png"));
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            if (exit.contains(Gdx.input.getX(), PointAndClick.HEIGHT - Gdx.input.getY())) {
                gsm.set(new MenuState(gsm));
            }
            potion.update();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0 , 0, PointAndClick.WIDTH, PointAndClick.HEIGHT);
        if (potion.isShow()) {
            sb.draw(potion.getTexture(), potion.getPositionStart().x, potion.getPositionStart().y, PointAndClick.WIDTH / 30, PointAndClick.HEIGHT / 30);
        }
        sb.draw(exit.getTexture(), exit.getPositionStart().x, exit.getPositionStart().y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        potion.dispose();
    }
}
