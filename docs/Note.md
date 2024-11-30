- 과정
  - 백엔드
  - 프론트

- 레벨
  - 1,2,3,4,5
---
### 상수
- Course(E) - 백엔드, 프론트
- Level(E) - 1,2,3,4,5
- Function(E) - 페어메칭, 페어조회 등등...
- PairType(E) - 2명, 3명

### 객체
- Crew
  - Course
  - name
- CrewsByCourse : 이곳에서 파일을 읽어온다 ❌
  - Backend
  - Frontend

- Mission
  - Level(E)
  - List<String> missions

- Missions



- PairMember
  - List<Crew>
  - @Overrride Equals ❌
  
- PairResult
  - Course(E)
  - Level(E)
  - Mission - String
  - List<PairMember>
  
- PairHistory
  - List<PairResult>

### 서비스
- PairMatchingService
  - MissionMatcher : 입력된[과정-레벨-미션]으로 미션을 매칭하여
    - PairResult를 업데이트함
    1. 과정, 레벨, 미션이 존재하는가?
    2. 동일한 매칭 정보가 있는가?
  
  - PairMemberMather : 크루들로 짝을 매칭하여
    - PairResult의 PairMember를 업데이트함
    1. 동일한 레벨일 경우 중복된 페어 멤버가 존재하는가?

---
### 주요 기능
1. List<String> 으로 준비
2. 순서를 랜덤으로 섞음 - shuffle
3. 앞에서부터 2명씩 짝을 지음
4. 홀수인 경우 마지막은 3명으로 짝을 지음 - 2,2,2,3
- 만약 같은 레벨에서 만난 패어랑 또 짝이 된다면, 
  - 다시 순서를 랜덤으로 섞는다. - shuffle
  - 재매칭 안내를 출력하고 여부를 입력받는다.
- 매칭을 할 수 없는 경우 에러 메시지를 띄운다. - [ERROR] 매칭 이력이 없습니다.
  - 3회 시도까지 shuffle
  - 매칭을 할 수 있는 경우의 수가 없으면 ❌ ?????? 
### 세부 기능
- 페어 매칭 조건
  - 2명씩 매칭
  - 홀수인 경우 3명씩 매칭
  - 중복된 매칭 불가 -- ????? ❌-> 매칭된 리스트를 만들어야할듯
### 플로우
1. 페어 멤버 데이터를 준비한다. 
1. [과정-레벨-미션]을 입력받는다.
2. PairResult를 업데이트한다. + 유효 검사
   - 존재하는가?
   - 동일한 매칭 정보가 있는가?
3. 해당 과정의 크루를 준비하여 페어 짝을 매칭한다 + 유효검사
   - 같은 레벨, 동일한 페어 매칭 결과가 있는가?
3. 출력한다.
### 유효 검사
- 과정
  - 존재하는 과정인지
- 레벨
  - 존재하는 레벨인지
- 미션
  -  존재하는 미션인지

- 매칭시
  - 같은 레벨의 중복된 페어인지. ❌
### 주의 사항
- 같은 레벨동안은 중복된 페어를 만나지 않는다.