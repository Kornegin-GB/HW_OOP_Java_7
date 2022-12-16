package com.unit.game.Units.greenSide;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.unit.game.System.MyAnim;
import com.unit.game.Units.Unit;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Spearman extends Unit {
    public Spearman(List<Unit> ownGang, List<Unit> enemyGang, int x, int y, TextureAtlas atlas) {
        super(4, 5, new int[]{1, 3}, 10, 4, "Копейщик");
        super.ownGang = ownGang;
        this.position = new Vector2(x, y);
        super.enemyGang = enemyGang;
//        this.quantity = new Random().nextInt(15, 20);
        super.atlas = new TextureAtlas("atlas/Spearman/Spearman.atlas");
        this.animMap.put("стоит", new MyAnim(this.atlas, "stay", 12, Animation.PlayMode.LOOP));
        this.animMap.put("удар", new MyAnim(this.atlas, "hit", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("возрождение", new MyAnim(this.atlas, "revival", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("ходит", new MyAnim(this.atlas, "goes", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертв", new MyAnim(this.atlas, "ded", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертвый", new MyAnim(this.atlas, "deadUnit", 12, Animation.PlayMode.NORMAL));
        this.status = "стоит";
    }

    @Override
    public void step() {
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
            if (dist < 2) {
                enemyGang.get(index).getHit(getDamage(enemyGang.get(index)));
            } else {
                Vector2 enemyPosition = enemyGang.get(index).getPosition();
                Vector2 newPosition = new Vector2(0, 0);
                if (enemyPosition.y == this.position.y) {
                    newPosition.y = this.position.y;
                    if (this.position.x - enemyPosition.x < 0) {
                        newPosition.x = this.position.x + 1;
                    } else {
                        newPosition.x = this.position.x - 1;
                    }
                } else {
                    newPosition.x = this.position.x;
                    if (enemyPosition.y - this.position.y > 0) {
                        newPosition.y = this.position.y + 1;
                    } else {
                        newPosition.y = this.position.y - 1;
                    }
                }
                AtomicBoolean empty = new AtomicBoolean(true);
                for (Unit unit : ownGang) {
                    if (unit.getPosition().equals(newPosition)) {
                        empty.set(false);
                    }
                }
                if (empty.get()) {
                    this.position = newPosition;
                }
            }
        }
    }
}
