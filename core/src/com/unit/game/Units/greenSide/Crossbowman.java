package com.unit.game.Units.greenSide;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.unit.game.System.MyAnim;
import com.unit.game.Units.Unit;

import java.util.List;

public class Crossbowman extends Unit {
    private int shots;

    public Crossbowman(List<Unit> ownGang, List<Unit> enemyGang, int x, int y, TextureAtlas atlas) {
        super(6, 3, new int[]{1, 3}, 10, 4, "Арбалетчик");
        shots = 16;
        super.ownGang = ownGang;
        this.position = new Vector2(x, y);
        super.enemyGang = enemyGang;
//        this.quantity = new Random().nextInt(2, 5);
        super.atlas = new TextureAtlas("atlas/Crossbowman/Crossbowman.atlas");
        this.animMap.put("стоит", new MyAnim(this.atlas, "stay", 12, Animation.PlayMode.LOOP));
        this.animMap.put("удар", new MyAnim(this.atlas, "hit", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("возрождение", new MyAnim(this.atlas, "revival", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертв", new MyAnim(this.atlas, "ded", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертвый", new MyAnim(this.atlas, "deadUnit", 12, Animation.PlayMode.NORMAL));
        this.status = "стоит";
    }

    @Override
    public void step() {
        for (Unit unit : super.ownGang) {
            if (unit.getName().equals("Крестьянин")) {
                if (!unit.getStatus().equals("заряжает") && !unit.getStatus().equals("мертв")) {
                    shots++;
                    unit.setStatus("заряжает");
                    break;
                }
            }
        }
        if (shots > 0) {
            double dist = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < enemyGang.size(); i++) {
                double tmp = enemyGang.get(i).getPosition().dst(this.position);
                if (dist > tmp && !enemyGang.get(i).getStatus().equals("мертв")) {
                    dist = tmp;
                    index = i;
                }
            }
            if (index >= 0) {
                enemyGang.get(index).getHit(speed > dist ? getDamage(enemyGang.get(index)) : getDamage(enemyGang.get(index)) / 2);
                shots--;
            }
        }
    }
}
