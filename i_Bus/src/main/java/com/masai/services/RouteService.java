package com.masai.services;

import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.RouteException;
import com.masai.models.Route;

public interface RouteService {

	public Route addRoute(Route route,String key) throws RouteException, AdminException;
	
	public Route updateRoute(Route route,String key) throws RouteException, AdminException;
	
	public Route deleteRoute(Integer routeId,String key) throws RouteException, AdminException;
	
	public Route viewRoute(Integer routeId) throws RouteException;
	
	public List<Route> viewAllRoute() throws RouteException;
	
	
}
