package Salonce.DiscordBot.Dtos;


import java.util.List;

public class Question {
    private String question;
    private List<Answer> answerList;

}

class Answer{
    String answer;
    boolean correct;
}