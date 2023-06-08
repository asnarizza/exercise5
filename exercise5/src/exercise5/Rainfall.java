package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program demonstrate writing data as byte using FileOutputStream.
 * 
 * 1. Declaration of file name
 * 2. Data of rainfall
 * 3. Construct output stream object
 * 4. Insert data into the file
 * 5. Flush the stream
 * 6. Close the stream
 * 
 * @author Rose Asnarizza Nahar
 *
 */

public class Rainfall {

	public static void main(String[] args) {

		//1. Declaration of file name
		String fileName = "rainfall.txt";
		
		//2. Data of rainfall
		int[] rainfallData = { 0, 4, 1, 0, 6, 19 };

		try (
			
			//3. Construct output stream object
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
			
			//4. Insert data into the file
			for (int rainfall : rainfallData) {
				outputStream.writeInt(rainfall);
			}
			
			//5. Flush the stream
			outputStream.flush();
			
			//6. Close the stream
			outputStream.close();
			
			//indicate if the program is success
			System.out.println("Data has been recorded to the file: " + fileName);

		} catch (IOException e) {
			
			//if there an error, it will display this message
			System.out.println("An error occurred while writing the rainfall data to the file: " + e.getMessage());
		}
		
		RainfallDisplay display = new RainfallDisplay("rainfall.txt");
		display.displayRainfallData();
		
		RainfallAverage avg = new RainfallAverage("rainfall.txt");
		avg.calculateAvg();
	}

}