package pl.mmilosz.task.endpoint1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StatusPingController {
	
	private static final String TEMPLATE = "%s";
	
	private static final String BODY = "pong";
		
	/*
	 * Returns the /status/ping node with <strong>BODY</strong> as a content,
	 * formatted according to a given <strong>TEMPLATE</strong>.
	 * 
	 * @return 		Plain text content
	 */
	@GetMapping(value = "/status/ping", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	ResponseEntity<String> getPingStatus() {
		StatusPing statusPing = new StatusPing(BODY);
		log.info("GET request – body: {}", statusPing.getContent());
		
		return ResponseEntity.ok().body(
				String.format(TEMPLATE, statusPing.getContent())
				);
	}
}
