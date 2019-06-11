
public class ValidNumber {
	
	 public boolean isNumber(String s) {
	        if(s=="") return false;
//	        if(s.charAt(0)=='-'||s.charAt(0)=='+'){
//	            if(s.length()>1) s=s.substring(1);
//	            else return false;
//	        }
	        while(s.charAt(0)==' '){
	            if(s.length()>1) s = s.substring(1);
	            else return false;
	        }
	        
	        if((s.charAt(0)=='-'||s.charAt(0)=='+')){
	            if(s.length()>1) s=s.substring(1);
	            else return false;
	        }
	        if(s.charAt(0)==' ') return false;
	        int counter=0;
	        int firtswhitespace=0;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)==' '){
	                if(counter==0) firtswhitespace=i;
	                counter++;
	            }
	        }
	        if(counter!=0){
	            if(s.substring(0,firtswhitespace).length()+counter==s.length()) s=s.substring(0,firtswhitespace);
	        }
	        if(s.charAt(s.length()-1)=='f') return false;
	        try{
	            double d = Double.parseDouble(s);
	            return true;
	        }
	        catch(NumberFormatException e){
	            return false;
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("959440.94f"));

	}

}
