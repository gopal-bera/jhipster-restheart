import { IStudent } from 'app/shared/model/student.model';

export interface IDepartment {
  id?: string;
  name?: string | null;
  location?: string | null;
  university?: string | null;
  students?: IStudent[] | null;
}

export const defaultValue: Readonly<IDepartment> = {};
