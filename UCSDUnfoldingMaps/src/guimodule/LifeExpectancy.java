package guimodule;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.providers.Google.*;

import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;

import java.util.HashMap;


import de.fhpotsdam.unfolding.marker.Marker;

public class LifeExpectancy extends PApplet 
{
	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	
	private Map<String,Float> loadLifeExpectancyFromCSV(String fileName)
	{
		Map<String,Float> lifeExpMap = new HashMap<String, Float>();
		String[] rows= loadStrings(fileName);
		
		for(String row: rows)
		{
			String[] columns = row.split(",");
			if( columns.length == 6 && !columns[5].equals("..") ) {
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);
			}
		}
		
		return lifeExpMap;
	}
	
	List<Feature> countries = new ArrayList();
	List<Marker> countryMarkers;
	
	countries = GeoJSONReader.loadData(this, "data/countries.geo.json");
	countryMarkers = MapUtils.createSimpleMarkers(countries);
	
	public void setup()
	{
		size(800,600,OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExpByCountry= loadLifeExpectancyFromCSV("data/LifeExpectancyWorldBank.csv");
	}
	
	public void draw()
	{
		
		
		
		
	}
}
