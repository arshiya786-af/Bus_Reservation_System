package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.models.Bus;
import com.masai.services.BusService;

@RestController
public class BusController {
	
	@Autowired
	BusService bService;
	

	@PostMapping("/home/bus/admin")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus,@RequestParam(required = false) String key) throws BusException, AdminException{
		
		Bus newBus=bService.addBus(bus,key);
		
		return new ResponseEntity<Bus>(newBus,HttpStatus.CREATED);
	}
	
	@PutMapping("/home/bus/admin")
	public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus,@RequestParam(required = false) String key) throws BusException, AdminException{
		
		Bus newBus=bService.updateBus(bus,key);
		
		return new ResponseEntity<Bus>(newBus,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/home/bus/admin/{busId}")
	public ResponseEntity<Bus> DeleteBus(@PathVariable("busId") Integer busId,@RequestParam(required = false) String key) throws BusException, AdminException{
		
		Bus bus=bService.deleteBus(busId,key);
		
		return new ResponseEntity<Bus>(bus,HttpStatus.OK);
	}
	
	@GetMapping("/home/bus")
	public ResponseEntity<Bus> getBusesById(@RequestParam Integer busId) throws BusException{
		
		Bus bus=bService.viewBus(busId);
		
		return new ResponseEntity<Bus>(bus,HttpStatus.OK);
	}
	
	
	@GetMapping("/home/buses/{busType}")
	public ResponseEntity<List<Bus>> getBusesByType(@PathVariable("busType") String busType) throws BusException{
		
		List<Bus> listOfBuses=bService.viewBusByType(busType);
		
		return new ResponseEntity<List<Bus>>(listOfBuses,HttpStatus.OK);
	}
	
	@GetMapping("/home/buses")
	public ResponseEntity<List<Bus>> getAllBuses() throws BusException{
		
		List<Bus> listOfBuses=bService.viewAllBuses();
		
		return new ResponseEntity<List<Bus>>(listOfBuses,HttpStatus.OK);
	}

}
