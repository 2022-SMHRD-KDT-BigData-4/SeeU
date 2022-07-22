import { Component } from "react";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import 'css/Board.css';
import Comment from 'views/ui/Comment'; 
import { Link } from "react-router-dom";

class BoardList extends Component {
    /**
     * @return {Component} Component
     */
    render() {
        return (
            <div>

               <div className="a-3"><h1>제목 : 신고합니다</h1></div> 
               <div className="b-3"><a href="#" className="re-3">수정ㅤ</a><a href="#" className="de-3">삭제</a></div>
               
               <hr></hr>
               <div className="br-3">이민지의 실체를 폭로하겠습니다.</div>
               <div className="cr-3">
                    <span className="a1">🕐 2022-06-22</span>
                    <span className="a2">작성자 : 태리니</span>
               </div>
               <br></br>
               <Comment></Comment>
               <br></br>
               <Link to="/Table">
                <button type="button" className="back-3">목록으로</button>
               </Link>
            </div>
        );
    }
}

export default BoardList;