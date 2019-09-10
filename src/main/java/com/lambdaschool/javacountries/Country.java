package com.lambdaschool.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
	// fields of the object

	private static final AtomicLong counter = new AtomicLong();

	private long id;
	private String name;
	private int population;
	private int size;
	private int medianAge;

	// constructor
	public Country(String name, int population, int size, int medianAge)
	{
		this.id = counter.incrementAndGet();
		this.name = name;
		this.population = population;
		this.size = size;
		this.medianAge = medianAge;
	}

	public Country(Country toClone)
	{
		this.id = toClone.getId();
		this.name = toClone.getName();
		this.population = toClone.getPopulation();
		this.size = toClone.getSize();
		this.medianAge = toClone.getMedianAge();
	}

	// getters and setters
	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public int getPopulation()
	{
		return population;
	}

	public void setPopulation(int population)
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
