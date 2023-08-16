# [Gold III] 행성 X3 - 2830 

[문제 링크](https://www.acmicpc.net/problem/2830) 


## 문제 이해
- 우선 거주민들의 이름은 모두 자연수로 주어진다.
- 두 거주민의 친밀도를 구하기위해서는 각자의 이름을 이진수로 표현후 XOR연산을 해야한다.
- 행성의 가치는 모든 거주민의 이름 조합에 대한 친밀도의 합

## 고려사항
- 거주민의 수는 1,000,000이하이기에 배열의 크기는 2^20으로 제한한다.(2^10*2^10)
- 비트마스킹을 활용해 시간복잡도 효율성 높임
- 

## 시간복잡도
- 행성 거주민의 이름 스캔시 O(N) 소요
- 행성 거주민끼리 친밀도 계산시 N * (N-1) 해당 경우 N이 1,000,000일경우 시간복잡도 급수적으로 증가.
- 비트연산을 사용해 각 이름을 한번씩 계산하게 변경, 해당 경우 시간복잡도 O(N)
<br>
<details><summary style="color:skyblue">비트 연산자 참조</summary>
<p>

**사용된 비트 이동 연산자**

- '&'   : AND 연산자. 두 이진수의 해당 자릿수가 모두 1일때만 1 반환 
- '^'   : XOR 연산자. 두 이진수의 해당 자릿수가 다르면1, 같으면 0 반환
- '<<'  : 왼쪽 시프트 연산자. 주어진 수를 왼쪽으로 지정된 비트 수만큼 이동.
- '>>'  : 오른쪽 시프트 연산자. 주어진 수를 오른쪽으로 지정된 비트 수만큼 이동.
- '>>=' : 오른쪽 시프트 할당 연산자 (아래코드참조.)

```java
int name = 19; //예시
// >>= 연산자 사용예시
for (int i = 0; i < 5; i++) { // 19는 5비트 이므로 예시로 5회 반복
    System.out.println("Before shift: " + name);
    name >>= 1;
    System.out.println("After shift: " + name);
}
```
```mathematica
/**
* 실행결과
* 괄호안은 2진수표기
**/
Before shift: 19 (10011)
After  shift: 9  (01001)
Before shift: 9  (01001)
After  shift: 4  (00100)
Before shift: 4  (00100)
After  shift: 2  (00010)
Before shift: 2  (00010)
After  shift: 1  (00001)
Before shift: 1  (00001)
After  shift: 0  (00000)
```

</p>
</details>


## 0의 개수, 1의 개수를 곱하여 2^i 곱하기
- 각 이름을 이진수로 변환 후 해당 비트위치에 나타나는 1을 카운트.
- i 번째 비트 위치에서의 친밀도 합은 (N - count) * count * 2^i

![inital](https://github.com/SeongJunBlog/algorithm-and-data-structure/assets/92978646/8f969312-6515-4310-827b-4a7fedd95728)





<br><br>
 
