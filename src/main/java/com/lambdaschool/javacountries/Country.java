package com.lambdaschool.javacountries;

public class Country
{
	// fields of the object
	private String name;
	private long population;
	private int size;
	private int medianAge;

	// getters and setters
	public String getName()
	{
		return name;
	}

	public long getPopulation()
	{
		return population;
	}

	public void setPopulation(long population)
	{
		this.population = population;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int getMedianAge()
	{
		return medianAge;
	}

	public void setMedianAge(int medianAge)
	{
		this.medianAge = medianAge;
	}

	// methods

	@Override
	public String toString()
	{
		return "Country{" + "name='" + name + '\'' + ", population=" + population + ", size=" + size + ", medianAge=" + medianAge + '}';
	}
}
