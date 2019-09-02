package dev.codenmore.java2Dgame.entities;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    //InstanceFields

    private Handler handler;
    private Player player; //Special Entity

    private ArrayList<Entity> entities;

    //Constructors

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
    }

    //Getters

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    //Methods

    public void tick(){
        for(int i = 0; i < entities.size() ; i++ ){
            Entity e = entities.get(i);
            e.tick();
        }
        player.tick();
    }

    public void render(Graphics graphics){
        for(Entity e: entities){
            e.render(graphics);
        }
        player.render(graphics);
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }
}
