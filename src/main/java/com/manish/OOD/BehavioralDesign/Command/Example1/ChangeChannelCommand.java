package com.manish.OOD.BehavioralDesign.Command.Example1;

// Concrete command for changing the channel of a TV
class ChangeChannelCommand implements Command {
    private TV tv;

    public ChangeChannelCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}
