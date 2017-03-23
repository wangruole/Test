package exp3;
class OuteR{
	private int i=0;
	public OuteR(int i){
		this.i=i;
	}
	public void print(){
		System.out.println("Outer:"+i);
		
	}
	public class Inner{
		private int j=0;
		public Inner(int j){
			this.j=j;
		}
		public void print(){
			System.out.println("Inner:"+i+","+j);
		}
	}
}
public class Exp3 {
    public static void main(String args[])
    {
    	OuteR outer=new OuteR(10);
    	outer.print();
    	OuteR.Inner inner=outer.new Inner(20);
    	inner.print();
    }
}
