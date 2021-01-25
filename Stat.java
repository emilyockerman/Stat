/*
* Stat.java
* Author: Emily Ockerman
* Submission Date: November 8, 2018
*
* Purpose: Creates a class that describes the actions and attributes of objects of type stat.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
CSCI 1301: Project 4 Page 5
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

public class Stat {

	//VARIABLE DECLARATION
	private double[] data;
	
	//CONSTRUCTORS
	//default: creates default values for the object if the user doesn't provide any
	public Stat()
	{
		double[] data = {0.0};
		this.data = data;
	}
	
	//custom: when the user has array values
	public Stat(double[] d)
	{
		data = new double[d.length];
		for(int i = 0; i < d.length; i++)
		{
			data[i] = d[i];
		}
	}
	
	
	//GET DATA VALUES
	//should return a COPY of the data array so we can't edit the OG
	public double[] getData()
	{
		double[] temp = new double[data.length]; //creates a new temporary array that returns the values of the OG array
		for(int i = 0; i < data.length; i++ )
		{
			temp[i] = data[i]; //assigns every value in array a matching value of OG array
		}
		return temp;
	}
	
	//SET DATA VALUES
	//creates a copy of the array d and assigns it to data a reference to the copy
	public void setData(double[] d)
	{
		data = new double[d.length]; //creates a new array containing copies of the values in the OG array
		for(int i = 0; i < d.length; i++)
		{
			data[i] = d[i]; //assigns every value in array a matching value of OG array
		}
	}
	
	
	//EQUALS METHOD
	//compares two arrays and returns true or false based on whether they have matching data values
	public boolean equals(Stat s) 
	{
		Stat d = this;
		if (d.data.length != s.data.length) //to make sure they have the same # of values
		{
			return false;
		}
		else
		{
		for (int i = 0; i < d.data.length; i++) //proceed if we know they're of equal length
		{
			if (d.data[i] != s.data[i])
			{
				return false;
			}
		}
		return true;
		}
	}
	
	
	//TO STRING METHOD
	//returns the data contained in an array to the user
	public String toString()
	{
		String string = "";
		Stat d = this;
		//write a for loop that goes through and prints every value of the array
		for (int i = 0; i < d.data.length; i++)
		{
			if (i == d.data.length - 1)
			{
				string += d.data[i];
			}
			else
			{
				string += d.data[i] + ", ";
			}
		}
		return "[" + string + "]";
	}
	
	
	//MIN METHOD
	//returns the smallest value in an array
	public double min()
	{
		Stat d = this;
		double smallest = d.data[0];
		//scans array and takes the value and compares it to the next one; drops that value and takes the new one instead if it's smaller, then scans next one. if that one is smaller etc etc
		for(int i = 0; i < d.data.length; i++)
		{
			if (smallest > d.data[i])
			{
				smallest = d.data[i];
			}
		}
		return smallest;
	}
	
	
	//MAX METHOD
	//returns the largest number in an array
	public double max()
	{
		Stat d = this;
		double biggest = d.data[0];
		//scans array just like min does and takes val and compares
		for(int i = 0; i < d.data.length; i++)
		{
			if (biggest < d.data[i])
			{
				biggest = d.data[i];
			}
		}
		return biggest;
	}
	
	
	//AVERAGE METHOD
	//returns the average for a double[] data
	public double average()
	{
		Stat d = this;
		double average = d.data[0];
		//scans array and adds up all the values then divides them by the length of the array
		for (int i = 1; i < d.data.length; i++)
		{
			average += d.data[i];
		}
		average = average/d.data.length;
		return average;
	}
	
	
	//MODE METHOD
	//returns the mode if there is one.
	public double mode()
	{
		Stat d = this;
		int greatestNumOfOccur = 0;
		double mode = d.data[0];
		//int[] counts = new int[4];
		//takes value in array and scans to look for other instances of the value. keeps a running count of these instances
		//maybe have two variables for mode and scan and compare and scan and compare and whichever one has the most instances is the output?
		for (int i = 0; i < d.data.length; i++)
		{
			int count = 0;
			for (int s = i+1; s < d.data.length; s++)
			{
				if (d.data[i] == d.data[s])
				{
					count++;
				}
			}
			//if there's only one number in array
			if(d.data.length == 1)
			{
				mode = d.data[0];
			}
			//compares this count with the past biggest count
			if(count > greatestNumOfOccur)
			{
				greatestNumOfOccur = count;
				mode = d.data[i];
				
			}
			//if they are equal then mode is NaN
			else if (greatestNumOfOccur == count && d.data.length != 1)
			{
				mode = Double.NaN;
			}
		}
		return mode;
	}
	
	//NOTES
	//have to add .data because it specifies that ur scanning and looking for the values. 
	//if you just said d and s then you would be comparing the memory addresses that refer to the array values, 
	//not the values themselves.
	
	
	
}
