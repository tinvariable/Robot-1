
package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.omg.CORBA.portable.UnknownException;
import org.usfirst.frc.team1891.robot.commands.ExampleCommand;
import org.usfirst.frc.team1891.robot.subsystems.ExampleSubsystem;

public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	//Brings in DriveMaster
	Command autonomousCommand;
	//Instantiates jags with appropriate ID's
    CANJaguar jag3;
    CANJaguar jag4;
    CANJaguar jag5;
    CANJaguar jag6;
    JAGValue getSpeed;
	//Initiates all instances of all classes
    int moveTest=0;
    public void robotInit()
    {
    	getSpeed = new JAGValue();
    	oi = new OI();
		jag3 = new CANJaguar(3);
		jag4 = new CANJaguar(4);
		jag5 = new CANJaguar(5);
		jag6 = new CANJaguar(6);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {

        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	
        if (autonomousCommand != null){
        	autonomousCommand.cancel();
        }
        
     }   	
        	
    public void disabledInit() 
    {

    }

    public void teleopPeriodic() 
    {	
		Scheduler.getInstance().run();
<<<<<<< HEAD
		jag3.set(getSpeed.setSpeed(3));
		jag4.set(getSpeed.setSpeed(4));
		jag5.set(getSpeed.setSpeed(5));
		jag6.set(getSpeed.setSpeed(6));
=======
		//sets Y axis to move robot forwards and backwards
		moveTest=0;
		if(moveTest==0)
		{
			if(roboDrive.testYAxis())
			{
				jag3.set(roboDrive.getYAxis());
				jag4.set(-(roboDrive.getYAxis()));
				jag5.set(-(roboDrive.getYAxis()));
				jag6.set(roboDrive.getYAxis());
				moveTest++;
			}
		}
		if(moveTest==0)
		{
			if(roboDrive.testZAxis())
			{
				jag3.set(roboDrive.getZAxis());
				jag4.set(roboDrive.getZAxis());
				jag5.set(roboDrive.getZAxis());
				jag6.set(roboDrive.getZAxis());
				moveTest++;
			}
		}
		if(moveTest==0)
		{
			if(roboDrive.testXAxisPos())
			{
				//Move right
				jag3.set(roboDrive.getXAxis());
				jag4.set(-(roboDrive.getXAxis()));
				jag5.set(roboDrive.getXAxis());
				jag6.set(-(roboDrive.getXAxis()));
				moveTest++;
			}
		}
		if(moveTest==0)
		{
			if(roboDrive.testXAxisNeg())
			{
				//Move right
				jag3.set(roboDrive.getXAxis());
				jag4.set(-(roboDrive.getXAxis()));
				jag5.set(roboDrive.getXAxis());
				jag6.set(-(roboDrive.getXAxis()));
				moveTest++;
		
			}
		}
				
>>>>>>> origin/master
    }


    public void testPeriodic() {
        LiveWindow.run();
    }
}
