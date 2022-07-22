import React from "react";
import Single from "views/ui/Single";
import 'css/Board.css';


class Comment extends React.Component{
  constructor(props){
    super(props);
    this.state={
      tweets:[
        {
          uuid:1,
          writer:"김코딩",
          date:"2021-10-10",
          content:"안녕 리액트"
        },
        {
          uuid:2,
          writer:"박코딩",
          date:"2022-10-10",
          content:"잘가 리액트"
        }
      ]
    }
    this.addTweet=this.addTweet.bind(this);
  }
  addTweet(){
    let value=document.querySelector('#new-tweet-content').value;
    this.setState({tweets:[...this.state.tweets, {
      uuid: this.state.tweets.length +1,
      writer:"김코딩",
      date: new Date().toISOString().slice(0,10),
      content: value
    }]})
  }
  render(){
    return(
        <div id="root">
          <div>
              <div id="writing-area">
                <textarea id="new-tweet-content" className="q-1"></textarea>
                <button id="submit-new-tweet" onClick={this.addTweet} className="q-2">댓글 쓰기</button>
              </div>
              <div className="q-3">
              <ur id="tweets">
                {
                  this.state.tweets.map(tweet => {
                    return <Single key={tweet.uuid} tweet={tweet} />
                  })
                }
              </ur>
              </div>
          </div>
        </div>
    )
  }
}
export default Comment;