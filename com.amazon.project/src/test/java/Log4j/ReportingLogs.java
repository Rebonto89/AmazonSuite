package Log4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class ReportingLogs {

	
	public void startlog(Class<?> clsnme){
		Logger logTime=Logger.getLogger(clsnme);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		LocalDateTime now = LocalDateTime.now(); 
		PropertyConfigurator.configure("Log4j.properties");
		logTime.info("Logging Started at "+dtf.format(now));
	}
	public void setLog(Class<?> Clsname,String msg){
		
		 
		Logger logger=Logger.getLogger(Clsname);
		PropertyConfigurator.configure("C:\\Users\\311035\\Desktop\\workspace\\PageObjectModel\\Log4j.properties");
		logger.info(msg);
		
	}
	
	
	public void endLog(Class<?> clsnme){
		Logger logTime=Logger.getLogger(clsnme);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		LocalDateTime now = LocalDateTime.now(); 
		PropertyConfigurator.configure("C:\\Users\\311035\\Desktop\\workspace\\PageObjectModel\\Log4j.properties");
		logTime.info("Logging Ended at "+dtf.format(now)+"\n=======================================================================================");
	}
}
