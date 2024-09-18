package com.manish.OOD.CreationalDesign.PrototypeDesign.QuizApp;

public class QuizApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        // create a prototype Science quiz object
        Quiz scienceQuizPrototype = new ScienceQuiz();

        // create a new Science quiz instance by cloning the prototype object
        Quiz scienceQuizInstance1 = scienceQuizPrototype.clone();
        scienceQuizInstance1.setQuestions(new String[] {"What is the speed of light?",
                "What is the smallest particle in an element?",
                "What is the equation for gravitational force?"});
        scienceQuizInstance1.startQuiz();

        // create another Science quiz instance by cloning the prototype object
        Quiz scienceQuizInstance2 = scienceQuizPrototype.clone();
        scienceQuizInstance2.setQuestions(new String[] {"What is the unit of electric charge?",
                "What is the boiling point of water?",
                "What is the process of converting solid directly to gas?"});
        scienceQuizInstance2.startQuiz();
    }
}
