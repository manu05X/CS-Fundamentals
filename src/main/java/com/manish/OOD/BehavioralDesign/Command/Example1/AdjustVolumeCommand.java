package com.manish.OOD.BehavioralDesign.Command.Example1;

// Concrete command for adjusting the volume of a stereo
class AdjustVolumeCommand implements Command {
    private Stereo stereo;

    public AdjustVolumeCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.adjustVolume();
    }
}