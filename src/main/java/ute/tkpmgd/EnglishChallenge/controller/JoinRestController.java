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

import ute.tkpmgd.EnglishChallenge.service.IJoinService;

@RestController
@RequestMapping("/api/join")
public class JoinRestController {

	@Autowired
	private TaskScheduler taskScheduler;

	private ScheduledFuture<?> scheduledFuture;

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
	public ResponseEntity<?> start(@PathVariable("id") int joinId) {
		if (joinService.getTimeSecond(joinId) == IJoinService.MAX_SECONDS)
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
			@RequestParam("answer") int answerUser, @RequestParam("questionId") int questionId) {
		return ResponseEntity.ok().body(joinService.saveUserAnswer(userId, questionId, answerUser, joinId));
	}
}
