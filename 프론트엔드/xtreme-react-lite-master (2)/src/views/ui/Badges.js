import { useState } from 'react';
import 'css/lest.css';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { Link } from 'react-router-dom';


// 게시글 작성 Page

function Review() {
  const [movieContent, setMovieContent] = useState({
    title : '',
    content : ''
})

const [viewContent, setViewContent] = useState([]);

const getValue = e => {
    const { name, value } = e.target;
    setMovieContent({
        ...movieContent,
        [name]: value
    })
    console.log(movieContent);
};
return (
<div className="App">
  <h1>Movie Review</h1>
  
  <div className='form-wrapper'>
    <input className="title-input" 
            type='text' 
            placeholder='제목' 
            onChange={getValue}
            name='title'
    />
    <CKEditor
      editor={ClassicEditor}
      data="<p>Hello from CKEditor 5!</p>"
      onReady={editor => {
        
        console.log('Editor is ready to use!', editor);
      }}
      onChange={(event, editor) => {
        const data = editor.getData();
        console.log({ event, editor, data });
        setMovieContent({
          ...movieContent,
          content: data
        })
        console.log(movieContent);
      }}
      onBlur={(event, editor) => {
        console.log('Blur.', editor);
      }}
      onFocus={(event, editor) => {
        console.log('Focus.', editor);
      }}
    />
  </div>
  <Link to="/Table">
              <button type="button" className="submit-button1">
                    목록
              </button>
 </Link>

 <Link to="/Buttons">
  <button className="submit-button2"
  onClick={() => {
    setViewContent(viewContent.concat({...movieContent}));
  }
  }>완료</button>
 </Link>
</div>
);
}


export default Review;