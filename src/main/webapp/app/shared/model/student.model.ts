import { IDepartment } from 'app/shared/model/department.model';

export interface IStudent {
  id?: string;
  name?: string | null;
  stream?: string | null;
  course?: string | null;
  percentage?: number | null;
  departments?: IDepartment[] | null;
}

export const defaultValue: Readonly<IStudent> = {};
