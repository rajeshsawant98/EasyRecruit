// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pdfparsertesting.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import pdfparser.impl.PdfParser;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Retrieves the content of a PDF file and returns it as a string.
 */
public class ChkRapidCertifiedStatus extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __inputFile;
	private system.proxies.FileDocument inputFile;

	public ChkRapidCertifiedStatus(IContext context, IMendixObject inputFile)
	{
		super(context);
		this.__inputFile = inputFile;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.inputFile = this.__inputFile == null ? null : system.proxies.FileDocument.initialize(getContext(), __inputFile);

		// BEGIN USER CODE
		IContext context = this.context(); 											// Return Mendix context

		if (inputFile != null && inputFile.getHasContents(context)) {
			PdfParser pdfParser = new PdfParser(); 									// Instantiates the PDF parser class
			String content= pdfParser.getContent(__inputFile, context);
		    Boolean status = false;
		    if(content.contains("mendix rapid certified"))
		    	status=true;
		    else if(content.contains("Mendix Rapid Certified"))
		    	status=true;
		    else if(content.contains("MENDIX RAPID CERTIFIED"))
		    	status=true;
		    else if(content.contains("Rapid Developer"))
		    	status=true;
		    else if(content.contains("RAPID DEVELOPER"))
		    	status=true;
		    else
		    	status=false;
		   
		      return status;
		}

		else {
			throw new NullPointerException("Empty input file in PDF Parser.");
		}

		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "ChkRapidCertifiedStatus";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}