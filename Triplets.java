
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Triplets {

	/*
	 * Complete the solve function below.
	 */
	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
        int Alice=0,Bob=0;   
        int[] Result=new int[2];
        int Rating[]={a0,a1,a2,b0,b1,b2};
        try {
        	for(int i=0 ; i < Rating.length ; i++) {
                if(!(Rating[i]>1 && Rating[i]<100))
                {
                    throw new Exception();
                }
            }
       
        for(int i=0;i < Rating.length; i++){
            for(int j=i+3; j < Rating.length; j+=3)
            {
                if(Rating[i]>Rating[j]){
                    Alice+=1;
                }
                else if(Rating[i]<Rating[j]){
                    Bob+=1;
                }
                else{
                    continue;
                }
            }
          
        }
        }
        catch(Exception e) {
        	System.out.println("Exception occurs");
        }
        Result[0] = Alice;
        Result[1] = Bob;
        return Result;
    }

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] a0A1A2 = scan.nextLine().split(" ");

		int a0 = Integer.parseInt(a0A1A2[0].trim());

		int a1 = Integer.parseInt(a0A1A2[1].trim());

		int a2 = Integer.parseInt(a0A1A2[2].trim());

		String[] b0B1B2 = scan.nextLine().split(" ");

		int b0 = Integer.parseInt(b0B1B2[0].trim());

		int b1 = Integer.parseInt(b0B1B2[1].trim());

		int b2 = Integer.parseInt(b0B1B2[2].trim());

		int[] result = solve(a0, a1, a2, b0, b1, b2);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bw.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bw.write(" ");
			}
		}

		bw.newLine();

		bw.close();
	}
}
