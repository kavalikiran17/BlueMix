package com.dialog.hsbc.dto;

/**
 * @author Learning
 *
 */
public class HSBCDialogProps {

	private String dialogId;
	private String userName;
	private String password;

	public String getDialogId() {
		return dialogId;
	}
	public void setDialogId(String dialogId) {
		this.dialogId = dialogId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "HSBCDialogProps [dialogId=" + dialogId + ", userName=" + userName + ", password=" + password + "]";
	}
}
