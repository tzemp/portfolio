/*
 * This file was automatically generated by EvoSuite
 * Mon May 25 19:45:31 GMT 2020
 */

package name.abuchen.portfolio.snapshot.security;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import name.abuchen.portfolio.snapshot.SecurityPosition;
import name.abuchen.portfolio.snapshot.security.DividendInitialTransaction;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockClock;
import org.evosuite.runtime.mock.java.time.MockLocalDateTime;
import org.evosuite.runtime.mock.java.time.MockOffsetDateTime;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DividendInitialTransaction_ESTest extends DividendInitialTransaction_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ZoneOffset zoneOffset0 = ZoneOffset.MAX;
      Clock clock0 = MockClock.tickMinutes(zoneOffset0);
      OffsetDateTime offsetDateTime0 = MockOffsetDateTime.now(clock0);
      LocalDateTime localDateTime0 = MockLocalDateTime.from(offsetDateTime0);
      DividendInitialTransaction dividendInitialTransaction0 = null;
      try {
        dividendInitialTransaction0 = new DividendInitialTransaction((SecurityPosition) null, localDateTime0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("name.abuchen.portfolio.snapshot.security.DividendInitialTransaction", e);
      }
  }
}
