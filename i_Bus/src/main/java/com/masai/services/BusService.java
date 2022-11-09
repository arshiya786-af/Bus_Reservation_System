package com.masai.services;

import java.util.List;

import com.masai.exceptions.BusException;
import com.masai.models.Bus;

public interface BusService {
	
	
    public Bus addBus(Bus bus,String key) throws BusException;
	
	public Bus updateBus(Bus bus,String key) throws BusException;
	
	public Bus deleteBus(Integer busId,String key) throws BusException;
	
	public Bus viewBus(Integer busId) throws BusException;
	
	public List<Bus> viewBusByType(String BusType) throws BusException;
	
	public List<Bus> viewAllBuses() throws BusException;
	

}
