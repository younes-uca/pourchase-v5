import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PurchaseService} from 'src/app/controller/service/Purchase.service';
import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/PurchaseCriteria.model';

import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {TagDto} from 'src/app/controller/model/Tag.model';
import {TagService} from 'src/app/controller/service/Tag.service';
import {PurchaseTagDto} from 'src/app/controller/model/PurchaseTag.model';
import {PurchaseTagService} from 'src/app/controller/service/PurchaseTag.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {PurchaseItemDto} from 'src/app/controller/model/PurchaseItem.model';
import {PurchaseItemService} from 'src/app/controller/service/PurchaseItem.service';
@Component({
  selector: 'app-purchase-view-admin',
  templateUrl: './purchase-view-admin.component.html'
})
export class PurchaseViewAdminComponent extends AbstractViewController<PurchaseDto, PurchaseCriteria, PurchaseService> implements OnInit {

    purchaseItems = new PurchaseItemDto();
    purchaseItemss: Array<PurchaseItemDto> = [];
    purchaseTag = new PurchaseTagDto();
    purchaseTags: Array<PurchaseTagDto> = [];

    constructor(private purchaseService: PurchaseService, private productService: ProductService, private tagService: TagService, private purchaseTagService: PurchaseTagService, private clientService: ClientService, private purchaseItemService: PurchaseItemService){
        super(purchaseService);
    }

    ngOnInit(): void {
        this.purchaseItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.purchaseTag.tag = new TagDto();
        this.tagService.findAll().subscribe((data) => this.tags = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }


    get product(): ProductDto {
       return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products():Array<ProductDto> {
       return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get tag(): TagDto {
       return this.tagService.item;
    }
    set tag(value: TagDto) {
        this.tagService.item = value;
    }
    get tags():Array<TagDto> {
       return this.tagService.items;
    }
    set tags(value: Array<TagDto>) {
        this.tagService.items = value;
    }


}
