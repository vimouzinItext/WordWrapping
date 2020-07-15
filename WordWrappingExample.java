package WordWrapExample;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WordWrappingExample {
    String thaiText="อักษรมอญและอักษรขอมที่ไทยนำมาดัดแปลงใช้นั้นล้วนเป็นอักษรที่รับและแปลงรูปมาจากอักษรพราหมี " +
            "ของพวกพราหมณ์ซึ่งแพร่หลายในอินเดียตอน เหนือ และอักษรสันสกฤตในสมัยราชวงศ์ปัลลวะ ซึ่งแพร่หลายบริเวณอินเดียตอนใต้ " +
            "อักษรอินเดียทั้งคู่นี้ต่างก็รับแบบมาจากอักษรฟินิเชียนอีกชั้นหนึ่ง อักษรเฟนีเซียนับได้ว่าเป็นอักษรที่เก่าแก่ที่สุด และเป็นแม่แบบตัวอักษรของชาติต่างๆ ทั้งในเอเชียและยุโรป";
    /**
     * Some languages don't use spaces to separate words and instead use spaces to only separate sentences.
     * An Example of one of these languages is Thai.
     * Itext has developed an advanced mechanism that allows for
     * wrapping at word boundaries for languages which don't use spaces for word separation
     * */
    public  void thaiWrappingExample(String outPutFilePath, String fontPath){

        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outPutFilePath));
            Document doc = new Document(pdfDoc);
            //add thaiText to a paragraph
            Paragraph paragraph = new Paragraph(this.thaiText);
            //set width of paragraph (optional)
            paragraph.setWidth(50);
            //set background color of paragraph (optional)
            paragraph.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            //add paragraph to document and createFont with specified path to Thai font add Pdf Encodings
            doc.add(paragraph.setFont(PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H)));
            doc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
