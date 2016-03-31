import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private int xSpeed = 1;
    private boolean ejeHorizontal;         // True si se mueve horizonalmente hacia la derecha
    private boolean ejeVertical;           // True si se mueve verticalmente hacia abajo
    private int rectangleXIni;
    private int rectangleXFin;
    private int rectangleYIni;
    private int rectangleYFin;

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    Canvas drawingCanvas, boolean horizontal, boolean vertical, int xInic, int xFin, int yInic, int yFin)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        ejeHorizontal = horizontal;
        ejeVertical = vertical;
        rectangleXIni = xInic;
        rectangleXFin = xFin;
        rectangleYIni = yInic;
        rectangleYFin = yFin;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
        if(ejeVertical){
            yPosition += ySpeed;
        }
        else{
            yPosition -= ySpeed;
        }
        if(ejeHorizontal){
            xPosition += xSpeed;
        }
        else{
            xPosition -= xSpeed;
        }

        if(xPosition <= rectangleXIni || xPosition >= rectangleXFin - diameter){
            ejeHorizontal = !ejeHorizontal;
        }
        if(yPosition <= rectangleYIni || yPosition >= rectangleYFin - diameter){
            ejeVertical = !ejeVertical;
        }
        
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}

