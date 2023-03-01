// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivetrain extends SubsystemBase {
  private WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(19);
  private WPI_VictorSPX backRightMotor = new WPI_VictorSPX(10);
  private WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(17);
  private WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(11);
  private MotorControllerGroup lefMotorControllerGroup;
  private MotorControllerGroup rightMotorControllerGroup;
  
  public Drivetrain() {
    frontRightMotor.setInverted(false);
    frontLeftMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    backRightMotor.setInverted(false);
    this.lefMotorControllerGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
    this.rightMotorControllerGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
  }
}
