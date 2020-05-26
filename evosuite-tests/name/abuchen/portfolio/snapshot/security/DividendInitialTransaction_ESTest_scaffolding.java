/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Mon May 25 19:45:31 GMT 2020
 */

package name.abuchen.portfolio.snapshot.security;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class DividendInitialTransaction_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "name.abuchen.portfolio.snapshot.security.DividendInitialTransaction"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "/var/folders/yl/2gx75vtx2tbbxdrrdtjkplq80000gn/T/"); 
    java.lang.System.setProperty("user.country", "CH"); 
    java.lang.System.setProperty("user.dir", "/Users/timothyzemp/Projects/buchen_new"); 
    java.lang.System.setProperty("user.home", "/Users/timothyzemp"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "timothyzemp"); 
    java.lang.System.setProperty("user.timezone", "Europe/Zurich"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(DividendInitialTransaction_ESTest_scaffolding.class.getClassLoader() ,
      "name.abuchen.portfolio.model.AccountTransaction$Type",
      "name.abuchen.portfolio.model.Transaction",
      "name.abuchen.portfolio.model.Client",
      "name.abuchen.portfolio.money.CurrencyConverterImpl",
      "name.abuchen.portfolio.snapshot.AccountSnapshot",
      "name.abuchen.portfolio.money.MonetaryException",
      "name.abuchen.portfolio.snapshot.SecurityPosition",
      "name.abuchen.portfolio.model.ConfigurationSet$Configuration",
      "name.abuchen.portfolio.model.Classification",
      "name.abuchen.portfolio.money.ExchangeRateTimeSeries",
      "name.abuchen.portfolio.money.ExchangeRateProviderFactory$CurrencyPair",
      "name.abuchen.portfolio.model.Transaction$ByDate",
      "name.abuchen.portfolio.money.Values$QuoteValues",
      "name.abuchen.portfolio.model.ConfigurationSet",
      "com.thoughtworks.xstream.converters.ErrorReporter",
      "name.abuchen.portfolio.model.Transaction$Unit$Type",
      "name.abuchen.portfolio.money.MonetaryOperator",
      "com.thoughtworks.xstream.converters.Converter",
      "name.abuchen.portfolio.model.SecurityEvent$Type",
      "name.abuchen.portfolio.model.Account",
      "name.abuchen.portfolio.money.ExchangeRateProviderFactory",
      "com.thoughtworks.xstream.XStreamException",
      "name.abuchen.portfolio.model.SecurityProperty$Type",
      "com.thoughtworks.xstream.converters.SingleValueConverter",
      "com.thoughtworks.xstream.converters.reflection.ReflectionProvider$Visitor",
      "com.thoughtworks.xstream.converters.MarshallingContext",
      "name.abuchen.portfolio.model.InvestmentPlan",
      "name.abuchen.portfolio.model.Client$1",
      "com.thoughtworks.xstream.io.HierarchicalStreamReader",
      "com.thoughtworks.xstream.converters.ConverterMatcher",
      "com.thoughtworks.xstream.converters.ConverterLookup",
      "com.thoughtworks.xstream.core.util.FastField",
      "name.abuchen.portfolio.model.SecurityEvent",
      "name.abuchen.portfolio.model.PortfolioTransaction",
      "name.abuchen.portfolio.money.Money",
      "name.abuchen.portfolio.money.Values",
      "name.abuchen.portfolio.money.Quote",
      "name.abuchen.portfolio.money.ExchangeRateProvider",
      "name.abuchen.portfolio.model.CrossEntry",
      "com.thoughtworks.xstream.converters.ConversionException",
      "name.abuchen.portfolio.events.SecurityChangeEvent",
      "com.thoughtworks.xstream.mapper.Mapper",
      "name.abuchen.portfolio.model.SecurityProperty",
      "name.abuchen.portfolio.model.Taxonomy",
      "com.thoughtworks.xstream.converters.UnmarshallingContext",
      "name.abuchen.portfolio.model.Classification$Assignment",
      "name.abuchen.portfolio.money.Values$MoneyValues",
      "name.abuchen.portfolio.model.Taxonomy$2",
      "name.abuchen.portfolio.model.Taxonomy$1",
      "name.abuchen.portfolio.model.LatestSecurityPrice",
      "name.abuchen.portfolio.model.Named",
      "name.abuchen.portfolio.model.SecurityPrice",
      "com.thoughtworks.xstream.io.HierarchicalStreamWriter",
      "name.abuchen.portfolio.model.Adaptable",
      "com.thoughtworks.xstream.annotations.XStreamConverter",
      "name.abuchen.portfolio.model.TransactionOwner",
      "com.thoughtworks.xstream.converters.DataHolder",
      "name.abuchen.portfolio.model.Attributes",
      "name.abuchen.portfolio.money.Values$13",
      "name.abuchen.portfolio.money.Values$12",
      "name.abuchen.portfolio.money.Values$15",
      "name.abuchen.portfolio.money.Values$14",
      "name.abuchen.portfolio.money.Values$17",
      "name.abuchen.portfolio.money.Values$16",
      "name.abuchen.portfolio.money.Values$19",
      "name.abuchen.portfolio.money.Values$18",
      "com.thoughtworks.xstream.core.BaseException",
      "name.abuchen.portfolio.money.Values$11",
      "name.abuchen.portfolio.money.Values$10",
      "name.abuchen.portfolio.model.Security",
      "name.abuchen.portfolio.money.ExchangeRate",
      "name.abuchen.portfolio.snapshot.security.DividendInitialTransaction",
      "name.abuchen.portfolio.events.ChangeEvent",
      "name.abuchen.portfolio.model.Bookmark",
      "name.abuchen.portfolio.money.CurrencyConverter",
      "name.abuchen.portfolio.model.Attributable",
      "name.abuchen.portfolio.snapshot.SecurityPosition$1",
      "name.abuchen.portfolio.model.InvestmentVehicle",
      "com.thoughtworks.xstream.annotations.XStreamAlias",
      "com.thoughtworks.xstream.converters.ErrorWritingException",
      "com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter",
      "name.abuchen.portfolio.model.Annotated",
      "name.abuchen.portfolio.model.Dashboard$Widget",
      "com.thoughtworks.xstream.converters.reflection.ReflectionProvider",
      "name.abuchen.portfolio.model.Portfolio",
      "name.abuchen.portfolio.money.Values$9",
      "name.abuchen.portfolio.money.Values$8",
      "name.abuchen.portfolio.money.Values$7",
      "name.abuchen.portfolio.model.Dashboard",
      "name.abuchen.portfolio.model.AccountTransaction",
      "name.abuchen.portfolio.model.TransactionPair",
      "name.abuchen.portfolio.money.Values$2",
      "name.abuchen.portfolio.money.Values$1",
      "name.abuchen.portfolio.model.Transaction$Unit",
      "com.thoughtworks.xstream.converters.ErrorWriter",
      "name.abuchen.portfolio.money.Values$6",
      "name.abuchen.portfolio.model.Taxonomy$Visitor",
      "name.abuchen.portfolio.money.Values$5",
      "name.abuchen.portfolio.money.Values$4",
      "name.abuchen.portfolio.money.Values$3",
      "name.abuchen.portfolio.snapshot.SecurityPosition$Record",
      "name.abuchen.portfolio.model.AttributeType$Converter",
      "name.abuchen.portfolio.model.Category",
      "name.abuchen.portfolio.model.AttributeType",
      "name.abuchen.portfolio.model.PortfolioTransaction$Type",
      "com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$DuplicateFieldException",
      "name.abuchen.portfolio.model.ClientSettings"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(DividendInitialTransaction_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "name.abuchen.portfolio.model.Transaction",
      "name.abuchen.portfolio.snapshot.security.DividendInitialTransaction",
      "name.abuchen.portfolio.snapshot.SecurityPosition",
      "name.abuchen.portfolio.snapshot.SecurityPosition$1",
      "name.abuchen.portfolio.model.Security",
      "name.abuchen.portfolio.money.ExchangeRate",
      "name.abuchen.portfolio.money.CurrencyConverterImpl",
      "name.abuchen.portfolio.model.Account",
      "name.abuchen.portfolio.model.Client",
      "name.abuchen.portfolio.model.ClientSettings",
      "name.abuchen.portfolio.model.Bookmark",
      "name.abuchen.portfolio.model.AttributeType",
      "name.abuchen.portfolio.snapshot.AccountSnapshot",
      "name.abuchen.portfolio.money.Money",
      "name.abuchen.portfolio.money.ExchangeRateProviderFactory",
      "name.abuchen.portfolio.model.SecurityPrice",
      "name.abuchen.portfolio.model.Portfolio",
      "name.abuchen.portfolio.model.Transaction$ByDate",
      "name.abuchen.portfolio.model.InvestmentPlan",
      "name.abuchen.portfolio.model.LatestSecurityPrice",
      "name.abuchen.portfolio.model.Attributes",
      "name.abuchen.portfolio.model.SecurityProperty",
      "name.abuchen.portfolio.model.AccountTransaction",
      "name.abuchen.portfolio.model.PortfolioTransaction",
      "name.abuchen.portfolio.money.Values$1",
      "name.abuchen.portfolio.money.Values$MoneyValues",
      "name.abuchen.portfolio.money.Values$2",
      "name.abuchen.portfolio.money.Values$3",
      "name.abuchen.portfolio.money.Values$4",
      "name.abuchen.portfolio.money.Values$5",
      "name.abuchen.portfolio.money.Values$QuoteValues",
      "name.abuchen.portfolio.money.Values$6",
      "name.abuchen.portfolio.money.Values$7",
      "name.abuchen.portfolio.money.Values$8",
      "name.abuchen.portfolio.money.Values$9",
      "name.abuchen.portfolio.money.Values$10",
      "name.abuchen.portfolio.money.Values$11",
      "name.abuchen.portfolio.money.Values$12",
      "name.abuchen.portfolio.money.Values$13",
      "name.abuchen.portfolio.money.Values$14",
      "name.abuchen.portfolio.money.Values$15",
      "name.abuchen.portfolio.money.Values$16",
      "name.abuchen.portfolio.money.Values$17",
      "name.abuchen.portfolio.money.Values$18",
      "name.abuchen.portfolio.money.Values$19",
      "name.abuchen.portfolio.money.Values",
      "name.abuchen.portfolio.model.Transaction$Unit",
      "name.abuchen.portfolio.model.Dashboard",
      "name.abuchen.portfolio.model.SecurityEvent"
    );
  }
}
