import {PurchaseCriteria} from './PurchaseCriteria.model';
import {TagCriteria} from './TagCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PurchaseTagCriteria  extends   BaseCriteria  {

    public id: number;
  public purchase: PurchaseCriteria ;
  public purchases: Array<PurchaseCriteria> ;
  public tag: TagCriteria ;
  public tags: Array<TagCriteria> ;

}
