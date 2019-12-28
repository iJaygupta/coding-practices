/*<applet code="CircleThreads1.class" height=500 width=500>
  </applet>*/
import java.awt.*;
import java.applet.*;
public class CircleThreads1 extends Applet implements Runnable
   {
     private Thread red, green, blue;
     private int rx,yx;
    public void init()
     {
	red = new Thread(this,"RED");
	red.start();
	
      }
     public void run() 
       {
	while(true)
	{
	  try
           {
	    if(Thread.currentThread() == red)
		{
		    rx++;
	                      yx++;
		  Thread.sleep(50);
		}
		repaint();
		}
	  catch (Exception e) {
		e.printStackTrace();
	   }
	}
}
public void paint(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(rx,yx,80,80);

   }
	
}
