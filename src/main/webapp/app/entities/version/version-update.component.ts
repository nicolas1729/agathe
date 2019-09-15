import { Component, OnInit } from '@angular/core';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { IVersion, Version } from 'app/shared/model/version.model';
import { VersionService } from './version.service';

@Component({
  selector: 'jhi-version-update',
  templateUrl: './version-update.component.html'
})
export class VersionUpdateComponent implements OnInit {
  isSaving: boolean;
  dateDp: any;

  editForm = this.fb.group({
    id: [],
    nom: [],
    date: [],
    versionCommunautaire: [],
    commentaire: []
  });

  constructor(protected versionService: VersionService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ version }) => {
      this.updateForm(version);
    });
  }

  updateForm(version: IVersion) {
    this.editForm.patchValue({
      id: version.id,
      nom: version.nom,
      date: version.date,
      versionCommunautaire: version.versionCommunautaire,
      commentaire: version.commentaire
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const version = this.createFromForm();
    if (version.id !== undefined) {
      this.subscribeToSaveResponse(this.versionService.update(version));
    } else {
      this.subscribeToSaveResponse(this.versionService.create(version));
    }
  }

  private createFromForm(): IVersion {
    return {
      ...new Version(),
      id: this.editForm.get(['id']).value,
      nom: this.editForm.get(['nom']).value,
      date: this.editForm.get(['date']).value,
      versionCommunautaire: this.editForm.get(['versionCommunautaire']).value,
      commentaire: this.editForm.get(['commentaire']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IVersion>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
