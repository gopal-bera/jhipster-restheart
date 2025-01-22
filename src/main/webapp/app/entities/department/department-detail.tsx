import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './department.reducer';

export const DepartmentDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const departmentEntity = useAppSelector(state => state.department.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="departmentDetailsHeading">Department</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{departmentEntity.id}</dd>
          <dt>
            <span id="name">Name</span>
          </dt>
          <dd>{departmentEntity.name}</dd>
          <dt>
            <span id="location">Location</span>
          </dt>
          <dd>{departmentEntity.location}</dd>
          <dt>
            <span id="university">University</span>
          </dt>
          <dd>{departmentEntity.university}</dd>
          <dt>Student</dt>
          <dd>
            {departmentEntity.students
              ? departmentEntity.students.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {departmentEntity.students && i === departmentEntity.students.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/department" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/department/${departmentEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default DepartmentDetail;
