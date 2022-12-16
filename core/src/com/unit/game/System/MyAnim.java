package com.unit.game.System;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnim {
    private Animation<TextureAtlas.AtlasRegion> animation;
    private float time;

    public MyAnim(TextureAtlas atlas, String name, int fps, Animation.PlayMode playMode) {
        animation = new Animation<TextureAtlas.AtlasRegion>(1.0f / fps, atlas.findRegions(name));
        animation.setPlayMode(playMode);
    }

    public void setTime(float time) {
        this.time = time;
    }

    public boolean deltaTime(float delta) {
        time += delta;
        return animation.isAnimationFinished(time);
    }

    public TextureRegion getFrame() {
        return animation.getKeyFrame(time);
    }
}
