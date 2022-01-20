package com.heights.auditapp.notification.mail;

import java.util.List;

public class MailRequest {

    private List<String> recipientEmailAddress;
    private String messageBody;
    private String mailSubject;

    public MailRequest(List<String> recipientEmailAddress, String messageBody, String mailSubject) {
        this.recipientEmailAddress = recipientEmailAddress;
        this.messageBody = messageBody;
        this.mailSubject = mailSubject;
    }

    public List<String> getRecipientEmailAddress() {
        return recipientEmailAddress;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getMailSubject() {
        return mailSubject;
    }

	@Override
	public String toString() {
		return "MailRequest [recipientEmailAddress=" + recipientEmailAddress + ", messageBody=" + messageBody
				+ ", mailSubject=" + mailSubject + "]";
	}
    
    
}
