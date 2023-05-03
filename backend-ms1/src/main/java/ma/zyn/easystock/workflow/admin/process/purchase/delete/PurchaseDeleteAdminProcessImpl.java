package ma.zyn.easystock.workflow.admin.process.purchase.delete;
import ma.zyn.easystock.service.facade.admin.PurchaseAdminService;

import ma.zyn.easystock.zynerator.process.AbstractProcessImpl;
import ma.zyn.easystock.zynerator.process.Result;
import ma.zyn.easystock.bean.core.Purchase;

public class PurchaseDeleteAdminProcessImpl extends AbstractProcessImpl<PurchaseDeleteAdminInput, PurchaseDeleteAdminOutput,  Purchase,  PurchaseDeleteAdminConverter> implements PurchaseDeleteAdminProcess {

    @Override
    public void init(PurchaseDeleteAdminInput input, Purchase item) {

    }

    @Override
    public void validate(PurchaseDeleteAdminInput input, Purchase item, Result<PurchaseDeleteAdminInput, PurchaseDeleteAdminOutput, Purchase> result) {
        
    }

    @Override
    public void run(PurchaseDeleteAdminInput input, Purchase t, Result<PurchaseDeleteAdminInput, PurchaseDeleteAdminOutput, Purchase> result) {
        
    }
    


    private PurchaseAdminService service;
    public PurchaseDeleteAdminProcessImpl(PurchaseAdminService service, PurchaseDeleteAdminConverter converter) {
        super(converter);
        this.service = service;
    }

}
