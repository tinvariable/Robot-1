package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;

public class DriveMaster
{
	Joystick joyRight;
	final double DEADZONE=0.05;
	public DriveMaster(int joyPort)
	{
		joyRight= new Joystick(joyPort);
	}
	public double getYAxis()
	{
		double value = joyRight.getY();
		if(Math.abs(value) > DEADZONE)
		{
			return value;
		}
		else
		{
			return 0;
		}
	}
	public double getXAxis()
	{
		double value = joyRight.getY();
		if(Math.abs(value) > DEADZONE)
		{
			return value;
		}
		else
		{
			return 0;
		}
	}
	public double getZAxis()
	{
		double value = joyRight.getY();
		if(Math.abs(value) > DEADZONE)
		{
			return value;
		}
		else
		{
			return 0;
		}
	}	
}
