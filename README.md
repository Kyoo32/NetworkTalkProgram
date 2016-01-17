# NetworkTalkProgram

### 소스파일구성

* (연습용)TCPEchoClient, TCPEchoServer
    - 출처 : 'TCP/IP socket programming for java', Micheal J. Donahoo, Kenneth L.Calvert

* TalkClient, TalkServer
    - 구현 완료 기능  
        - 서버는 여러 클라이언트와 커넥션을 맺을 수 있다.
        - 클라이언트가 서버에 접속하면, "~ 채팅방에 들어왔다."라는 메세지를 보여준다.
    - complie
        - javac TalkClient.java && javac TalkSerever.java
    - usage
        - java TalkServer
            - => lee Calling the Socket Server on localhost port 1234 at Sun Jan 17 20:11:30 KST 2016
        - java TalkClient lee
            - => lee enters at Sun Jan 17 20:11:30 KST 2016Finalizer
    - 참고 : [web link](http://edn.embarcadero.com/article/31995)
    - [socket interface API](https://github.com/Kyoo32/NetworkTalkProgram/wiki/java-Socket-API)
    - [bug report](https://github.com/Kyoo32/NetworkTalkProgram/wiki/bug-report)
    
* (포기 후, 참고용) MultiChatClient, MultiChatServer
    - 출처 : [web link](http://warmz.tistory.com/entry/%EC%86%8C%EC%BC%93-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-TCPIP-nm-%EC%B1%84%ED%8C%85)
    - [code analysis](https://github.com/Kyoo32/NetworkTalkProgram/wiki/full-source-code-analysis)
