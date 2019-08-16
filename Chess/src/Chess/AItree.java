package Chess;

import java.awt.Point;

public class AItree {

	public Integer value;
	public Point point;
	public AItree [][] childs;
	public AItree  left;
	public AItree [][] right;
	public AItree(int x,int y,Integer value)
	{
		point=new Point(x,y);
		this.value=value;
	}
}
