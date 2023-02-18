
public class SystemControl {
	public static void main(String[] args) {
		
		//Room r = new Room();
		int N =24,M =28;	
		
		Room.setRoom(N,M,2,3);
		
		
	
		while(Room.randomWalk(Room.lastx,Room.lasty,N,M,Room.lastmove) == false);
		
		
		
		
		
		}
}
