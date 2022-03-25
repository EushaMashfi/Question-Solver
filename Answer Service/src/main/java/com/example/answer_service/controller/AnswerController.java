package com.example.answer_service.controller;

import com.example.answer_service.Constants;
import com.example.answer_service.entity.Answer;
import com.example.answer_service.entity.QuestionStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AnswerController {
    Answer answer = new Answer();

    @RabbitListener(queues = Constants.QUEUE )
    public void consumeMessageFromQueue(QuestionStatus questionStatus) {
        answer.setId(3);
        answer.setDescription("True");

        if (questionStatus.getQuestion().getId() == answer.getId()){
            System.out.println("Correct");
        }
        else System.out.println("Incorrect");

    }
}

