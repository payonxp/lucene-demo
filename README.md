# lucene-demo
A RestFul application for file indexing and searching  
IR lesson project 1

## Environment
* Maven
* JDK 1.8
* If you meet jdk version problem in Intellij Idea,   
try to change jdk version in setting and project structure.  

## Dependencies
* lucene 6.4.2
* [jieba](https://github.com/huaban/jieba-analysis) 
* spring boot

## Run
`mvn spring-boot:run`
`localhost:8888/demo/index.html`
## RestApi
1. index
```
url: /index
method: POST
content-type: JSON
body: { path: string }
return: { result: [string] }
```

2. query
```
url: /query
method: POST
content-type: JSON
body: { keyword: string }
return: { result: [string] }
```
