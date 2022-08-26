package extentreportstraining;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import freemarker.log.Logger;

public class BasicExtentReport {

	public static void main(String[] args) throws Exception {
		// BasicConfigurator.configure();
		/*
		 * Properties prop = new Properties(); prop.setProperty("log4j.rootLogger",
		 * "WARN"); PropertyConfigurator.configure(prop);
		 */

		ExtentReports extentreport = new ExtentReports();
		File file = new File("\\reports\\report.html");
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(extentsparkreporter);

		//creating test with pass
		ExtentTest test1 = extentreport.createTest("Test 1");
		test1.pass("this is passed");
		
		//creating test with log
		ExtentTest test2 = extentreport.createTest("Test 2");
		test2.log(Status.FAIL, "This is failed");
		
		//crearing test without initializing
		extentreport.createTest("Test 3").skip("This is skipped");
		
		extentreport.createTest("Test 4")
		.log(Status.INFO, "info")
		.log(Status.INFO, "info2")
		.log(Status.INFO, "info3")
		.log(Status.PASS, "pass1")
		.log(Status.PASS, "Pass2")
		.log(Status.WARNING, "Warning")
		.log(Status.INFO, "info4")
		.log(Status.SKIP, "Skip")
		.log(Status.SKIP, "Skip1")
		.log(Status.FAIL, "Fail");
	//order Fail>Skip>Warning>Pass>Info

		extentreport.createTest("Text based Test")
		.log(Status.INFO, "info")
		.log(Status.INFO, "<b>info1</b>")
		.log(Status.INFO, "<i>info2</i>")
		.log(Status.INFO, "<strong>info3</strong>")
		.log(Status.INFO, "<em>info4</em>")
		.log(Status.INFO, "<mark>info5</mark>")
		.log(Status.INFO, "<small>info6</small>")
		.log(Status.INFO, "<ins>info7</ins>")
		.log(Status.INFO, "<del>info8</del>")
		.log(Status.INFO, "<sub>info9</sub>")
		.log(Status.INFO, "<sup>info10</sup>")
		.log(Status.INFO, "<b><i>info11</i></b>");
		
		String xmldata = "<!DOCTYPE glossary PUBLIC \"-//OASIS//DTD DocBook V3.1//EN\">\r\n"
				+ " <glossary><title>example glossary</title>\r\n"
				+ "  <GlossDiv><title>S</title>\r\n"
				+ "   <GlossList>\r\n"
				+ "    <GlossEntry ID=\"SGML\" SortAs=\"SGML\">\r\n"
				+ "     <GlossTerm>Standard Generalized Markup Language</GlossTerm>\r\n"
				+ "     <Acronym>SGML</Acronym>\r\n"
				+ "     <Abbrev>ISO 8879:1986</Abbrev>\r\n"
				+ "     <GlossDef>\r\n"
				+ "      <para>A meta-markup language, used to create markup\r\n"
				+ "languages such as DocBook.</para>\r\n"
				+ "      <GlossSeeAlso OtherTerm=\"GML\">\r\n"
				+ "      <GlossSeeAlso OtherTerm=\"XML\">\r\n"
				+ "     </GlossDef>\r\n"
				+ "     <GlossSee OtherTerm=\"markup\">\r\n"
				+ "    </GlossEntry>\r\n"
				+ "   </GlossList>\r\n"
				+ "  </GlossDiv>\r\n"
				+ " </glossary>";
		
		String jsondata= "{\r\n"
				+ "    \"glossary\": {\r\n"
				+ "        \"title\": \"example glossary\",\r\n"
				+ "		\"GlossDiv\": {\r\n"
				+ "            \"title\": \"S\",\r\n"
				+ "			\"GlossList\": {\r\n"
				+ "                \"GlossEntry\": {\r\n"
				+ "                    \"ID\": \"SGML\",\r\n"
				+ "					\"SortAs\": \"SGML\",\r\n"
				+ "					\"GlossTerm\": \"Standard Generalized Markup Language\",\r\n"
				+ "					\"Acronym\": \"SGML\",\r\n"
				+ "					\"Abbrev\": \"ISO 8879:1986\",\r\n"
				+ "					\"GlossDef\": {\r\n"
				+ "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\r\n"
				+ "						\"GlossSeeAlso\": [\"GML\", \"XML\"]\r\n"
				+ "                    },\r\n"
				+ "					\"GlossSee\": \"markup\"\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
		
		String xmldata1 = "<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		String jsondata1 = "{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		
		extentreport.createTest("test6")
		.info(MarkupHelper.createCodeBlock(xmldata, CodeLanguage.XML));
		
		extentreport.createTest("test7")
		.log(Status.INFO, (MarkupHelper.createCodeBlock(jsondata, CodeLanguage.JSON)));
		
		extentreport.createTest("test8").info(MarkupHelper.createCodeBlock(xmldata1 , CodeLanguage.XML));
		extentreport.createTest("test9").log(Status.INFO, MarkupHelper.createCodeBlock(jsondata1, CodeLanguage.JSON));
		
		/*
		 * extentreport.createTest("test6") .log(Status.INFO, xmldata);
		 * 
		 * extentreport.createTest("test7") .log(Status.INFO, jsondata);
		 */
		
		List<String> listdata =  new ArrayList<String>();
		listdata.add("Abcd");
		listdata.add("bfer");
		listdata.add("ytug");
		
		Map<Integer, String> mapdata = new HashMap<Integer, String>();
		mapdata.put(101, "abcd");
		mapdata.put(102, "jsondata1");
		mapdata.put(103, "jsondata2");
		
		Set<Integer> setdata = mapdata.keySet();
		
		extentreport.createTest("test12").info(MarkupHelper.createOrderedList(listdata))
		.info(MarkupHelper.createUnorderedList(listdata));
		
		extentreport.createTest("test13").info(MarkupHelper.createOrderedList(mapdata))
		.info(MarkupHelper.createUnorderedList(mapdata));
		
		extentreport.createTest("test13").info(MarkupHelper.createOrderedList(setdata))
		.info(MarkupHelper.createUnorderedList(setdata));
		
		
		extentreport.createTest("test14")
		.info("this is not a highlighted methid test")
		.info(MarkupHelper.createLabel("This is a higlighted messgae", ExtentColor.RED));
		
		try {
			int i=5/0;
		}catch(Exception e) {
			extentreport.createTest("test15")
			.fail(e);
		}
		
		Throwable t= new RuntimeException("This is custom exception");
		extentreport.createTest("test16")
		.fail(t);
		
		
		
		extentreport.flush();
		//to directly lunch report html file
		Desktop.getDesktop().browse(new File("\\reports\\report.html").toURI());
		

	}

}
