package com.masai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.RouteException;
import com.masai.models.AvailableAdminSession;
import com.masai.models.Bus;
import com.masai.models.Route;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSesionDao;
import com.masai.repository.BusDao;
import com.masai.repository.RouteDao;

public class RouteServiceImpl  implements RouteService{

	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private AdminSesionDao adminSessionDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Route addRoute(Route route,String key) throws RouteException, AdminException {
		
	    AvailableAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to add route!");
		}
		
		Route newRoute = routeDao.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());
		
		if(newRoute != null) throw new RouteException("Route :"+ newRoute.getRouteFrom() +" to "+ newRoute.getRouteTo()+ " is already present!");
		
		
		List<Bus> buses = new ArrayList<>();	
		
		if(route != null) {
			route.setBusList(buses);
			return routeDao.save(route);
		}
		else {
			throw new RouteException("This root is not available");
		}
	}

	@Override
	public Route updateRoute(Route route,String key) throws RouteException, AdminException {
		
		AvailableAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to add route!");
		}
		
		Optional<Route> existedRoute = routeDao.findById(route.getRouteId());
		if(existedRoute.isPresent()) {
			
			Route presentRoute = existedRoute.get();
			List<Bus> busList = presentRoute.getBusList();
			
			if(!busList.isEmpty()) throw new RouteException("Cannot update running route! Buses are already scheduled in the route.");
			
			return routeDao.save(route);
		}
		else
			throw new RouteException("Route doesn't exist with routeId : "+ route.getRouteId());

	}

	@Override
	public Route deleteRoute(Integer routeId,String key) throws RouteException, AdminException {
		
		AvailableAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to add route!");
		}
	
		Optional<Route> route=routeDao.findById(routeId);
		
		if(route.isPresent()) {
			Route existingRoute=route.get();
			routeDao.delete(existingRoute);
			return existingRoute;
		}
		else
			throw new RouteException("There is no route of routeId : "+ routeId);

	}


	@Override
	public Route viewRoute(Integer routeId) throws RouteException {
		
		Optional<Route> existedRoute=routeDao.findById(routeId);
		
		if(existedRoute.isPresent()) {
			return existedRoute.get();
		}
		else
			throw new RouteException("There is no route present of routeId :" + routeId);
		
	}

	@Override
	public List<Route> viewAllRoute() throws RouteException {
			
		List<Route> routes=routeDao.findAll();
		
		if(routes.size()>0)
			return routes;
		else
			throw new RouteException("There is no route available");
			
	}

}
