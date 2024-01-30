// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pdfparser.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import pdfparser.impl.PdfParser;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Returns the modification date of a PDF as a DateTime.
 */
public class GetModificationDate extends CustomJavaAction<java.util.Date>
{
	private IMendixObject __inputFile;
	private system.proxies.FileDocument inputFile;

	public GetModificationDate(IContext context, IMendixObject inputFile)
	{
		super(context);
		this.__inputFile = inputFile;
	}

	@java.lang.Override
	public java.util.Date executeAction() throws Exception
	{
		this.inputFile = this.__inputFile == null ? null : system.proxies.FileDocument.initialize(getContext(), __inputFile);

		// BEGIN USER CODE
		IContext context = this.context(); 			
		
		if (inputFile != null && inputFile.getHasContents(context)) {
			PdfParser pdfParser = new PdfParser(); 									// Instantiates the PDF parser class
			return pdfParser.getModificationDate(__inputFile, context);
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
		return "GetModificationDate";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
