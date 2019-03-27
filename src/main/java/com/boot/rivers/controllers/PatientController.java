package com.boot.rivers.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.model.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> list() {
		try{
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        //String url = "http://riverbrain.com/api/v1/rivers";
	        //ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);   
	        Patient p1 = new Patient("P1", "01-feb-1980", "drug1", "AE1");
	        Patient p2 = new Patient("P2", "05-Aug-1985", "drug2", "AE2");
	        List<Patient> l = new ArrayList<Patient>();
	        l.add(p1);
	        l.add(p2);
	        
	        ObjectMapper mapper = new ObjectMapper();
	        List<Patient> l1 = mapper.readValue(new FileInputStream(new File("input.json")), new TypeReference<List<Patient>>(){});
	        
	        return new ResponseEntity<List<Patient>>(l1, headers, HttpStatus.OK);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

}
