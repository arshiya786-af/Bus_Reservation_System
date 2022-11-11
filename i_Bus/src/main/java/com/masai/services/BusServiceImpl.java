package com.masai.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.models.AvailableAdminSession;
import com.masai.models.Bus;
import com.masai.models.Route;
import com.masai.repository.AdminSesionDao;
import com.masai.repository.BusDao;
import com.masai.repository.RouteDao;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao busDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private AdminSesionDao adminSessionDao;

	@Override
	public Bus addBus(Bus bus,String key) throws AdminException,BusException {
		
		//checking admin
		
		AvailableAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to add bus!");
		}
		
		else {
		
		Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
		
		
		//adding bus to route
		if(route != null) {
			route.getBusList().add(bus);
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("IncorrectBus details..!");
		
		}
	}
		

	@Override
	public Bus updateBus(Bus bus,String key) throws BusException, AdminException {
		
		AvailableAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to update bus!");
		}
		
		
		
		Optional<Bus> existingBusOpt=busDao.findById(bus.getBusId());
		
		//if bus is available
		if(existingBusOpt.isPresent()) {
			
			Bus existingBus = existingBusOpt.get();
			
			if(existingBus.getAvailableSeats()!=existingBus.getSeats()) throw new BusException("Cannot update already scheduled bus!");
			
			Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
			
			if(route == null)
				throw new BusException("Invalid route!");
			
			
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+ bus.getBusId());

	}

	@Override
	public Bus deleteBus(Integer busId,String key) throws BusException, AdminException {
		
		AvailableAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to delete bus!");
		}
		
		Optional<Bus> bus=busDao.findById(busId);
		
		
		if(bus.isPresent()) {
			Bus existingBus = bus.get();			
			
			//checking the availability of seats
			if(LocalDate.now().isBefore(existingBus.getBusJourneyDate()) && existingBus.getAvailableSeats()!=existingBus.getSeats())
				throw new BusException("Cannot delete as the bus is scheduled and reservations are booked for the bus.");
			
			
			busDao.delete(existingBus);
			
			return existingBus;
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+busId);
		
	}

	@Override
	public List<Bus> viewBusByType(String BusType) throws BusException {
		List<Bus> listOfBusType = busDao.findByBusType(BusType);
		
		if(listOfBusType.size() >0)
			return listOfBusType;
		else
			throw new BusException(" No bus of type "+ BusType);
	
	}

	@Override
	public List<Bus> viewAllBuses() throws BusException {
		
		List<Bus> buses= busDao.findAll();
		
		if(buses.size()>0)
			return buses;
		else
			throw new BusException(" No bus availabe....");

	}

	@Override
	public Bus viewBus(Integer busId) throws BusException {
		Optional<Bus> bus=busDao.findById(busId);
		
		if(bus.isPresent()) {
			Bus existingBus = bus.get();
			return existingBus;
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+busId);
	}
}
