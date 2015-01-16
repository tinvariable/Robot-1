
package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1891.robot.commands.ExampleCommand;
import org.usfirst.frc.team1891.robot.subsystems.ExampleSubsystem;

public class Robot extends IterativeRobot
{

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	DriveMaster testDrive = new DriveMaster();

	
	
    Command autonomousCommand;
    public void robotInit()
    {
		oi = new OI();
        autonomousCommand = new ExampleCommand();
        
        


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
        	
    public void disabledInit(){

    }

    public void teleopPeriodic()
    {	
		Scheduler.getInstance().run();
		testDrive.basicMove();
        
    }
    

    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
