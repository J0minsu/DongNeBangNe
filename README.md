# DongNeBangNe Server

##소스코드 설명

DongNeBangNe Server 는 Springboot 환경에서 제작되었고, 철저한 MVC 패턴을 유지하고 있다.


>~/config
>>프로젝트 설정 정보를 담은 클래스들이 들어가있다.
![configs](/images/configs.png)
![config1](/images/config1.png)

>~/model
>>프로젝트에서 다루는 Model 클래스들이 들어가있다.
![models](/images/models.png)
![model1](/images/model1.png)


>~/controller
>>실질적으로 view에 넘여줄 데이터들을 가공 및 정의해주는 클래스들이 들어있다.
![contollers](/images/controllers.png)
![controller1](/images/controller1.png)


>~/repository
>>CrudRepository Interface를 상속받은 Interface 들이 들어가있고
  DB에 접근하는 기본적인 쿼리들을 제공해준다.
![repositories](/images/repositories.png)
![repository1](/images/repository1.png)
