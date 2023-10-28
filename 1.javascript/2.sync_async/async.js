// 2. 비동기 방식(Asynchronous)
// https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Asynchronous/Introducing

/**
 * 현재 실행 중인 작업(Task)가 아직 종료되지 않은 상태라고 해도, 다음 작업을 곧바로 실행하는 방식
 */

function first() {
    console.log('first() called');
}

function second() {
    console.log('second() called');
}


setTimeout(first, 0);
second();
// setTimeout(callback, 지연시킬 시간(ms)); // 지정한 시간 이후에 코드를 수행하도록 동작하는 함수