# java-lotto
로또 미션 진행을 위한 저장소

## Todo

- 구매한 갯수와 생성된 로또 출력 구현

- 지난 주 당첨번호 입력 받기
    + [예외처리] 콤마(,)로 split하고 숫자인지 판별
    + [예외처리] 6개의 수인지
    + [예외처리] 중복된 번호가 있는지

힌트
>로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
 Collections.sort() 메소드를 활용해 정렬 가능하다.
 ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
 

## Done
- 로또 번호를 의미하는 클래스 구현
    + 1~45 사이의 수 인지 검증 (예외처리)
- 로또 1장을 만드는 Generator 구현
    + LottoGenerator의 LottoNumber 객체 45개가 담긴 List가 있고,
    + generateLotto를 할 때마다 shuffle을 하고 List에서 subList로 로또 수들의 list를 가져온다.
 - 로또 한 장을 의미하는 객체 구현
     + [예외처리] 6개의 수 인지 검사
     + [예외처리] 중복된 수가 있는지 검사
 
 - 지난 주 당첨 로또 클래스 구현
    + [예외처리] 6개의 수 인지 검사
    + [예외처리] 중복된 수가 있는지 검사
    
 - 금액 객체 구현
    + [예외처리] 1000원 단위 양의정수인지 검사ㅎ
    
 - 돈과 자동생성된 로또들을 가지고 있는 User 구현
 
 - 구입금액 입력 받기
