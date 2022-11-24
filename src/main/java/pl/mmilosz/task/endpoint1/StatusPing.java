package pl.mmilosz.task.endpoint1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Value;

@Data
public class StatusPing {

	@Autowired
	private String content;

	public StatusPing(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
