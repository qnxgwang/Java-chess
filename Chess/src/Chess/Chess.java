package Chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Chess extends JFrame implements Chess_config{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	

	
	

	public static void main(String [] args)
	{
		Chess ch=new Chess();
		ch.fengUI();
	}
	
	
	public void fengUI()
	{
		this.setTitle("五子棋第一代(黑棋先手)");
		this.setSize(870, 740);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);		
		
		ImageIcon icon=new ImageIcon("aini.jpg");   
  	    JLabel la=new JLabel(icon);
  	    la.setBounds(0, 0,870, 1000);	 
  	    
  	    JButton j1=new JButton("人人对战");
  	    j1.setBackground(Color.white);
  	    j1.setBounds(700, 100, 100, 50);
  	    
	    JButton j2=new JButton("人机对战");
	    j2.setBackground(new Color(250,250,250));
	    j2.setBounds(700, 180, 100, 50);
	    
	    JButton j3=new JButton("悔棋");
	    j3.setBackground(Color.white);
	    j3.setBounds(700, 550, 100, 50);
	   
	    JLabel jl1=new JLabel("当前执子：");
	    jl1.setBounds(700, 300, 100, 50);
	    
	    
	    this.add(jl1);
	    this.add(j1);
	    this.add(j2);
	    this.add(j3);
  	    this.add(la);	  
  		this.setVisible(true);
  	    	     
		ChessListener cl=new ChessListener();
		cl.g=this.getGraphics();
		cl.c=this;
		this.addMouseListener(cl);
		j1.addActionListener(cl);
		j2.addActionListener(cl);
		j3.addActionListener(cl);
		
		
	
	
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			{
				array[i][j]=new Feng(x0+Size*i,y0+Size*j,0);
			}
		}
	}
	
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);	
		
		g.drawString("15×15标准五子棋盘", 48, 64);
		for(int i=0;i<Rows;i++)
		{
			g.drawLine(x0, y0+Size*i,x0+Size*(Rows-1) , y0+Size*i);//横线
			g.drawLine(x0+Size*i, y0, x0+Size*i, y0+Size*(Rows-1));//竖线
						
		}
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			{
				if(array[i][j].now==1) 
				{
				/*g.setColor(Color.black);				
	    		g.fillOval(array[i][j].x-(int)(0.5*ChessSize), array[i][j].y-(int)(0.5*ChessSize), ChessSize, ChessSize);*/
					mension(array[i][j],g,1);
				}
				if(array[i][j].now==2) 
				{
				/*g.setColor(Color.white);				
	    		g.fillOval(array[i][j].x-(int)(0.5*ChessSize), array[i][j].y-(int)(0.5*ChessSize), ChessSize, ChessSize);*/
					mension(array[i][j],g,2);
				}
				
				
			}
		}
		
		
	
		
	}
	
	
	public void mension(Feng f,Graphics g,int x)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(f.now==1||x==1)
		{
		g.setColor(Color.black);
		for(int i=44;i>0;i--)	
			{
				if(i>=36)
					g.fillOval(f.x-(int)(i*0.5), f.y-(int)(i*0.5), i, i);
				else
				{	
					g.fillOval(f.x-(int)(i*0.5), f.y-(int)(i*0.5), i, i);			
					g.setColor(changeblackcolor(g.getColor()));
				}
			}
		}	
		
		if(f.now==2||x==2)
		{
		g.setColor(new Color(220,220,220));
		for(int i=44;i>0;i--)	
				{
				if(i>=36)
					g.fillOval(f.x-(int)(i*0.5), f.y-(int)(i*0.5), i, i);
				else if(i>10)
				{
					g.fillOval(f.x-(int)(i*0.5), f.y-(int)(i*0.5), i, i);
					g.setColor(changewhitecolor(g.getColor()));
				}
				else g.fillOval(f.x-(int)(i*0.5), f.y-(int)(i*0.5), i, i);			
				}
		}
	}
	
	public Color changeblackcolor (Color color)
	{
		int r=color.getRed();
		int g=color.getGreen();
		int b=color.getBlue();
		if(r<253)r=r+5;
		if(g<253)g=g+5;
		if(b<253)b=b+5;
		return new Color(r,g,b);
	}
	public Color changewhitecolor (Color color)
	{
		int r=color.getRed();
		int g=color.getGreen();
		int b=color.getBlue();
		if(r<255)r=r+1;
		if(g<255)g=g+1;
		if(b<255)b=b+1;
		return new Color(r,g,b);
	}

}
