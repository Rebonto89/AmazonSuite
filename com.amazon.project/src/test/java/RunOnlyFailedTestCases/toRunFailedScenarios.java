/**
 * 
 */
package RunOnlyFailedTestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

/**
 * @author 311035
 *
 */
public class toRunFailedScenarios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TestNG runner=new TestNG();
        
        List<String>failedTc = new ArrayList<String>();
        failedTc.add("C:\\Users\\311035\\Desktop\\workspace\\com.amazon.project\\target\\surefire-reports\\Amazon Application Test Suite\\testng-failed.xml");
        runner.setTestSuites(failedTc);
        runner.run();
        
	}

}
