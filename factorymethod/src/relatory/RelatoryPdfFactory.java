package relatory;

import model.Relatory;
import model.RelatoryPdf;

public class RelatoryPdfFactory implements RelatoryFactory{

    @Override
    public Relatory createRelatory() {
        RelatoryPdf relatoryPdf = new RelatoryPdf();
        relatoryPdf.generateRelatory();
        return relatoryPdf;
    }
}
