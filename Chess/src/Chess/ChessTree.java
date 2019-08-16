package Chess;

import java.awt.Point;

public class ChessTree implements Chess_config{
    

	
	public Feng [][] test;
	public AItree [][]tree_list;
	/*
	 * 输入虚拟棋盘
	 */
	public void input()
	{
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Rows;j++)
			{
				test[i][j]=new Feng(array[i][j].x,array[i][j].y,array[i][j].now);
			}
		}
	}
	/*
	 * 构造博弈树
	 */
	public void preTree(Feng test [][],AItree [][]tree_list,int max,int min,int step)
	{
	if(step==1) return ;
	if(step%2==0) {
		
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			{
				if(test[i][j].now==0)
				{
				tree_list[i][j].value=pointvalue(i,j, test);
				test[i][j].now=1;
				tree_list[i][j].childs=new AItree[Rows][Column];
				preTree(test,tree_list[i][j].childs,1,0,step-1);
				}
			}
		}	
	}
	
	else {
		
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			{
				if(test[i][j].now==0)
				{
				tree_list[i][j].value=pointvalue(i,j,array);
				test[i][j].now=2;
				tree_list[i][j].childs=new AItree[Rows][Column];
				preTree(test,tree_list[i][j].childs,1,0,step-1);
				}
			}
		}	
	}
	}
	private Integer pointvalue(int i, int j, Feng[][] array) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 往回查找返回最佳位置
	 */
	public void Recursion(int step,Integer max,Integer min,AItree [][]tree_list,AItree f)
	{   if(step<=1)  return ;
		if(step%2==0) {
			
		}
		
		
		else {
			
		}
			
	}
	
	

	
	
}
