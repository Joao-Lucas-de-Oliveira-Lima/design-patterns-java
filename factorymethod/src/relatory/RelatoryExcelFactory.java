package relatory;

import model.Relatory;
import model.RelatoryExcel;

public class RelatoryExcelFactory implements RelatoryFactory{

    @Override
    public Relatory createRelatory() {
        RelatoryExcel relatoryExcel = new RelatoryExcel();
        relatoryExcel.generateRelatory();
        return relatoryExcel;
    }
}
