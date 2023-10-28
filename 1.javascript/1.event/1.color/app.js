const button = document.getElementById('btn');
console.dir(button);

// function test() {
//     console.log('test 함수');
// }

// 콜백 함수 - 어떤 함수의 인수로 전달되는 '함수'
button.addEventListener('click', () => {
    // const result = getRandomNumber(0, 255);

    // const red = result[0];
    // const green = result[1];
    // const blue = result[2];
    
    // '배열' 디스트럭처링(Destructuring) - 구조 분해 할당
    const [ r, g, b ] = getRandomNumber(0, 255);
    
    const rgbColor = `rgb(${r}, ${g}, ${b})`; // backtick(백틱), 템플릿 리터럴 문법
    console.log(rgbColor);

    document.body.style.backgroundColor = rgbColor;
    color.style.colr = rgbColor;
    color.textContent = rgbColor;

});

/*
    () => {}
    화살표 함수(Arrow function)
    1. 익명 함수
*/

// 랜덤값 추출
function getRandomNumber(min, max) {
    const randomRGBArray = [];

    for (let i = 0; i < 3; i++) {
        const randomNumber = Math.floor(Math.random() * ( max - min + 1)) + min;
        randomRGBArray.push(randomNumber);
    }

    return randomRGBArray;
}