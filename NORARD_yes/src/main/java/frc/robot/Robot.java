// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  TalonFX myMotor1 = new TalonFX(1);
  TalonFX myMotor2 = new TalonFX(2);
  TalonFX myMotor3 = new TalonFX(3);
  TalonFX myMotor4 = new TalonFX(4);
  TalonFX myMotor5 = new TalonFX(5);
  TalonFX myMotor6 = new TalonFX(6);
  TalonFX myMotor7 = new TalonFX(7);
  TalonFX myMotor8 = new TalonFX(8);

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

    // Set up motor configuration
    myMotor1.getConfigurator().apply(new TalonFXConfiguration());
    myMotor2.getConfigurator().apply(new TalonFXConfiguration());
    myMotor3.getConfigurator().apply(new TalonFXConfiguration());
    myMotor4.getConfigurator().apply(new TalonFXConfiguration());
    myMotor5.getConfigurator().apply(new TalonFXConfiguration());
    myMotor6.getConfigurator().apply(new TalonFXConfiguration());
    myMotor7.getConfigurator().apply(new TalonFXConfiguration());
    myMotor8.getConfigurator().apply(new TalonFXConfiguration());

    // sets electrical current of motors
    var currentConfiguration = new CurrentLimitsConfigs();
    currentConfiguration.StatorCurrentLimit = 80;
    currentConfiguration.StatorCurrentLimitEnable = true;

    // refreshes and applies the current configuration to all motors
    myMotor1.getConfigurator().refresh(currentConfiguration);
    myMotor1.getConfigurator().apply(currentConfiguration);
    myMotor2.getConfigurator().refresh(currentConfiguration);
    myMotor2.getConfigurator().apply(currentConfiguration);
    myMotor3.getConfigurator().refresh(currentConfiguration);
    myMotor3.getConfigurator().apply(currentConfiguration);
    myMotor4.getConfigurator().refresh(currentConfiguration);
    myMotor4.getConfigurator().apply(currentConfiguration);
    myMotor5.getConfigurator().refresh(currentConfiguration);
    myMotor5.getConfigurator().apply(currentConfiguration);
    myMotor6.getConfigurator().refresh(currentConfiguration);
    myMotor6.getConfigurator().apply(currentConfiguration);
    myMotor7.getConfigurator().refresh(currentConfiguration);
    myMotor7.getConfigurator().apply(currentConfiguration);
    myMotor8.getConfigurator().refresh(currentConfiguration);
    myMotor8.getConfigurator().apply(currentConfiguration);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {

    // myMotor1.set(0.5);
    // myMotor2.set(0.5);
    // myMotor3.set(0.5);
    // myMotor4.set(0.5);
    // myMotor5.set(0.5);
    // myMotor6.set(0.5);
    // myMotor7.set(0.5);
    // myMotor8.set(0.5);
  }


  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
