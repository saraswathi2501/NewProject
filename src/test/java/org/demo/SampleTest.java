package org.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest extends BaseClass{
	@BeforeClass
    private void beforeClass() {
	chromeBrowser();
}
	@Test
private void test() {
		urlLaunch("http://tutorialsninja.com/demo/");
}
}
