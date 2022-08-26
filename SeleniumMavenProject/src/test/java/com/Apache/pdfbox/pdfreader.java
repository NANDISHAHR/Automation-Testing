package com.Apache.pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pdfreader {

	@Test
	public void readPDFfile() throws Exception {

		File file = new File("C:\\Users\\nandish.h.r\\Downloads\\file-sample_150kB.pdf");
		FileInputStream fis = new FileInputStream(file);

		PDDocument pdfdocument = PDDocument.load(fis);
		System.out.println(pdfdocument.getPages().getCount());
		
		PDFTextStripper pdftextstripper = new PDFTextStripper();
		pdftextstripper.setStartPage(2);
		pdftextstripper.setEndPage(3);
		String documenttext = pdftextstripper.getText(pdfdocument);
		System.out.println(documenttext);
		Assert.assertTrue(documenttext.startsWith("Lorem ipsum"));
		pdfdocument.close();
		fis.close();

	}

}