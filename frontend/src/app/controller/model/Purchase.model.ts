import {PurchaseTagDto} from './PurchaseTag.model';
import {PurchaseItemDto} from './PurchaseItem.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PurchaseDto  extends BaseDto{

    public id: number;
    public reference: string;
   public purchaseDate: Date;
    public image: string;
    public total: number;
    public description: string;
    public purchaseDateMax: string ;
    public purchaseDateMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public client: ClientDto ;
     public purchaseItems: Array<PurchaseItemDto>;
     public purchaseTag: Array<PurchaseTagDto>;

}
