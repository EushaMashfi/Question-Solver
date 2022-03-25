package com.example.question_service.controller;



import com.example.question_service.Constants;
import com.example.question_service.entity.QuestionStatus;
import com.example.question_service.entity.Questions;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.UUID;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    

    @PostMapping("/{questionID}")
    public String bookOrder(@RequestBody Questions question, @PathVariable String questionID ) {
        question.setId(UUID.randomUUID().toString());
        QuestionStatus questionStatus = new QuestionStatus(question, "PROCESS", "Question Successfully Saved. ID: "+ questionID);

        rabbitTemplate.convertAndSend(Constants.EXCHANGE,Constants.ROUTING_KEY, questionStatus);
        return "success!!";
    }

}