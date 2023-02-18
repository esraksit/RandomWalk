import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class Room {
	
	public static int lastx,lasty,lastmove=1;
	public static int [][] room;
	
	
	public static void setRoom(int N,int M,int x,int y) {
		room = new int[N][M];
		lastx=x;
		lasty=y;
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				room[i][j]=0;
			}
		}			
	}
	
	
	public static boolean randomWalk(int xBUG,int yBUG,int N ,int M,int move) {
				
		if((xBUG-1)<0 && (xBUG+1)<=(N-1)) { // alt sýnýrda sýkýntý varsa
			xBUG=ThreadLocalRandom.current().nextInt(0, xBUG+1 + 1);
		}
		else if((xBUG-1)>=0 && (xBUG+1)>(N-1)){//üst sýnýrda sýkýntý varsa
			xBUG=ThreadLocalRandom.current().nextInt(xBUG-1, (N-1)+ 1);
		}
		else if((xBUG-1)<0 && (xBUG+1)>(N-1)){ // ikisindede sýkýntý varsa
			xBUG=ThreadLocalRandom.current().nextInt(0, (N-1)+ 1);
		}
		else {
			xBUG=ThreadLocalRandom.current().nextInt(xBUG-1, xBUG+1 + 1);
		}
		
				
		
		if((yBUG-1)<0 && (yBUG+1)<=(M-1)) { // alt sýnýrda sýkýntý varsa
			yBUG=ThreadLocalRandom.current().nextInt(0, yBUG+1 + 1);
		}
		else if((yBUG-1)>=0 && (yBUG+1)>(M-1)){//üst sýnýrda sýkýntý varsa
			yBUG=ThreadLocalRandom.current().nextInt(yBUG-1, (M-1)+ 1);
		}
		else if((yBUG-1)<0 && (yBUG+1)>(M-1)){ // ikisindede sýkýntý varsa
			yBUG=ThreadLocalRandom.current().nextInt(0, (M-1)+ 1);
		}
		else {
			yBUG=ThreadLocalRandom.current().nextInt(yBUG-1, yBUG+1 + 1);
		}
		
		
		room[xBUG][yBUG]=room[xBUG][yBUG]+1;
		move++;
		
		if (move>50000) {
			System.out.println("not completed");
				return true;
		}
		
		
		if(!control(N,M)) {
			if(move%1000 == 0)
			{
			//	lastx=xBUG;
			//	lasty =yBUG;
			//	lastmove = move;
			//	System.out.println("lastx:"+lastx+" lasty:"+lasty +" lastmove:"+lastmove);
				return false;
			}else
			return randomWalk(xBUG,yBUG,N,M,move);

		}
		else {
			print(room, move, N , M);
			
			return true;
		}
		
		
	}
	
	
public static boolean control(int N ,int M) {
	
	boolean flag=true;
	
	for(int i =0;i<N;i++) {
		for(int j =0;j<M;j++) {
			if(room[i][j]==0) {
				flag=false;
				break;
			}			
		}
	}	
	
	if (flag==true) {
		return true;
	}
	else {
		return false;//dolmamýþ
	}		
}
	
public static void print( int [][] room,int move,int N , int M) {
	System.out.println("the total number of moves = "+ move);
	for(int i =0;i<N;i++) {
		for(int j =0;j<M;j++) {
			System.out.print(room[i][j]+" ");
		}
		System.out.println();
	}
	
}

	

}
