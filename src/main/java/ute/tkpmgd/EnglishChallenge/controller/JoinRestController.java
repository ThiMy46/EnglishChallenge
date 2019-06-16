package ute.tkpmgd.EnglishChallenge.controller;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.dao.JoinRepository;
import ute.tkpmgd.EnglishChallenge.model.Join;
import ute.tkpmgd.EnglishChallenge.service.IJoinService;

@RestController
@RequestMapping("/api/join")
public class JoinRestController {

	@Autowired
	private TaskScheduler taskScheduler;

	private ScheduledFuture<?> scheduledFuture;
	
	@Autowired
	private JoinRepository joinRepository;

	@Autowired
	private IJoinService joinService;

	@GetMapping(value = "/create/{id}")
	public ResponseEntity<?> create(@PathVariable("id") int userId) {
		return ResponseEntity.ok(joinService.readyToJoin(userId));
	}

	@GetMapping(value = "/wait/{id}")
	public ResponseEntity<?> wait(@PathVariable("id") int joinId) {
		return ResponseEntity.ok(joinService.waitToJoin(joinId));
	}

	@GetMapping(value = "/start/{id}")
	public ResponseEntity<?> start(@PathVariable("id") int joinId, @RequestParam(name="userId", required=true) int userId) {
		Join join = joinRepository.getOne(joinId);
		if (join.getTimeRemain() == IJoinService.MAX_SECONDS && join.getUser1() == userId)
			scheduledFuture = taskScheduler.scheduleAtFixedRate(processTimeSecond(joinId), IJoinService.FIXED_RATE);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/progress/{id}")
	public ResponseEntity<?> progress(@PathVariable("id") int joinId) {
		return ResponseEntity.ok(joinService.getTimeSecond(joinId));
	}
	
	@GetMapping(value = "/complete/{id}")
	public ResponseEntity<?> complete(@PathVariable("id") int joinId) {
		return ResponseEntity.ok(joinService.completeJoin(joinId));
	}

	private Runnable processTimeSecond(int joinId) {
		return () -> joinService.processTimeSecond(joinId, scheduledFuture);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> saveUserAnswer(@PathVariable("id") int joinId, @RequestParam("userId") int userId, 
			@RequestParam("answer") int answerUser) {
		return ResponseEntity.ok().body(joinService.saveUserAnswer(userId, answerUser, joinId));
	}
	
	@GetMapping(value = "/send/{id}")
	public ResponseEntity<?> saveMessage1(@PathVariable("id") int joinId, @RequestParam("message") String message,
			@RequestParam("userId") int userId) {
		return ResponseEntity.ok(joinService.saveMessage(joinId, message, userId));
	}
	
	@GetMapping(value = "/receive/{id}")
	public ResponseEntity<?> getMessage1(@PathVariable("id") int joinId, @RequestParam("userId") int userId) {
		return ResponseEntity.ok(joinService.getMessage(joinId, userId));
	}
	
	@GetMapping(value = "/review/{id}")
	public ResponseEntity<?> redirectReview(@PathVariable("id") int joinId) {
		Join join = joinRepository.getOne(joinId);
		return ResponseEntity.ok(join.getTotal1() == IJoinService.MAX_QUESTIONS && join.getTotal1() == join.getTotal2());
	}
}
