##Iteration#1:
- [x] [B-1: get All movies. Response should be in JSON](http://localhost:8080/api/v1/movie)
- [x] [B-1A: get movie by id](http://localhost:8080/api/v1/movie/3570)
- [X] [B-2: get random movies](http://localhost:8080/api/v1/movie/random)
- [x] [B-4: get movies by genre](http://localhost:8080/api/v1/movie/genre/3512)
- [x] [B-5: get all movies by rating (desc) or price (acs/desc)](http://localhost:8080/api/v1/movie?rating=desc)
##Iteration#2:

## TEST
###B-1, B-4: path, JSON, mapper
("id", "nameTarget", "nameOrigin", "yearOfRelease", "rating", "price", "picturePath"), ("id", "name")
###B-2 Get 3 random movie:
size(3)
###B-4 Get all genres:
("id", "nameTarget", "nameOrigin", "yearOfRelease", "rating", "price", "picturePath")
###B-5 Implement sortDirection:
[price=ASC](http://localhost:8080/api/v1/movie?price=ASC)
[price=DESC](http://localhost:8080/api/v1/movie?price=DESC)
[rating=ASC](http://localhost:8080/api/v1/movie?rating=ASC)
[rating=DESC](http://localhost:8080/api/v1/movie?rating=DESC)
[default id=ASC](http://localhost:8080/api/v1/movie?id=ASC)
[price=DESC, rating=DESC](http://localhost:8080/api/v1/movie?rating=ASC&price=DESC)
[price=ASC, rating=DESC](http://localhost:8080/api/v1/movie?rating=ASC&price=DESC)
[price=DESC, rating=ASC](http://localhost:8080/api/v1/movie?rating=ASC&price=DESC)
[price=ASC, rating=ASC](http://localhost:8080/api/v1/movie?rating=ASC&price=ASC)

URL should be /v1/movie/{movieId}, HTTP method GET.
Movie should be in JSON format.
("id", "nameTarget", "nameOrigin", "yearOfRelease", "rating", "price", "picturePath", "description", "genres","country", "review")
Response example:{
"id": 1,
"nameRussian": "Побег из Шоушенка",
"nameNative": "The Shawshank Redemption",
"yearOfRelease": "1994",
"description": "Успешный банкир ",
"rating": 8.89,
"price": 123.45,
"picturePath": "https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg",
"countries": [{"id": 1,"name": "США"}],
"genres": [{"id": 1,"name": "драма"}, {"id": 2,"name": "криминал"}],
"reviews": [{"id": 1,"user": "id": 3,"nickname": "Дарлин Эдвардс"},"text": "Гениальное кино!"},
{"id": 2,"user": {"id": 4,"nickname": "Габриэль Джексон"},"text": "Кино это является"}]
}