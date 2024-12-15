import model.Relatory;
import relatory.RelatoryCsvFactory;
import relatory.RelatoryExcelFactory;
import relatory.RelatoryFactory;
import relatory.RelatoryPdfFactory;

public class App {
    public static void main(String[] args){
        Relatory relatory;
        RelatoryFactory relatoryFactory;
        
        relatoryFactory = new RelatoryPdfFactory();
        relatory = relatoryFactory.createRelatory();


        relatoryFactory = new RelatoryCsvFactory();
        relatory = relatoryFactory.createRelatory();

        relatoryFactory = new RelatoryExcelFactory();
        relatory = relatoryFactory.createRelatory();
    }
}
