
public class Test3 {

	public static void main(String[] args) {
		
		int[][] v = {{1,1},{2,2},{1,2}};
		int[] result = new int[2];
		
		for(int i=0;i<2;i++) {
			
			int thisNum=v[0][i];
			boolean check = false;
			for(int j=1;j<3;j++) {
				if(thisNum == v[j][i]) {
					check=true;
					if(j==1)
						result[i]=v[2][i];
					else
						result[i]=v[1][i];
				}
			}//for end
			if(!check)
				result[i]=v[0][i];
		}//for end

		System.out.println("y= "+result[0]+" x="+result[1]);
		
	}//main() end
}//class end