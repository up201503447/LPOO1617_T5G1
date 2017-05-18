package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.ButtonImg;
import com.mygdx.game.ChickenVsFood;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by vitor on 06/04/2017.
 */

public class Hud implements Disposable{
    public Stage stage;
    private Viewport viewport;
    public Integer cornCounter;

    //progress
   /* textureBar = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("barGreen_horizontalMid.png"))));
    barStyle = new ProgressBarStyle(skin.newDrawable("white", Color.DARK_GRAY), textureBar);
    bar = new ProgressBar(0, 10, 0.5f, false, barStyle);
    bar.setPosition(10, 10);
    bar.setSize(290, bar.getPrefHeight());
    bar.setAnimateDuration(2);
    stage.addActor(bar);*/

    Label cornLabel;
    Label progressLevelLabel;
    Label leveLabel;
    Texture tex,tex1,tex2;

    public Hud(SpriteBatch sb){
        cornCounter = 0;
        viewport = new FitViewport(ChickenVsFood.V_WIDTH,ChickenVsFood.V_HEIGHT, new OrthographicCamera());

        stage = new Stage(viewport, sb);

        Gdx.input.setInputProcessor(stage);

        //upper hud
        Table tableT = new Table();
        tableT.top();
        tableT.left();
        tableT.setFillParent(true);

        tex = new Texture("butter.png");
        tex1 = new Texture("UmbrellaCopr.png");
        tex2 = new Texture("Tree1.png");

        ButtonImg food1 = new ButtonImg(tex,tex1,tex2);

      //  food1.setZIndex();

        food1.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                System.out.println("coiso1");
            }
        });

        ButtonImg food2 = new ButtonImg(tex1,tex1,tex1);

        food2.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                System.out.println("coiso2");
            }
        });

        ButtonImg food3 = new ButtonImg(tex2,tex2,tex2);

        food3.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                System.out.println("coiso3");
            }
        });

        cornLabel = new Label(String.format("%04d", cornCounter), new Label.LabelStyle(new BitmapFont(), Color.GOLD));

        tableT.add(cornLabel).padLeft(50);
        tableT.add(food1).padLeft(400);
        tableT.add(food2).padLeft(10);
        tableT.add(food3).padLeft(10);
        stage.addActor(tableT);


        //lower hud
        Table tableD = new Table();
        tableD.bottom();
        tableD.right();
        tableD.setFillParent(true);

        leveLabel = new Label("Level 1-1", new Label.LabelStyle(new BitmapFont(), Color.GOLD));
        tableD.add(leveLabel).padRight(50);
        stage.addActor(tableD);
    }


    @Override
    public void dispose() {
        stage.dispose();
    }
}