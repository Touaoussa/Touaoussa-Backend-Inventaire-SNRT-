package com.inventry.project.configuration;

import org.apache.catalina.valves.ErrorReportValve;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;



public class CustomError  extends ErrorReportValve{

	// Create a simple logger
    Logger log = Logger.getLogger(CustomError.class.getName());

    @Override
    protected void report(Request request, Response response, Throwable t) {
        try {
            // Write a more friendly, less technical message to the user
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            out.write("<html><head><title>Oops</title><body>");
            out.write("<h1>Oops</h1>");
            out.write("<p>Well, that didn't go as we had expected.</p>");
            out.write("<p>Don't worry though, we're working on it.</p>");
            out.write("</body></html>");
            out.close();

            // Log the error with your favorite logging framework...
            log.severe("Uncaught throwable was thrown: " + t.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
