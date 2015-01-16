package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class DriveMaster extends IterativeRobot
{
	//instantiate all jags with correct ID numbers
	CANJaguar jag3 = new CANJaguar(3);
	CANJaguar jag4 = new CANJaguar(4);
	CANJaguar jag5 = new CANJaguar(5);
	CANJaguar jag6 = new CANJaguar(6);
	//Extremem3DPro
	Joystick joyRight = new Joystick(1);
	//Joystick constructer will have to be changed when port number is reassigned
	//ATK3
	Joystick joyLeft = new Joystick(0);
	//retrieve the joystick axis
	public void basicMove()
	{
		jag3.set(joyRight.getY());
		jag6.set(joyRight.getY());
		jag4.set(-(joyLeft.getY()));
		jag5.set(-(joyLeft.getY()));
	}
}
