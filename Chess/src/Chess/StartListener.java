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
		 * ���˶�ս�㷨
		 */
		if(jb.getActionCommand().equals("���¿�ʼ"))
					{
						cl.WarMode="���˶�ս";	 
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
		 * �˻���ս�㷨
		 */
		if(jb.getActionCommand().equals("���¿���"))
		            {
			   			cl.WarMode="�˻���ս";
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
		 * �����㷨
		 */
		
		if(jb.getActionCommand().equals("ȷ��")&&cl.WarMode.equals("���˶�ս"))
        {
			   if(!cl.win.equals("false")) JOptionPane.showMessageDialog(null, "��ǰ�Ծ��ѽ���");
			   else if(cl.f!=null&&cl.num==0)
			     {
			     cl.f.now=0;
			     cl.c.repaint();
			     if(cl.turn==1)cl.turn=2;
			     else cl.turn=1;
			     cl.num=1;
			     }
        }
		else if(jb.getActionCommand().equals("ȷ��")&&cl.WarMode.equals("�˻���ս"))
		{
			JOptionPane.showMessageDialog(null, "�˻���ս��ʱ���ɻ���");
		}
		else if(jb.getActionCommand().equals("ȷ��")&&cl.WarMode.equals("null"))
		{
			JOptionPane.showMessageDialog(null, "��δ����");
		}
		
		
	}
		
	}


