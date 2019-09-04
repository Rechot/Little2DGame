package dev.codenmore.java2Dgame.entities.creatures;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.Entity;
import dev.codenmore.java2Dgame.graphics.Animation;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //InstanceFields
    private Animation animationIdle;
    private Animation animationWalk;
    private Animation animationMeleeAttack;
        //Attack timer, time in which single attack is performed
    private long lastAttackTimer, attackCooldown = 750, attackTimer = attackCooldown;

    //Constructors

    public Player(float x, float y, int health, float speed, Handler handler, String name) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, speed, handler, name);
        collisionBounds.x = 40;
        collisionBounds.y = 64;
        collisionBounds.width = 32;
        collisionBounds.height = 52;
    }

    public Player(float x, float y, int health, Handler handler, String name) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, Creature.DEFAULT_SPEED, handler, name);
        collisionBounds.x = 40;
        collisionBounds.y = 64;
        collisionBounds.width = 32;
        collisionBounds.height = 52;

        //Player animations
        animationIdle = new Animation(250, Assets.adventurerIdle);
        animationWalk = new Animation(250, Assets.adventurerWalk);
        animationMeleeAttack = new Animation(250, Assets.adventurerMeleeAttack);
    }

    //Methods


    @Override
    public void die(){

    }

    @Override // Updating any variables for our object.
    public void tick() {
        //Animation
        animationIdle.tick();
        animationWalk.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        //Attack
        checkMeleeAttack();
    }

    @Override
    public void render(Graphics graphics) {
        //System.out.println("x : "+x+", y: "+y);
        graphics.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        //Bellow is the code for test purposes only.
//        graphics.setColor(Color.red);
//        graphics.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
//               collisionBounds.width, collisionBounds.height);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){yMove = -speed;}
        if(handler.getKeyManager().down){yMove = speed;}
        if(handler.getKeyManager().left){xMove = -speed;}
        if(handler.getKeyManager().right){xMove = speed;}
    }

    //Here we will be checking whether player uses the meleeAttack key and generate the attack and appropriate animation.
    private void checkMeleeAttack(){
        // Setting attack time pace
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer <  attackCooldown) {return;}

        Rectangle attackRectangleArea = new Rectangle();
        int attackRectangleAreaSize = 40; //pixels, basically the reach of an attack in pixels,
        // our attackArea will be a square width = height = attackRectangleAreaSize;
        // that square will be positioned in a way, that one of its edges will adjoin the edge of a player's collision boundaries.
        attackRectangleArea.width = attackRectangleAreaSize;
        attackRectangleArea.height = attackRectangleAreaSize;

        Rectangle collisionBounds = getCollisionBounds(0,0);
        // if ... else if ... meaning player will attack one direction at a time, up, down, right, left, depending on which key was pressed;
        if(handler.getKeyManager().attackUp){
            attackRectangleArea.x = collisionBounds.x + collisionBounds.width / 2 - attackRectangleAreaSize / 2;
            attackRectangleArea.y = collisionBounds.y - attackRectangleAreaSize;
        } else if(handler.getKeyManager().attackDown){
            attackRectangleArea.x = collisionBounds.x + collisionBounds.width / 2 - attackRectangleAreaSize / 2;
            attackRectangleArea.y = collisionBounds.y + collisionBounds.height;
        } else if(handler.getKeyManager().attackRight){
            attackRectangleArea.x = collisionBounds.x + attackRectangleAreaSize;
            attackRectangleArea.y = collisionBounds.y + collisionBounds.height / 2 - attackRectangleAreaSize / 2;
        } else if(handler.getKeyManager().attackLeft){
            attackRectangleArea.x = collisionBounds.x - collisionBounds.width;
            attackRectangleArea.y = collisionBounds.y + collisionBounds.height / 2 - attackRectangleAreaSize / 2;
        } else {
            return;
        }

        attackTimer = 0;

        // Now checking for the attacks after setting attack area
        for(Entity e : handler.getLevel().getEntityManager().getEntities()){
            if(equals(this)) { continue;}
            if(e.getCollisionBounds(0,0).intersects(attackRectangleArea)){
                e.hurt(1);
                return;
            }
        }
    }

    private BufferedImage getCurrentAnimationFrame(){
         if(xMove >0 || xMove < 0 || yMove > 0 || yMove < 0){ return  animationWalk.getCurrentAnimationFrame(); }
         else { return animationIdle.getCurrentAnimationFrame(); }
    }
}
