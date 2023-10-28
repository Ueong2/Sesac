const express = require('express'); // node_modules에서 express 모듈 import
const app = express(); // express 인스턴스 생성 후 app 변수에 할당

const httpRequest = require('request');// 설치한 request 라이브러리 모듈 import

const clientId = 'dVfz8bFccn0geTghojDj';
const clientSecret = 'dMMRPx4knG';

// 미들웨어 추가
app.use(express.static('public')); // 정적인 자원(static)은 public 폴더에 보관
app.use(express.json()); // 직렬화 처리용 모듈

// '/' 경로로 요청 시 동작할 메서드(핸들러)
app.get('/', (request, response) => {
    response.sendFile('index.html');
});

// /detect 경로로 요청 시 동작할 핸들러
app.post('/detect', (request, response) => {
    console.log(request.body);// body 내 데이터 추출

    const url = 'https://openapi.naver.com/v1/papago/detectLangs';
    
    const options = {// body, header에 추가할 정보 작성 부분
        url, // url: url와 같음
        form: request.body,
        headers: {
            'Content-Type': 'application/json',
            'X-Naver-Client-Id': clientId,
            'X-Naver-Client-Secret': clientSecret
        }
    } 
    
    // 실제 요청 전송 부분
    httpRequest.post(options, (error, httpResponse, body) => {
        if (!error && response.statusCode === 200) {
            response.send(body); // 서버(server.js)가 클라이언트(app.js)로 데이터를 응답
        }
    })
});

// 언어 번역 요청 부분 localhost:3000/translate
app.post('/translate', (request, response) => {
    const url = 'https://openapi.naver.com/v1/papago/n2mt';
    console.log(request.body);
    // 2. Body, Header 등 데이터
    const options = {
        url,
        form: request.body,
        headers: {
            'Content-Type': 'application/json',
            'X-Naver-Client-Id': clientId,
            'X-Naver-Client-Secret': clientSecret,
        }
    }

    httpRequest.post(options, (error, httpResponse, body) => {
        if (!error && response.statusCode === 200) {
            response.send(body); // 서버가 클라이언트로 데이터를 응답
        }
    });
})

const port = 3000; // 서버 실행 포트 번호

app.listen(port, // 서버가 해당 포트에서 동작 대기하도록
    () => console.log(`http://localhost:3000/ app listening on port ${port}`));