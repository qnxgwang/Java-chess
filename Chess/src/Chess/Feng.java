package Chess;

public class Feng {

	
	
	public  int  x;
	public  int  y;
	public  int  now;
	public  int  weight;
	public  String step="";
	public Feng arr[][];
	/*
	 *   now=0  :   ÎÞÆå
	 *   now=1  :   ºÚÆå
	 *   now=2  :   °×Æå
	 */
	
	
	public Feng(int x,int y,int now)
	{
		this.x=x;
		this.y=y;
		this.now=now;
	}
}
