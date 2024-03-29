# project_wifi
WIFI 정보 가져오기 프로젝트

기능	<br>
	1. 서울시에서 제공하는 WIFI 정보를 가져온다.<br>
	2. 현재 나의 위치의 위경도 값을 가져온다.<br>
	3. 위경도 값을 기준으로 가까운 WIFI 정보 20개를 불러온다.<br>
	4. 조회한 위치를 저장하고 보여준다.<br>
	5. WIFI 정보를 즐겨찾기 할 수 있는 그룹을 생성한다.<br>
	6. 즐겨찾기 그룹을 수정한다.<br>
	7. 즐겨찾기 그룹을 삭제한다.<br>
	8. WIFI 정보를 즐겨찾기 그룹을 지정해 추가할 수 있다.<br>
	9. 저장한 즐겨찾기 WIFI 정보를 삭제할 수 있다.<br>
	10. 가까운 WIFI 정보 조회 화면에서 WIFI 이름 클릭시 개별 와이파이와 현재 위치에서 떨어진 거리를 보여준다.<br><br><br>


겪었던 어려움	<br>
		1. 초기에 프로젝트 세팅과 관련해 오류가 많이 나서 어려웠던 것 같습니다.<br>
			&emsp;&emsp;1-1. IntelliJ 프로젝트 생성시 이클립스에서 작업했던 것과 다르게 JakartaEE를 사용해 이를 Javax를 사용하도록 수정했습니다.<br>
			&emsp;&emsp;1-2. JakartaEE 로 프로젝트를 생성해서 진행했는데, 최소 버전이 java11이어서 java버전은 11을 사용했습니다.<br>
			&emsp;&emsp;1-3. 이클립스로 진행하던 중 이클립스가 멈추는 등의 오류가 발생해 Intellij로 갈아탔습니다.<br>
			&emsp;&emsp;1-4. out객체를 활용해 jsp 페이지에서 java 문법을 쓰려고 했는데, 처음에 안되어서 애가 탔습니다.
			<br>&emsp;&emsp;	결국, 톰켓의 lib 폴더에 있는 모든 jar의 의존성을 추가해줌으로써 작동하게 했습니다.<br>
		2. 초기에 프로젝트 구성을 잘 가져갔어야 했는데, 그렇지 못해서 중구난방인 코드가 되어 많이 헷갈렸습니다.<br>
		3. ClassNotFoundException이 jsp 페이지 내에 java 문법 오류가 있을 경우 발생할 수 있다는 것을 몰라 헤맸습니다.<br>
		4. 쿼리에 따옴표 관련 오류의 경우 NullPointerException이 발생하는 것을 확인하는 데 조금 걸렸습니다.<br><br><br>

아쉬운 점<br>		1. sqlite를 사용했는데, DB 파일과 연결되는 Connection 객체를 계속 물고 있는 것이 맞을 것 같은데, 이와 관련해 작동은 되지만, 수정이 필요한 사항이 아닌가 싶습니다.<br>
		2. 시간에 쫓기다 보니 구조적인 설계 전에 구현에 급급했습니다. 그러다보니, 헷갈리고 중구난방인 코드가 된 것 같습니다.<br>
		3. 아는 범위를 크게 벗어나지 않다보니 이런저런 고려사항들이 더 있을 것 같습니다.<br>

  
프로젝트 구조(ERD) <br>
![박재우_ERD](https://github.com/some1mine/project_wifi/assets/71738723/9723934a-d680-4f15-81a1-f734788932e9)

시연 영상

![박재우_WIFI정보 구하기_마스터](https://github.com/some1mine/project_wifi/assets/71738723/c47772e1-312c-4462-8b78-408c4efc5266)
![ezgif com-optimize](https://github.com/some1mine/project_wifi/assets/71738723/b86b93a4-df85-45b8-9d65-bd0658468686)

