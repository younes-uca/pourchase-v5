import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PurchaseTagDto} from '../model/PurchaseTag.model';
import {PurchaseTagCriteria} from '../criteria/PurchaseTagCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {PurchaseDto} from '../model/Purchase.model';
import {TagDto} from '../model/Tag.model';

@Injectable({
  providedIn: 'root'
})
export class PurchaseTagService extends AbstractService<PurchaseTagDto, PurchaseTagCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/purchaseTag/');
    }

    public constrcutDto(): PurchaseTagDto {
        return new PurchaseTagDto();
    }

    public constrcutCriteria(): PurchaseTagCriteria {
        return new PurchaseTagCriteria();
    }
}
