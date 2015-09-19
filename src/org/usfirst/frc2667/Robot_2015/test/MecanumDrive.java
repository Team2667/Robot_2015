package org.usfirst.frc2667.Robot_2015.test;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;

public class MecanumDrive extends SampleRobot {

	private static final int FRONT_LEFT_CHANNEL = 4;
	private static final int REAR_LEFT_CHANNEL = 3;
	private static final int FRONT_RIGHT_CHANNEL = 2;
	private static final int REAR_RIGHT_CHANNEL = 1;
	
	private static final int JOYSTICK_CHANNEL = 0;
	
	private final RobotDrive robotDrive;
	private final Joystick joyStick;
	
	public MecanumDrive() {
		this.robotDrive = new RobotDrive(new Talon(FRONT_LEFT_CHANNEL), new Talon(REAR_LEFT_CHANNEL), new Talon(FRONT_RIGHT_CHANNEL), new Talon(REAR_RIGHT_CHANNEL));
		this.robotDrive.setExpiration(0.1D);
		this.robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		this.robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		this.robotDrive.setMaxOutput(0.2D);
		this.joyStick = new Joystick(JOYSTICK_CHANNEL);
	}
	
	@Override
	public void operatorControl() {
		while(this.isOperatorControl() && this.isEnabled()) {
			SmartDashboard.putNumber("posX=", this.joyStick.getX());
			SmartDashboard.putNumber("posY=", this.joyStick.getY());
			SmartDashboard.putNumber("posZ=", this.joyStick.getZ());
			SmartDashboard.putNumber("rotation(radians)=", this.joyStick.getDirectionRadians());
			SmartDashboard.putNumber("rotation(degrees)=", this.joyStick.getDirectionDegrees());
			//robotDrive.mecanumDrive_Polar(getThrottle(), joyStick.getDirectionRadians(), 0);
			robotDrive.mecanumDrive_Cartesian(this.joyStick.getX(), this.joyStick.getY(), this.joyStick.getDirectionRadians(), 0);
		}
	}
	
	private double getThrottle() {
		return 1 - (0.5D * (joyStick.getZ() + 1));
	}
	
}
