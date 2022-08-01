import { func } from 'prop-types';
import Button from 'react-bootstrap/Button';
import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Popover from 'react-bootstrap/Popover';
import { Link } from "react-router-dom";
import 'css/lest.css';

function PopoverPositionedExample() {

 
function del (){
  let a = document.getElementsByClassName('ling')
  document.getElementsByClassName('bs-popover-bottom')[0].innerHTML="";
  try {
      a[0].classList.remove('ling')
  } catch (error) {
    console.log('이미없음')
  }
} 
  return (
    <>
    </>
  );
}

export default PopoverPositionedExample;