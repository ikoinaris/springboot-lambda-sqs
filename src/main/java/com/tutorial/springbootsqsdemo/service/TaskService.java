package com.tutorial.springbootsqsdemo.service;

import com.tutorial.springbootsqsdemo.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class TaskService {

    private final SqsClient sqsClient;
    private final String queueUrl;

    public TaskService(SqsClient sqsClient, @Value("${aws.sqs.queue-url}") String queueUrl) {
        this.sqsClient = sqsClient;
        this.queueUrl = queueUrl;
    }


    public void submitTask(Task task) {
        SendMessageRequest request =
                SendMessageRequest.builder()
                        .queueUrl(queueUrl).messageBody(
                                String.format("Team '%s' was assigned the following task: \n %s",task.getTeam(), task.getDescription())).build();
        sqsClient.sendMessage(request);
    }
}
