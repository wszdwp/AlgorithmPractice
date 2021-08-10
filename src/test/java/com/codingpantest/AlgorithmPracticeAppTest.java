import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmPracticeAppTest {
  @Test
  public void testAppHasAGreeting() {
    com.codingpan.AlgorithmPracticeApp classUnderTest = new com.codingpan.AlgorithmPracticeApp();
    assertNotNull("app should have a greeting", classUnderTest.getGreeting());
  }
}
