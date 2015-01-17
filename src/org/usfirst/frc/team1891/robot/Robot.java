
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

public class Robot extends IterativeRobot
{

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	//Brings in DriveMaster
	DriveMaster roboDrive;
	Command autonomousCommand;
	//Instantiates jags with appropriate ID's
    CANJaguar jag3;
    CANJaguar jag4;
    CANJaguar jag5;
    CANJaguar jag6;
	//Initiates all instances of all classes
    public void robotInit()
    {
		oi = new OI();
		jag3 = new CANJaguar(3);
		jag4 = new CANJaguar(4);
		jag5 = new CANJaguar(5);
		jag6 = new CANJaguar(6);
		roboDrive = new DriveMaster(1);
    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

    public void autonomousInit()
    {

        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        
        
        
    }

    public void teleopInit() 
    {
    	
        if (autonomousCommand != null) 
        {
        	autonomousCommand.cancel();
        }
        
     }   	
        	
    public void disabledInit()
    {

    }

    public void teleopPeriodic()
    {	
		Scheduler.getInstance().run();
		//sets Y axis to move robot forwards and backwards
		if(roboDrive.getZAxis()<roboDrive.getDEADZONE())
		{
			if(roboDrive.getZAxis()>-(roboDrive.getDEADZONE()))
			{
				if(roboDrive.getXAxis()<roboDrive.getDEADZONE())
				{
					if(roboDrive.getXAxis()>-(roboDrive.getDEADZONE()))
					{
						jag3.set(roboDrive.getYAxis());
						jag4.set(-(roboDrive.getYAxis()));
						jag5.set(-(roboDrive.getYAxis()));
						jag6.set(roboDrive.getYAxis());
					}
				}
			}
		}
		//sets z axis to turn the robot left and right
		else if(roboDrive.getYAxis()<roboDrive.getDEADZONE())
		{
			if(roboDrive.getYAxis()>-(roboDrive.getDEADZONE()))
			{
				if(roboDrive.getXAxis()<roboDrive.getDEADZONE() )
				{
					if(roboDrive.getXAxis()>-(roboDrive.getDEADZONE()))
					{
						jag3.set(roboDrive.getZAxis());
						jag4.set(roboDrive.getZAxis());
						jag5.set(roboDrive.getZAxis());
						jag6.set(roboDrive.getZAxis());
					}

				}
			}
		}
		//turns the robot left and right horizontally with the x axis
		else if(roboDrive.getYAxis()<roboDrive.getDEADZONE())
		{
			if(roboDrive.getYAxis()>-(roboDrive.getDEADZONE()))
			{
				if(roboDrive.getXAxis()<roboDrive.getDEADZONE())
				{
					if(roboDrive.getZAxis()>-(roboDrive.getDEADZONE()))
					{
						//Move right
						if (roboDrive.getXAxis()>0)
						{
							jag3.set(roboDrive.getXAxis());
							jag4.set(-(roboDrive.getXAxis()));
							jag5.set(roboDrive.getXAxis());
							jag6.set(-(roboDrive.getXAxis()));
						}
						//Move left
						if(roboDrive.getXAxis()<0)
						{
							jag3.set(roboDrive.getXAxis());
							jag4.set(-(roboDrive.getXAxis()));
							jag5.set(roboDrive.getXAxis());
							jag6.set(-(roboDrive.getXAxis()));
						}
					}
				}
			}
		}
		
		
				
    }
    

    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
