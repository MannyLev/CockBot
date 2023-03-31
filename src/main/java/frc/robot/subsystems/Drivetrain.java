// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontRightMotor = new CANSparkMax(Constants.Drivetrain.kFrontRightPort, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(Constants.Drivetrain.kBackRightPort, MotorType.kBrushless);
  private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.Drivetrain.kFrontLeftPort, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(Constants.Drivetrain.kBackLeftPort, MotorType.kBrushless);

  private MotorControllerGroup leftMotorControllerGroup;
  private MotorControllerGroup rightMotorControllerGroup;
  private DifferentialDrive diffDrive;

  private SlewRateLimiter throRateLimiter = new SlewRateLimiter(2);
  private SlewRateLimiter turnRateLimiter = new SlewRateLimiter(2);
  
  
  public Drivetrain() {
    this.frontRightMotor.setInverted(true);
    this.frontLeftMotor.setInverted(false);
    this.backLeftMotor.setInverted(false);
    this.backRightMotor.setInverted(true);

    this.frontLeftMotor.setSmartCurrentLimit(40);
    this.frontRightMotor.setSmartCurrentLimit(40);
    this.backLeftMotor.setSmartCurrentLimit(40);
    this.backRightMotor.setSmartCurrentLimit(40);
    
    this.frontLeftMotor.enableVoltageCompensation(12);
    this.frontRightMotor.enableVoltageCompensation(12);
    this.backLeftMotor.enableVoltageCompensation(12);
    this.backRightMotor.enableVoltageCompensation(12);

    this.leftMotorControllerGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
    this.rightMotorControllerGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
    this.diffDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
  }

  public void arcadeDrive(double throttle, double turn){
    this.diffDrive.arcadeDrive(throRateLimiter.calculate(throttle), turnRateLimiter.calculate(turn));
  }

  // public void initDefaultCommand(){

  // }

  // public void setMotorPwn(){
  //   backLeftMotor.set(0.25);
  // }
}
