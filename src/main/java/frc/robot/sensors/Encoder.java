package frc.robot.sensors;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import java.lang.Math;

import frc.robot.Robot;

public class Encoder {
    public static double leftEncoderPosition;
    public static double rightEncoderPosition;
    public static double roundNumber = 0;
    public static double velocity;
    public static double encoderValue;
    public static double encoderRound;
    public static double encoderPosition;
    public static double encoderZeroValue;

    public Encoder() {
        /*
        ***************************
        *   CONFIGURING ENCODERS  *
        ***************************
        */    
        Robot.m_drivetrain.exampleLeftTalon.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        Robot.m_drivetrain.exampleLeftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        Robot.m_drivetrain.exampleLeftTalon.setSelectedSensorPosition(0);
        
        Robot.m_drivetrain.exampleRightTalon.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        Robot.m_drivetrain.exampleRightTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        Robot.m_drivetrain.exampleRightTalon.setSelectedSensorPosition(0);
         

    }
    public static void printLeftEncoderPosition(){
        leftEncoderPosition = Robot.m_drivetrain.exampleLeftTalon.getSelectedSensorPosition();
        
        System.out.println("Left Encoder Position   : " + leftEncoderPosition);
        System.out.println("Left Round Number : " + leftEncoderPosition/4100); // Calculating round number 
                                                                                 // 4100 comes from sensor's datasheet.
        

    }
    public static void printRightEncoderPosition() {
        
        rightEncoderPosition = Robot.m_drivetrain.exampleRightTalon.getSelectedSensorPosition();
        System.out.println("Right Encoder Position   : " + rightEncoderPosition);
        System.out.println("Right Round Number : " + rightEncoderPosition/4100);     
    }

    public static double getEncoderPosition() {
        encoderValue = (Robot.m_drivetrain.exampleLeftTalon.getSelectedSensorPosition()+ Robot.m_drivetrain.exampleRightTalon.getSelectedSensorPosition())/2;
        encoderRound = encoderValue/4100;
        encoderPosition = encoderRound*Math.PI*15.24; // Translating data to centimeters
        return encoderPosition-encoderZeroValue;
    }

    public static void zeroEncoder() {
        encoderValue = (Robot.m_drivetrain.exampleLeftTalon.getSelectedSensorPosition()+ Robot.m_drivetrain.exampleRightTalon.getSelectedSensorPosition())/2;
        encoderRound = encoderValue/4100;
        encoderPosition = encoderRound*Math.PI*15.24;
        encoderZeroValue = encoderPosition;
        
    }
    
    public static void printEncoderVelocity(){

        velocity  = ( Robot.m_drivetrain.exampleLeftTalon.getSelectedSensorVelocity() + Robot.m_drivetrain.exampleRightTalon.getSelectedSensorVelocity() )/2;  
        System.out.println("Velocity is : "+velocity);

    }


}