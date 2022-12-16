package com.unit.game.Units.greenSide;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.unit.game.System.MyAnim;
import com.unit.game.Units.Unit;

import java.util.*;

public class Monk extends Unit {
    static int atmInt = -1;
    private boolean magic;

    public Monk(List<Unit> ownGang, List<Unit> enemyGang, int x, int y, TextureAtlas atlas) {
        super(12, 7, new int[]{-4, -4}, 30, 5, "Монах");
        magic = true;
        super.ownGang = ownGang;
        this.position = new Vector2(x, y);
        super.enemyGang = enemyGang;
//        this.quantity = new Random().nextInt(2, 3);
        super.atlas = new TextureAtlas("atlas/Monk/Monk.atlas");
        this.animMap.put("стоит", new MyAnim(this.atlas, "stand", 12, Animation.PlayMode.LOOP));
        this.animMap.put("удар", new MyAnim(this.atlas, "hit", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("лечит", new MyAnim(this.atlas, "hil", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("возрождение", new MyAnim(this.atlas, "revival", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертв", new MyAnim(this.atlas, "dead", 12, Animation.PlayMode.NORMAL));
        this.animMap.put("мертвый", new MyAnim(this.atlas, "deadUnit", 12, Animation.PlayMode.LOOP));
        this.status = "стоит";
    }

        @Override
    public void step() {
//        double minHealth = Integer.MAX_VALUE;
//        Map<Integer, Double> healths = new HashMap<>();
//        for (int i = 0; i < ownGang.size(); i++) {
//            healths.put(i, ownGang.get(i).getHealth() / ownGang.get(i).getMAX_HEALTH());
//        }
//        List<Double> a = new ArrayList<>(healths.values().stream().toList());
//        Collections.sort(a);
//        healths.forEach((index, value) -> {
//            if (value.equals(a.get(0))) {
//                atmInt = index;
//            }
//        });
//        if (a.get(0) > 0.5) {
//            double dist = 1;
//            int index = -1;
//            for (int i = 0; i < enemyGang.size(); i++) {
//                double tmp = enemyGang.get(i).getHealth() / enemyGang.get(i).getMAX_HEALTH();
//                if (dist > tmp && enemyGang.get(i).getStatus().equals("Мертв")) {
//                    dist = tmp;
//                    index = i;
//                }
//            }
//            if (index < 0) {
//                index = 0;
//            }
//            enemyGang.get(index).getHit(damage[0] * -1);
//            setStatus("Выстрелил в " + index);
//            return;
//        }
//        if (a.get(0).equals(0.0)) {
//            healths.forEach((index, value) -> {
//                if (value.equals(0.0)) {
//                    if (ownGang.get(index).getName().equals("Арбалетчик") || ownGang.get(index).getName().equals("Монах")) {
//                        atmInt = index;
//                    }
//                }
//            });
//            if (atmInt >= 0) {
//                ownGang.get(atmInt).setHealth(1);
//                ownGang.get(atmInt).setStatus("Стоит");
//                setStatus("Возродил " + atmInt);
//            }
//            return;
//        }
//        if (a.get(0) <= 0.5) {
//            ownGang.get(atmInt).setHealth(ownGang.get(atmInt).getHealth() - this.damage[0]);
//            if (ownGang.get(atmInt).getHealth() > ownGang.get(atmInt).getMAX_HEALTH()) {
//                ownGang.get(atmInt).setHealth(ownGang.get(atmInt).getMAX_HEALTH());
//            }
//            setStatus("Вылечил " + atmInt);
//        }
    }
}
