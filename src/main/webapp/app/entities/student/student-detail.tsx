import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './student.reducer';

export const StudentDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const studentEntity = useAppSelector(state => state.student.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="studentDetailsHeading">Student</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{studentEntity.id}</dd>
          <dt>
            <span id="name">Name</span>
          </dt>
          <dd>{studentEntity.name}</dd>
          <dt>
            <span id="stream">Stream</span>
          </dt>
          <dd>{studentEntity.stream}</dd>
          <dt>
            <span id="course">Course</span>
          </dt>
          <dd>{studentEntity.course}</dd>
          <dt>
            <span id="percentage">Percentage</span>
          </dt>
          <dd>{studentEntity.percentage}</dd>
          <dt>Department</dt>
          <dd>
            {studentEntity.departments
              ? studentEntity.departments.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {studentEntity.departments && i === studentEntity.departments.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/student" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/student/${studentEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default StudentDetail;
