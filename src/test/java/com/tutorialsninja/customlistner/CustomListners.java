package com.tutorialsninja.customlistner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        ITestListener.super.onTestFailure(result);
//        // This step take screenshot and store in to test-output/html folder
//       // String screenshotName = Utility.takeScreenShot(result.getName());
//
//        //This line Required for  ReportNG reports
//        System.setProperty("org.uncommons.reportng.escape-output", "false");
//
//        // Attach the Screenshot
//        Reporter.log("Click to see screenshot");
//        Reporter.log("<a target = \"_blank\" href=" + screenshotName + ">Screenshot</a>");
//        Reporter.log("<br>");
//        Reporter.log("<br>");
//        Reporter.log("<a target = \"_blank\" href=" + screenshotName + "><img src=" + screenshotName + " height=200 width=200></img></a>");
//
//
//    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
