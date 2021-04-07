/**
 * 
 */
package TestNgListeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

/**
 * @author 311035
 *
 */
public class ReportListeners implements ITestListener, IReporter {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("The following Test Suite of " +arg0.getName()+" Finished");
	}

	public void onStart(ITestContext res) {
		// TODO Auto-generated method stub
		System.out.println("The following Test Suite of " +res.getName()+" Started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The Test Case  " + result.getName()+ "Failed\n"+"====================================================");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The following Test case "+result.getName()+" Skipped\n"+"====================================================");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The following Test case "+result.getName()+" Started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The following Test case "+result.getName()+" Passed\n"+"====================================================");
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String OutPutDir) {
		// TODO Auto-generated method stub
		
		//Iterating over each suite included in the test
	      for (ISuite suite : suites) {
	            
	         //Following code gets the suite name
	         String suiteName = suite.getName();
	            
	         //Getting the results for the said suite
	         Map<String, ISuiteResult> suiteResults = suite.getResults();
	         for (ISuiteResult sr : suiteResults.values()) {
	            ITestContext tc = sr.getTestContext();
	            System.out.println("Passed tests for suite '" + suiteName +
	               "' is:" + tc.getPassedTests().getAllResults().size());
	            System.out.println("Failed tests for suite '" + suiteName +
	               "' is:" + tc.getFailedTests().getAllResults().size());
	            System.out.println("Skipped tests for suite '" + suiteName +
	               "' is:" + tc.getSkippedTests().getAllResults().size());
	         }
	      }
		
	}

	
}
