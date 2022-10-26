import {
  Card,
  CardImg,
  CardText,
  CardBody,
  CardTitle,
  CardSubtitle,
  CardGroup,
  Button,
  Row,
  Col,
} from "reactstrap";
import Blog from "../../components/dashboard/Blog";
import bg1 from "../../assets/images/bg/bg1.jpg";
import snp from "../../assets/images/bg/시니어.png";
import 자물쇠2 from "../../assets/images/bg/자물쇠2.png";
import React, {useEffect, useState} from "react";
import 'css/Modal.css'
import Modal from "modals/Modal";
import Axios from "axios";
import { Link, resolvePath, useLocation, useNavigate } from "react-router-dom";
import { param } from "jquery";

const Cards = () => {
  const navigate = useNavigate();
  const [senior, setSenior] = useState([]);
  const [ModalOn, setModalOn] = useState(false);
  const [photo, setphoto] =useState([]);

  useEffect(()=>{
    const mem_id = sessionStorage.getItem('mem_id')
    const mem_address = sessionStorage.getItem('mem_address')
    const mem_name = sessionStorage.getItem('mem_name')
    const mem_phone = sessionStorage.getItem('mem_phone')
    const s_name = sessionStorage.getItem('s_name')
    let param = {};
    Axios.post("/api/seniorList",param).then((response)=>{
      console.log("1", response)
      param.mem_id = (sessionStorage.getItem('mem_id'))
      console.log(param.mem_id)
      
      
      
      if(response.data){
        // 여기 스프레드표현법 말고 그냥 바로넣음(그래야 실행이 됨)
        setSenior(response.data); // ...을 써줘서  state가 변경된걸 리액트에게 알려주기
        console.log(response.data);
    
        console.log("3", response.data);
      }else{
        alert("failed to");
      }
    });
 // useEffect안에서 set함수 사용하면 오류 발생(무한루프) -> 빈 배열([]) 하나 넣어주기

  },[]);
  const mem_id = sessionStorage.getItem('mem_id')
  const mem_address = sessionStorage.getItem('mem_address')
  const mem_name = sessionStorage.getItem('mem_name')
  const mem_phone = sessionStorage.getItem('mem_phone')
  const s_name = sessionStorage.getItem('s_name')
    if(mem_id === null ){
      return(
        <>
        <div className='dd'>
          <br></br>
          <img className="wk" src={자물쇠2}></img><h1 className="h1">Login</h1>
          <hr></hr>
          <br></br>
          <p className="pp">서비스를 이용하시려면 로그인이 필요합니다.</p>
          <br></br>
          <Link to="/About"><button className='one' type='button'>로그인</button></Link><Link to="/Breadcrumbs"><button className='two' type='button'>회원가입</button></Link>
        </div>
        </>
        )
  }
  else {
    if(s_name === null){
      return (
        <>
      <Modal show={ModalOn} onHide={()=>setModalOn(false)} />
      <div>
        <Row>
          <div className="ss3"></div>
          <div className="tt-3"><Link to="/Forms"><button className="ll-3">추가하기</button></Link></div>
        </Row>
        <Row>
          <Col>
            <CardGroup className="group">
            
          <hr></hr>
          <br></br><br></br><br></br><br></br><br></br>
          <p className="fkfk">시니어를 추가해주세요</p>
              
            </CardGroup>
          </Col>
        </Row>
      </div>
      </>
      )
    }
    else{
    return (
      <>
      <Modal show={ModalOn} onHide={()=>setModalOn(false)} />
      <div>
        <Row>
          <div className="ss3"></div>
          <div className="tt-3"><Link to="/Forms"><button className="ll-3">추가하기</button></Link></div>
        </Row>
        <Row>
          <Col>
            <CardGroup className="group">
            
              {

                senior.map((senior,index) => (
              <Card key = {index} className="snlist">
                <CardImg alt="Card image cap" className="go" src= {snp} top width="100%" />
                <CardBody className="to">
                  <CardTitle tag="h5">{senior.s_name}</CardTitle>
                  <CardSubtitle className="mb-2 text-muted" tag="h6">
                   {senior.s_gender} {senior.s_birth}
                  </CardSubtitle>
                  <hr></hr>
                  <CardText>
                    {senior.s_address}
                  </CardText>
                  <hr></hr>
                  <p>{senior.s_care}</p>
                  <hr></hr>
                  <Button className="b" onClick={()=> setModalOn(true)}>영상보기</Button>
                </CardBody>
              </Card>
                ))
              }
              
            </CardGroup>
          </Col>
        </Row>
      </div>
      </>
    )
  }
}
};

export default Cards;