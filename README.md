# GRPC-User & Post-Service
Communication between 2 service by gRPC.

![Adsız-2022-07-05-1747](https://user-images.githubusercontent.com/21373505/205436193-0fe69835-fcbe-4b48-8671-2da0b7323e73.png)


Generate proto files.

```bash
  cd Post-Service
```
```bash
  mvn clean package
```

```bash
  cd User-Service
```
```bash
  mvn clean package
```


## Find users posts.

```http
  GET http://localhost:8080/users/${userId}/posts
```

| Parameter | Type     | 
| :-------- | :------- |
| `userId` | `int` | 

### Response:

```javascript
{
  "id": 1,
  "name": "mert",
  "posts": [
    {
      "id": 3,
      "subject": "sub 3",
      "content": "content 3",
      "userId": 2
    },
    {
      "id": 6,
      "subject": "sub 6",
      "content": "content 6",
      "userId": 2
    }
  ]
}
```

## Find user of post.

```http
  GET http://localhost:8081/posts/${postId}/users
```

| Parameter | Type     | 
| :-------- | :------- | 
| `postId`      | `int` | 

### Response:

```javascript
{
  "id": 3,
  "subject": "sub 3",
  "content": "content 3",
  "user": {
    "id": 2,
    "name": "mert"
  }
}
```
