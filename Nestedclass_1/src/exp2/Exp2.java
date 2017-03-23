package exp2;

public class Exp2 {
    innerClass in =new innerClass();
    public void ouf(){
    	in.inf();
    }
    class innerClass{
    	innerClass(){
    		
    	}
    	public void inf(){
    	
    	}
    	int y=0;
    }
    public innerClass doit(){
    	in.y=4;
    	return new innerClass();
    }
    public static void main(String args[]){
    	Exp2 out=new Exp2();
    	Exp2.innerClass in=out.doit();
    	
    }
    
}
