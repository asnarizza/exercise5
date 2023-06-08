package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * This program demonstrate reading data from a file using FileInputStream
 * 
 * 1. Identify the source
 * 2. Construct input stream object
 * 3. Read the data
 * 4. Close the stream
 * 
 * @author Rose Asnarizza Nahar
 * 
 */
public class RainfallDisplay {

	private String fileName;

	//1. Identify the source
	public RainfallDisplay(String fileName) {
		this.fileName = fileName;
	}

	public void displayRainfallData() {
		
	
		try (
			
			//2. Construct input stream object
			DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
			System.out.println();
			System.out.println("---------------");
			System.out.println(" Rainfall Data");
			System.out.println("---------------");
			
			//3. Read the data 
			for (int i = 0; i < 6; i++) {
				int rainfall = inputStream.readInt();
				System.out.println("Day " + (i + 1) + ": " + rainfall + " mm");
				
			}
			
			//4. Close the stream
			inputStream.close();
			System.out.println();
			
		} catch (IOException e) {
			
			//if there an error, it will display this message.
			System.out.println("An error occurred while reading the rainfall data: " + e.getMessage());
		}
	}
}