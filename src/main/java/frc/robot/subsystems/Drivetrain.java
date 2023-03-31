// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontRightMotor = new CANSparkMax(19, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(11, MotorType.kBrushless);
  private CANSparkMax frontLeftMotor = new CANSparkMax(17, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(10, MotorType.kBrushless);

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
    
    this.leftMotorControllerGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
    this.rightMotorControllerGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
    this.diffDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
  }

  public void arcadeDrive(double throttle, double turn){
    this.diffDrive.arcadeDrive(throRateLimiter.calculate(throttle), turnRateLimiter.calculate(turn));
  }

  public void initDefaultCommand(){

  }

  public void setMotorPwn(){
    backLeftMotor.set(0.25);
  }
}
