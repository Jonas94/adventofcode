package dag3;

public class Dag3 {

	public static void main(String[] args) {
		String[][] board = new String[10000][10000];
		int x = 500;
		int a = 500;
		int tal = 1;
		int rowlength = 1;
		int collength = 1;
		board[x][a] = Integer.toString(tal);

		for(int snurra = 0; snurra < 400; snurra++){
			for(int i = 0; i < rowlength; i++){
				tal++;
				a++;
				board[x][a] = Integer.toString(tal);
			}
			rowlength++;
			for(int i = 0; i < collength; i++){
				tal++;
				x--;
				board[x][a] = Integer.toString(tal);
			}
			collength++;

			for(int i = 0; i < rowlength; i++){
				tal++;
				a--;
				board[x][a] = Integer.toString(tal);
			}
			rowlength++;
			for(int i = 0; i < collength; i++){
				tal++;
				x++;
				board[x][a] = Integer.toString(tal);
			}
			collength++;
		}
		int svarY = 0;
		int svarZ = 0;
		for(int y = 0;y<1000; y++){
			for(int z = 0;z<1000; z++){
				if(board[y][z] != null){
				if(board[y][z].equals("368078")){
					svarY = y-500;
					svarZ = z-500;
				}
				}
				System.out.printf(" %4s", board[y][z]);
			}
			System.out.println("");
			
		}
		System.out.println("SVARET: " + svarY +"," + svarZ);
	}
}
