package com.tree.presentation.ui.event.data

data class EventListItem(
    val title: String,
    val imageUrl: String,
    val date: String
)

val list = listOf(
    EventListItem(
        title = "2023 GREEN CAREER FORUN전환 '앞장'",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwKoVhKYP7GFhsY1t56ehBvflr7Mpf4iguYwFf_6-PdQ&s",
        date = "~ 23-11-25"
    ),
    EventListItem(
        title = "그린피스 플콕조사",
        imageUrl = "https://www.greenpeace.org/static/planet4-korea-stateless/2023/06/2be863f5-1_1_%ED%94%8C%EC%BD%95%EC%A1%B0%EC%82%AC-%EB%A7%A4%ED%81%AC%EB%A1%9C_%ED%94%8C%EB%9D%BC%EC%8A%A4%ED%8B%B1%EB%AA%AC%EC%8A%A4%ED%84%B0_1080x1080-e1685581941572.jpg",
        date = "~ 23.07.10"
    ),
    EventListItem(
        title = "어스앤런 허니비 - 꿀벌을 지키는 달리기",
        imageUrl = "https://www.greenpeace.org/static/planet4-korea-stateless/2022/09/f76fc232-copy-of-0819_%EC%96%B4%EC%8A%A4%EC%95%A4%EB%9F%B0_%EC%9B%B9%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg",
        date = "22.09.15 ~ 22.09.28"
    ),
    EventListItem(
        title = "OO 사지 않기!",
        imageUrl = "https://cdn.imweb.me/upload/S20210309bc33078ae88ba/a9b486345bfa7.png",
        date = "22.05.31 ~ 22.06.05"
    )
)