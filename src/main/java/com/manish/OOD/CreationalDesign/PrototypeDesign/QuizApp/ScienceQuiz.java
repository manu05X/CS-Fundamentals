package com.manish.OOD.CreationalDesign.PrototypeDesign.QuizApp;

public class ScienceQuiz implements Quiz {
    private String[] questions;

    public ScienceQuiz() {
        // default set of questions for Science quiz
        this.questions = new String[]{"What is the largest planet in our solar system?",
                "What is the smallest planet in our solar system?",
                "What is the most abundant gas in Earth's atmosphere?"};
    }

    @Override
    public Quiz clone() throws CloneNotSupportedException {
        ScienceQuiz cloned = new ScienceQuiz();
        cloned.setQuestions(this.questions.clone());
        return cloned;
    }

    @Override
    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    @Override
    public void startQuiz() {
        System.out.println("Starting Science Quiz with questions:");
        for (String question : this.questions) {
            System.out.println(question);
        }
    }
}
