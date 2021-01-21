package com.daniel.pointandclick.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
    private Vector2 positionStart, positionEnd;
    private Texture texture;
    private boolean show;
    private float width, height;


    public GameObject(int x, int y, Texture texture) {
        this.positionStart = new Vector2(x, y);
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.show = true;
    }

    public GameObject(int x, int y, Texture texture, float width, float height) {
        this.positionStart = new Vector2(x, y);
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.show = true;
    }


    public void update() {
        show = !show;
    }

    public Vector2 getPositionStart() {
        return positionStart;
    }

    public boolean isShow() {
        return show;
    }

    public Texture getTexture() {
        return texture;
    }


    public void dispose() {
        texture.dispose();
    }

    public boolean contains(int x, int y) {
        return x >= positionStart.x && x <= positionStart.x + width && y >= positionStart.y && y <= positionStart.y + height;
    }
}
