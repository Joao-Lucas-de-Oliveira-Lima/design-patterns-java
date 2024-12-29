import model.Relatory;
import relatory.RelatoryCsvFactory;
import relatory.RelatoryExcelFactory;
import relatory.RelatoryFactory;
import relatory.RelatoryPdfFactory;

public class App {
    public static void main(String[] args){ 
        RelatoryFactory factory;

        factory = new RelatoryPdfFactory();
        Relatory pdfReport = factory.createRelatory();


        factory = new RelatoryCsvFactory();
        Relatory csvReport = factory.createRelatory();

        factory = new RelatoryExcelFactory();
        Relatory excelReport = factory.createRelatory();
    }
}
