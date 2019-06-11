package lab10part1;

public class EditDistanceDynamicProgram {
	
	int[][] D;
	
	public int findEditDistance(String s,String t) {
		int i = s.length();
		int j = t.length();
		D = new int[i+1][j+1];
		for(int k=1;k<i+1;k++) {
			for(int l=1;l<j+1;l++) {
				D[k][l]=-1;
			}
		}
		
		return recursiveED(s,t);
	}
	
	private int recursiveED(String s, String t) {
		if(s.length()==0) return t.length();
		if(t.length()==0) return s.length();
		int i = s.length();
		int j = t.length();
		if(D[i][j]!=-1) return D[i][j];
		if(s.charAt(i-1)==t.charAt(j-1)) {
			if(D[i-1][j-1]!=-1) {
				D[i][j] = D[i-1][j-1];
				
			}
			D[i][j] = recursiveED(s.substring(0, i-1),t.substring(0,j-1));			
		}
		else {
			if(D[i-1][j]==-1) D[i-1][j]= recursiveED(s.substring(0, i-2),t.substring(0,j-1));
			if(D[i][j-1]==-1) D[i][j-1]= recursiveED(s.substring(0, i-1),t.substring(0,j-2));
			if(D[i-1][j-1]==-1) D[i-1][j-1]= recursiveED(s.substring(0, i-2),t.substring(0,j-2));
			D[i][j] = min(D[i-1][j],D[i][j-1],D[i-1][j-1]) + 1;
		}
		return D[i][j];
	}
	
	private int min(int x,int y, int z) {
		if(x<=y && x<=z) return x;
		else if(y<=x && y<=z) return y;
		return z;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistanceDynamicProgram ed = new EditDistanceDynamicProgram();
		System.out.println(ed.findEditDistance("DUCK", "TUG"));

	}

}
