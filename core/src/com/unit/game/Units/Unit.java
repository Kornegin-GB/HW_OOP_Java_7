package com.unit.game.Units;

//import com.unit.game.System.Vector2D;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.unit.game.System.MyAnim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Unit implements UnitInterface {
    protected final double MAX_HEALTH;
    protected String name;
    protected double health;
    protected int attack;
    protected int protection;
    protected int[] damage;
    protected int speed;
    protected String status;
    protected List<Unit> ownGang, enemyGang;
    protected Vector2 position;
    protected int quantity;
    protected Map<String, MyAnim> animMap;
    protected TextureAtlas atlas;
    protected float time;
    protected int x;
    protected int y;

    public Unit(int attack, int protection, int[] damage, double health, int speed, String name) {
        this.attack = attack;
        this.name = name;
        this.protection = protection;
        this.damage = damage;
        this.health = health;
        this.MAX_HEALTH = health;
        this.speed = speed;
        animMap = new HashMap<>();
    }

    public void update(float delta) {
        animMap.get(this.status).deltaTime(delta);
    }

    public TextureRegion getFamre() {
        return animMap.get(this.status).getFrame();
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSpeed() {
        return speed;
    }

    public double getDamage(Unit enemy) {
        if (enemy.protection - this.attack == 0) {
            return ((this.damage[0] + this.damage[1]) / 2.0) * this.quantity;
        }
        if (enemy.protection - this.attack < 0) {
            return this.damage[1] * this.quantity;
        }
        return this.damage[0] * this.quantity;
    }

    public void getHit(double damage) {
        double tmpHealth = (this.quantity - 1) * this.MAX_HEALTH + this.health;
        tmpHealth -= damage;
        if (tmpHealth <= 0) {
            this.health = 0;
            this.status = "Мертв";
            this.quantity = 0;
        } else {
            this.quantity = (int) (tmpHealth / this.MAX_HEALTH);
            this.health = this.MAX_HEALTH;
            if (tmpHealth % this.MAX_HEALTH > 0) {
                this.quantity++;
                this.health = tmpHealth % this.MAX_HEALTH;
            }
        }
    }
}
