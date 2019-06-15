package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.model.Join;
import ute.tkpmgd.EnglishChallenge.serviceImp.JoinServiceImp;

@RestController
@RequestMapping("/api/join")
public class JoinRestController {

	@Autowired
	JoinServiceImp joinSer;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getJoinByid(@PathVariable int id) {
		
		Join join = joinSer.getJoinById(id);
		
		return ResponseEntity.ok().body(join);
	}
}
