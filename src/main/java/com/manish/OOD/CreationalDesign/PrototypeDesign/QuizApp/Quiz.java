package com.manish.OOD.CreationalDesign.PrototypeDesign.QuizApp;

public interface Quiz extends Cloneable {
    public Quiz clone() throws CloneNotSupportedException;

    public void setQuestions(String[] questions);

    public void startQuiz();
}
