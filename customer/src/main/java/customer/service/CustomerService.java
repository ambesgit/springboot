package customer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.dao.Profile;
import customer.repository.IProfileRepository;
@Service
public class CustomerService {
	@Autowired
	IProfileRepository iProfileRepository;
	Map<Long,Profile> profiles = new HashMap();
	{
		 profiles.put(1L, new Profile("ambes","tetemke",1,"masters",Profile.createAddress("20003 N 23rd Ave","Phoenix","85027","AZ")));
		 profiles.put(2L,new Profile("tesfaye","tetemke",2,"MD",Profile.createAddress("20003 N 23rd Ave","Phoenix","85027","AZ")));
	}
	public List<Profile> getProfiles(){
		List<Profile> temprofiles = new ArrayList();
//		for(Map.Entry<Long, Profile> entry:profiles.entrySet()) {
//			temprofiles.add(entry.getValue());
//		}
		iProfileRepository.findAll().forEach(temprofiles::add);
		return temprofiles;
	}
	
	public Profile getProfile(long id) {
		return profiles.get(id);
	}
	
	public void addProfile(Profile profile) {
		iProfileRepository.save(profile);
		//Long id =Long.parseLong(""+profiles.size())+1L;
		//profiles.put(id, profile);
	}
	
	public void updateProfile(Profile profile, Long id) {
		
		if(profiles.containsKey(id)) {
			profiles.put(id,profile);
		}
	}
	
	public void deleteProfile(Long id) {
		if(profiles.containsKey(id)) {
			profiles.remove(id);
		}
	}
}
