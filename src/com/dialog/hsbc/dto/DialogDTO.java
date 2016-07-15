package com.dialog.hsbc.dto;

import java.util.Arrays;
import java.util.List;

/**
 * @author Learning
 *
 */
public class DialogDTO {

	private String dialogId;
	private String input;
	private Integer client_id;
	private Integer conversation_id;
	private Double confidence;
	private String[] response;
	public String getDialogId() {
		return dialogId;
	}
	public void setDialogId(String dialogId) {
		this.dialogId = dialogId;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	public Integer getConversation_id() {
		return conversation_id;
	}
	public void setConversation_id(Integer conversation_id) {
		this.conversation_id = conversation_id;
	}
	public Double getConfidence() {
		return confidence;
	}
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}
	public String[] getResponse() {
		return response;
	}
	public void setResponse(String[] response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "DialogDTO [dialogId=" + dialogId + ", input=" + input + ", client_id=" + client_id
				+ ", conversation_id=" + conversation_id + ", confidence=" + confidence + ", response="
				+ Arrays.toString(response) + "]";
	}
}
