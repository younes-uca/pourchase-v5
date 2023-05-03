import {Component, OnInit} from '@angular/core';
import {TagService} from 'src/app/controller/service/Tag.service';
import {TagDto} from 'src/app/controller/model/Tag.model';
import {TagCriteria} from 'src/app/controller/criteria/TagCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-tag-list-admin',
  templateUrl: './tag-list-admin.component.html'
})
export class TagListAdminComponent extends AbstractListController<TagDto, TagCriteria, TagService>  implements OnInit {

    fileName = 'Tag';

  
    constructor(tagService: TagService) {
        super(tagService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadTags(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Tag', 'list');
        isPermistted ? this.service.findAll().subscribe(tags => this.items = tags,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'reference', header: 'Reference'},
        ];
    }



	public initDuplicate(res: TagDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Reference': e.reference ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
        }];
      }
}
