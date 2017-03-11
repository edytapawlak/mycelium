import Box2D.Box2DProcessing;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.joints.DistanceJointDef;
import processing.core.PApplet;

/**
 * Przykładowa klasa, definiuje wygląd obiektów Ball.
 */
public class Ball implements Interpretation {
    private int radius;
    private BodyDef bd;
    private CircleShape ps;
    private FixtureDef fd;
    private PApplet context;


    public Ball(PApplet context, Box2DProcessing world, int radius) {
        this.context = context;
        this.radius = radius;

        // Definicja BodyDef
        bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
//        bd.fixedRotation = true;
        bd.linearDamping = 0.8f;
        bd.angularDamping = 0.9f;
//        bd.bullet = true;

        // Definicja kształtu
        ps = new CircleShape();
        ps.setRadius(world.scalarPixelsToWorld(radius));

        // Definicja dowiązania ciała do kształtu
        fd = new FixtureDef();
        fd.shape = ps;
        fd.density = 1;
        fd.friction = 0.3f;
        fd.restitution = 0.5f;
    }

    public void display(Vec2 v, float phi) {
        context.pushMatrix();
        context.translate(v.x, v.y);
        context.rotate(-phi);
        context.fill(255, 60, 0);
        context.ellipse(0, 0, radius, radius);
        context.noStroke();
        context.popMatrix();
    }

    public BodyDef getBodyDef() {
        return this.bd;
    }

    public CircleShape getShape() {
        return ps;
    }

    public FixtureDef getFixtureDef() {
        return fd;
    }
}
