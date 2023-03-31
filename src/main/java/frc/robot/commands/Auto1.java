// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public final class Auto1 extends SequentialCommandGroup {
  public Auto1(Drivetrain drivetrain){
    addCommands(
      new ParallelRaceGroup(
        new RunMotors(drivetrain, 0.75, 0),
        new WaitCommand(1.5)
    )

  );

  addRequirements(drivetrain);
  }
}
