package game.player;

import base.Attribute;
import base.Vector2D;
import input.KeyBoardEvent;

public class PlayerMove implements Attribute<Player> {
    private  Vector2D defaultvelocity = new Vector2D(2.5f,0);
    @Override
    public void run(Player gameObject) {
        Vector2D velocity = this.defaultvelocity.copy();
        if (KeyBoardEvent.instance.isA) {
            gameObject.angle -= 3;
        }
        if (KeyBoardEvent.instance.isD) {
            gameObject.angle += 3;
        }
        if (KeyBoardEvent.instance.isW) {
            velocity = this.defaultvelocity.copy().multiply(2);
        }
        gameObject.velocity.set(velocity.rotate(gameObject.angle));
        gameObject.position.addUp(gameObject.velocity);
        this.backToScreen(gameObject.position);
    }

    private void backToScreen(Vector2D position) {
        if (position.x > 1024) position.set(0, position.y);
        if (position.x < 0) position.set(1024, position.y);
        if (position.y > 600) position.set(position.x, 0);
        if (position.y < 0) position.set(position.x, 600);
    }

}
