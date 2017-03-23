package exp1;

class Outer {
      private int x=1;
      public void print(){
    	  Inner inner =new Inner();
    	  inner.display();
      }
      class Inner{
    	  private int y=2;
    	  private void display(){
    		  System.out.println("Inner:"+x++);
    	  }
      }
}
public class Exp1{
	public static void main(String arg[])
	{
		Outer outer =new Outer();
		outer.print();
	}
	
}
