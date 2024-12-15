package relatory;

import model.Relatory;
import model.RelatoryCsv;

public class RelatoryCsvFactory implements RelatoryFactory{

    @Override
    public Relatory createRelatory() {
        RelatoryCsv relatoryCsv = new RelatoryCsv();
        relatoryCsv.generateRelatory();
        return relatoryCsv;
    }
}
