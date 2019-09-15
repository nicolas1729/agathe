import { Moment } from 'moment';

export interface IVersion {
  id?: number;
  nom?: string;
  date?: Moment;
  versionCommunautaire?: string;
  commentaire?: string;
}

export class Version implements IVersion {
  constructor(
    public id?: number,
    public nom?: string,
    public date?: Moment,
    public versionCommunautaire?: string,
    public commentaire?: string
  ) {}
}
