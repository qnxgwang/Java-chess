package Chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ChessListener extends MouseAdapter implements Chess_config ,ActionListener{
	
	public Graphics g; 
	public int turn=1;               //轮流下棋
	public Feng f;                   //记录当前棋子
	public int num=0;                //记录悔棋次数
	public boolean t=false;          //判断下棋位置是否正确
	public Chess c;                  //借过来的窗体
	public String WarMode="null";    //战斗方式
	public String enter="false";     //判断是否进入新游戏
    public String win="false";       //判断是否获胜


	public void mouseClicked(MouseEvent e)
	{
		int x=e.getX();
		int y=e.getY();
	
	
		/*
		 * 判断位置
		 */
		
		if(WarMode.equals("人人对战")||WarMode.equals("人机对战"))
		{
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			
			{
				if((array[i][j].x-x<15)&&(array[i][j].x-x>=0)&&(array[i][j].y-y<15)&&(array[i][j].y-y>=0))
				
				{   
	
				     
					f=array[i][j];
					t=true;
				    break;
				}
				else if ((x-array[i][j].x<15)&&(x-array[i][j].x>=0)&&(y-array[i][j].y<15)&&(y-array[i][j].y>=0))
					
				{
			
					f=array[i][j];
					t=true;
				    break;
				}
				
			}
		}
		
		/*
		 * 判断棋色
		 */
		if(t==true&&f.now==0)
		{
		    if(turn==1)
		    {	
		    	
		    	/*
		    	 * 人人对战黑棋算法算法
		    	 */
		    		
		    		/*c.paint(g);
		    		g.setColor(Color.black);
		    		g.fillOval(f.x-(int)(0.5*ChessSize), f.y-(int)(0.5*ChessSize), ChessSize, ChessSize);*/
		    	    c.mension(f,g,1);
		    		f.now=1;
		    		turn=2;    		
		    		g.setColor(Color.white);	    		
		    		g.fillOval(780, 350,(int)(0.5*ChessSize) , (int)(0.5*ChessSize));
		    	   // drawMark(f);
		    	    
		    	    /*
		    	         *人机对战白棋算法
		    	     */
		    	    if(WarMode.equals("人机对战"))
		    	    {
		    	    	//c.paint(g);
				    	g.setColor(Color.white);
				    	ChessAI ai=new ChessAI();
				    	ai.ValueCount();
				    	ai.AIplay(g);
				    	turn=1;	    	
				    	g.setColor(Color.black);
				    	g.fillOval(780, 350, (int)(0.5*ChessSize), (int)(0.5*ChessSize));
				    //	drawMark(f);
		    	    }
		    	    
		    }
		    /*
		         * 人人对战白棋算法
		     */
		    else if(WarMode.equals("人人对战"))
		    {   
	    		/*c.paint(g);
		    	g.setColor(Color.white);
		    	g.fillOval(f.x-(int)(0.5*ChessSize), f.y-(int)(0.5*ChessSize), ChessSize, ChessSize);*/
		    	c.mension(f,g,2);
		    	f.now=2;
		    	turn=1;	    	
		    	g.setColor(Color.black);
		    	g.fillOval(780, 350, (int)(0.5*ChessSize), (int)(0.5*ChessSize));
		    	//drawMark(f);
		    }
		   t=false;
		   
		}
		/*
		 *判断结束
		 */
		
		
		for(int i=0;i<Rows-4;i++) 
			for(int j=0;j<Column;j++)
			{
			if(array[j][i].now==1&&array[j][i+1].now==1&&array[j][i+2].now==1&&array[j][i+3].now==1&&array[j][i+4].now==1)  win="黑色胜利";
			if(array[j][i].now==2&&array[j][i+1].now==2&&array[j][i+2].now==2&&array[j][i+3].now==2&&array[j][i+4].now==2)  win="白色胜利";
			}	
		for(int i=0;i<Rows;i++)
			for(int j=0;j<Column-4;j++)
			{
			if(array[j][i].now==1&&array[j+1][i].now==1&&array[j+2][i].now==1&&array[j+3][i].now==1&&array[j+4][i].now==1) win="黑色胜利";
			if(array[j][i].now==2&&array[j+1][i].now==2&&array[j+2][i].now==2&&array[j+3][i].now==2&&array[j+4][i].now==2) win="白色胜利";
			}	
		for(int i=0;i<Rows-4;i++)		
			for(int j=0;j<Column-4;j++)
			{
			if(array[i][j].now==1&&array[i+1][j+1].now==1&&array[i+2][j+2].now==1&&array[i+3][j+3].now==1&&array[i+4][j+4].now==1) win="黑色胜利";
			if(array[i][j].now==2&&array[i+1][j+1].now==2&&array[i+2][j+2].now==2&&array[i+3][j+3].now==2&&array[i+4][j+4].now==2) win="白色胜利";
			}
		for(int i=0;i<Rows-4;i++)
			for(int j=4;j<Column;j++)
			{
			if(array[i][j].now==1&&array[i+1][j-1].now==1&&array[i+2][j-2].now==1&&array[i+3][j-3].now==1&&array[i+4][j-4].now==1) win="黑色胜利";
			if(array[i][j].now==2&&array[i+1][j-1].now==2&&array[i+2][j-2].now==2&&array[i+3][j-3].now==2&&array[i+4][j-4].now==2) win="白色胜利";
			}
		
		
		if(!win.equals("false")) {JOptionPane.showMessageDialog(null, win);c.removeMouseListener(this);}
		}	
		
		
		
		
		
		
		
	}
    
	public void actionPerformed(ActionEvent e)
	{
		JButton jb=(JButton)e.getSource();
	    
		if(jb.getActionCommand().equals("人人对战")==true)
				{
			
				JFrame jx=new JFrame();
				jx.setTitle("确定重新开始“人人对战”？");
				jx.setSize(450, 200);
				jx.setResizable(false);
				jx.setDefaultCloseOperation(1);
				jx.setLocationRelativeTo(null);
				jx.setLayout(null);
				jx.setVisible(true);
				JButton j1=new JButton("重新开始");
				j1.setBackground(Color.white);
				j1.setBounds(100, 50, 100, 50);
				JButton j2=new JButton("取消");
				j2.setBackground(Color.white);
				j2.setBounds(250, 50, 100, 50);
				
				StartListener sl=new StartListener();
				sl.cl=this;
				sl.je=jx;
				j1.addActionListener(sl);
				j2.addActionListener(sl);
				jx.add(j1);
				jx.add(j2);
			
				}
			if(jb.getActionCommand().equals("人机对战")==true)
				{
				JFrame jx=new JFrame();
				jx.setTitle("确定重新开始“人机对战”？");
				jx.setSize(450, 200);
				jx.setResizable(false);
				jx.setDefaultCloseOperation(1);
				jx.setLocationRelativeTo(null);
				jx.setLayout(null);
				jx.setVisible(true);
				JButton j1=new JButton("重新开局");
				j1.setBackground(Color.white);
			  	j1.setBounds(100, 50, 100, 50);
				JButton j2=new JButton("取消");
				j2.setBackground(Color.white);
			  	j2.setBounds(250, 50, 100, 50);
			  	
			  	StartListener sl=new StartListener();
				sl.cl=this;
				sl.je=jx;
				j1.addActionListener(sl);
				j2.addActionListener(sl);
				jx.add(j1);
				jx.add(j2);
				
				}
		
		if(jb.getActionCommand().equals("悔棋")==true)
				{
						if(num==1)
						JOptionPane.showMessageDialog(null, "每局最多悔棋一次！");     
						else
						{
						JFrame jx=new JFrame();
						jx.setTitle("每局最多悔棋一次，确定悔棋？");
						jx.setSize(450, 200);
						jx.setResizable(false);
						jx.setDefaultCloseOperation(1);
						jx.setLocationRelativeTo(null);
						jx.setLayout(null);
						jx.setVisible(true);
						JButton j1=new JButton("确定");
						j1.setBackground(Color.white);
					  	j1.setBounds(100, 50, 100, 50);
						JButton j2=new JButton("取消");
						j2.setBackground(Color.white);
					  	j2.setBounds(250, 50, 100, 50);
					  	
					  	StartListener sl=new StartListener();
						sl.cl=this;
						sl.je=jx;
						j1.addActionListener(sl);
						j2.addActionListener(sl);
						jx.add(j1);
						jx.add(j2);
						}
	  
	    
				}
		

	}
	
	public void drawMark(Feng f)
	{
		
		g.setColor(Color.red);
  	    
	    g.drawLine(f.x-(int)(0.5*ChessSize), f.y-(int)(0.5*ChessSize), f.x-(int)(0.25*ChessSize), f.y-(int)(0.5*ChessSize));
	    g.drawLine(f.x+(int)(0.25*ChessSize), f.y-(int)(0.5*ChessSize), f.x+(int)(0.5*ChessSize), f.y-(int)(0.5*ChessSize));
	    g.drawLine(f.x-(int)(0.5*ChessSize), f.y+(int)(0.5*ChessSize), f.x-(int)(0.25*ChessSize), f.y+(int)(0.5*ChessSize));
	    g.drawLine(f.x+(int)(0.25*ChessSize), f.y+(int)(0.5*ChessSize), f.x+(int)(0.5*ChessSize), f.y+(int)(0.5*ChessSize));
	    g.drawLine(f.x-(int)(0.5*ChessSize), f.y-(int)(0.5*ChessSize), f.x-(int)(0.5*ChessSize), f.y-(int)(0.25*ChessSize));
	    g.drawLine(f.x+(int)(0.5*ChessSize), f.y-(int)(0.5*ChessSize), f.x+(int)(0.5*ChessSize), f.y-(int)(0.25*ChessSize));
	    g.drawLine(f.x-(int)(0.5*ChessSize), f.y+(int)(0.25*ChessSize), f.x-(int)(0.5*ChessSize), f.y+(int)(0.5*ChessSize));
	    g.drawLine(f.x+(int)(0.5*ChessSize), f.y+(int)(0.5*ChessSize), f.x+(int)(0.5*ChessSize), f.y+(int)(0.25*ChessSize));
	}
	
}
