import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    // Atributo que generar� numeros aleatorios.
    private Random rnd;
    // Guardamos todas las bolas creadas.
    private ArrayList<BouncingBall> listaBolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        listaBolas = new ArrayList<>();
        rnd = new Random();
    }

    /**
     * Simula bolas saltarinas, el numero es introducido por el usuario.
     */
    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i = 0; i < numeroBolas; i++){
            // crate and show the balls
            listaBolas.add(new BouncingBall(50, 50, rnd.nextInt(40) + 10, Color.BLUE, ground, myCanvas));
            listaBolas.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < numeroBolas; i++){
                listaBolas.get(i).move();
            
            // stop once ball has travelled a certain distance on x axis
            if(listaBolas.get(i).getXPosition() >= 550) {
                finished = true;
            }
            }
        }
    }
}