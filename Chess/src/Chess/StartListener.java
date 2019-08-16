package Chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StartListener implements ActionListener , Chess_config {
	

	public ChessListener cl;
	public JFrame je;
	public void actionPerformed(ActionEvent e)
	{
		JButton jb=(JButton)e.getSource();
		/*
		 * 人人对战算法
		 */
		if(jb.getActionCommand().equals("重新开始"))
					{
						cl.WarMode="人人对战";	 
						for(int i=0;i<Rows;i++)
						{
							for(int j=0;j<Column;j++)
							{
								array[i][j].now=0;
							}	
						}
						cl.turn=1;
						cl.num=0;
						cl.win="false";
						cl.c.repaint();
						cl.c.addMouseListener(cl);
					}
		je.dispose();
		/*
		 * 人机对战算法
		 */
		if(jb.getActionCommand().equals("重新开局"))
		            {
			   			cl.WarMode="人机对战";
			   			for(int i=0;i<Rows;i++)
			   			{
			   				for(int j=0;j<Column;j++)
			   				{
			   					array[i][j].now=0;
			   				}	
			   			}
			   			cl.turn=1;
			   			cl.num=0;
			   			cl.win="false";
			   			cl.c.repaint();
			   			cl.c.addMouseListener(cl);
		            }
		/*
		 * 悔棋算法
		 */
		
		if(jb.getActionCommand().equals("确定")&&cl.WarMode.equals("人人对战"))
        {
			   if(!cl.win.equals("false")) JOptionPane.showMessageDialog(null, "当前对局已结束");
			   else if(cl.f!=null&&cl.num==0)
			     {
			     cl.f.now=0;
			     cl.c.repaint();
			     if(cl.turn==1)cl.turn=2;
			     else cl.turn=1;
			     cl.num=1;
			     }
        }
		else if(jb.getActionCommand().equals("确定")&&cl.WarMode.equals("人机对战"))
		{
			JOptionPane.showMessageDialog(null, "人机对战暂时不可悔棋");
		}
		else if(jb.getActionCommand().equals("确定")&&cl.WarMode.equals("null"))
		{
			JOptionPane.showMessageDialog(null, "尚未开局");
		}
		
		
	}
		
	}


