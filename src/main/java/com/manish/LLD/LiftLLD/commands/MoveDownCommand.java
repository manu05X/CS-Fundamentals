package com.manish.LLD.LiftLLD.commands;

import com.manish.LLD.LiftLLD.models.Lift;

public class MoveDownCommand implements LiftCommand{
    private Lift lift;

    public MoveDownCommand(Lift lift){
        this.lift = lift;
    }

    @Override
    public void execute() {
        lift.moveDown();
    }
}
