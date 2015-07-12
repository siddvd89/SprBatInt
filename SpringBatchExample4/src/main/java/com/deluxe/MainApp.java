package com.deluxe;

import java.io.File;

import org.springframework.beans.DirectFieldAccessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.file.*;
import org.springframework.expression.common.*;
public class MainApp {

	public static void main(String[] args) {

		MainApp obj = new MainApp();
		obj.run();

	}
	
	private void run() {

		String[] springConfig = { "spring/batch/jobs/job-poll.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		File inDir = (File) new DirectFieldAccessor(context.getBean(FileReadingMessageSource.class)).getPropertyValue("directory");
		LiteralExpression expression = (LiteralExpression) new DirectFieldAccessor(context.getBean(FileWritingMessageHandler.class)).getPropertyValue("destinationDirectoryExpression");
		File outDir = new File(expression.getValue());
		System.out.println("Input directory is: " + inDir.getAbsolutePath());
		System.out.println("Output directory is: " + outDir.getAbsolutePath());
	}
	
}
