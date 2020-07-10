using iText.IO.Font;
using iText.Kernel.Colors;
using iText.Kernel.Font;
using iText.Kernel.Pdf;
using iText.Layout;
using iText.Layout.Element;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace ConsoleApp1
{
    class WordWrapping

    {
        String thaiText = "อักษรมอญและอักษรขอมที่ไทยนำมาดัดแปลงใช้นั้นล้วนเป็นอักษรที่รับและแปลงรูปมาจากอักษรพราหมี " +
        "ของพวกพราหมณ์ซึ่งแพร่หลายในอินเดียตอน เหนือ และอักษรสันสกฤตในสมัยราชวงศ์ปัลลวะ ซึ่งแพร่หลายบริเวณอินเดียตอนใต้ " +
        "อักษรอินเดียทั้งคู่นี้ต่างก็รับแบบมาจากอักษรฟินิเชียนอีกชั้นหนึ่ง อักษรเฟนีเซียนับได้ว่าเป็นอักษรที่เก่าแก่ที่สุด และเป็นแม่แบบตัวอักษรของชาติต่างๆ ทั้งในเอเชียและยุโรป";
        public void thaiWrappingExample(String outPutFilePath, String fontPath)
        {

            try
            {
                PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outPutFilePath));
                Document doc = new Document(pdfDoc);
                //add thaiText to a paragraph
                Paragraph paragraph = new Paragraph(this.thaiText);
                //set with of paragraph (optional)
                paragraph.SetWidth(50);
                //set background color of paragraph (optional)
                paragraph.SetBackgroundColor(ColorConstants.LIGHT_GRAY);
                //add paragraph to document and createFont with specified path to Thai font add Pdf Encodings
                doc.Add(paragraph.SetFont(PdfFontFactory.CreateFont(fontPath, PdfEncodings.IDENTITY_H)));
                doc.Close();
            }
            catch (FileNotFoundException e)
            {
                Console.WriteLine(e.StackTrace);
            }
            catch (IOException e)
            {
                Console.WriteLine(e.StackTrace);
            }
        }
    }
}
