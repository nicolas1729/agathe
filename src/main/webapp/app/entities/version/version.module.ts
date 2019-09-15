import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AgatheSharedModule } from 'app/shared/shared.module';
import { VersionComponent } from './version.component';
import { VersionDetailComponent } from './version-detail.component';
import { VersionUpdateComponent } from './version-update.component';
import { VersionDeletePopupComponent, VersionDeleteDialogComponent } from './version-delete-dialog.component';
import { versionRoute, versionPopupRoute } from './version.route';

const ENTITY_STATES = [...versionRoute, ...versionPopupRoute];

@NgModule({
  imports: [AgatheSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    VersionComponent,
    VersionDetailComponent,
    VersionUpdateComponent,
    VersionDeleteDialogComponent,
    VersionDeletePopupComponent
  ],
  entryComponents: [VersionComponent, VersionUpdateComponent, VersionDeleteDialogComponent, VersionDeletePopupComponent]
})
export class AgatheVersionModule {}
