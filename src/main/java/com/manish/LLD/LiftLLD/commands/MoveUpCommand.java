package com.manish.LLD.LiftLLD.commands;

import com.manish.LLD.LiftLLD.models.Lift;

public class MoveUpCommand implements LiftCommand{
    private Lift lift;

    public MoveUpCommand(Lift lift){
        this.lift = lift;
    }

    @Override
    public void execute(){
        lift.moveUp();
    }
}
