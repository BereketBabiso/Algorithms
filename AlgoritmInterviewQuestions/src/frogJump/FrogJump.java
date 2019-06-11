package frogJump;

public class FrogJump {
	
	 public boolean canCross(int[] stones) {
	     if(stones.length==1) return true;
	     if(stones[1]-stones[0]!=1) return false;
		 boolean flag = true;
	        int unit=1;
	        int nextUnit=0;
	        for(int i=1;i<stones.length-1;i++){
	        	int j = unit +1;	
	        	int k = i+1;
	            nextUnit = stones[k]-stones[i];
	            if(j>nextUnit && i<stones.length-2) {
	            	//System.out.println("checking");
	            while(k<stones.length-2) {
	            	int temp = stones[k+1]-stones[i];
	            	 if(temp==unit-1||temp==unit||temp==unit+1) {
	            		 int x = stones[k+2]-stones[k+1];
	            		 System.out.println(x);
	            		 if(x!=temp-1&&x!=temp&&x!=temp+1) {
	            			 break;
	            		 }
	 	            	nextUnit=temp;
	 	            	System.out.println(nextUnit);
	 	            	i=k+1;
	 	            	k=i+1;
	 	            	
	 	            }
	            	 else {
	            		 if(nextUnit==unit-1||nextUnit==unit||nextUnit==unit+1) {
	     	            	unit=nextUnit;
	     	            	break;
	     	            }
	     	            else {
	     	            	flag=false;
	     	            	break;
	     	            }
	            	 }
	            	
	            }
	            }else {
	            if(nextUnit==unit-1||nextUnit==unit||nextUnit==unit+1) {
	            	unit=nextUnit;
	            }
	            else {
	            	flag=false;
	            	break;
	            }
	            }
	        }
	        return flag;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrogJump fj = new FrogJump();
		int[] stones = {0,1,3,5,6,8,12,17};
		int[] stones2 = {0,1,3,6,7};
		int[] stones3 = {0,1,3,6,10,13,15,16,19,21,25};
		int [] stones4 = {0,1,3,6,10,13,14};
		//System.out.println(fj.canCross(stones));
		System.out.println(fj.canCross(stones4));

	}

}
