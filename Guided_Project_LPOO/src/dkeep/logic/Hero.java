package dkeep.logic;

public class Hero implements Character{

	private char HeroSprite;
	
	private int Hero_i;
	private int Hero_j;
	
	public Hero(int i,int j,char s){
		this.Hero_i=i;
		this.Hero_j=j;
		this.HeroSprite=s;
	}	
	
	public void move2(int i,int j){
		Hero_i +=i;
		Hero_j +=j;
	}
	
	public Club getClub(){
		Club c = new Club();
		return c;
	}
	
	public void move(){}
	public int getStun(){return 0;}
	public void setStun(int x) {} {}
	public void setCoordenateI(int i){this.Hero_i = i;}	
	public void setCoordenateJ(int j){this.Hero_j = j;}	
	public int getCoordenateI(){return Hero_i;}
	public int getCoordenateJ(){return Hero_j;}	
	public char getSprite(){return HeroSprite;}	
	public void setSprite(char s){HeroSprite = s;}
	public boolean hasClub(){return false;}
	
	
}
