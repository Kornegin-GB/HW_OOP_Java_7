package com.unit.game.Units;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.unit.game.System.MyAnim;

import java.util.List;
import java.util.Random;

public class Peasant extends Unit {
    private boolean delivery;

    public Peasant(List<Unit> ownGang, List<Unit> enemyGang, int x, int y, TextureAtlas atlas) {
        super(1, 1, new int[]{1, 1}, 1, 3, "Крестьянин");
        delivery = true;
        super.ownGang = ownGang;
        this.position = new Vector2(x, y);
        super.enemyGang = enemyGang;
//        this.quantity = new Random().nextInt(1, 5);
        super.atlas = new TextureAtlas("atlas/Peasant/Peasant.atlas");
        this.animMap.put("стоит", new MyAnim(this.atlas, "stand", 12, Animation.PlayMode.LOOP));
        this.animMap.put("заряжает", new MyAnim(this.atlas, "recharge", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертв", new MyAnim(this.atlas, "ded", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертвый", new MyAnim(this.atlas, "deadUnit", 12, Animation.PlayMode.LOOP));
        this.animMap.put("возрождение", new MyAnim(this.atlas, "revival", 12, Animation.PlayMode.NORMAL));
        this.status = "стоит";
    }


    @Override
    public void step() {
        if (status.equals("заряжает")) {
            status = "стоит";
        }
    }
}
