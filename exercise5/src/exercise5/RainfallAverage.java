package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * This program demonstrate reading data from a file using FileInputStream
 * and calculate the average of the data.
 * 
 * 1. Construct Writer object
 * 2. Read data from file rainfall_data.bin
 * 3. Calculate total of the data
 * 4. calculate average of the data
 * 5. Display average
 * 
 * @author Rose Asnarizza Nahar
 * 
 */ 

public class RainfallAverage {

	private int total=0;
	private int average = 0;
	private int day = 6;
	private String filename;
	
	//constructor
	public RainfallAverage(String filename) {
		this.filename = filename;
	}
	
	//method to calculate average of rainfall at Simpang Ampat
	public void calculateAvg() {
		
		try (
				
			//1. Construct input stream object	
			DataInputStream inputStream = new DataInputStream(new FileInputStream(filename))) 
			{
			
			//2. Read data from file rainfall_data.bin
			for (int i = 0; i < 6; i++) {
				int rain = inputStream.readInt();
				
				//3. Calculate total of the data
				total += rain;
			
			}
			
			//close stream
			inputStream.close();
			
			//4. Calculate average of the data 
			average = total / day;
			
			//5. Display average
			System.out.println("Average rainfall from station Simpang Ampat : " + average);
			System.out.println();
			
		} catch (IOException e) {
			
			//if there are error, this message will be displayed
			System.out.println("An error occurred while reading the rainfall data: " + e.getMessage());
		}
		
			
	}


}