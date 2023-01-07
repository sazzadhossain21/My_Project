package hooks;


import generic.SuperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks_Class extends SuperClass {
@Before
public void setUp() {
	initial();
}
@After
public void tearDown() {
	driver.quit();
}
}
