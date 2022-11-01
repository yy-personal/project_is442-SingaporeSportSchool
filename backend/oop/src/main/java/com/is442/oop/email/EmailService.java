package com.is442.oop.email;

import javax.activation.DataSource;

import org.springframework.stereotype.Component;

import com.is442.oop.data.models.Template;
import com.is442.oop.data.models.User;
import com.is442.oop.exception.ActionNotExecutedException;

@Component
public interface EmailService {
    void sendAdminEmail(Integer loanId, Integer templateId) throws ActionNotExecutedException;
    void sendPassConfirmationEmail(Integer loanId, Integer templateId) throws ActionNotExecutedException;
    void sendSimpleConfirmationUrlEmail(User user, Integer tempalteId, String confirmationUrl) throws ActionNotExecutedException;
    void sendGenericEmail(String recipientEmail, String emailSubject, String emailBody) throws ActionNotExecutedException;
    void sendAttachmentEmail(String recipientEmail, Template template, String attachmentName, DataSource attachment) throws ActionNotExecutedException;
}
