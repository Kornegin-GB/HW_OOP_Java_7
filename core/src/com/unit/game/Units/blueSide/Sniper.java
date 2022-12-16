package com.unit.game.Units.blueSide;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.unit.game.System.MyAnim;
import com.unit.game.Units.Unit;

import java.util.List;

public class Sniper extends Unit {
    private int shots;

    public Sniper(List<Unit> ownGang, List<Unit> enemyGang, int x, int y, TextureAtlas atlas) {
        super(12, 10, new int[]{8, 10}, 15, 9, "Снайпер");
        shots = 32;
        super.ownGang = ownGang;
        this.position = new Vector2(x, y);
        super.enemyGang = enemyGang;
//        this.quantity = new Random().nextInt(1, 3);
        super.atlas = new TextureAtlas("atlas/Sniper/Sniper.atlas");
        this.animMap.put("стоит", new MyAnim(this.atlas, "stay", 12, Animation.PlayMode.LOOP));
        this.animMap.put("удар", new MyAnim(this.atlas, "hit", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("возрождение", new MyAnim(this.atlas, "revival", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертв", new MyAnim(this.atlas, "ded", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертвый", new MyAnim(this.atlas, "deadUnit", 12, Animation.PlayMode.NORMAL));
        this.status = "стоит";
    }

    @Override
    public void step() {

    }

    //    @Override
//    public void step() {
//        for (Unit unit : super.ownGang) {
//            if (unit.getName().equals("Крестьянин")) {
//                shots++;
//                unit.setStatus("Занят");
//                break;
//            }
//        }
//        if (shots > 0) {
//            double dist = Double.MAX_VALUE;
//            int index = -1;
//            for (int i = 0; i < enemyGang.size(); i++) {
//                double tmp = enemyGang.get(i).getPosition().getDist(this.position);
//                if (dist > tmp && !enemyGang.get(i).getStatus().equals("Мертв")) {
//                    dist = tmp;
//                    index = i;
//                }
//            }
//            if (index >= 0) {
//                enemyGang.get(index).getHit(speed > dist ? getDamage(enemyGang.get(index)) : getDamage(enemyGang.get(index)) / 2);
//                shots--;
//            }
//        }
//    }
}
