package pdfparser.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.text.PDFTextStripper;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import system.proxies.FileDocument;

public class PdfParser {

	public String getAuthor(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			return info.getAuthor();
		} finally {
			closeStream(inputStream);
		}
	}

	
	public String getContent(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			return pdfStripper.getText(document);

		} finally {
			closeStream(inputStream);
		}
	}
	
	public Date getCreationDate(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			Calendar calendar = info.getCreationDate();

			return calendar == null ? null : calendar.getTime();

		} finally {
			closeStream(inputStream);
		}
	}

	public Integer getPageCount(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			return document.getNumberOfPages();

		} finally {
			closeStream(inputStream);
		}
	}
	
	public Date getModificationDate(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			Calendar calendar = info.getModificationDate();

			return calendar == null ? null : calendar.getTime();

		} finally {
			closeStream(inputStream);
		}
	}
	
	public String getKeywords(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			return info.getKeywords();

		} finally {
			closeStream(inputStream);
		}
	}
	
	public String getSubject(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			return info.getSubject();

		} finally {
			closeStream(inputStream);
		}
	}

	public String getTitle(IMendixObject inputFile, IContext context) throws Exception {
		InputStream inputStream = null;

		try {
			inputStream = Core.getFileDocumentContent(context, inputFile);
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			return info.getTitle();

		} finally {
			closeStream(inputStream);
		}
	}


	public void setAuthor(FileDocument inputFile, IContext context, String author) throws Exception {
		InputStream inputStream = null;
		ByteArrayInputStream newInputStream = null;
		try {
			inputStream = Core.getFileDocumentContent(context, inputFile.getMendixObject());
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();

			info.setAuthor(author);
			document.setDocumentInformation(info);
			newInputStream = createByteArrayInputStream(document);
			Core.storeFileDocumentContent(context, inputFile.getMendixObject(), newInputStream);

		} finally {
			closeStream(inputStream);
			closeStream(newInputStream);
		}
	}
	
	public void setTitle(FileDocument inputFile, IContext context, String title) throws Exception {
		InputStream inputStream = null;
		ByteArrayInputStream newInputStream = null;
		try {
			inputStream = Core.getFileDocumentContent(context, inputFile.getMendixObject());
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();

			info.setTitle(title);
			document.setDocumentInformation(info);
			newInputStream = createByteArrayInputStream(document);
			Core.storeFileDocumentContent(context, inputFile.getMendixObject(), newInputStream);

		} finally {
			closeStream(inputStream);
			closeStream(newInputStream);
		}
	}

	public void setKeywords(FileDocument inputFile, IContext context, String keywords) throws Exception {
		InputStream inputStream = null;
		ByteArrayInputStream newInputStream = null;
		try {
			inputStream = Core.getFileDocumentContent(context, inputFile.getMendixObject());
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();

			info.setKeywords(keywords);
			document.setDocumentInformation(info);
			newInputStream = createByteArrayInputStream(document);
			Core.storeFileDocumentContent(context, inputFile.getMendixObject(), newInputStream);

		} finally {
			closeStream(inputStream);
			closeStream(newInputStream);
		}
	}
	
	public void setSubject(FileDocument inputFile, IContext context, String subject) throws Exception {
		InputStream inputStream = null;
		ByteArrayInputStream newInputStream = null;
		try {
			inputStream = Core.getFileDocumentContent(context, inputFile.getMendixObject());
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();

			info.setSubject(subject);
			document.setDocumentInformation(info);
			newInputStream = createByteArrayInputStream(document);
			Core.storeFileDocumentContent(context, inputFile.getMendixObject(), newInputStream);

		} finally {
			closeStream(inputStream);
			closeStream(newInputStream);
		}
	}	
	
	public void setCreationDate(FileDocument inputFile, IContext context, Date creationDate) throws Exception {
		InputStream inputStream = null;
		ByteArrayInputStream newInputStream = null;
		try {
			inputStream = Core.getFileDocumentContent(context, inputFile.getMendixObject());
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			info.setCreationDate(dateToCalendar(creationDate));
			document.setDocumentInformation(info);
			newInputStream = createByteArrayInputStream(document);
			Core.storeFileDocumentContent(context, inputFile.getMendixObject(), newInputStream);

		} finally {
			closeStream(inputStream);
			closeStream(newInputStream);
		}
	}	
	
	public void setModificationDate(FileDocument inputFile, IContext context, Date modificationDate) throws Exception {
		InputStream inputStream = null;
		ByteArrayInputStream newInputStream = null;
		try {
			inputStream = Core.getFileDocumentContent(context, inputFile.getMendixObject());
			PDDocument document = PDDocument.load(inputStream);
			PDDocumentInformation info = document.getDocumentInformation();
			info.setModificationDate(dateToCalendar(modificationDate));
			document.setDocumentInformation(info);
			newInputStream = createByteArrayInputStream(document);
			Core.storeFileDocumentContent(context, inputFile.getMendixObject(), newInputStream);

		} finally {
			closeStream(inputStream);
			closeStream(newInputStream);
		}
	}	
	
	private ByteArrayInputStream createByteArrayInputStream(PDDocument document) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		document.save(out);
		ByteArrayInputStream newInputStream = new ByteArrayInputStream(out.toByteArray());
		return newInputStream;
	}
	
	private void closeStream(InputStream inputStream) throws Exception {
		if (inputStream != null) {
			inputStream.close();
		}		
	}
	
	private Calendar dateToCalendar(Date date){ 
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  return calendar;
		}
}
