# Ace(Affordable and Clean Energy)
<p align="center">
 ![Frame 126](https://github.com/Tree-Figlin/Ace-Android/assets/108396442/c302a4b6-f37f-42bc-9ed6-5db59003e4db)<br>
</p> 

## 🤔 ACE?
### ACE는 다음과 같은 목적으로 탄생했어요 <br>
우리 사회는 `지속 가능한 발전` 을  위해 노력 중이에요.<br>
그에 발맞춰 `환경에 관심`을 가져 주시는 분들이 많지만, 그에 맞는 `장소나 행사` 등을 찾아보기는 어려운 일이에요.<br>
저희는 이 문제를 어떻게 해결할 수 있을까요?

### ACE는 아래의 기능들을 제공해요. </span><br>
<span>1. 사용자의 위치를 기반으로 주변의 신재생에너지 관련 기관을 소개해요! </span><br>
<span>2. 환경에 관련한 이슈들을 ACE로 간편 하게 접해 보아요! </span><br>
<span>3. 환경관 관련한 여러 행사들을 손쉽게 찾고 참여해 보아요! </span><br>


## 📱 Screen<br>
<p>
![Intro](https://github.com/Tree-Figlin/Ace-Android/assets/108396442/d3584c07-93f5-46f3-8dfa-19cb2c0656f3)<br>
![Intro 2](https://github.com/Tree-Figlin/Ace-Android/assets/108396442/4be7802b-b1c7-4ceb-a245-404830613afc)<br>

</p>
<br>
## 🗂️ Packages <br>
```
ACE Android<br>
 ┣ 📂buildSrc <br>
 ┣ 📂data<br>
 ┃ ┣ 📂datasource<br>
 ┃ ┣ 📂remote<br>
 ┃ ┃ ┣ 📂api<br>
 ┃ ┃ ┣ 📂datasource<br>
 ┃ ┃ ┗ 📂dto<br>
 ┃ ┣ 📂repository<br>
 ┃ ┗ 📂util<br>
 ┣ 📂design-system<br>
 ┃ ┣ 📂componet<br>
 ┃ ┃ ┣ 📂bottombar<br>
 ┃ ┃ ┣ 📂bottom<br>
 ┃ ┃ ┣ 📂text<br>
 ┃ ┃ ┣ 📂textfield<br>
 ┃ ┃ ┗ 📂lottie<br>
 ┃ ┣ 📂icon<br>
 ┃ ┣ 📂theme<br>
 ┃ ┃ ┗ 📂color<br>
 ┃ ┗ 📂util<br>
 ┣ 📂di<br>
 ┃ ┗ 📂module<br>
 ┣ 📂domain<br>
 ┃ ┣ 📂exception<br>
 ┃ ┣ 📂model<br>
 ┃ ┣ 📂repository<br>
 ┃ ┗ 📂usecase<br>
 ┣ 📂presentation<br>
 ┃ ┣ 📂ui<br>
 ┃ ┃ ┣ 📂base<br>
 ┃ ┃ ┣ 📂event<br>
 ┃ ┃ ┣ 📂home<br>
 ┃ ┃ ┣ 📂intro<br>
 ┃ ┃ ┣ 📂map<br>
 ┃ ┃ ┣ 📂news<br>
 ┃ ┃ ┗ 📂util<br>
 ┃ ┗ 📂viewmodel<br>
 ┃ ┃ ┗ 📂util<br>
 
```
<br>

## :rocket: Tech Skills
- Language: Kotlin
- Ui: Jetpack Compose
- Minumun SDK 26
- Architecture: Clean Architecture, MVVM
- Async: Coroutine
- DI: Dagger-Hilt
- Network: Retrofit2, OKhttp3
- Image: Coil
- Cooperation: Git, Github, GitFlow
- AAC(Android Architecture Components)
- Sever: firebase
- Map: google Maps SDK for Android

## :sparkles: 프로젝트 빌드 방법
local.propreties 안에<br>
GOOGLE_API_KEY="AIzaSyAngCNmkeiECy-8B8bC4QdahM0YGfwWv9g"<br>
NEWS_API_KEY="b9e2157143ec4af7932ca7381645645d"<br>
BASE_URL="https://newsapi.org/v2/"<br>
추가후 di모듈로 앱 빌드
