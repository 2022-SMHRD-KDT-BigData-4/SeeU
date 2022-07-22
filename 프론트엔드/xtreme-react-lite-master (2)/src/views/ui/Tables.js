import ProjectTables from "../../components/dashboard/ProjectTable";
import { Row, Col, Table, Card, CardTitle, CardBody } from "reactstrap";
import { Link, useLocation } from "react-router-dom";
import 'css/Board.css';
import Pagination from 'modals/Pagination';

const Tables = () => {
  return (
    <Row>
      <Col lg="12">
        <Card>
          <CardTitle tag="h6" className="border-bottom p-3 mb-0">
            <i className="bi bi-card-text me-2"> </i>
            Table with Me <Link to="/Badges"><button style={{position:"relative", left:950, borderRadius: 5, height: 35}}>글 쓰기 💌</button></Link>
          </CardTitle>
          <CardBody className="">
            <Table bordered striped>
              <thead>
                <tr className="z">
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                </tr>
              </thead>
              <tbody>
                <tr className="z">
                  <th scope="row">1</th>
                  <td><Link to="/Buttons" className="em-3">신고합니다</Link></td>
                  <td>태리니</td>
                  <td>2022-06-22</td>
                </tr>
                <tr className="z">
                  <th scope="row">2</th>
                  <td>행복합니다</td>
                  <td>정형</td>
                  <td>2022-02-22</td>
                </tr>
                <tr className="z">
                  <th scope="row">3</th>
                  <td>감사합니다</td>
                  <td>정미니</td>
                  <td>2022-05-22</td>
                </tr>
                <tr className="z">
                  <th scope="row">4</th>
                  <td>어쩌구합니다</td>
                  <td>진화니</td>
                  <td>2022-06-27</td>
                </tr>
                <tr className="z">
                  <th scope="row">5</th>
                  <td>저쩌구합니다</td>
                  <td>민처리</td>
                  <td>2022-07-20</td>
                </tr>
                <tr className="z">
                  <th scope="row">6</th>
                  <td>머시기합니다</td>
                  <td>우혀니</td>
                  <td>2022-07-22</td>
                </tr>
                <tr className="z">
                  <th scope="row">7</th>
                  <td>미래에서 왔습니다</td>
                  <td>훈겨미</td>
                  <td>2207-15-24</td>
                </tr>
              </tbody>
            </Table>
          </CardBody>
        </Card>
      </Col>
      <div className="fhdn">
      <Pagination></Pagination>
      </div>
    </Row>
  );
};

export default Tables;
