package gergo.keszletkezelo.service;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import gergo.keszletkezelo.domain.Invoice;
import javafx.collections.ObservableList;

public class pdfGeneration {

    public void generatePDF(String filename, ObservableList<Invoice>data, String invoiceNumber){
        Document document = new Document();

        try {
            //Céges logó
            PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
            document.open();
            com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(getClass().getResource("/logo.png"));
            image1.scaleToFit(200, 120);
            image1.setAbsolutePosition(225f, 715f);
            document.add(image1); //hozzáadjuk a képet a doksihoz

//sortörés
            document.add(new Paragraph("\n\n\n\n\n\n"));
            Chunk invoicenum = new Chunk("Számlaszám: "+invoiceNumber);
            document.add(invoicenum);
            //táblázat betöltése
            float[] columWidths = {2, 4, 2, 2, 2, 2}; //oszlopok szélességét arányosítjuk
            PdfPTable table = new PdfPTable(columWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("szamla"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(6);
            table.addCell(cell);

            table.getDefaultCell().setBackgroundColor(new GrayColor(0.70f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Sorszám");
            table.addCell("Név");
            table.addCell("Típus");
            table.addCell("Év");
            table.addCell("Darab");
            table.addCell("Egységár");
            table.setHeaderRows(1);

            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);

            for (int i = 1; i <= data.size(); i++) {
                Invoice actualInvoice = data.get(i - 1);
                table.addCell("" + i);
                table.addCell(actualInvoice.getName());
                table.addCell(actualInvoice.getType());
                table.addCell(actualInvoice.getYear());
                table.addCell(actualInvoice.getPiece());
                table.addCell(actualInvoice.getPrice());
            }

            document.add(table);

            //Aláírás
            Chunk signature = new Chunk("\n\n\n Generálva a Készletkezelő alkalmazás segítségével");
            Paragraph base = new Paragraph(signature);
            document.add(base);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        document.close();
    }
}
