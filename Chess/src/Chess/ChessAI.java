package Chess;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class ChessAI implements Chess_config{

	
	
	
	public static HashMap<String,Integer>map=new HashMap<String,Integer>();
	       static {
	    	   
	    	   /*
	    	    * 停止计算有两种情况
	    	    * 1.到达边界
	    	    * 2.出现异子
	    	    * 3.数据不足，代码来凑
	    	    */
	    	   
	    	   map.put("0",0 );
	    	   map.put("00",10);
	    	   map.put("000", 20);
	    	   map.put("0000",30 );
	    	   map.put("00000",40 );
	 
	    	   map.put("01",100 );
	    	   map.put("02", 200);
	    	   
	    	   map.put("001", 45);
	    	   map.put("002", 50);
	    	   map.put("011", 250);
	    	   map.put("010", 200);
	    	   map.put("020", 400);
	    	   map.put("022", 500);
	    	   
	    	   map.put("0001",5 );
	    	   map.put("0002", 10);
	    	   map.put("0011", 150);
	    	   map.put("0022", 300);
	    	   map.put("0010", 50);
	    	   map.put("0020", 100);
	    	   map.put("0111", 500);
	    	   map.put("0222", 800);
	    	   map.put("0220", 1000);
	    	   map.put("0110", 450);
	    	   map.put("0202", 800);
	    	   map.put("0101", 400);
	    	   
	    	   map.put("00000", 10);
	    	   map.put("00001", 10);
	    	   map.put("00010", 10);
	    	   map.put("00100", 20);
	    	   map.put("01000", 50);
	    	   map.put("00002", 10);
	    	   map.put("00020", 10);
	    	   map.put("00200", 10);
	    	   map.put("02000", 10);
	    	   map.put("01100", 500);
	    	   map.put("01010", 500);
	    	   map.put("01001", 500);
	    	   map.put("00110", 100);
	    	   map.put("00101", 100);
	    	   map.put("00011", 100);
	    	   map.put("02200", 500);
	    	   map.put("02020", 500);
	    	   map.put("02002", 500);
	    	   map.put("00220", 200);
	    	   map.put("00202", 200);
	    	   map.put("00022", 10);
	    	   map.put("00111", 400);
	    	   map.put("01011", 500);
	    	   map.put("01101", 500);
	    	   map.put("01110", 4000);
	    	   map.put("00222", 4000);
	    	   map.put("02022", 4000);
	    	   map.put("02202", 1000);
	    	   map.put("02220", 2000);
	    	   map.put("01111", 100000);
	    	   map.put("02222", 100000);
	    	   
	    	   map.put("000001", 10);
	    	   map.put("000010", 10);
	    	   map.put("000100", 10);
	    	   map.put("001000", 10);
	    	   map.put("010000", 200);	   
	    	   map.put("011000", 400);
	    	   map.put("010100", 200);
	    	   map.put("010010", 100);
	    	   map.put("010001", 100);
	    	   map.put("001100", 100);
	    	   map.put("001010", 100);
	    	   map.put("001001", 10);
	    	   map.put("000110", 50);
	    	   map.put("000101", 50);
	    	   map.put("000011", 30);
	    	   
	    	   map.put("000002", 10);
	    	   map.put("000020", 10);
	    	   map.put("000200", 10);
	    	   map.put("002000", 10);
	    	   map.put("020000", 20);	   
	    	   map.put("022000", 500);
	    	   map.put("020200", 100);
	    	   map.put("020020", 50);
	    	   map.put("020002", 50);
	    	   map.put("002200", 200);
	    	   map.put("002020", 200);
	    	   map.put("002002", 200);
	    	   map.put("000220", 10);
	    	   map.put("000202", 10);
	    	   map.put("000022", 10);
	    	   
	    	   map.put("000111", 100);
	    	   map.put("001011", 100);
	    	   map.put("001101", 10);
	    	   map.put("001110", 200);
	    	   map.put("010011", 300);	   
	    	   map.put("010101", 300);
	    	   map.put("010110", 300);
	    	   map.put("011001", 300);
	    	   map.put("011010", 300);
	    	   map.put("011100", 8000);
	    	   map.put("000222", 50);
	    	   map.put("002022",50 );
	    	   map.put("002202", 50);
	    	   map.put("002220", 50); 
	    	   map.put("020022", 200);	   
	    	   map.put("020202", 200);
	    	   map.put("020220", 200);
	    	   map.put("022002", 300);
	    	   map.put("022020", 400);
	    	   map.put("022200", 10000);	    	   
	    	   map.put("011110", 50000);
	    	   map.put("011101", -10);
	    	   map.put("011011", -10);
	    	   map.put("010111", -10);
	    	   map.put("001111", -10);	    	   
	    	   map.put("022220", 300000);
	    	   map.put("022202", -10);
	    	   map.put("022022", -10);
	    	   map.put("020222", -10);
	    	   map.put("002222", -10);
	       }
	
	       
	public void ValueCount()               
	{
		   /*
	        * AI 朝八个方向计算权值
	        */
	
			for(int i=0;i<Rows;i++)
			{
				for(int j=0;j<Column;j++)
				{
					if(array[i][j].now==0) 
					{
						String code=countWESTcode(i,j);
						
						Integer value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						 code=countEASTcode(i,j);
						 value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						 code=countNORTHcode(i,j);
						 value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						 code=countSOUTHcode(i,j);
						 value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						 code=countENcode(i,j);
						 value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						 code=countEScode(i,j);
						 value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						 code=countWNcode(i,j);
						 value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						 code=countWScode(i,j);
						 value=map.get(code);
						if(value!=null) 
						{
							array[i][j].weight+=value;
						}
						array[i][j].weight+=countCollision(i,j);
						
					}
					
				}
			}
	}
	/*
	 * 冲四的特殊处理
	 */
	public Integer countCollision(int i,int j)
	{
		Integer value=0;
		/*
		 * 东西冲二四
		 */
		if(i+2<Rows&&i-2>=0)
		{
		if(array[i+1][j].now==1&&array[i+2][j].now==1&&array[i-1][j].now==1&&array[i-2][j].now==1) value+=20000;
		if(array[i+1][j].now==2&&array[i+2][j].now==2&&array[i-1][j].now==2&&array[i-2][j].now==2)value+=100000;
		}
		/*
		 * 南北冲二四
		 */
		if(j+2<Rows&&j-2>=0)
		{
		if(array[i][j+1].now==1&&array[i][j+2].now==1&&array[i][j-1].now==1&&array[i][j-2].now==1) value+=20000;
		if(array[i][j+1].now==2&&array[i][j+2].now==2&&array[i][j-1].now==2&&array[i][j-2].now==2) value+=100000;
		}
		/*
		 * 西北冲二四	
		 */
		if(i+2<Rows&&i-2>=0&&j+2<Rows&&j-2>=0)
		{
		if(array[i-1][j-1].now==1&&array[i-2][j-2].now==1&&array[i+1][j+1].now==1&&array[i+2][j+2].now==1) value+=20000;
		if(array[i-1][j-1].now==2&&array[i-2][j-2].now==2&&array[i+1][j+1].now==2&&array[i+2][j+2].now==2) value+=100000;	
		}
		/*
		 * 东北冲二四	
		 */
		if(i+2<Rows&&i-2>=0&&j+2<Rows&&j-2>=0)
		{
		if(array[i+1][j-1].now==1&&array[i+2][j-2].now==1&&array[i-1][j+1].now==1&&array[i-2][j+2].now==1) value+=20000;
		if(array[i+1][j-1].now==2&&array[i+2][j-2].now==2&&array[i-1][j+1].now==2&&array[i-2][j+2].now==2) value+=100000;	
		}
			
		/*
		 * 东西冲一三四
		 */
		if(i-3>=0&&i+1<Rows)
		{
		if(array[i+1][j].now==1&&array[i-1][j].now==1&&array[i-2][j].now==1&&array[i-3][j].now==1) value+=20000;
		if(array[i+1][j].now==2&&array[i-1][j].now==2&&array[i-2][j].now==2&&array[i-3][j].now==2) value+=100000;
		}
		if(i+3<Rows&&i-1>=0)
		{
		if(array[i+1][j].now==1&&array[i+2][j].now==1&&array[i+3][j].now==1&&array[i-1][j].now==1) value+=20000;
		if(array[i+1][j].now==2&&array[i+2][j].now==2&&array[i+3][j].now==2&&array[i-1][j].now==2) value+=100000;
		}
		/*
		 * 南北冲一三四
		 */
		if(j+3<Rows&&j-1>=0)
		{
		if(array[i][j+1].now==1&&array[i][j+2].now==1&&array[i][j+3].now==1&&array[i][j-1].now==1) value+=20000;
		if(array[i][j+1].now==2&&array[i][j+2].now==2&&array[i][j+3].now==2&&array[i][j-1].now==2) value+=100000;
		}
		if(j+1<Rows&&j-3>=0)
		{
		if(array[i][j-1].now==1&&array[i][j-2].now==1&&array[i][j-3].now==1&&array[i][j+1].now==1) value+=20000;
		if(array[i][j-1].now==2&&array[i][j-2].now==2&&array[i][j-3].now==2&&array[i][j+1].now==2) value+=100000;
		}
		/*
		 * 西北冲一三四
		 */
		if(i+3<Rows&&i-1>=0&&j+3<Rows&&j-1>=0)
		{
		if(array[i-1][j-1].now==1&&array[i+1][j+1].now==1&&array[i+2][j+2].now==1&&array[i+3][j+3].now==1) value+=20000;
		if(array[i-1][j-1].now==2&&array[i+1][j+1].now==2&&array[i+2][j+2].now==2&&array[i+3][j+3].now==2) value+=100000;
		}
		if(i+1<Rows&&i-3>=0&&j+1<Rows&&j-3>=0)
		{
		if(array[i-1][j-1].now==1&&array[i-2][j-2].now==1&&array[i-3][j-3].now==1&&array[i+1][j+1].now==1) value+=20000;
		if(array[i-1][j-1].now==1&&array[i-2][j-2].now==1&&array[i-3][j-3].now==1&&array[i+1][j+1].now==1) value+=100000;
		}
		/*
		 * 东北冲一三四
		 */
		if(i+3<Rows&&i-1>=0&&j+1<Rows&&j-3>=0)
		{
		if(array[i+1][j-1].now==1&&array[i+2][j-2].now==1&&array[i+3][j-3].now==1&&array[i-1][j+1].now==1) value+=20000;
		if(array[i+1][j-1].now==1&&array[i+2][j-2].now==1&&array[i+3][j-3].now==1&&array[i-1][j+1].now==1) value+=100000;
		}
		if(i+1<Rows&&i-3>=0&&j+3<Rows&&j-1>=0)
		{
		if(array[i-1][j+1].now==1&&array[i-2][j+2].now==1&&array[i-3][j+3].now==1&&array[i+1][j-1].now==1) value+=20000;
		if(array[i-1][j+1].now==1&&array[i-2][j+2].now==1&&array[i-3][j+3].now==1&&array[i+1][j-1].now==1) value+=100000;
		}
		
		return value;
	}
	 
	public String countWESTcode(int i,int j)    //   AI 向西计算权值的方法
	{
		String code="0";
		for(int m=i-1;m>=0;m--)
		{   if(m==i-6)break;
			if(array[m][j].now==1&&code.contains("2")) break;
			if(array[m][j].now==2&&code.contains("1")) break;	
			code +=array[m][j].now;
		}
		return code;
	}
	public String countEASTcode(int i,int j)    //   AI 向东计算权值的方法
	{
		String code="0";
		for(int m=i+1;m<Rows;m++)
		{
			if(m==i+6)break;
			if(array[m][j].now==1&&code.contains("2")) break;
			if(array[m][j].now==2&&code.contains("1")) break;	
			code +=array[m][j].now;
		}
		return code;
	}
	public String countNORTHcode(int i,int j)   //   AI 向北计算权值的方法
	{
		String code="0";
		for(int m=j-1;m>=0;m--)
		{
			if(m==j-6)break;
			if(array[i][m].now==1&&code.contains("2")) break;
			if(array[i][m].now==2&&code.contains("1")) break;	
			code +=array[i][m].now;
		}
		return code;
	}
	public String countSOUTHcode(int i,int j)   //   AI 向南计算权值的方法
	{
		String code="0";
		for(int m=j+1;m<Rows;m++)
		{
			if(m==j+6)break;
			if(array[i][m].now==1&&code.contains("2")) break;
			if(array[i][m].now==2&&code.contains("1")) break;	
			code +=array[i][m].now;
		}
		return code;
	}
	public String countWNcode(int i,int j)   //   AI 向西北计算权值的方法
	{
		String code="0";
		for(int m=i-1,n=j-1;m>=0&&n>=0;m--,n--)
		{
			if(m==i-6)break;
			if(array[m][n].now==1&&code.contains("2")) break;
			if(array[m][n].now==2&&code.contains("1")) break;	
			code +=array[m][n].now;
		}
		return code;
	}
	public String countENcode(int i,int j)   //   AI 向东北算权值的方法
	{
		String code="0";
		for(int m=i+1,n=j-1;m<Rows&&n>=0;m++,n--)
		{
			if(m==i+6)break;
			if(array[m][n].now==1&&code.contains("2")) break;
			if(array[m][n].now==2&&code.contains("1")) break;	
			code +=array[m][n].now;
		}
		return code;
	}
	public String countWScode(int i,int j)   //   AI 向西南算权值的方法
	{
		String code="0";
		for(int m=i-1,n=j+1;m>=0&&n<Rows;m--,n++)
		{
			if(m==i-6)break;
			if(array[m][n].now==1&&code.contains("2")) break;
			if(array[m][n].now==2&&code.contains("1")) break;	
			code +=array[m][n].now;
		}
		return code;
	}
	public String countEScode(int i,int j)   //   AI 向东南算权值的方法
	{
		String code="0";
		for(int m=i+1,n=j+1;m<Rows&&n<Rows;m++,n++)
		{
			if(m==i+6)break;
			if(array[m][n].now==1&&code.contains("2")) break;
			if(array[m][n].now==2&&code.contains("1")) break;	
			code +=array[m][n].now;
		}
		return code;
	}
	
	
	
	public void AIplay(Graphics g)           //   AI 开始下棋
	{
		int m=0;
		int n=0;
		/*
		 * 找到第一个未下棋子的地方
		 */
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			{
				if(array[i][j].now==0)
				{
					
					m=i;
					n=j;
					break;
				}
			}
		}
		Integer MAXvalue=array[m][n].weight;
		/*
		 * 找到最大权值的坐标
		 */
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			{
				if(array[i][j].weight>MAXvalue&&array[i][j].now==0) 
				{
					MAXvalue=array[i][j].weight;
					m=i;
					n=j;
				}
			}
		}
		g.setColor(Color.white);
		g.fillOval(array[m][n].x-(int)(0.5*ChessSize), array[m][n].y-(int)(0.5*ChessSize), ChessSize, ChessSize);
		array[m][n].now=2;
		/*
		 * 权值归零
		 */
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Column;j++)
			{
				array[i][j].weight=0;
			}
		}
		
	}
	
}
