package com.unit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import com.unit.game.Units.Peasant;
import com.unit.game.Units.Unit;
import com.unit.game.Units.blueSide.Robber;
import com.unit.game.Units.blueSide.Sniper;
import com.unit.game.Units.blueSide.Wizard;
import com.unit.game.Units.greenSide.Crossbowman;
import com.unit.game.Units.greenSide.Monk;
import com.unit.game.Units.greenSide.Spearman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GdxUnitGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture backgroundGame;
    Music soundTrack;
    List<Unit> blueSide, greenSide;
    TextureAtlas atlas;

    @Override
    public void create() {
        batch = new SpriteBatch();
        backgroundGame = new Texture("fon.jpg");
        soundTrack = Gdx.audio.newMusic(Gdx.files.internal("sound/track.mp3"));
        createUnitsSide(atlas);
    }


    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(backgroundGame, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        soundTrack.setVolume(0.5f);
        soundTrack.play();
        displayUnits();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        backgroundGame.dispose();
        soundTrack.dispose();
//        atlas.dispose();
    }

    private void createUnitsSide(TextureAtlas atlas) {
        blueSide = new ArrayList<>();
        greenSide = new ArrayList<>();

//        int x = 1;
//        for (int i = 0; i < 5; i++) {
//            blueSide.add(new Robber(blueSide, greenSide, x, i + 1, atlas));
//        }
//        x = Gdx.graphics.getWidth();
//        for (int i = 0; i < 5; i++) {
//            greenSide.add(new Peasant(greenSide, blueSide, x - 150, i + 1, atlas));
//        }
        final int GANG_SIZE = 10;
        blueSide = new ArrayList<>();
        greenSide = new ArrayList<>();
        int x = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    blueSide.add(new Robber(blueSide, greenSide, x, i + 1, atlas));
                    break;
                case 1:
                    blueSide.add(new Sniper(blueSide, greenSide, x, i + 1, atlas));
                    break;
                case 2:
                    blueSide.add(new Wizard(blueSide, greenSide, x, i + 1, atlas));
                    break;
                default:
                    blueSide.add(new Peasant(blueSide, greenSide, x, i + 1, atlas));
            }
            if (i % 2 != 0) {
                x = 1;
            } else {
                x = x + 2;
            }
        }

        x = Gdx.graphics.getWidth();
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    greenSide.add(new Peasant(greenSide, blueSide, x - 150, i + 1, atlas));
                    break;
                case 1:
                    greenSide.add(new Spearman(greenSide, blueSide, x - 150, i + 1, atlas));
                    break;
                case 2:
                    greenSide.add(new Crossbowman(greenSide, blueSide, x - 150, i + 1, atlas));
                    break;
                default:
                    greenSide.add(new Monk(greenSide, blueSide, x - 150, i + 1, atlas));
            }
            if (i % 2 == 0) {
                x = Gdx.graphics.getWidth() - 90;
            } else {
                x = Gdx.graphics.getWidth();
            }
        }
    }

    private void displayUnits() {
        for (Unit hero : blueSide) {
            hero.update(Gdx.graphics.getDeltaTime());
            batch.draw(hero.getFamre(), hero.getPosition().x * 45, hero.getPosition().y * Gdx.graphics.getHeight() * 2 / 18);
        }
        for (Unit hero : greenSide) {
            hero.update(Gdx.graphics.getDeltaTime());
            batch.draw(hero.getFamre(), hero.getPosition().x, hero.getPosition().y * Gdx.graphics.getHeight() * 2 / 18);
        }
    }
}
