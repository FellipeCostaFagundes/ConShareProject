package br.conshare.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collaboration")
public class CollaborationController {

	@GetMapping("/start")
	public String getStartCollaboration() {
		return "/collaboration/start";
	}

	@GetMapping("/frequenty_question")
	public String getFrequentyQuestionPage() {
		return "/collaboration/frequenty_question";

	}
	
	@GetMapping("/recomended_doc")
	public String getRecomendedDocPage() {
		return "/collaboration/recomended_doc";

	}
	
	
	@GetMapping("/online_teachers")
	public String getOnlineTeachersPage() {
		return "/collaboration/online_teachers";
	}
	
	@GetMapping("/best_rate_question")
	public String getRatedQuestionPage() {
		return "/collaboration/best_rate_question";
	}
	
	@GetMapping("/bug_report")
	public String getReportBugPage() {
		return "/collaboration/bug_report";
	}
	
	
	@GetMapping("/send_feedback")
	public String getFeedbackPage() {
		return "/collaboration/send_feedback";
	}
	
	
	


}
