// 1. XMLHttpRequest() 인스턴스(객체) 생성
const xhr = new XMLHttpRequest();

// 2. 서버로부터의 응답이 완료되었는지 확인

xhr.onload = () => { // 프로퍼티 기반 이벤트 추가 방식으로 구현
    if (xhr.readyState === xhr.DONE && xhr.status === 200) {
        // responseText: 서버로부터 받은 응답 데이터
        const responseData = xhr.responseText; // 직렬화된 상태의 문자열 데이터
        const result = JSON.parse(responseData); // JSON.parse() -> 역직렬화(문자열 -> JS객체)
        console.log(result.address);
    }
}

// addEventListener 메서드를 통한 이벤트 추가 방식으로 구현



// 3. 요청 준비하는 코드(open())
const url = 'https://jsonplaceholder.typicode.com/users/1';
xhr.open('GET', url);

// 4. 요청 실제 전송
xhr.send();