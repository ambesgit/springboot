package customer.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import customer.dao.Profile;
import customer.service.CustomerService;

@RestController
public class Controller {
	@Autowired
	CustomerService customerService;
	@RequestMapping("/profiles")
	public List<Profile> getProfiles() {
		return customerService.getProfiles();
	}
	@RequestMapping("/profile/{id}")
	public Profile getProfile(@PathVariable String id) {
		return customerService.getProfile(Long.parseLong(id));
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/profile")
	public void addProfile(@RequestBody Profile profile) {
		customerService.addProfile(profile);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/profile/{id}")
	public void updateProfile(@RequestBody Profile profile,@PathVariable String id) {
		customerService.updateProfile(profile,Long.parseLong(id));
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/profile/{id}")
	public void deleteProfile(@PathVariable String id) {
		customerService.deleteProfile(Long.parseLong(id));
	}
}
