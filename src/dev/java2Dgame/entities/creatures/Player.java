package dev.java2Dgame.entities.creatures;

import dev.java2Dgame.Handler;
import dev.java2Dgame.entities.Entity;
import dev.java2Dgame.graphics.Animation;
import dev.java2Dgame.graphics.Assets;
import dev.java2Dgame.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Creature{

    //InstanceFields
    private Animation animationIdle;
    private Animation animationWalk;
    private Animation animationMeleeAttack;
        //Attack timer, time in which single attack is performed
    private long lastAttackTimer, attackCooldown = 2500, attackTimer = attackCooldown;
    private Rectangle attackRectangleArea;
        //Inventory
    private Inventory inventory;
        //Debug
    private boolean isDebugOn = false;

    //Constructors

    public Player(float x, float y, int health, float speed, Handler handler, String name) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, speed, handler, name);
        collisionBounds.x = 40;
        collisionBounds.y = 64;
        collisionBounds.width = 32;
        collisionBounds.height = 60;

        //Player animations
        animationIdle = new Animation(250, Assets.adventurerIdle);
        animationWalk = new Animation(250, Assets.adventurerWalk);
        animationMeleeAttack = new Animation(250, Assets.adventurerMeleeAttack);
        //Inventory
        inventory = new Inventory(this.handler);
    }

    public Player(float x, float y, int health, Handler handler, String name) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, Creature.DEFAULT_SPEED, handler, name);
        collisionBounds.x = 40;
        collisionBounds.y = 64;
        collisionBounds.width = 32;
        collisionBounds.height = 60;

        //Player animations
        animationIdle = new Animation(250, Assets.adventurerIdle);
        animationWalk = new Animation(250, Assets.adventurerWalk);
        animationMeleeAttack = new Animation(250, Assets.adventurerMeleeAttack);
        //Inventory
        inventory = new Inventory(this.handler);
    }

    //Getters

    public Inventory getInventory() {
        return inventory;
    }

    //Setters

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    //Methods

    @Override
    public void die(){
        super.die();
    }

    @Override // Updating any variables for our object.
    public void tick() {
        //Animation
        animationIdle.tick();
        animationWalk.tick();
        animationMeleeAttack.tick();
        //x += 1;

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        //Attack
        checkMeleeAttack();

        //Inventory
        inventory.tick();
    }

    @Override
    public void render(Graphics graphics) {
        //System.out.println("x : "+x+", y: "+y);
        graphics.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        //Bellow is the code for test purposes only.
//        isDebugOn = true;
        if(isDebugOn){
            graphics.setColor(Color.blue);
            graphics.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
                    collisionBounds.width, collisionBounds.height);
            if(handler.getKeyManager().attackDown || handler.getKeyManager().attackUp || handler.getKeyManager().attackRight || handler.getKeyManager().attackLeft) {
                graphics.setColor(Color.green);
                graphics.fillRect((int) (attackRectangleArea.x - handler.getGameCamera().getxOffset()),
                        (int) (attackRectangleArea.y - handler.getGameCamera().getyOffset()),
                        attackRectangleArea.width, attackRectangleArea.height);
            }
        }
    }

    //When we will call this method everything else will be drawn already.
    public void postRender(Graphics graphics){
        inventory.render(graphics);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return lastAttackTimer == player.lastAttackTimer &&
                attackCooldown == player.attackCooldown &&
                attackTimer == player.attackTimer &&
                Objects.equals(animationIdle, player.animationIdle) &&
                Objects.equals(animationWalk, player.animationWalk) &&
                Objects.equals(animationMeleeAttack, player.animationMeleeAttack) &&
                Objects.equals(attackRectangleArea, player.attackRectangleArea);
    }

    private void getInput(){
        if(inventory.isActive()){
            xMove = 0;
            yMove = 0;
            return;
        }

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

        if(inventory.isActive()){return;}

        attackRectangleArea = new Rectangle();
        int attackRectangleAreaSize = 50; //pixels, basically the reach of an attack in pixels,
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
        } else if(handler.getKeyManager().attackLeft){
            attackRectangleArea.x = collisionBounds.x + collisionBounds.width;
            attackRectangleArea.y = collisionBounds.y + collisionBounds.height / 2 - attackRectangleAreaSize / 2;
        } else if(handler.getKeyManager().attackRight){
            attackRectangleArea.x = collisionBounds.x - attackRectangleAreaSize;
            attackRectangleArea.y = collisionBounds.y + collisionBounds.height / 2 - attackRectangleAreaSize / 2;
        } else {
            return;
        }

        attackTimer = 0;

        // Now checking for the attacks after setting attack area
        for(Entity e : handler.getLevel().getEntityManager().getEntities()){
            if(e.equals(this)) {
                System.out.println("Weszło");
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(attackRectangleArea)){
                System.out.println(e.getCollisionBounds(0,0).intersects(attackRectangleArea));
                e.hurt(1);
                System.out.println(e.getName() + " " + e.getCurrentHealthPoints());
                return;
            }
        }
    }

    private BufferedImage getCurrentAnimationFrame(){
         if(xMove >0 || xMove < 0 || yMove > 0 || yMove < 0)
            { return  animationWalk.getCurrentAnimationFrame(); }
         else if(handler.getKeyManager().attackDown || handler.getKeyManager().attackUp || handler.getKeyManager().attackRight || handler.getKeyManager().attackLeft)
            { return  animationMeleeAttack.getCurrentAnimationFrame(); }
         else { return animationIdle.getCurrentAnimationFrame(); }
    }
}
