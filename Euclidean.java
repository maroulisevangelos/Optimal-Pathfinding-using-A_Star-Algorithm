import java.lang.Math;
import java.io.*;
import java.util.*;

public class Euclidean {
	
	public static double EuclideanDistance(int x1,int y1,int x2,int y2) {	//Calculates the Euclidean Distance between two nodes
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	//distance = ((x2 - x1)^ 2 + (y2 - y1)^2)^1/2
    	return distance;
	}
	
	public static void main(String[] args) {
			
			int ox,oy;	//coordinates of the node which is over the current node
			int ux,uy;	//coordinates of the node which is under the current node
			int bx,by;	//coordinates of the node which is behind the current node
			int fx,fy;	//coordinates of the node which is in front of the current node
			double od,ud,bd,fd;	//distance from the neighbors to the end
			double mind;	//min distance from the neighbors to the end
			int nx,ny;	//coordinates of the next node
			int [][] table;	//table that contains the nodes
			int z,index; //variables which help print and store nodes in the table
			int xs, ys;	//coordinates of the start node
			int xe, ye;	//coordinates of the end node
			int lx, ly;	//length of lines and columns
			int steps = 0;	//number of steps
			int cost = 0;	//cost of the path
			boolean flag = false;	//flag for deadlock
			List<int[]> path = new ArrayList<int[]>();	//list which contains the path
			
			
			Scanner sc= new Scanner(System.in);	//System.in is a standard input stream  
			System.out.print("Enter the name of the text file you want to give as input (without the <<.txt>>): ");  
			String str= sc.nextLine();	//reads the name 
			str += ".txt";
			sc.close();
			
			try {
				
				File myObj = new File(str);
			    Scanner myReader = new Scanner(myObj);  
				String data = myReader.nextLine();	//read the first line and save lx and ly
				data += ' ';
				lx = Integer.parseInt(String.valueOf(data.charAt(0)));	
				if (data.charAt(1)!=' ') {
					lx = lx*10+Integer.parseInt(String.valueOf(data.charAt(1)));
					ly = Integer.parseInt(String.valueOf(data.charAt(3)));	
					if (data.charAt(4)!=' ') {
						ly = ly*10+Integer.parseInt(String.valueOf(data.charAt(4)));
					}
				}else {
					ly = Integer.parseInt(String.valueOf(data.charAt(2)));
					if (data.charAt(3)!=' ') {
						ly = ly*10+Integer.parseInt(String.valueOf(data.charAt(3)));
					}
				}
				
				table = new int [lx][ly];	//create the table
				
				for (int i=0;i<lx;i++) {	//save the nodes in the table
					data = myReader.nextLine();
					for (int y=0;y<ly;y++) {
						table[i][y] = Integer.parseInt(String.valueOf(data.charAt(y))); 
					}
				}
				
				data = myReader.nextLine();	//save xs and ys
				data += ' ';
				xs = Integer.parseInt(String.valueOf(data.charAt(0)));
				if (data.charAt(1)!=' ') {
					xs = xs*10+Integer.parseInt(String.valueOf(data.charAt(1)));
					ys = Integer.parseInt(String.valueOf(data.charAt(3)));
					if (data.charAt(4)!=' ') {
						ys = ys*10+Integer.parseInt(String.valueOf(data.charAt(4)));
					}
				}else {
					ys = Integer.parseInt(String.valueOf(data.charAt(2)));
					if (data.charAt(3)!=' ') {
						ys = ys*10+Integer.parseInt(String.valueOf(data.charAt(3)));
					}
				}
				
				int cx = xs;	//first value of current x is the start x
				int cy = ys;	//first value of current y is the start y
				
				data = myReader.nextLine();	//save xe and ye
				data += ' ';
				xe = Integer.parseInt(String.valueOf(data.charAt(0)));
				if (data.charAt(1)!=' ') {
					xe = xe*10+Integer.parseInt(String.valueOf(data.charAt(1)));
					ye = Integer.parseInt(String.valueOf(data.charAt(3)));
					if (data.charAt(4)!=' ') {
						ye = ye*10+Integer.parseInt(String.valueOf(data.charAt(4)));
					}
				}else {
					ye = Integer.parseInt(String.valueOf(data.charAt(2)));
					if (data.charAt(3)!=' ') {
						ye = ye*10+Integer.parseInt(String.valueOf(data.charAt(3)));
					}
				}
				
			    myReader.close();	//close the text file
			
			    long start = System.nanoTime();	//start counting the time of the production of solution
			    
			    path.add(new int[] { cx, cy });	//add to the path the start node
			    table[cx][cy] = -1;	//mark that you have been to the start node
			    while (cx != xe || cy!= ye) {
			    	table[cx][cy]=-1;	//mark that you have been to this node
					if (cx>0 && table[cx-1][cy]!=1) {	//find if there is a node over the current that i can visit
						ox = cx-1;
						oy = cy;		 
					}else {	//mark that there is not
						ox=-1;
						oy=-1;
					}
					if (cx<lx-1 && table[cx+1][cy]!=1) {	//find if there is a node under the current that i can visit
						ux = cx+1;
						uy = cy;		 
					}else {	//mark the there is not
						ux=-1;
						uy=-1;
					}
					if (cy>0 && table[cx][cy-1]!=1) {	//find if there is a node before the current that i can visit
						bx = cx;
						by = cy-1;
					}else {	
						bx=-1;
						by=-1;
					}
					if (cy<ly-1 && table[cx][cy+1]!=1) {	//find if there is a node in front of the current that i can visit
						fx = cx;
						fy = cy+1;
					}else {	//mark that there is not
						fx=-1;
						fy=-1;
					}
					if (ox!=-1) {	
						od = EuclideanDistance(xe,ye,ox,oy);	//calculate the distance from the over node to the end
					}else {
						od = 200;	//value that cannot be take because max table is 99*99
					}
					if (ux!=-1) {	
						ud = EuclideanDistance(xe,ye,ux,uy);	//calculate the distance from the under node to the end
					}else {
						ud = 200;	//value that cannot be take because max table is 99*99
					}
					if (bx!=-1) {
						bd = EuclideanDistance(xe,ye,bx,by);	//calculate the distance from the before node to the end
					}else {
						bd = 200;	//value that cannot be take because max table is 99*99
					}
					if (fx!=-1) {
						fd = EuclideanDistance(xe,ye,fx,fy);	//calculate the distance from the front node to the end
					}else {
						fd = 200;	//value that cannot be take because max table is 99*99
					}
					
					mind = 200;	//----
					nx = 100;	//--initialize the variables
					ny = 100;	//----
					
					//find the minimum distance and the coordinates of the next node 
					if (ox != -1) {
						if (cost + od< cost +mind && table[ox][oy]!=-2) {	//check if this distance is less than min and that this is not an abandoned node 
							mind = od;
							nx = ox;
							ny = oy;
						}
					}
					if (ux!=-1) {
						if (cost + ud<cost + mind && table[ux][uy]!=-2) {	//check if this distance is less than min and that this is not an abandoned node
							mind=ud;
							nx = ux;
							ny = uy;
						}
					}
					if (bx != -1) {
						if ((cost +bd<cost +mind || bd==mind) && table[bx][by]!=-2) {	//check if this distance is less than min and that this is not an abandoned node
							mind = bd;													//there is priority to the node of the same line
							nx = bx;
							ny = by;
						}
					}
					if (fx != -1) {
						if ((cost +fd<cost +mind || fd==mind) && table[fx][fy]!=-2) {	//check if this distance is less than min and that this is not an abandoned node
							mind = fd;													//there is priority to the node of the same line
							nx = fx;
							ny = fy;
						}
					}
					
					if (nx==100 && ny==100) {	//check for deadlock
						flag = true;
						break;
					}
					
					if (table[nx][ny]==-1) {	//go back to an opened node
						table[cx][cy]=-2;		//mark that you went back from the current node
						cost -=2;				//update the cost of the path
						cx = nx;
						cy = ny;
						index = path.size() - 1;
						path.remove(index);		//remove the node from the path
					}else {		//go to a closed node
						cx = nx;
						cy = ny;
						path.add(new int[] { cx, cy });	//add the node to the path
					}
					steps += 1;	//update the steps
					cost += 1;	//update the cost of the path until now
				}
			    
				long end = System.nanoTime();	//stop counting time
				
				if (flag!=true) {	//if there was not a deadlock
					System.out.print("Path: {");
					z=0;
					for (int[] eachRow : path) {	//print the path
						if (z!=0) {
							System.out.print(", ");
						}
			            System.out.print(Arrays.toString(eachRow));
			            z+=1;
					}
					System.out.println("}");
					
					
				} else {	//there was a deadlock
					System.out.println("There is not solution for this one!");
				}
				
				//System.out.println("Steps = "+steps);	//print the number of steps
				long execution = end - start;	//calculate the total time 
				//System.out.println("Execution time: " + execution + " nanoseconds");	//print the time
				
			} catch (FileNotFoundException e) {	//exception 
		    	System.out.println("An error occurred.");
		    	e.printStackTrace();
	    }
	}
}