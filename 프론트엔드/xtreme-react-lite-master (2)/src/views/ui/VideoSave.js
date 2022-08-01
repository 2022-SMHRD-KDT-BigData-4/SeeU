import React, {useState} from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import 자물쇠2 from "../../assets/images/bg/자물쇠2.png";
import 'css/lest.css';
// import Bar from 'modals/Bar';
import Pagination from 'modals/Pagination';
import RecordModal from 'modals/RecordModal';
import { Link } from "react-router-dom";


function AutoLayoutExample() {
  const [RecordModalOn, setRecordModalOn] = useState(false);
  const mem_id = sessionStorage.getItem('mem_id')
  const mem_address = sessionStorage.getItem('mem_address')
  const mem_name = sessionStorage.getItem('mem_name')
  const mem_phone = sessionStorage.getItem('mem_phone')
    
  
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
    
    
    else{
  return (
    <>
     <RecordModal show={RecordModalOn} onHide={()=>setRecordModalOn(false)}/>
   <div>
    <center><h2>Video Save</h2></center>
    <hr></hr>
    <Row>
        <Col className='z-1' md="3">
          <div className='x-1'>
            
              <img src="img/record.png" className='gg-2' onClick={()=>setRecordModalOn(true)}></img>
           
          </div>
          <hr className='hr'></hr>
          <p className='p-1'>2022-07-20 4:02pm</p>
        </Col>
        <Col className='z-2' md="3"><div className='x-1'>
         
              <img src="img/record.png" className='gg-2' onClick={()=>setRecordModalOn(true)}></img>
          
          </div>
          <hr className='hr'></hr>
          <p className='p-1'>2022-07-19 12:16 pm</p></Col>
        <Col className='z-3' md="3"><div className='x-1'>
            
              <img src="img/record.png" className='gg-2' onClick={()=>setRecordModalOn(true)}></img>
           
          </div>
          <hr className='hr'></hr>
          <p className='p-1'>2022-06-25 5:05 pm</p></Col>
      </Row>
      <br></br>
      <br></br>
      <Row>
        <Col className='z-1' md="3"><div className='x-1'>
          
              <img src="img/record.png" className='gg-2' onClick={()=>setRecordModalOn(true)}></img>
         
          </div>
          <hr className='hr'></hr>
          <p className='p-1'>2022-06-10 8:24 am</p></Col>
        <Col className='z-2' md="3"><div className='x-1'>
          
              <img src="img/record.png" className='gg-2' onClick={()=>setRecordModalOn(true)}></img>
          
          </div>
          <hr className='hr'></hr>
          <p className='p-1'>2022-05-29 3:16 pm</p></Col>
        <Col className='z-3' md="3"><div className='x-1'>
          
              <img src="img/record.png" className='gg-2' onClick={()=>setRecordModalOn(true)}></img>
          
          </div>
          <hr className='hr'></hr>
          <p className='p-1'>2022-05-18 10:14 am</p></Col>
      </Row>
      <br></br>
      <br></br>     
   </div>
   <div className="page">
    <Pagination></Pagination>
    </div>
    </>
  )}
}

export default AutoLayoutExample;