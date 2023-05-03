import {PurchaseDto} from './Purchase.model';
import {TagDto} from './Tag.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PurchaseTagDto  extends BaseDto{

    public id: number;
    public purchase: PurchaseDto ;
    public tag: TagDto ;

}
