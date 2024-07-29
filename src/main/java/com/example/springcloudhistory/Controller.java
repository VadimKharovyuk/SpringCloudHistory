package com.example.springcloudhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private  QuestionRepo questionRepo;

    @GetMapping("/sections")
    public List<Question> getQuestion(@RequestParam(value = "amount", defaultValue = "10") int amount) {
        List<Question> questions =questionRepo.findAll();
        Collections.shuffle(questions);
        return questions.stream().limit(amount).collect(Collectors.toList());
    }

    @PostMapping("/save")
    public Question save( @RequestBody Question question){
       return questionRepo.save(question);
    }
    @GetMapping("/{id}")
    public Question byId(@PathVariable int id){
       return questionRepo.findById(id).orElseThrow();
    }


    //    {
    //        "id": 1,
    //        "questions": "Who was the first President of the United States?",
    //        "answer": "George Washington"
    //    },
    //    {
    //        "id": 2,
    //        "questions": "In which year did the Titanic sink?",
    //        "answer": "1912"
    //    },
    //    {
    //        "id": 3,
    //        "questions": "Who was the leader of the Soviet Union during World War II?",
    //        "answer": "Joseph Stalin"
    //    }
    //]

}
